package com.example.mini_blog

import java.util.Date
import java.util.Calendar

// Obtention de la date actuelle

//val calendar = Calendar.getInstance()

class ArticleModel(
    val id: String = "article0",
    val name: String = "Article",
    val description: String = "",
    val auteur: String = "John Doe",
    val date: String = "22/05/2023"

)