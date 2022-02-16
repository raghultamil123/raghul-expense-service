package com.raghul.expenseservice.model

data class Expense(
    val id:String,
    val expenseName:String,
    val quantity: Int,
    val price:Double,
    val status:String
)