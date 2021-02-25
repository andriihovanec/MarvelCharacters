package com.andriikhovanets.marvelcharacters.domain

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

sealed class TextResource {

    private data class SimpleTextResource(
        val text: String
        ) : TextResource()

    private data class IdTextResource(
        @StringRes val id: Int
        ) : TextResource()

    private data class PluralTextResource(
        @PluralsRes val pluralId: Int, val quantity: Int
    ) : TextResource()

    companion object {
        fun fromText(text: String): TextResource = SimpleTextResource(text)
        fun fromStringId(@StringRes id: Int): TextResource = IdTextResource(id)
        fun fromPlural(@PluralsRes id: Int, pluralValue : Int) : TextResource = PluralTextResource(id, pluralValue)
    }
}