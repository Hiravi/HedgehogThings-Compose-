package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util

sealed class CategoryType {

    object Other : CategoryType() {

        override fun toString(): String {
            return "Other"
        }
    }
    object Movies : CategoryType() {

        override fun toString(): String {
            return "Movies"
        }
    }
    object Food : CategoryType() {

        override fun toString(): String {
            return "Food"
        }
    }
    object Holidays : CategoryType() {

        override fun toString(): String {
            return "Holidays"
        }
    }
    object ShoppingList : CategoryType() {

        override fun toString(): String {
            return "ShoppingList"
        }
    }
}
