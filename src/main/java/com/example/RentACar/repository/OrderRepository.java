// Author: Tolga Pakkan

package com.example.RentACar.repository;

import com.example.RentACar.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepository extends JpaRepository<Order, Long> {
}
