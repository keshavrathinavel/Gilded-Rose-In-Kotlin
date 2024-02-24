package org.example

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items.indices) {
            items[item].updateForEach()
        }
    }
}

private fun Item.updateForEach() {
    sellInDays -= when (name) {
        "Sulfuras, Hand of Ragnaros" -> 0
        else -> 1
    }

    updateQuality(
        when (name) {
        "Aged Brie" -> 1
        "Backstage passes to a TAFKAL80ETC concert" -> {
            if (sellInDays < 6) 3
            else if (sellInDays < 11) 2
            else 1
        }
        "Sulfuras, Hand of Ragnaros" -> 0
        "Conjured Mana Cake" -> -2
        else -> -1
    })

    if (sellInDays < 0) {
        updateQuality(
            when(name) {
                "Aged Brie" -> 1
                "Backstage passes to a TAFKAL80ETC concert" -> -quality
                "Sulfuras, Hand of Ragnaros" -> 0
                "Conjured Mana Cake" -> -2
                else -> -1
            }
        )
    }
}

private fun Item.updateQuality(change: Int = 1) {
    if (quality in 1..49) quality = (quality + change)
        .coerceIn(minimumValue = 0, maximumValue = 50)
}
