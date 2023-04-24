package com.attendence.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendence.dataObject.CheckInData;
import com.attendence.dataObject.CheckOutData;
import com.attendence.entities.CheckInProcessedData;
import com.attendence.entities.CheckOutProcessedData;
import com.attendence.repository.CheckinDataRepository;
import com.attendence.repository.CheckinProcessedDataRepository;
import com.attendence.repository.CheckoutDataRepository;
import com.attendence.repository.CheckoutProcessedDataRepository;

@Service
public class EmployeeRecordService {

	@Autowired
	CheckinDataRepository checkinDataRepository;

	@Autowired
	CheckoutDataRepository checkoutDataRepository;

	@Autowired
	CheckinProcessedDataRepository CheckinProcessedDataRepository;

	@Autowired
	CheckoutProcessedDataRepository checkoutProcessedDataRepository;

	public void data(int id) {

		List<CheckInData> checkinAll = checkinDataRepository.findAll();

		Map<Object, List<CheckInData>> empDataCheckin = checkinAll.stream()
				.collect(Collectors.groupingBy(ch -> ch.getEmployeeId()));

		for (Entry<Object, List<CheckInData>> entry : empDataCheckin.entrySet()) {

			Map<Object, List<Object>> checkinDateTime = entry.getValue().stream().collect(Collectors.groupingBy(
					chdate -> LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(chdate.getCheckinDateTime())),
					TreeMap::new, Collectors.mapping(e1 -> e1.getCheckinDateTime(), Collectors.toList())));
			System.out.println(entry.getKey() + "   :   " + entry.getValue());

			for (Entry<Object, List<Object>> entry2 : checkinDateTime.entrySet()) {

				String checkintime = (String) entry2.getValue().stream().findFirst().get();

				System.out.println("emp_id:" + entry.getKey() + "   ::   " + "date:" + entry2.getKey() + "   ::    "
						+ "checkintime:" + checkintime);

				CheckInProcessedData checkinProcesseddata = new CheckInProcessedData();
				checkinProcesseddata.setEmployeeId(entry.getKey().toString());
				checkinProcesseddata.setCheckinDate(entry2.getKey().toString());
				checkinProcesseddata.setCheckinDateTime(checkintime);

				CheckinProcessedDataRepository.save(checkinProcesseddata);

			}

		}

		List<CheckOutData> checkoutAll = checkoutDataRepository.findAll();

		Map<Object, List<CheckOutData>> empDataCheckout = checkoutAll.stream()
				.collect(Collectors.groupingBy(ch -> ch.getEmployeeId()));

		
		
		
		for (Entry<Object, List<CheckOutData>> entry : empDataCheckout.entrySet()) {

			Map<Object, List<Object>> checkoutDateTime = entry.getValue().stream().collect(Collectors.groupingBy(
					chdate -> LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(chdate.getCheckoutDateTime())),
					TreeMap::new, Collectors.mapping(e1 -> e1.getCheckoutDateTime(), Collectors.toList())));
			System.out.println(entry.getKey() + "   :   " + entry.getValue());

			for (Entry<Object, List<Object>> entry2 : checkoutDateTime.entrySet()) {

				String checkouttime = (String) entry2.getValue().stream().map(o->o.toString()).sorted(Comparator.reverseOrder()).findFirst().get();

				CheckOutProcessedData checkoutProcesseddata = new CheckOutProcessedData();
				checkoutProcesseddata.setEmployeeId(entry.getKey().toString());
				checkoutProcesseddata.setCheckoutDate(entry2.getKey().toString());
				checkoutProcesseddata.setCheckinDateTime(checkouttime);

				checkoutProcessedDataRepository.save(checkoutProcesseddata);

				System.out.println("emp_id:" + entry.getKey() + "   ::   " + "date:" + entry2.getKey() + "   ::    "
						+ "checkintime:" + checkouttime);

			}

		}

	}

	public int getTotalHours(int id) {

		List<CheckInData> checkin = (List<CheckInData>) checkinDataRepository.findAllByEmployeeId(id);
		List<CheckInData> checkinAll = checkinDataRepository.findAll();
		// CheckInData checkin1 = (CheckInData)
		// checkinDataRepository.findById(352).get();

		String checkinDateTime = checkin.stream().map(in -> in.getCheckinDateTime()).filter(chin -> {
			// System.out.println("LocalDate.now()--"+ LocalDate.now());
			// System.out.println("----"+LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(chin)));
			int result = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(chin)).compareTo(LocalDate.now());
			if (result == 0) {
				return true;
			} else {
				return false;
			}
		}).sorted().findFirst().get();

		List<CheckOutData> checkout = (List<CheckOutData>) checkoutDataRepository.findAllByEmployeeId(id);
		// CheckInData checkin1 = (CheckInData)
		// checkinDataRepository.findById(352).get();

		String checkoutDateTime = checkout.stream().map(in -> in.getCheckoutDateTime()).filter(chout -> {
			// System.out.println("LocalDate.now()--"+ LocalDate.now());
			// System.out.println("----"+LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(chin)));
			int result = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(chout)).compareTo(LocalDate.now());
			if (result == 0) {
				return true;
			} else {
				return false;
			}
		}).sorted(Comparator.reverseOrder()).findFirst().get();

		// System.out.println(checkin);

		// DateTimeFormatter dateTimeFormatter = new DateTimeFormatter();
		System.out.println(checkinDateTime);
		System.out.println(checkoutDateTime);

		long difference_In_Hours = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSSSSSSSS");
		try {

			// parse method is used to parse
			// the text from a string to
			// produce the date
			Date d1 = sdf.parse(checkinDateTime);
			Date d2 = sdf.parse(checkoutDateTime);

			long difference_In_Time = d1.getTime() - d2.getTime();

			System.out.println();

			difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

			System.out.println(difference_In_Hours);
		} catch (Exception e) {

			System.out.println(e);

		}

		return (int) difference_In_Hours;

	}
}
