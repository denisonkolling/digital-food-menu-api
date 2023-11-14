package com.example.digitalmenu.repository;

import com.example.digitalmenu.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
