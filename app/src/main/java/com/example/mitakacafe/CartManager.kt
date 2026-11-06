package com.example.mitakacafe

object CartManager {
    private val _selectedItems = mutableListOf<MenuModel>()
    val selectedItems: List<MenuModel> get() = _selectedItems

    fun add(menu: MenuModel) {
        _selectedItems.add(menu)
    }

    fun remove(menu: MenuModel) {
        _selectedItems.remove(menu)
    }

    fun clear() {
        _selectedItems.clear()
    }

    fun getTotalPriceInt(): Int {
        return _selectedItems.sumOf { parsePrice(it.price) }
    }

    fun getTotalPriceString(): String {
        return formatPrice(getTotalPriceInt())
    }

    private fun parsePrice(priceStr: String): Int {
        val digits = priceStr.replace(Regex("[^0-9]"), "")
        return digits.toIntOrNull() ?: 0
    }

    fun formatPrice(amount: Int): String {
        val formatted = java.text.NumberFormat.getInstance(java.util.Locale("id", "ID")).format(amount)
        return "Rp $formatted"
    }
}
