package org.example.strategies

import org.example.Item

class ConjuredItemStrategy : ItemStrategy {
    override fun update(item: Item): Pair<Int, Int> {
        if (expired(item)) {
            item.quality -= 4
        }
        else {
            item.quality -= 2
        }
        return Pair(item.sellIn - 1, item.quality)
    }

}
