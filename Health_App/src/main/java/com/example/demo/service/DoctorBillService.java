package com.example.demo.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.DoctorBill;
import com.example.demo.repository.DoctorBillRepository;

@Service
public class DoctorBillService {

	@Autowired
	private DoctorBillRepository doctorBillRepository;

	public List<DoctorBill> getAllDoctorBills() {
		List<DoctorBill> currentMonth = new ArrayList<DoctorBill>();
		
		try {
			Date date = Calendar.getInstance().getTime();

			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
			System.out.println(df.format(date));
			String dateStr = df.format(date);
			String[] dateArr = dateStr.split("/");

			int mm = Integer.parseInt(dateArr[0]);
			int dd = Integer.parseInt(dateArr[1]);
			int yy = Integer.parseInt(dateArr[2]);

			List<DoctorBill> list = doctorBillRepository.findAll();

			Date d;
			String dStr;
			int dmm, dyy;
			String[] dArr;

			for (DoctorBill a : list) {
				d = a.getDate();
				dStr = df.format(d);
				dArr = dStr.split("/");
				dmm = Integer.parseInt(dArr[0]);
				dyy = Integer.parseInt(dArr[2]);
				if (mm == dmm && yy == dyy) {
					currentMonth.add(a);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return currentMonth;
	}

	public boolean saveDoctorBill(DoctorBill doctorBill) {
		boolean flag = false;
		try {
			doctorBillRepository.save(doctorBill);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public String deleteDoctorBill(int id) {
		String responce = "Record not deleted";
		try {
			doctorBillRepository.deleteById(id);
			responce = "record deleted successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return responce;
	}
	
	
}
