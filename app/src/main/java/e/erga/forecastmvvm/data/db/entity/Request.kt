package e.erga.forecastmvvm.data.db.entity


import com.google.gson.annotations.SerializedName

data class Request(

    //see condition
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)