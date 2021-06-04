package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Result;

public interface ResultRepository extends JpaRepository<Result, Long>{
    
}
