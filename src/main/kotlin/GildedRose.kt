package org.example

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items.indices) {
            items[item].updateForEach()
        }
    }
}

private fun Item.updateForEach() {
    updateSellInDays()

    updateQuality(
        when (name) {
        "Aged Brie" -> 1
        "Backstage passes to a TAFKAL80ETC concert" -> {
            if (sellInDays < 5) 3
            else if (sellInDays < 10) 2
            else 1
        }
        "Sulfuras, Hand of Ragnaros" -> 0
        "Conjured Mana Cake" -> -2
        else -> -1
    })

    updateQuality(
        when(name) {
            "Aged Brie" -> if (expired) 1 else 0
            "Backstage passes to a TAFKAL80ETC concert" -> if (expired) 1 else -quality
            "Sulfuras, Hand of Ragnaros" -> if (expired) 1 else 0
            "Conjured Mana Cake" -> if (expired) 1 else -2
            else -> if (expired) 1 else -1
        }
    )
}

private val Item.expired get() = sellInDays < 0

private fun Item.updateSellInDays() {
    sellInDays -= when (name) {
        "Sulfuras, Hand of Ragnaros" -> 0
        else -> 1
    }
}

fun Item.updateQuality(change: Int = 1) {
    if (quality in 1..49) quality = (quality + change)
        .coerceIn(minimumValue = 0, maximumValue = 50)
}
