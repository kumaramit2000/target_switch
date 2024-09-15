package services;

import dao.UserDao;
import enums.Gender;
import models.User;

public class FoodKartUserServiceImpl implements FoodKartUserService{

    UserDao userDao;

    public FoodKartUserServiceImpl() {
        this.userDao = UserDao.getInstance();
    }

    @Override
    public void registerUser(String name, String gender, String phoneNumber, String pincode) {
        User user = new User(name, gender.toLowerCase().equals("male") ? Gender.MALE : Gender.FEMALE, phoneNumber,pincode);
        userDao.addUser(user);
    }

    @Override
    public boolean loginUser(String userId) {
        User user = userDao.getUser(userId);
        if (user != null) {
            userDao.setCurrentLoginUser(user);
            return true;
        }
        return false;
    }

}
