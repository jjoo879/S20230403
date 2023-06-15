package com.example.S20230403.dao.lcgDao;

import java.util.List;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Room_Img;
import com.example.S20230403.model.Zzim;
import com.example.S20230403.model.ChanJoin;



public interface ProductsFilterDao {
	
	// 리펙토링 숙소 종류로 가져오기
	List<Accom> cgSelectProductListByAccomtype(String accom_type);
	
	// 썸네일 이미지를 가져오기
	List<Room_Img> cgSelectRoom_imgList();

	// 주소로 가져오기

	List<Accom> cgSelectProductListsByAddr(Accom accom);

	
	// ajax에서 사용
	
	List<ChanJoin> cgSelectAjaxProductListsByAccomtypeAndAddr(ChanJoin chanJoin);

	// 찜목록 가져오기
	List<Zzim> cgSelectZzimListsByUser_id(String user_id);
	
		

}
