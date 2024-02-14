package ru.stan.piggybank3.data

data class Moneyboxe(
    val alreadyhave: Int,
    val amount: Int,
    val dateto: String,
    val id: String,
    val isArchived: Boolean,
    val title: String,
    val unit: String
)