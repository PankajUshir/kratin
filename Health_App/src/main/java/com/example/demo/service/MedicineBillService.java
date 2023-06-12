package com.example.demo.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.MedicineBill;
import com.example.demo.repository.MedicineBillRepository;

@Service
public class MedicineBillService {

	@Autowired
	private MedicineBillRepository medicineBillRepository;

	public List<MedicineBill> getAllMedicineBill() {
		List<MedicineBill> currentMonth = new ArrayList<MedicineBill>();

		try {
			Date date = Calendar.getInstance().getTime();

			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
			System.out.println(df.format(date));
			String dateStr = df.format(date);
			String[] dateArr = dateStr.split("/");

			int mm = Integer.parseInt(dateArr[0]);
			int dd = Integer.parseInt(dateArr[1]);
			int yy = Integer.parseInt(dateArr[2]);

			List<MedicineBill> list = medicineBillRepository.findAll();

			Date d;
			String dStr;
			int dmm, dyy;
			String[] dArr;

			for (MedicineBill a : list) {
				d = a.getDate();
				dStr = df.format(d);
				dArr = dStr.split("/");
				dmm = Integer.parseInt(dArr[0]);
				dyy = Integer.parseInt(dArr[2]);
				if (mm == dmm && yy == dyy) {
					currentMonth.add(a);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentMonth;
	}

	public String deleteMedicineBill(int id) {
		String responce = "Record not deleted";
		try {
			medicineBillRepository.deleteById(id);
			responce = "record deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responce;
	}

}
