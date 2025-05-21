data class User(
    val id: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val address: String,
    val vehicleType: String,
    val vehicleModel: String,
    val vehicleLicensePlate: String,
    val rating: Double
) {
    fun toUserDTO(): UserDTO {
        return UserDTO(id, name, email, phoneNumber, address, vehicleType, vehicleModel, vehicleLicensePlate, rating)
    }
}
data class UserDTO(
    val id: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val vehicleType: String,
    val vehicleModel: String,
    val vehicleLicensePlate: String,
    val rating: Double
) {
    fun toUser(): User {
        return User(id, name, email, phoneNumber, "", address, vehicleType, vehicleModel, vehicleLicensePlate, rating)
    }
}
// Compare this snippet from api-kotlin/src/main/kotlin/com/rideshare/api/service/UserService.kt: