package com.example.Sukbak.service.yheService;

import com.example.Sukbak.model.Users;

public interface UsersService {

    Users getUserAccount(String userId);
    void saveUser(Users user);

    int exists(String userId);

    void saveUser2Api(Users user);

    int isNewUser(String userId);

    void delete(String userId);

    void addInfoUser(Users users);

    int existsNick(String nickname);

    int existsPhone(String phone);
}