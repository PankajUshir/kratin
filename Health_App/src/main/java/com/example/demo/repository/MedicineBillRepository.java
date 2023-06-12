package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MedicineBill;

@Repository
public interface MedicineBillRepository extends JpaRepository<MedicineBill, Integer> {

}
