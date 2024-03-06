package org.example.strategies

import org.example.Item

private const val ZERO_WHEN_EXPIRED = 0

class BackstagePassStrategy : ItemStrategy {
    override fun updateItemProperties(item: Item): Pair<Int, Int> {
        when {
            hasExpired(item) -> item.quality = ZERO_WHEN_EXPIRED
            item.sellIn < 5 -> item.quality += 3
            item.sellIn < 10 -> item.quality += 2
            else -> item.quality += 1
        }
        item.quality = applyQualityBounds(item)
        return Pair(item.sellIn - 1, item.quality)
    }
}