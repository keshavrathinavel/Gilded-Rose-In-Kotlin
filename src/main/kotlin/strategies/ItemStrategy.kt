package org.example.strategies

import org.example.Item

interface ItemStrategy {
    fun update(item: Item): Pair<Int, Int>
    fun expired(item: Item): Boolean = item.sellIn < 0
}