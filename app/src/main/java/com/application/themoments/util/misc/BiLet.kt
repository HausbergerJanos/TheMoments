package com.xeropan.student.util.misc

/**
 * Let us the create pairs of nullable variables then check their nullability.
 * This allows us to use power of inline functions, and alter if blocks.
 */
fun <T, U, R> Pair<T?, U?>.biLet(body: (T, U) -> R): R? {
    val first = first
    val second = second
    if (first != null && second != null) {
        return body(first, second)
    }
    return null
}