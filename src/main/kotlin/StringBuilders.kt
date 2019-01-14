package org.albaross.collections

fun <T> StringBuilder.append(
    elements: Collection<T>, separator: String, empty: String = "",
    formatter: (T) -> String = { it.toString() }
): StringBuilder {

    if (elements.isEmpty())
        return this.append(empty)

    for ((i, element) in elements.withIndex()) {
        if (i > 0) this.append(separator)
        this.append(formatter(element))
    }

    return this

}