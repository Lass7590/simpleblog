package com.example.mini_blog

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.mini_blog.Adapter.ArticleAdapter

class ArticleDetails(
    private val adapter: ArticleAdapter,
    private val currentArticle: ArticleModel
) : Dialog(adapter.context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.page_article_details)
        setupComponents()
        setupReturnButton()
    }

    private fun setupReturnButton() {

        val icRetour = findViewById<ImageView>(R.id.ic_retour)
        icRetour.setOnClickListener{
            dismiss()
        }
    }

    private fun setupComponents() {
       //Actualiser l'article
        val titleArticle = findViewById<TextView>(R.id.textView)
        titleArticle.text = currentArticle.name

        val auteur = findViewById<TextView>(R.id.textView2)
        auteur.text = currentArticle.auteur

        val datePub = findViewById<TextView>(R.id.textView4)
        datePub.text = currentArticle.date

        val desc = findViewById<TextView>(R.id.textView3)
        desc.text = currentArticle.description
    }

}