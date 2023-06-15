package com.example.S20230403.controller.lcgController;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.S20230403.auth.PrincipalDetail;
import com.example.S20230403.model.Accom;
import com.example.S20230403.service.lcgService.ZzimService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ZzimController {
	private final ZzimService service;
	
	//  유저마이페이지에서 user_id를 파라미터로 내가 찜한 숙소 목록 보기 
	@GetMapping("/common-user/myzzim")
	public String myAccomZzimListsByUser_id(@AuthenticationPrincipal PrincipalDetail userDetail, Model model) {
		// 로그인 아이디 넣기 
		String user_id = userDetail.getUsername();
		
		// 권한 넣어주기
		// 찜을 한다는 건 로그인을 했다는 것. url로 치고 들어가도 에러나는 것을 확인.
		Collection<? extends GrantedAuthority> auth = userDetail.getAuthorities();
		
		List<Accom> myAccomZzimListsByUser_id = service.findMyAccomZzimListsByUser_id(user_id);
		
		log.info("로그인 한 user_id -> {} ",user_id);
		
		// 찜할 때 권한을 계속 물고 가기 때문에 같이 보내준다. 
		model.addAttribute("products", myAccomZzimListsByUser_id);
		model.addAttribute("auth", auth);
		model.addAttribute("user_id", user_id);
		
		return "/views/myZzim/myZzim";
	}
}
