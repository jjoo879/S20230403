package com.example.S20230403.dao.lghDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.GunJoin;
import com.example.S20230403.model.Out;
import com.example.S20230403.model.Qna;
import com.example.S20230403.model.Review;
import com.example.S20230403.model.Review_Img;
import com.example.S20230403.model.Room;
import com.example.S20230403.model.Users;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MypageDaoImpl implements MypageDao {

	private final SqlSessionTemplate session;

	@Override
	public Users getMyProfileInfo(String user_id) {
		System.out.println("MypageDAO getMyProfileInfo Start...");
		Users myProfileInfo = new Users();
		try {
			myProfileInfo = session.selectOne("getMyProfileInfo", user_id);
			System.out.println("MypageDAO myProfileInfo getNickname-> " + myProfileInfo.getNickname());
		} catch (Exception e) {
			System.out.println("MypageDAO myProfileInfo Exception-> " + e.getMessage());
		}
		return myProfileInfo;
	}

	@Override
	public int updateMyProfile(Users users) {
		System.out.println("MypageDAO updateProfile start...");
		int updateMyProfile = 0;
		try {
			updateMyProfile = session.update("updateMyProfile", users);
		} catch (Exception e) {
			System.out.println("MypageDAO updateMyProfile Exception-> " + e.getMessage());
		}
		return updateMyProfile;
	}
	
	@Override
	public int updatePassword(Users users) {
		System.out.println("MypageDAO updatePassword start...");
		int updatePwd = 0;
		try {
			updatePwd = session.update("updatePassword", users);
			System.out.println("MypageDAO updatePwd-> " + updatePwd);
		} catch (Exception e) {
			System.out.println("MypageDAO updatePassword Exception-> " + e.getMessage());
		}
		return updatePwd;
	}
	
	
	
	@Override
	public List<GunJoin> getMyResvList(String user_id) {
		List<GunJoin> myResvList = null;
		System.out.println("MypageDAO getMyResvList Start...");
		try {
			myResvList = session.selectList("getMyResvList", user_id);
			System.out.println("MypageDAO getMyResvList myResvList.size()-> " + myResvList.size());
		} catch (Exception e) {
			System.out.println("MypageDAO getMyResvList e.getMessage()-> " + e.getMessage());
		}
		return myResvList;
	}

	@Override
	public List<GunJoin> GetMyResvImgList(GunJoin biz_id) {
		System.out.println("MypageDAO GetMyResvImgList start...");
		List<GunJoin> myResvImgList = null;
		try {
			myResvImgList = session.selectList("getMyResvImgList", biz_id);
			System.out.println("MypageDAO myResvImgList.size()-> " + myResvImgList.size());
		} catch (Exception e) {
			System.out.println("MypageDAO GetMyResvImgList Exception-> " + e.getMessage());
		}
		return myResvImgList;
	}

	
	
	@Override
	public GunJoin getMyAccomInfo(Room room) {
		System.out.println("MypageDAO getMyAccomInfo start...");
		GunJoin myAccomInfo = new GunJoin();
		try {
			myAccomInfo = session.selectOne("getMyAccomInfo", room);
			System.out.println("MypageDAO getMyAccomInfo.getBizname-> " + myAccomInfo.getBiz_name());
		} catch (Exception e) {
			System.out.println("MypageDAO getMyAccomInfo Exception-> " + e.getMessage());
		}
		return myAccomInfo;
	}
	
	@Override
	public int putMyReview(GunJoin gj) {
		System.out.println("MypageDAO putMyReview Start...");
		int putMyReview = 0;
		try {
			putMyReview = session.insert("putMyReview", gj);
		} catch (Exception e) {
			System.out.println("MypageDAO putMyReview Exception-> " + e.getMessage());
		}
		return putMyReview;
	}

	@Override
	public int getMaxImgNum(Review_Img revImg) {
		System.out.println("MypageDAO getMaxImgNum start");
		int imgNum = 0;
		try {
			imgNum = session.selectOne("getMaxImgNum", revImg);
			System.out.println("MypageDAO maxImgNum-> " + imgNum);
		} catch (Exception e) {
			System.out.println("MypageDAO getMaxImgNum Exception-> " + e.getMessage());
		}
		return imgNum;
	}

	@Override
	public int putRevImgNum(Review_Img revImg) {
		System.out.println("MypageDAO putRevImgNum start");
		int putRevImgNumResult = 0;
		try {
			putRevImgNumResult = session.insert("putRevImgNum", revImg);
			System.out.println("MypageDAO putRevImgNum result-> " + putRevImgNumResult);
		} catch (Exception e) {
			System.out.println("MypageDAO putRevImgNum Exception-> " + e.getMessage());
		}
		return putRevImgNumResult;
	}
	
	
	
	@Override
	public List<Review> getMyReviewList(String user_id) {
		System.out.println("MypageDAO getMyReviewList start...");
		List<Review> myReviewList = null;
		try {
			myReviewList = session.selectList("getMyReviewList", user_id);
			System.out.println("MypageDAO myReviewList.size()-> " + myReviewList.size());
		} catch (Exception e) {
			System.out.println("MypageDAO getMyReviewList Exception-> " + e.getMessage());
		}
		return myReviewList;
	}
	
	@Override
	public List<Review_Img> getMyReviewImgList(List<Integer> myPayIds) {
		System.out.println("MypageDAO getMyReviewImgList start...");
		List<Review_Img> myReviewImgList = null;
		try {
			myReviewImgList = session.selectList("getMyReviewImgList", myPayIds);
			System.out.println("MypageDAO myReviewImgList.size()-> " + myReviewImgList.size());
		} catch (Exception e) {
			System.out.println("MypageDAO getMyReviewImgList Exception-> " + e.getMessage());
		}
		return myReviewImgList;
	}
	
	@Override
	public Review getMyRevUpdate(int pay_id) {
		System.out.println("MypageDAO getMyRevUpdate start");
		Review getMyRevUpdate = null;
		try {
			getMyRevUpdate = session.selectOne("getMyRevData", pay_id);
		} catch (Exception e) {
			System.out.println("MypageDAO getMyRevUpdate Exception-> " + e.getMessage());
		}
		return getMyRevUpdate;
	}
	
	@Override
	public int updateMyReview(Review review) {
		System.out.println("MypageDAO updateMyReview start");
		int updateMyReview = 0;
		try {
			updateMyReview = session.update("updateMyReview", review);
			System.out.println("MypageDAO updateMyReview result-> " + updateMyReview);
		} catch (Exception e) {
			System.out.println("MypageDAO updateMyReview Exception-> " + e.getMessage());
		}
		return updateMyReview;
	}
	
	@Override
	public int deleteMyReviewImg(int pay_id) {
		System.out.println("MypageDAO deleteReviewImg start");
		int deleteMyReviewImg = 0;
		try {
			deleteMyReviewImg = session.delete("deleteMyReviewImg", pay_id);
			System.out.println("MypageDAO deleteMyReview result-> " + deleteMyReviewImg);
		} catch (Exception e) {
			System.out.println("MypageDAO deleteMyReviewImg Exception-> " + e.getMessage());
		}
		return deleteMyReviewImg;
	}
	
	@Override
	public int deleteMyReview(int pay_id) {
		System.out.println("MypageDAO deleteMyReview start...");
		int deleteMyReview = 0;
		try {
			
			deleteMyReview = session.delete("deleteMyReview", pay_id);
			System.out.println("MypageDAO deleteMyReview result-> " + deleteMyReview);
		} catch (Exception e) {
			System.out.println("MypageDAO deleteMyReview Exception-> " + e.getMessage());
		}
		return deleteMyReview;
	}

	@Override
	public int checkPassword(String user_id, String inputPW) {
		System.out.println("MypageDAO inputPW-> " + inputPW);
		int    pwChkResult = 0;
		String dbPwString = null;
		try {
			dbPwString = session.selectOne("checkPassword", user_id);
			System.out.println("MypageDAO dbPwString-> " + dbPwString);
			if (inputPW.equals(dbPwString)) pwChkResult = 1;
			else                            pwChkResult = 0;
			
		} catch (Exception e) {
			System.out.println("MypageDAO checkPassword Exception-> " + e.getMessage());
		}
		return pwChkResult;
	}
	
	@Override
	public int updateWithdraw(String user_id) {
		System.out.println("MypageDAO updateWithdraw Start...");
		int updateWithdraw = 0;
		System.out.println("MypageDAO user_id-> " + user_id);
		try {
			updateWithdraw = session.update("updateWithdraw", user_id);
			System.out.println("MypageDAO updateWithdraw result-> " + updateWithdraw);
		} catch (Exception e) {
			System.out.println("MypageDAO updateWithdraw Exception-> " + e.getMessage());
		}
		return updateWithdraw;
	}

	@Override
	public int putWithdraw(Out outData) {
		System.out.println("MypageDAO putWithdraw start...");
		int putWithdraw = 0;
		try {
			putWithdraw = session.insert("putWithdraw", outData);
		} catch (Exception e) {
			System.out.println("MypageDAO putWithdraw Exception-> " + e.getMessage());
		}
		return putWithdraw;
	}

	
	
	@Override
	public Qna getMyQna(String user_id) {
		System.out.println("MypageDAO getMyQna start");
		Qna getMyQna = null;
		try {
			getMyQna = session.selectOne("getMyQna", user_id);
		} catch (Exception e) {
			System.out.println("MypageDAO getMyQna Exception-> " + e.getMessage());
		}
		return getMyQna;
	}

	@Override
	public List<Review_Img> getRevImages(int pay_id) {
		System.out.println("MypageDAO getRevImages Start..");
		List<Review_Img> getMyRevImages = null;
		try {
			getMyRevImages = session.selectList("getMyRevImages", pay_id);
		} catch (Exception e) {
			System.out.println("MypageDAO getRevImages Exception-> " + e.getMessage());
		}
		return getMyRevImages;
	}
	



}
