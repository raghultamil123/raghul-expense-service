package com.raghul.expenseservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*


@Document(collection = "transaction")
data class Transaction(
    @Id
    val id:String,
    @Field("amount")
    val amount:Double,
    @Field("amountType")
    val amountType:String,
    @Field("date")
    val date:Date

)