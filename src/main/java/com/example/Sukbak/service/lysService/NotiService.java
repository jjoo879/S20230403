package com.example.Sukbak.service.lysService;

import java.util.List;

import com.example.Sukbak.model.Accom;
import com.example.Sukbak.model.AccomPayment;
import com.example.Sukbak.model.Notice_Faq;
import com.example.Sukbak.model.Payment;
import com.example.Sukbak.model.Qna;
import com.example.Sukbak.model.Room;
import com.example.Sukbak.model.Users;

public interface NotiService {

	List<Notice_Faq> listNoticeFaq(Notice_Faq nf);

	List<Notice_Faq> listnc(Notice_Faq nf);

	List<Notice_Faq> listnt(Notice_Faq nf);

	int qnaInset(Qna qna);



}
