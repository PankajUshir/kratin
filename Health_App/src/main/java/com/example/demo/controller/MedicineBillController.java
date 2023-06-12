package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DoctorBill;
import com.example.demo.entity.MedicineBill;
import com.example.demo.service.MedicineBillService;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("/medicine/")
public class MedicineBillController {

	@Autowired 
	private MedicineBillService medicineBillService;
	
	@GetMapping("getallbills")
	public List<MedicineBill> getAllMedicineBill() {
		return medicineBillService.getAllMedicineBill();
	}
	
	@DeleteMapping("{id}")
	public String deleteMedicineBill(@PathVariable int id) {
		return medicineBillService.deleteMedicineBill(id);
	}
}
