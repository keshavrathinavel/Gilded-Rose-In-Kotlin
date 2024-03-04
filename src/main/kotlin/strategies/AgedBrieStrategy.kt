package org.example.strategies

import org.example.Item

private const val BY_ONE_FOR_AGED_BRIE = 1
private const val BY_TWO_FOR_AGED_BRIE = 2

class AgedBrieStrategy: ItemStrategy {
    override fun update(item: Item): Pair<Int, Int> {
        when {
            hasExpired(item) -> item.quality += BY_TWO_FOR_AGED_BRIE
            else -> item.quality += BY_ONE_FOR_AGED_BRIE
        }
        item.quality = applyQualityBounds(item)
        return Pair(item.sellIn - 1, item.quality)
    }
}