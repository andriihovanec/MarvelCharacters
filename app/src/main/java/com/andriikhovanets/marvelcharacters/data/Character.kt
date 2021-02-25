package com.andriikhovanets.marvelcharacters.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int, val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "modified") val modified: String,
    @Embedded val thumbnail: Thumbnail? = null
)

@Entity(tableName = "thumbnail")
data class Thumbnail(
    @ColumnInfo(name = "path") val path: String,
    @ColumnInfo(name = "extension") val extension: String
)