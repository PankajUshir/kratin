package com.example.demo.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="medicine_bill")
public class MedicineBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineBillId;
	
	@Column
	private String medicalName;
	
	@Column
	private int medicineBillAmount;
	
	@Column
	private int medicineBillStatus;
	
	@Column
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Medicine> medicines = new HashSet<Medicine>();
	
	
	
	public Set<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Set<Medicine> medicines) {
		for(Medicine oi : medicines)
			oi.setMedicineBill(this);
		this.medicines = medicines;
	}


	
	
}
