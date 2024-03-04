package org.example.strategies

import org.example.Item

private const val QUALITY_UPDATE_EXPIRED = 4
private const val QUALITY_UPDATE = 2

class ConjuredItemStrategy : ItemStrategy {
    override fun update(item: Item): Pair<Int, Int> {
        if (hasExpired(item)) {
            item.quality -= QUALITY_UPDATE_EXPIRED
        }
        else {
            item.quality -= QUALITY_UPDATE
        }
        item.quality = applyQualityBounds(item)
        return Pair(item.sellIn - 1, item.quality)
    }

}
