package com.raghul.expenseservice

import com.raghul.expenseservice.model.Transaction
import com.raghul.expenseservice.repository.TransactionRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class ExpenseserviceApplication

fun main(args: Array<String>) {
	var context = runApplication<ExpenseserviceApplication>(*args)


}
