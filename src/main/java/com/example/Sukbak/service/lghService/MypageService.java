package com.example.Sukbak.service.lghService;

import java.util.List;

import com.example.Sukbak.model.GunJoin;
import com.example.Sukbak.model.Out;
import com.example.Sukbak.model.Review;
import com.example.Sukbak.model.Review_Img;
import com.example.Sukbak.model.Room;
import com.example.Sukbak.model.Users;

public interface MypageService {

			// 프로필 관련
			Users 				getMyProfileInfo(String user_id);
			int 				existingNick(String newNickname);
			int		 			updateMyProfile(Users users);
			int 				updatePassword(Users users);

			//예약 관련
			List<GunJoin> 		getMyResvList(String user_id);
			Review 				getMyResvReviews(GunJoin gunJoin);
			int 				cancelResv(GunJoin gunJoin);
			
			// 새 후기 관련
			GunJoin 			getMyAccomInfo(Room room);
			int 				putMyReview(GunJoin gj);
			int 				getMaxImgNum(Review_Img revImg);
			int 				putRevImgNum(Review_Img revImg);
			
			// 작성된 후기 관련
			List<Review> 		getMyReviewImages(String user_id);
			List<Review_Img> 	getDelImgList(Review_Img delImgNums);
			int 				deleteMyReview(int pay_id);
			
			// 탈퇴 관련
			int		 			updateWithdraw(String user_id);
			int 				putWithdraw(Out outData);

}