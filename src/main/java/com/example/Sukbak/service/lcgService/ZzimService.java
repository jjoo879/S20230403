package com.example.Sukbak.service.lcgService;

import java.util.List;

import com.example.Sukbak.model.Accom;
import com.example.Sukbak.model.Zzim;

public interface ZzimService {
	// 찜하기
	int cgAjaxInsertZzim(Zzim zzim);
	// 찜 삭제
	int cgAjaxDeleteZzim(Zzim zzim);
	
	// 찜 리스트 가져오기 
	List<Accom> getMyAccomZzimListsByUser_id(String user_id);
	
	
	List<Accom> getAjaxMyAccomZzimListsByUser_id(String user_id);


}
