package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
	private int medicineId;
	
	@Column
	private String name;
	
	@Column
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "medicineBillId")
	private MedicineBill medicineBill;

}
