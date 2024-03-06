package org.example.strategies

import org.example.Item

interface ItemStrategy {
    fun updateItemProperties(item: Item): Pair<Int, Int>
    fun applyQualityBounds(num: Int) {
        num.coerceIn(0, 50)
    }
    fun hasExpired(item: Item): Boolean = item.sellIn < 0
}


