package org.example.strategies

import org.example.Item

class SulfurasStrategy: ItemStrategy {
    override fun update(item: Item): Pair<Int, Int> {
        item.quality = 80
        return Pair(item.sellIn, item.quality)
    }

}