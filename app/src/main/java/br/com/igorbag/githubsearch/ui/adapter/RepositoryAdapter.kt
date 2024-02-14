package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    var repoItemListener: (Repository) -> Unit = {}
    var btnShareListener: (Repository) -> Unit = {}

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtRepositoryName: TextView
        val btnShare: ImageView
        val cardViewItem: CardView

        init {
            txtRepositoryName = itemView.findViewById(R.id.txtRepositoryName)
            btnShare = itemView.findViewById(R.id.imgShare)
            cardViewItem = itemView.findViewById(R.id.clCardView)

        }



    }

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return RepositoryViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.txtRepositoryName.text = repositories[position].name
        //holder.cardViewItem = repositories[position]
        //holder.btnShare = repositories[position]

        //@TODO 8 -  Realizar o bind do viewHolder
        //Exemplo de Bind
        //  holder.preco.text = repositories[position].atributo

        // Click no CardView
        holder.cardViewItem.setOnClickListener {
         repoItemListener(repositories[position])
        }

        // Click no Share Button
        holder.btnShare.setOnClickListener {
            btnShareListener(repositories[position])
        }
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios
        //Exemplo:
        //val atributo: TextView

        //init {
        //    view.apply {
        //        atributo = findViewById(R.id.item_view)
        //    }

    }
}


