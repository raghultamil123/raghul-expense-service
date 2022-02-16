package com.raghul.expenseservice.repository

import com.raghul.expenseservice.model.Expense
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ExpenseRepository : ReactiveMongoRepository<Expense, String>