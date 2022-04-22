package com.ecommerce.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.userservice.entity.UserDetails;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

}
