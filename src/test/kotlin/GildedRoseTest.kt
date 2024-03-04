package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    @Test
    fun `Assert Item name persists`() {
        val items = listOf(Item("foo", 0, 0))
        val gildedRose = GildedRose(items)
        gildedRose.updateQuality()
        assertEquals("foo", gildedRose.items[0].name)
    }

    @Test
    fun `Quality decreases by 1 towards SellIn`() {
        val items = listOf(Item("milk", 10, 10))
        val gildedRose = GildedRose(items)
        gildedRose.updateQuality()
        assertEquals(9, gildedRose.items[0].quality)
    }

    @Test
    fun `Once the sell by date has passed, Quality degrades twice as fast`() {
        val items = listOf(Item("milk", 1, 10))
        val gildedRose = GildedRose(items)
        gildedRose.updateQuality()
        assertEquals(9, gildedRose.items[0].quality)
        gildedRose.updateQuality()
        assertEquals(7, gildedRose.items[0].quality)
    }

    @Test
    fun `The Quality of an item is never negative`() {
        val items = listOf(Item("milk", 1, 3))
        val gildedRose = GildedRose(items)
        repeat(3) {
            gildedRose.updateQuality()
        }
        assertEquals(0, gildedRose.items[0].quality)
    }

    @Test
    fun `Aged Brie actually increases in Quality the older it gets`() {
        val agedBrie = listOf(Item("Aged Brie", 4, 10))
        val gildedRose = GildedRose(agedBrie)
        repeat(5) {
            gildedRose.updateQuality()
        }
        assertEquals(16, gildedRose.items[0].quality)
    }

    @Test
    fun `Aged Brie increases in quality past sellIn date`() {
        val agedBrie = listOf(Item("Aged Brie", 0, 10))
        val gildedRose = GildedRose(agedBrie)
        gildedRose.updateQuality()
        assertEquals(12, gildedRose.items[0].quality)
    }

    @Test
    fun `The Quality of an item is never more than 50`() {
        val agedBrie = listOf(Item("Aged Brie", 10, 10))
        val gildedRose = GildedRose(agedBrie)
        repeat(100) {
            gildedRose.updateQuality()
        }
        assertEquals(50, gildedRose.items[0].quality)
    }

    @Test
    fun `Sulfuras being a legendary item, never has to be sold or decreases in Quality`() {
        val sulfuras = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val gildedRose = GildedRose(sulfuras)
        gildedRose.updateQuality()
        assertEquals(80, gildedRose.items[0].quality)
    }


    @Test
    fun `Backstage pass item quality increases by 1 when SellIn is greater than 10 days`() {
        val backstagePass = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 14, 10))
        val gildedRose = GildedRose(backstagePass)
        gildedRose.updateQuality()
        assertEquals(11, gildedRose.items[0].quality)
    }
    @Test
    fun `Backstage pass item quality increases by 2 when SellIn is 10 days or less`() {
        val backstagePass = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val gildedRose = GildedRose(backstagePass)
        gildedRose.updateQuality()
        assertEquals(12, gildedRose.items[0].quality)
    }

    @Test
    fun `Backstage pass item quality increases by 3 when SellIn is 5 days or less`() {
        val backstagePass = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 5))
        val gildedRose = GildedRose(backstagePass)
        gildedRose.updateQuality()
        assertEquals(8, gildedRose.items[0].quality)
    }

    @Test
    fun `Quality drops to 0 after the concert`() {
        val backstagePass = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10))
        val gildedRose = GildedRose(backstagePass)
        repeat(5) {
            gildedRose.updateQuality()
        }
        assertEquals(0, gildedRose.items[0].quality)
    }

    @Test
    fun `Print item`() {
        val item = Item("milk", expiryDate = 10, quality = 10)
        assertEquals( "milk, 10, 10", item.toString())
    }

    @Test
    fun `Sulfuras does not decrease in quality even after SellIn period`() {
        val sulfuras = listOf(Item("Sulfuras, Hand of Ragnaros", -1, 80))
        val gildedRose = GildedRose(sulfuras)
        gildedRose.updateQuality()
        assertEquals(80, gildedRose.items[0].quality)
    }

    @Test
    fun `Conjured item quality degrades twice as fast`()
    {
        val conjured = listOf(Item("Conjured Mana Cake", 3, 10))
        val gildedRose = GildedRose(conjured)
        gildedRose.updateQuality()
        assertEquals(8, gildedRose.items[0].quality)
    }

    @Test
    fun `Conjured item quality degrades 4 times as fast when sellIn is lesser than 0`() {
        val conjured = listOf(Item("Conjured Mana Cake", 0, 10))
        val gildedRose = GildedRose(conjured)
        gildedRose.updateQuality()
        assertEquals(6, gildedRose.items[0].quality)
    }
}

