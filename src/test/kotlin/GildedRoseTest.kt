package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `Assert Item name persists`() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun `Quality decreases by 1 towards SellIn`() {
        val items = listOf(Item("milk", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun `Once the sell by date has passed, Quality degrades twice as fast`() {
        val items = listOf(Item("milk", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
        app.updateQuality()
        assertEquals(7, app.items[0].quality)
    }

    @Test
    fun `The Quality of an item is never negative`() {
        val items = listOf(Item("milk", 1, 3))
        val app = GildedRose(items)
        repeat(3) {
            app.updateQuality()
        }
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `Aged Brie actually increases in Quality the older it gets`() {
        val agedBrie = listOf(Item("Aged Brie", 4, 10))
        val app = GildedRose(agedBrie)
        repeat(4) {
            app.updateQuality()
        }
        assertEquals(14, app.items[0].quality)
    }

    @Test
    fun `The Quality of an item is never more than 50`() {
        val agedBrie = listOf(Item("Aged Brie", 10, 10))
        val app = GildedRose(agedBrie)
        repeat(100) {
            app.updateQuality()
        }
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun `Sulfuras being a legendary item, never has to be sold or decreases in Quality`() {
        val sulfuras = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(sulfuras)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun `Backstage pass item quality increases by 2 when SellIn is 10 days or less`() {
        val backstagePass = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val app = GildedRose(backstagePass)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun `Backstage passes increases by 3 when SellIn is 5 days or less`() {
        val backstagePass = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 4, 5))
        val app = GildedRose(backstagePass)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun `Quality drops to 0 after the concert`() {
        val backstagePass = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10))
        val app = GildedRose(backstagePass)
        repeat(4) {
            app.updateQuality()
        }
        assertEquals(0, app.items[0].quality)
    }

}

