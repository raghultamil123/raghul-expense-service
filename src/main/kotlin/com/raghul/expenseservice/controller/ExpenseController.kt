package com.raghul.expenseservice.controller

import com.raghul.expenseservice.model.Expense
import com.raghul.expenseservice.service.ExpenseService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("api/expense")
class ExpenseController(
    private val expenseService: ExpenseService
) {

    @GetMapping("/")
    fun getExpenses(): Flux<Expense> {
        return expenseService.getAllExpenses()
    }

    @PostMapping("/")
    fun saveExpense(@RequestBody expense:Expense):Mono<Expense>{
        return expenseService.saveExpense(expense = expense)
    }

}