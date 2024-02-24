package org.example

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items.indices) {
            items[item].updateForEach()
        }
    }
}

private fun Item.updateForEach() {
    if (name == "Aged Brie") updateQuality()
    else if (name == "Backstage passes to a TAFKAL80ETC concert") {
        if (sellIn < 6) updateQuality(3)
        else if (sellIn < 11) updateQuality(2)
        else updateQuality()
    }
    else if (quality > 0) {
        quality -= (if (name == "Sulfuras, Hand of Ragnaros") 0 else 1)
    }

    sellIn -= if (name == "Sulfuras, Hand of Ragnaros") 0 else 1

    if (sellIn < 0) {
        updateQuality(
            when(name) {
                "Aged Brie" -> 1
                "Backstage passes to a TAFKAL80ETC concert" -> -quality
                "Sulfuras, Hand of Ragnaros" -> 0
                else -> -1
            }
        )
    }
}

private fun Item.updateQuality(change: Int = 1) {
    if (quality in 1..49) quality = (quality + change)
        .coerceIn(minimumValue = 0, maximumValue = 50)
}
