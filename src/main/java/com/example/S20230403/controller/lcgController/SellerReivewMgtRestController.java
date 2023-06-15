package com.example.S20230403.controller.lcgController;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.S20230403.auth.PrincipalDetail;
import com.example.S20230403.model.Review;
import com.example.S20230403.service.lcgService.SellerReviewMgtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SellerReivewMgtRestController {
	private final SellerReviewMgtService service;
	
	// biz_id와 kind(높은평점순 낮은평점순 인기순 구분자)를 파라미터로 사용해서 sorting해주는 로직
	@GetMapping("/biz/review/detail/biz-id/sorting")
	public List<Review> cgAjaxSortingReviewListByBizIdAndKind(Review review){
		log.info("/cgGetAjaxSortingReviewLists kind-> {} ", review.getKind());
		log.info("/cgGetAjaxSortingReviewLists biz_id-> {} ", review.getBiz_id());

		List<Review> ajaxReviewSortingLists = service.cgFindAjaxSortingReviewListsByBizIdAndKind(review);
		return ajaxReviewSortingLists;
		
	}
}
