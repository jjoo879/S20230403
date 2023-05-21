package com.example.Sukbak.service.kjsService;

import java.util.List;
import java.util.Map;

import com.example.Sukbak.model.Notice_Faq;
import com.example.Sukbak.model.Qna;

public interface ChatBotService {

	List<Notice_Faq> getNoticeFaqTitleList(String notice_type);

	List<Notice_Faq> getNoticeFaqContentList(String notice_id);

	void qnaInsert(Qna qna);

}
