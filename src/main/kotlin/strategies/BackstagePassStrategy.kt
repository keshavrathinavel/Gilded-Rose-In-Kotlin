package org.example.strategies

import org.example.Item

class BackstagePassStrategy : ItemStrategy {
    override fun update(item: Item): Pair<Int, Int> {
        when {
            expired(item) -> item.quality = 0
            item.sellIn < 5 -> item.quality += 3
            item.sellIn < 10 -> item.quality += 2
            else -> item.quality += 1
        }
        return Pair(item.sellIn - 1, item.quality)
    }
}