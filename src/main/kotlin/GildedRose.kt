package org.example

import org.example.contexts.ContextForAlItems

class GildedRose(var items: List<Item>) {
    fun updateItemProperties() {
        for (item in items) {
            val context = ContextForAlItems(item.name)
            val result = context.updateQualityAndExpiry(item)
            item.sellIn = result.first
            item.quality = result.second
        }
    }
}
