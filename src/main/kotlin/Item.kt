package org.example

open class Item (
    val name: String,
    var expiryDate: Int,
    var quality: Int
) {
    override fun toString(): String {
        return "$name, $expiryDate, $quality"
    }
}