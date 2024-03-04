package org.example.strategies

import org.example.Item

private const val BY_ONE_STANDARD_ITEM = 1
private const val BY_TWO_STANDARD_ITEM = 2

class StandardItemStrategy: ItemStrategy {
    override fun update(item: Item): Pair<Int, Int> {
        updateQuality(item)
        return Pair(item.sellIn - BY_ONE_STANDARD_ITEM, item.quality)
    }

    private fun updateQuality(item: Item) {
        item.quality -= when {
            hasExpired(item) -> BY_TWO_STANDARD_ITEM
            else -> BY_ONE_STANDARD_ITEM
        }.coerceIn(0, 50)
    }
}