package com.example.mini_blog.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mini_blog.ArticleModel
import com.example.mini_blog.ArticleRepository
import com.example.mini_blog.MainActivity
import com.example.mini_blog.R
import java.util.UUID

class AddArticleFragment(
    private val context: MainActivity
) : Fragment() {

    //private var uploadedArticle:TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater?.inflate(R.layout.fragment_add_article, container, false)

        //Recuperer le boutton ajouter
        val addButton = view?.findViewById<Button>(R.id.button_add)
        if (addButton != null) {
            addButton.setOnClickListener{ sendForm(view) }
        }

        return view
    }

    private fun sendForm(view: View) {

        val repo = ArticleRepository()

        val articleTitle = view.findViewById<EditText>(R.id.titleInput).text.toString()
        val articleDescription = view.findViewById<EditText>(R.id.descInput).text.toString()

        //Creer un nouvel articleModel
        val article = ArticleModel(
            UUID.randomUUID().toString(),
            articleTitle,
            articleDescription
        )

        //Envoyer en BDD
        repo.insertArticle(article)
    }


}