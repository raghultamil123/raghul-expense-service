package com.raghul.expenseservice.extension

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


fun <T> Mono<T>.logOnSucess(message:String): Mono<T> {
    println(message)
    return this
}

fun <T> Flux<T>.logOnSucess(message:String):Flux<T>{
    println(message)
    return this
}