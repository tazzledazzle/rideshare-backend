package com.rideshare.matching.repository;

import com.rideshare.common.models.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<UserDto, Long> {
}