package com.example.mini_blog.articles

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_blog.Adapter.ArticleAdapter
import com.example.mini_blog.ArticleModel
import com.example.mini_blog.ArticleRepository.Singleton.articleList
import com.example.mini_blog.MainActivity
import com.example.mini_blog.R

class NewArticle(
    private val context: MainActivity
) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_article, container, false)

        //Creer une liste qui va stocker ces articles
        //val articleList = arrayListOf<ArticleModel>()


        //Recuperer le recyclerView
        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        if (verticalRecyclerView != null) {
            verticalRecyclerView.adapter = ArticleAdapter(context, articleList)
        }

        return view
    }
}


