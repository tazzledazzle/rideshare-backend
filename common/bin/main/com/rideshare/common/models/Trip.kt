open class Trip(
    val id: String,
    val startLocation: String,
    val endLocation: String,
    val distance: Double,
    val duration: Int,
    val price: Double,
    val driverId: String,
    val passengerId: String
) {
    override fun toString(): String {
        return "Trip(id='$id', startLocation='$startLocation', endLocation='$endLocation', distance=$distance, duration=$duration, price=$price, driverId='$driverId', passengerId='$passengerId')"
    }
}
// Compare this snippet from api-kotlin/src/main/kotlin/com/rideshare/api/service/TripService.kt: