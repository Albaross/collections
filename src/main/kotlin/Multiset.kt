package org.albaross.collections

import kotlin.math.min

typealias Multiset<T> = HashMap<T, Int>

inline fun <T> Multiset<T>.add(elem: T) {
    this[elem] = (this[elem] ?: 0) + 1
}

infix fun <T> Multiset<T>.and(other: Multiset<T>): Multiset<T> {
    if (other.size < this.size) return other and this

    val intersection = Multiset<T>(this.size)
    for ((item, count) in this) {
        val min = min(count, other[item] ?: 0)
        if (min > 0) intersection[item] = min
    }
    return intersection
}