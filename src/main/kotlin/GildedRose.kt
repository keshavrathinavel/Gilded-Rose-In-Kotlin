package org.example

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items.indices) {
            items[item].updateForEach()
        }
    }
}

private fun Item.updateForEach() {
    updateExpiryDate()
    updateItemQuality()
}

private fun Item.updateItemQuality() {
    updateQuality(
        when (name) {
            "Aged Brie" -> if (expired) 2 else 1
            "Backstage passes to a TAFKAL80ETC concert" -> {
                if (expired) -quality else when {
                    expiryDate < 5 -> 3
                    expiryDate < 10 -> 2
                    else -> 1
                }
            }
            "Sulfuras, Hand of Ragnaros" -> 0
            "Conjured Mana Cake" -> if (expired) -4 else -2
            else -> if (expired) -2 else -1
        }
    )
}

private val Item.expired get() = expiryDate < 0

private fun Item.updateExpiryDate() {
    expiryDate -= when (name) {
        "Sulfuras, Hand of Ragnaros" -> 0
        else -> 1
    }
}

fun Item.updateQuality(change: Int) {
    quality = when (name) {
        "Sulfuras, Hand of Ragnaros" -> 80
        else -> (quality + change)
            .coerceIn(minimumValue = 0, maximumValue = 50)
    }
}
