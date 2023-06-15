package com.example.S20230403.controller.lcgController;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Zzim;
import com.example.S20230403.service.lcgService.ZzimService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ZzimRestController {
	private final ZzimService service;
	
	@PostMapping("/productList/myzzim")
	public int cgAjaxZzimAdd(Zzim zzim) {
		
		int result = 0;

		// 혹시몰라서 여기서 한번 더 보안
		if(zzim.getUser_id() == null || zzim.getUser_id() == "" || !zzim.getAuth().equals("[USER]")) {
			return 0;
		}
		
		result = service.cgAjaxAddZzim(zzim);
		log.info("result 결과 1이 나와야 함 -> {} ",result);
		
		return result;
	}
	
	@DeleteMapping("/productList/myzzim/{user_id}")
	public int cgAjaxtZzimRemoveByUserId(Zzim zzim) {
		
		int result = 0;

		// 혹시몰라서 여기서 한번 더 보안
		if(zzim.getUser_id() == null || zzim.getUser_id() == "" || !zzim.getAuth().equals("[USER]")) {
			return 0;
		}
		
		result = service.cgAjaxRemoveZzimByUserId(zzim);
		log.info("result 결과 1이 나와야 함 -> {} ",result);
		
		return result;
	}
	
	@GetMapping("/commonUser/myzzim/{user_id}")
	public List<Accom> cgAjaxZzimListsByUser_id(@PathVariable("user_id") String user_id){
		
		List<Accom> cgAjaxZzimListsByUser_id = service.findAjaxMyAccomZzimListsByUser_id(user_id);
		
		return cgAjaxZzimListsByUser_id;
	}
}
