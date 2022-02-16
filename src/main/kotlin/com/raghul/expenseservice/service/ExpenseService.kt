package com.raghul.expenseservice.service

import com.raghul.expenseservice.extension.logOnSucess
import com.raghul.expenseservice.model.Expense
import com.raghul.expenseservice.repository.ExpenseRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class ExpenseService(
    private val expenseRepository: ExpenseRepository
) {


    fun getAllExpenses():Flux<Expense>{
        return expenseRepository.findAll()
            .logOnSucess(message = "works successfully")
            .switchIfEmpty(
                Flux.empty()
            )
    }

    fun saveExpense(expense: Expense):Mono<Expense> {
        return expenseRepository.save(expense)
    }
}