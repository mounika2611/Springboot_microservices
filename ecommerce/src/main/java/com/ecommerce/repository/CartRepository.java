package com.ecommerce.repository;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.ecommerce.dao.Cart;
import com.ecommerce.dao.User;



@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{



List<Cart>findAllByUserOrderByCreatedDateDesc(User user);
}