// matching-engine-java/src/main/java/com/rideshare/matching/repository/RiderRepository.java
package com.rideshare.matching.repository;

import com.rideshare.common.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<User, Long> {
    // Additional rider-specific queries can be added here
}