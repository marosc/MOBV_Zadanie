package eu.mcomputing.mobv.mobvzadanie.data.model

data class User(
    val username: String,
    val email: String,
    val id: String,
    val access: String,
    val refresh: String
)