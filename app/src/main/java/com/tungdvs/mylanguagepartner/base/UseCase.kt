package com.tungdvs.mylanguagepartner.base

abstract class UseCase<Input, Output> {
    abstract suspend fun execute(input: Input): Output
}