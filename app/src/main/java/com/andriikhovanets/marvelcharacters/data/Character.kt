package com.andriikhovanets.marvelcharacters.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(@PrimaryKey @ColumnInfo(name = "id") val id: Int, val name: String)