package com.jianastrero.capiche

import java.io.Serializable

interface Consumer<T, U> : Serializable {
    fun consume(t: T): U
}