package com.example.mini_blog

import com.example.mini_blog.ArticleRepository.Singleton.articleList
import com.example.mini_blog.ArticleRepository.Singleton.databaseRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ArticleRepository {

    object Singleton{
        //Se connecter a la reference articles
        val databaseRef = FirebaseDatabase.getInstance().getReference("articles")

        //creer une liste qui va contenir les articles
        val articleList = arrayListOf<ArticleModel>()
    }

    fun updateData(callback: () -> Unit){
        //Absorber les donnees recuperer a la datbaseRef -> Listes d'articles
        databaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //retirer les anciens articles
                articleList.clear()

               //Recolter la liste
                for(ds in snapshot.children){
                    //contruire un objet article
                    val article = ds.getValue(ArticleModel::class.java)

                    //verifier qu l'article n'est pas null
                    if(article != null){
                        articleList.add(article)
                    }
                }
                //actionner le callback
                callback()
            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }

    // Inserer un nouvel article en BDD
    fun insertArticle(article: ArticleModel) = databaseRef.child(article.id).setValue(article)
}