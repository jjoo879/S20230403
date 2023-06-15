package com.example.S20230403.dao.lcgDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.Accom;

import com.example.S20230403.model.Review;
import com.example.S20230403.model.Review_Img;
import com.example.S20230403.model.Room_Img;
import com.example.S20230403.model.Users;



@Repository
@RequiredArgsConstructor
@Slf4j
public class SellerReviewMgtDaoImpl implements SellerReviewMgtDao {
	private final SqlSession session;
	
	@Override
	public List<Accom> selectMyAccomListBySellerUserId(String sellerUser_id) {
		
		List<Accom> myAccoms = null;
		try {
			myAccoms = session.selectList("selectMyAccomListBySellerUserId", sellerUser_id);
			
		} catch (Exception e) {
			log.error("dao selectMyAccomListBySellerUserId 에러 -> {} ",e.getMessage());
		}
		
		return myAccoms;
	}
	
	@Override
	public List<Room_Img> selectMyAccomsImg() {
		//System.out.println("dao getMyaccomsimg 시작");
		List<Room_Img> myAccomsImgs = null;
		try {
			myAccomsImgs = session.selectList("cgSelectRoom_imgList");
		} catch (Exception e) {
			log.error("dao selectMyAccomsImg 에러 -> {} ",e.getMessage());
		}
		return myAccomsImgs;
	}


	@Override
	public List<Accom> selectMyInfoDetailByBizId(String biz_id) {
		
		List<Accom> myInfo = null;
		try {
			myInfo = session.selectList("selectMyInfoDetailByBizId", biz_id);
		} catch (Exception e) {
			log.error("dao selectMyInfoDetailByBizId 에러 -> {} ",e.getMessage());
		}
		return myInfo;
	}

	@Override
	public List<Review> selectMyReviewListByBizId(Review review) {
		List<Review> myReviews = null;
		try {
			myReviews = session.selectList("selectMyReviewListByBizId", review);
		} catch (Exception e) {
			log.error("dao selectMyReviewListByBizId 에러 -> {} ",e.getMessage());
		}
		return myReviews;
	}

	@Override
	public Users selectUserNicknameDetailByUserId(String user_id) {

		Users userNicknames = null;
		try {
			userNicknames = session.selectOne("selectUserNicknameDetailByUserId", user_id);
		} catch (Exception e) {
			log.error("dao selectUserNicknameDetailByUserId 에러 -> {} ",e.getMessage());
		}
		return userNicknames;
	}

	@Override
	public List<Review_Img> selectReviewImgListByPayId(int pay_id) {
	
		List<Review_Img> review_imgs = null;
		try {
			review_imgs = session.selectList("selectReviewImgListByPayId", pay_id);
		} catch (Exception e) {
			log.error("dao selectReviewImgListByPayId 에러 -> {} ",e.getMessage());
		}
		return review_imgs;
	}


	@Override
	public int updateReviewDelRequestByPayId(Review review) {
	
		int resultRequest = 0;
		try {
			resultRequest = session.update("updateReviewDelRequestByPayId", review);
		
		} catch (Exception e) {
			log.error("dao updateReviewDelRequestByPayId 에러 -> {} ",e.getMessage());
		}
		return resultRequest;
	}

	@Override
	public Review selectMyReviewConutByBizId(String biz_id) {
		Review totalReviewAndBiz_id = null;
		try {
			totalReviewAndBiz_id = session.selectOne("selectMyReviewConutByBizId", biz_id);
		} catch (Exception e) {
			log.error("dao selectMyReviewConutByBizId 에러 -> {} ",e.getMessage());
		}
		return totalReviewAndBiz_id;
	}
	
	// ajax
	@Override
	public List<Review> cgSelectAjaxSortingReviewListsByBizIdAndKind(Review review) {
		List<Review> ajaxReviewSortingLists = null;
		try {
			ajaxReviewSortingLists = session.selectList("cgSelectAjaxSortingReviewListsByBizIdAndKind", review);
		} catch (Exception e) {
			log.error("dao cgSelectAjaxSortingReviewListsByBizIdAndKind 에러 -> {} ",e.getMessage());
		}
		return ajaxReviewSortingLists;
	}






}
