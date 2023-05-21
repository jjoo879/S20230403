package com.example.Sukbak.service.kjsService;

import java.util.List;

import com.example.Sukbak.model.Accom;
import com.example.Sukbak.model.JinJoin;
import com.example.Sukbak.model.Review;
import com.example.Sukbak.model.Room_Img;

public interface AccomDetailService {

	List<JinJoin> getAccomDetailRoomList(String biz_id, String checkIn, String checkOut);

	Accom getAccomBasicInfo(String biz_id);

	List<Room_Img> getRoomImgList(String biz_id);

	List<Review> getAccomReviewWithImagesList(String biz_id);

	Review getCalculateReview(String biz_id);

}