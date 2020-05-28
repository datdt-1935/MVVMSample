package com.sun.mvvmsample.data.model

import android.content.ClipData
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Type

@Parcelize
data class GithubRepo(
    @SerializedName("od")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("html_url")
    val url: String,
    @SerializedName("stargazers_count")
    val starCount: Int,
    @SerializedName("forks_count")
    val folkCount: Int,
    @SerializedName("owner")
    @JsonAdapter(AvatarDeserializer::class)
    val avatarUrl: String
): Parcelable

private class AvatarDeserializer : JsonDeserializer<String> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ) = json?.asJsonObject?.get("avatar_url")?.asString
}

class RepoItemCallBack : DiffUtil.ItemCallback<GithubRepo>() {

    override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo) = oldItem === newItem

    override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo) = oldItem == newItem
}
