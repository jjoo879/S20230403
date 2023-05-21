package com.example.Sukbak.dao.ljyDao;

import java.util.List;

import com.example.Sukbak.model.Accom;
import com.example.Sukbak.model.Comm;
import com.example.Sukbak.model.Room;
import com.example.Sukbak.model.Room_Img;
import com.example.Sukbak.model.Users;

public interface SukbakDao {

	void 			accomInsert(Accom accom);

	List<Accom> 	accomList(String id);

	List<Comm> 		selectCommList(int code);

	Accom 			accomSelect(String biz_id);

	void 			accomUpdate(Accom accom);

	String 			getDBPassword(String user_id);

	Users 			getNowLoginUser(String user_id);

	int 			userDelete(String user_id);

	void 			userUpdate(Users nowLoginUser);

	List<Room>		roomList(String user_id);

	void 			roomInsert(Room room);

	int 			roomIdExtract(Room room);

	int 			getImgNum(Room room);

	void 			roomImgInsert(Room room);

	List<Room> 	selectRoomImgList(Room_Img ri);

	Room 			roomSelect(Room room);

	void 			roomImgDelete(Room room);

	void			roomUpdate(Room room);

	void 			roomStatus(Room room, String string);

	boolean 		getBizId(String biz_id);

	void 			updateRoomCount(String biz_id, String string);

	void 			accomStatus(Accom accom, String string);

	List<Room> 		roomListSelectWithAccom(String biz_id);

	List<Room_Img> 	selectAccomAllRoomImgList(String biz_id);  
}        
       	   