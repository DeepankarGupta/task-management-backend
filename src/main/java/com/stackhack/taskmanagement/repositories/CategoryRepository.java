package com.stackhack.taskmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackhack.taskmanagement.models.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
