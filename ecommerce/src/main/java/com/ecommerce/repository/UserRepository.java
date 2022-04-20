package com.ecommerce.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    @Modifying
    @Transactional
	@Query("update User set balance=?1 where accountNumber=?2")
	void updateTransactions(double remainingAmount, int accountNumber);
}
