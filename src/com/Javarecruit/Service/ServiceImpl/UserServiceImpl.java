package com.Javarecruit.Service.ServiceImpl;

import com.Javarecruit.Dao.DaoImpl.UserDaoImpl;
import com.Javarecruit.Dao.UserDao;
import com.Javarecruit.Service.UserService;
import com.Javarecruit.pojo.User;

public class UserServiceImpl implements UserService {
    /**
     * 修改
     * @return 返回信息
     */
    @Override
    public int revise(User u) {
        UserDao userDao = new UserDaoImpl();
        return userDao.revise(u);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public String enroll(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.addByUser(user);
        return "成功";
    }

    /**
     * 登录
     * @param uname 用户名
     * @param pwd 用户密码
     * @return
     */
    @Override
    public String login(String uname, String pwd) {
        UserDao ud=new UserDaoImpl();
        User name = ud.querybynamepwd(uname, pwd);
        if (name!=null){
            return "成功";
        }
        return "失败";
    }
}
