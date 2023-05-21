package com.example.Sukbak.dao.lysDao;

import java.util.List;

import com.example.Sukbak.model.Accom;
import com.example.Sukbak.model.AccomPayment;
import com.example.Sukbak.model.Event;
import com.example.Sukbak.model.Notice_Faq;
import com.example.Sukbak.model.Payment;
import com.example.Sukbak.model.Qna;
import com.example.Sukbak.model.Room;
import com.example.Sukbak.model.Users;

public interface NotiQnaDao {

	List<Notice_Faq> listnofiFaq(Notice_Faq nf);

	List<Notice_Faq> listnc(Notice_Faq nf);

	List<Notice_Faq> listnt(Notice_Faq nf);

	int qnaInsert(Qna qna);

	List<Event> getEvent(Notice_Faq nf);

}
