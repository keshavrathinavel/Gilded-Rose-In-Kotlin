package org.example

open class Item (
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString(): String {
        return "$name, $sellIn, $quality"
    }
}