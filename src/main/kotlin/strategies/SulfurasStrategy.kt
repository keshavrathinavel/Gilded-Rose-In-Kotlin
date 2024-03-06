package org.example.strategies

import org.example.Item

private const val DEFAULT_QUALITY = 80

class SulfurasStrategy: ItemStrategy {
    override fun updateItemProperties(item: Item): Pair<Int, Int> {
        item.quality = DEFAULT_QUALITY
        return Pair(item.sellIn, item.quality)
    }

}