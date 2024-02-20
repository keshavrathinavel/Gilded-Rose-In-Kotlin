package org.example

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items.indices) {
            items[item].updateForEach()
        }
    }
}

private fun Item.updateForEach() {
    when {
        name == "Aged Brie" -> updateQuality()
        name == "Backstage passes to a TAFKAL80ETC concert" -> {
            updateQuality()
            if (sellIn < 11) updateQuality()
            if (sellIn < 6) updateQuality()
        }
        quality > 0 -> quality -= (if (name == "Sulfuras, Hand of Ragnaros") 0 else 1)
    }


    sellIn -= if (name == "Sulfuras, Hand of Ragnaros") 0 else 1

    if (sellIn < 0) {
        when (name) {
            "Aged Brie" -> updateQuality()
            "Backstage passes to a TAFKAL80ETC concert" -> quality = 0
            "Sulfuras, Hand of Ragnaros" -> quality -= 0
            else -> if (quality > 0) quality -= 1
        }
    }
}

private fun Item.updateQuality(change: Int = 1) {
    if (quality < 50) quality = (quality + change)
        .coerceIn(minimumValue = 0, maximumValue = 50)
}
