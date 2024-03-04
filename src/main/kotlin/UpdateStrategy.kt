package org.example

interface UpdateStrategy {
    fun update(item: Item): Pair<Int, Int>
}