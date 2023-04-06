package com.kagami.j2ee.user.service;

import com.kagami.j2ee.user.dao.UserDao;
import com.kagami.j2ee.user.entity.UserInfo;

import java.util.List;

public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public List<UserInfo> getBookInfos(UserInfo userInfo) {
        // TODO Add your bussiness
        return this.userDao.list(userInfo);
    }

    public UserInfo getUserInfo(int userId) {
        // TODO Add your bussiness
        return this.userDao.get(userId);
    }

    public UserInfo addUserInfo(UserInfo userInfo) {
        // TODO Add your bussiness
        return this.userDao.insert(userInfo);
    }

    public UserInfo modifyUserInfo(UserInfo userInfo) {
        // TODO Add your bussiness
        return this.userDao.update(userInfo);
    }

    public Boolean deleteUserInfo(int useId) {
        // TODO Add your bussiness
        return this.userDao.delete(useId);
    }
}
