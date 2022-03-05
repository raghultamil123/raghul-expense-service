package com.raghul.expenseservice.model

import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Expense(
    val id:String,
    val expenseName:String,
    val quantity: Int,
    val price:Double,
    val status:String
)