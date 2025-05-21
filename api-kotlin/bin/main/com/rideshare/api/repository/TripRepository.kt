

@Repository
interface TripRepository : JpaRepository<Trip, Long> {
    fun fildAllByUserId(userId: Long): List<Trip>
}