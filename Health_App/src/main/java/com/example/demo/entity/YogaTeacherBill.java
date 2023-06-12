package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="yoga_teacher_bill")
public class YogaTeacherBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int yogaTeacherBillId;
	
	@Column
	private String yogaTeacherName;
	
	@Column
	private int yogaTeacherBillAmount;
	
	@Column
	private int yogaTeacherBillStatus;
	
	@Column
	private Date date;
}
