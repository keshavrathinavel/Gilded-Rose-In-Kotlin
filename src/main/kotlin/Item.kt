package org.example

open class Item(
    val name: String,
    var sellInDays: Int,
    var quality: Int
) {
    override fun toString(): String {
        return "$name, $sellInDays, $quality"
    }
}