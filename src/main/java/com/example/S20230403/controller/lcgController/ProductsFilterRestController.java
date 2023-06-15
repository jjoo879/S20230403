package com.example.S20230403.controller.lcgController;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.S20230403.auth.PrincipalDetail;
import com.example.S20230403.model.ChanJoin;
import com.example.S20230403.service.lcgService.ProductsFilterService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsFilterRestController {
	private final ProductsFilterService service;
	
	@RequestMapping("/cgAjaxProductList")
	public List<ChanJoin> cgAjaxProductListsByAccomtypeAndAddr(@AuthenticationPrincipal PrincipalDetail userDetail, 
																ChanJoin chanJoin){
		
		log.info("ajax cgProductList getKind-> {} ", chanJoin.getKind());
		log.info("ajax cgProductList getAccom_type-> {} ", chanJoin.getAccom_type());
		log.info("ajax cgProductList getCheck_in-> {} ", chanJoin.getCheck_in());
		log.info("ajax cgProductList getCheck_out()-> {} ", chanJoin.getCheck_out());
		log.info("ajax cgProductList getBed_type(-> {} ", chanJoin.getBed_type());
		log.info("ajax cgProductList getCafe()-> {} ", chanJoin.getCafe());
		log.info("ajax cgProductList getStore()-> {} ", chanJoin.getStore());
		log.info("ajax cgProductList getFitness()-> {} ", chanJoin.getFitness());
		log.info("ajax cgProductList getR_capacity()-> {} ", chanJoin.getR_capacity());
		log.info("ajax cgProductList getMin_price_r2()-> {} ", chanJoin.getMin_price_r2());
		log.info("ajax cgProductList getAddr()-> {} ", chanJoin.getAddr());
		
		// userDetail에 있는 정보를 넣을 필드를 초기화 함.
		// user_id 초기화
		String user_id = "";
		// 권한 초기화.
		Collection<? extends GrantedAuthority> auth = null;
		
		// 만약에 로그인을 안했다면.
		if(userDetail == null) {
			user_id = "";
			auth = null;
		// 로그인을 했다면 필드에 넣어주기 .
		}else {
			user_id = userDetail.getUsername();
			auth = userDetail.getAuthorities();
		}
		
		log.info("로그인하고 안하고 확인하기 -> {} ", user_id);
		log.info("로그인하고 안하고 확인하기 -> {} ", auth);

		// id를 세팅하는 이유는 서비스에 가서 로그인한 아이디 값으로 zzim 목록을 가져오기 위함
		// 그리고 zzim 리스트의 user_id와 로그인한 아이디 값이 일치했을 때 accom모델에 있는 zzim_status에 Y라는 값을 넣기 위함. 서비스 딴 참고.
		chanJoin.setUser_id(user_id);
		
		List<ChanJoin> cgAjaxProductLists = service.cgFindAjaxProductListsByAccomtypeAndAddr(chanJoin);
		
		log.info("ajax cgProductList  사이즈 -> {} ", cgAjaxProductLists.size());
		return cgAjaxProductLists;
	}
	

}
