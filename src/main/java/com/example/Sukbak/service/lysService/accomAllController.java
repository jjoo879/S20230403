package com.example.Sukbak.service.lysService;

import java.util.List;

import com.example.Sukbak.model.Accom;
import com.example.Sukbak.model.AccomPayment;
import com.example.Sukbak.model.Notice_Faq;
import com.example.Sukbak.model.Payment;
import com.example.Sukbak.model.Room;
import com.example.Sukbak.model.Soldout;
import com.example.Sukbak.model.Users;

public interface accomAllController {

	List<Payment> getr_name(Payment pmt);

	List<AccomPayment> getapt(AccomPayment apt);

	List<Room> getR_price(AccomPayment apt);

	int paymentInsert(AccomPayment apt,List<String> resvDateList);

	List<Soldout> getResvDate(AccomPayment apt);

}
