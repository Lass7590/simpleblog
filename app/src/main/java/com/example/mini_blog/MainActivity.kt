package com.example.mini_blog

import com.example.mini_blog.R
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mini_blog.articles.AddArticleFragment
import com.example.mini_blog.articles.NewArticle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Charger notre article repository
        val repo = ArticleRepository()

        //mettre a jour la liste d'article
        repo.updateData{
            //Injecter le fragment dans la boite (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            //transaction.replace(com.example.mini_blog.R.id.fragment_container, AddArticleFragment(this))
            transaction.replace(com.example.mini_blog.R.id.fragment_container, NewArticle(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }

}