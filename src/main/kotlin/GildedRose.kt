package org.example

class GildedRose(var items: List<Item>) {
    fun updateItemProperties() {
        for (item in items) {
            val context = StrategyContext(item.name)
            val result = context.updateQualityAndExpiry(item)
            item.sellIn = result.first
            item.quality = result.second
        }
    }
}
