package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RegressionTest {

    @Test
    fun `Match updates over two days`() {
        log("OMGHAI!")

        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20), //
            Item("Aged Brie", 2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Item("Conjured Mana Cake", 3, 6)
        )
        val gildedRose = GildedRoseClient(items)

        (0..<2).forEach { day ->
            log("-------- day $day --------")
            log("name, sellIn, quality")
            for (item in items) {
                log(item)
            }
            log()
            gildedRose.updateQuality()
        }
        assertEquals(expectedOutput, output)

    }
}

fun log(any: Any = "") {
    output += any.toString() + "\n"
}

private var output = ""
private val expectedOutput = """
            OMGHAI!
            -------- day 0 --------
            name, sellIn, quality
            +5 Dexterity Vest, 10, 20
            Aged Brie, 2, 0
            Elixir of the Mongoose, 5, 7
            Sulfuras, Hand of Ragnaros, 0, 80
            Sulfuras, Hand of Ragnaros, -1, 80
            Backstage passes to a TAFKAL80ETC concert, 15, 20
            Backstage passes to a TAFKAL80ETC concert, 10, 49
            Backstage passes to a TAFKAL80ETC concert, 5, 49
            Conjured Mana Cake, 3, 6
        
            -------- day 1 --------
            name, sellIn, quality
            +5 Dexterity Vest, 9, 19
            Aged Brie, 1, 0
            Elixir of the Mongoose, 4, 6
            Sulfuras, Hand of Ragnaros, 0, 80
            Sulfuras, Hand of Ragnaros, -1, 80
            Backstage passes to a TAFKAL80ETC concert, 14, 21
            Backstage passes to a TAFKAL80ETC concert, 9, 50
            Backstage passes to a TAFKAL80ETC concert, 4, 50
            Conjured Mana Cake, 2, 4
        """.trimIndent()

