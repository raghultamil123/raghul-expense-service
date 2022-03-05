package com.raghul.expenseservice.repository

import com.raghul.expenseservice.model.Transaction
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface TransactionRepository : ReactiveMongoRepository<Transaction,String>{

}