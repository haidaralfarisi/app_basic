package com.dicoding.androidaplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tanaman(
    val name: String,
    val description: String,
    val photo: Int,
    val manfaat: String
): Parcelable