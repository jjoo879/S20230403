package com.example.S20230403.dao.lcgDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Room_Img;
import com.example.S20230403.model.Zzim;
import com.example.S20230403.model.ChanJoin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductsFilterDaoImpl implements ProductsFilterDao {
	private final SqlSession session;

		// 호텔 빼고 accom_type으로 호텔 리스트 가져오기
		@Override
		public List<Accom> cgSelectProductListByAccomtype(String accom_type) {

			List<Accom> cgProductLists = null;
			try {
				cgProductLists = session.selectList("cgSelectProductListByAccomtype",accom_type);
			} catch (Exception e) {
				log.error("dao cgSelectProductListByAccomtype 에러-> {} ",e.getMessage());
				// TODO: handle exception
			}
			return cgProductLists;
		}
		
		
		// 호텔 사진빼고 다가져오기
		@Override
		public List<Room_Img> cgSelectRoom_imgList() {
		
			List<Room_Img> cgGetRoom_img = null;
			try {
				cgGetRoom_img = session.selectList("cgSelectRoom_imgList");
			} catch (Exception e) {
				log.error("dao cgSelectRoom_imgList 에러-> {} ",e.getMessage());
			}
			return cgGetRoom_img;
		}
		
		
		// 주소로 호텔빼고 리스트 가져오기
		@Override
		public List<Accom> cgSelectProductListsByAddr(Accom accom) {
			
			List<Accom> cgProductListsByAddr = null;
			try {
				cgProductListsByAddr = session.selectList("cgSelectProductListsByAddr", accom);
				
			} catch (Exception e) {
				log.error("dao cgSelectProductListsByAddr 에러-> {} ",e.getMessage());
			}
			return cgProductListsByAddr;
		}
		
		
		// ajax dao 필터링
		@Override
		public List<ChanJoin> cgSelectAjaxProductListsByAccomtypeAndAddr(ChanJoin chanJoin) {
			
			List<ChanJoin> cgAjaxProductLists = null;
			try {
			
				cgAjaxProductLists = session.selectList("cgSelectAjaxProductListsByAccomtypeAndAddr", chanJoin);
				
			} catch (Exception e) {
				log.error("dao cgSelectAjaxProductListsByAccomtypeAndAddr 에러-> {} ",e.getMessage());
			
			}
			return cgAjaxProductLists;
		}


		@Override
		public List<Zzim> cgSelectZzimListsByUser_id(String user_id) {
		
			List<Zzim> zzimLists = null;
			try {
				zzimLists = session.selectList("cgSelectZzimListsByUser_id", user_id);
			} catch (Exception e) {
				log.error("dao cgSelectAjaxProductListsByAccomtypeAndAddr 에러-> {} ",e.getMessage());
				
			}
			return zzimLists;
		}

}
