package com.example.S20230403.dao.lcgDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Room_Img;
import com.example.S20230403.model.Zzim;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ZzimDaoImpl implements ZzimDao {
	private final SqlSession session;

	@Override
	public int cgAjaxInsertZzim(Zzim zzim) {
		int result = 0;
		try {
			result = session.insert("cgAjaxInsertZzim", zzim);
		} catch (Exception e) {
			log.error("dao cgAjaxInsertZzim 에러 -> {} ",e.getMessage());
		}
		return result;
	}

	@Override
	public int cgAjaxDeleteZzimByUserId(Zzim zzim) {
		
		int result = 0;
		try {
			result = session.delete("cgAjaxDeleteZzimByUserId", zzim);
		} catch (Exception e) {
			log.error("dao cgAjaxDeleteZzimByUserId 에러 -> {} ",e.getMessage());
		}
		return result;
	}

	// 유저 마이페이지에서 찜한 숙소만 가져오기 
	@Override
	public List<Accom> selectMyAccomZzimListsByUser_id(String user_id) {
		
		List<Accom> myAccomZzimLists = null;
		try {
			myAccomZzimLists = session.selectList("selectMyAccomZzimListsByUser_id", user_id);
		} catch (Exception e) {
			log.error("dao selectMyAccomZzimListsByUser_id 에러 -> {} ",e.getMessage());
		}
		return myAccomZzimLists;
	}
	// 유저 마이페이지에서 찜한 숙소 이미지만 가져오기 
	@Override
	public List<Room_Img> selectMyZzimAccomImgListByUser_id(String user_id) {
		
		List<Room_Img> myZzimAccomImgsByUser_id = null;
		try {
			myZzimAccomImgsByUser_id = session.selectList("selectMyZzimAccomImgListByUser_id", user_id);
		} catch (Exception e) {
			log.error("dao selectMyZzimAccomImgListByUser_id 에러 -> {} ",e.getMessage());
		}
		return myZzimAccomImgsByUser_id;
	}

	
}
