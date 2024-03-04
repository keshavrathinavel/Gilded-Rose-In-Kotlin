package org.example

import org.example.strategies.*

class StrategyContext(name: String) {

    private var strategyForItem: ItemStrategy = when(name) {
        "Aged Brie" -> AgedBrieStrategy()
        "Backstage passes to a TAFKAL80ETC concert" -> BackstagePassStrategy()
        "Sulfuras, Hand of Ragnaros" -> SulfurasStrategy()
        "Conjured Mana Cake" -> ConjuredItemStrategy()
        else -> StandardItemStrategy()
    }

    fun updateQualityAndExpiry(item: Item): Pair<Int, Int> {
        return strategyForItem.update(item)
    }
}