package com.example.S20230403.service.lcgService;

import java.util.List;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.ChanJoin;



public interface ProductsFilterService {
	

	// 리펙토링
	List<Accom> cgFindProductListByAccomtype(Accom accom);

	
	// 주소로 찾기 

	List<Accom> cgFindProductListsByAddr(Accom accom);

	
	// ajax에서 사용하는 거
	List<ChanJoin> cgFindAjaxProductListsByAccomtypeAndAddr(ChanJoin chanJoin);
	


}
