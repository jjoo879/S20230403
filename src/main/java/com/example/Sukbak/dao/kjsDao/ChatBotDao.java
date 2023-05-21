package com.example.Sukbak.dao.kjsDao;

import java.util.List;
import java.util.Map;

import com.example.Sukbak.model.Notice_Faq;
import com.example.Sukbak.model.Qna;

public interface ChatBotDao {

	List<Notice_Faq> fetchNoticeFaqTitleList(String notice_type);

	List<Notice_Faq> fetchNoticeFaqContentList(String notice_id);

	void qnaInsert(Qna qna);
	
}
