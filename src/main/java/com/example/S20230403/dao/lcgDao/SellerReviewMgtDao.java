package com.example.S20230403.dao.lcgDao;

import java.util.List;

import org.apache.catalina.User;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Payment;
import com.example.S20230403.model.Review;
import com.example.S20230403.model.Review_Img;
import com.example.S20230403.model.Room_Img;
import com.example.S20230403.model.Users;

public interface SellerReviewMgtDao {

	List<Accom> selectMyInfoDetailByBizId(String biz_id);

	List<Review> selectMyReviewListByBizId(Review review);

	Users selectUserNicknameDetailByUserId(String user_id);

	List<Review_Img> selectReviewImgListByPayId(int pay_id);
	// 숙박가져오기
	List<Accom> selectMyAccomListBySellerUserId(String sellerUser_id);

	List<Room_Img> selectMyAccomsImg();

	int updateReviewDelRequestByPayId(Review review);

	Review selectMyReviewConutByBizId(String biz_id);

	List<Review> cgSelectAjaxSortingReviewListsByBizIdAndKind(Review review);







}
