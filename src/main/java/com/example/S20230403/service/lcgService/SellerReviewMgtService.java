package com.example.S20230403.service.lcgService;

import java.util.List;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Review;

public interface SellerReviewMgtService {

	List<Review> findMyReviewListByBizId(Review review);

	List<Accom> findMyAccomListBySellerUserId(String sellerUser_id);

	int modifyReviewDelRequestByPayId(Review review);

	Review findMyReviewConutByBizId(String biz_id);

	// ajax 
	List<Review> cgFindAjaxSortingReviewListsByBizIdAndKind(Review review);
	

	




}
