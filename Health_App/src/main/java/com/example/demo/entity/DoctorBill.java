package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doctor_bill")
public class DoctorBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorBillId;
	
	@Column
	private String doctorName;
	
	@Column
	private int doctorBillAmount;
	
	@Column
	private int doctorBillStatus;
	
	@Column
	private Date date;
	
}
