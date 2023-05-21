package com.example.Sukbak.dao.lysDao;

import java.util.List;

import com.example.Sukbak.model.Accom;
import com.example.Sukbak.model.AccomPayment;
import com.example.Sukbak.model.Notice_Faq;
import com.example.Sukbak.model.Payment;
import com.example.Sukbak.model.Qna;
import com.example.Sukbak.model.Room;
import com.example.Sukbak.model.Soldout;
import com.example.Sukbak.model.Users;

public interface AccomAllDaoImpl {

	List<Accom> searchAc(Accom accom);

	List<Users> userlist(Users usid);

	int userNum(Users usid);

	int userTotal();

	int coundTotalUser(Users usid);

	List<Users> listSearchUsers(Users usid);

	List<Payment> getr_name(Payment pmt);

	List<AccomPayment> getapt(AccomPayment apt);

	List<Room> getR_price(AccomPayment apt);

	int insertPayment(AccomPayment apt);

	int insertReserv(AccomPayment apt);

	int insertSoldOut(List<String> resvDateList);
	

	List<Soldout> getResvDate(AccomPayment apt);


}
