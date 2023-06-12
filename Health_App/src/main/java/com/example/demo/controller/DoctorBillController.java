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
import com.example.demo.service.DoctorBillService;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("/doctor/")
public class DoctorBillController {

	@Autowired
	private DoctorBillService doctorBillService;
	
	@GetMapping("getallbills")
	public List<DoctorBill> getAllDoctorBills() {
		return doctorBillService.getAllDoctorBills();
	}
	
	@PostMapping("savebill")
	public boolean saveDoctorBill(@RequestBody DoctorBill doctorBill) {
		return doctorBillService.saveDoctorBill(doctorBill);
	}
	
	@DeleteMapping("{id}")
	public String deleteDoctorBill(@PathVariable int id) {
		return doctorBillService.deleteDoctorBill(id);
	}
}
