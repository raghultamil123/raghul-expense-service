package com.raghul.expenseservice.controller

import com.raghul.expenseservice.model.Transaction
import com.raghul.expenseservice.service.TransactionService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
@RequestMapping("/api/transaction")
@CrossOrigin("http://localhost:3000")
class TransactionController(
    private val transactionService: TransactionService
) {



    @GetMapping("/transactions")
    fun getTransactions():Flux<Transaction>{
        return transactionService.getTransactions()
    }
}