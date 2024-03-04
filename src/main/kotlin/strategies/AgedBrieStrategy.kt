package org.example.strategies

import org.example.Item

class AgedBrieStrategy: ItemStrategy {
    override fun update(item: Item): Pair<Int, Int> {
        when {
            expired(item) -> item.quality += 2
            else -> item.quality += 1
        }
        return Pair(item.sellIn - 1, item.quality)
    }
}