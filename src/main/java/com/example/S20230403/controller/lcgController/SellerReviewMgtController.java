package com.example.S20230403.controller.lcgController;

import java.util.List;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.S20230403.auth.PrincipalDetail;
import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Review;
import com.example.S20230403.service.lcgService.SellerReviewMgtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SellerReviewMgtController {
	private final SellerReviewMgtService service;
	
	// 나의 업체를 가져오는 로직
	@GetMapping("/biz/review")
	public String myAccomListBySellerUserId(@AuthenticationPrincipal PrincipalDetail userDetail, Model model) {
		String sellerUser_id = userDetail.getUsername();

		log.info("컨트롤러 getMyAccoms  selleruser_id -> {} ", sellerUser_id);
		
		List<Accom> myAccoms = service.findMyAccomListBySellerUserId(sellerUser_id);

		log.info("컨트롤러getMyAccoms myAccoms 사이즈 -> -> {} ", myAccoms.size());
		
		model.addAttribute("myAccoms", myAccoms);
		
		return "/views/sellerReview/sellerReviewMgt";
	}
	
	// 실제 내 업소에 달린 리뷰를 가져오는 로직
	@RequestMapping("/biz/review/detail/biz-id/{biz_id}")
	public String myReviewListByBizId(@PathVariable("biz_id") String biz_id, Model model, Review review) {
		
		// ajax사용 시에 사용한 kind 값을 유지하기 위해 Review객체 안에 kind가 있음
		log.info("컨트롤러 getMyReviews biz_id-> {} ",biz_id);
		review.setBiz_id(biz_id);
		
		// 리뷰 다가져오기
		List<Review> myReviews = service.findMyReviewListByBizId(review);
		log.info("컨트롤러 getMyReviews  myReviews-> {} ", myReviews);
		
		// biz_id별로  리뷰 개수 가져오기, biz_id도 가져와야됨. ajax사용해야됨.
		Review totalReviewAndBiz_id = service.findMyReviewConutByBizId(biz_id);
		
		// 리뷰가 없을 시에 null일 경우 nullPointException 발동 되므로 토탈 리뷰 갯수를 null이라면  0으로 만들어준다. 
		if(totalReviewAndBiz_id == null) {
		   totalReviewAndBiz_id = new Review();
		   totalReviewAndBiz_id.setTotalReview(0);
		}
	
		model.addAttribute("myReviews", myReviews);
		model.addAttribute("totalReviewAndBiz_id", totalReviewAndBiz_id);
		return "/views/sellerReview/reviewDetail";
		
	}
	
	// 부당하게 달린 리뷰를 삭제요청하는 로직
	@PostMapping("/biz/review/delete-request")
	public String reviewDelRequestModifyByPayId(Review review, Model model) {
		
		log.info("delReason-> {} ",review.getDel_reason());
		log.info("review payid-> {} ",review.getPay_id());
		log.info("review bizid-> {} ",review.getBiz_id());
		
		String biz_id = review.getBiz_id();
		
		int resultRequest = service.modifyReviewDelRequestByPayId(review);
		
		// biz_id를 보내는 이유
		// @PathVariable("biz_id") String biz_id가 있기 때문에 받아줘야 한다. 
		model.addAttribute("biz_id", biz_id);
		return "forward:/biz/review/detail/biz-id/"+biz_id;
	}

	
}
