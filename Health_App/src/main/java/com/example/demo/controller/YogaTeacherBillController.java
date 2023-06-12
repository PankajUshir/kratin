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

import com.example.demo.entity.YogaTeacherBill;
import com.example.demo.service.YogaTeacherBillService;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("/yogateacher/")
public class YogaTeacherBillController {

	@Autowired
	private YogaTeacherBillService yogaTeacherBillService;
	
	@GetMapping("getallbills")
	public List<YogaTeacherBill> getAllYogaTeacherBills() {
		return yogaTeacherBillService.getAllYogaTeacherBills();
	}
	
	@PostMapping("savebill")
	public boolean saveYogaTeacher(@RequestBody YogaTeacherBill YogaTeacher) {
		return yogaTeacherBillService.saveYogaTeacherBill(YogaTeacher);
	}
	
	@DeleteMapping("{id}")
	public String deleteYogaTeacher(@PathVariable int id) {
		return yogaTeacherBillService.deleteYogaTeacherBill(id);
	}
}
