package com.raghul.expenseservice.service

import com.raghul.expenseservice.model.Transaction
import com.raghul.expenseservice.repository.TransactionRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository
) {


    fun getTransactions(): Flux<Transaction>{
        return transactionRepository.findAll()
            .defaultIfEmpty(Transaction("1",20.0,"credited", Date()))
    }

}