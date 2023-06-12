package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DoctorBill;

@Repository
public interface DoctorBillRepository extends JpaRepository<DoctorBill, Integer> {

}
