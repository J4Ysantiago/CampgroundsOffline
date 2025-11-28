package com.codepath.campgrounds

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// The full API response from NPS
@Keep
@Serializable
data class CampgroundResponse(
    @SerialName("data")
    val data: List<Campground>?
)

// Represents a single campground object from the API
@Keep
@Serializable
data class Campground(
    @SerialName("name")
    val name: String?,

    @SerialName("description")
    val description: String?,

    @SerialName("latLong")
    val latLong: String?,

    @SerialName("images")
    val images: List<CampgroundImage>?
) : java.io.Serializable {

    // ⭐ This pulls the first non-null image URL safely
    val imageUrl: String?
        get() = images?.firstOrNull { !it.url.isNullOrEmpty() }?.url
}

// Represents a single image from the API
@Keep
@Serializable
data class CampgroundImage(
    @SerialName("url")
    val url: String?,

    @SerialName("title")
    val title: String?
) : java.io.Serializable
