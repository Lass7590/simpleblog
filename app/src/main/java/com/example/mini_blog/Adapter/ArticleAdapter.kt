package com.example.mini_blog.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_blog.ArticleDetails
import com.example.mini_blog.ArticleModel
import com.example.mini_blog.MainActivity
import com.example.mini_blog.R

class ArticleAdapter(
    val context: MainActivity,
    private val articleList: List<ArticleModel>
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    //Boite pour ranger tous les articles a controller
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val articleItem = view.findViewById<TextView>(R.id.article_item)
        val articleText = view.findViewById<TextView>(R.id.text_article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_article, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Recuperer les informations de l'article
        val currentArticle = articleList[position]

        //Mettre a jour le nom de la plante
        holder.articleItem.text = currentArticle.name

        //mettre a jour le nom de l'auteur
        holder.articleText.text = currentArticle.description

        //Interaction lors du clic sur un article
        holder.itemView.setOnClickListener{
            //afficher l'article
            ArticleDetails(this, currentArticle).show()
        }
    }
}