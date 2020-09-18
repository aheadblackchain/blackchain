package com.ahead.blockchain.servlet;

import com.ahead.blockchain.dao.UserDao;
import com.ahead.blockchain.entity.User;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServlet {
    @Autowired
    private UserDao userDao;

    public User insertOrUpdateUser(User user){
       return userDao.save(user);
    }

    public void delUser(Long id){
        userDao.deleteById(id);
    }

    public List<User> userList(){
        return userDao.findAllByOrderByIdDesc();
    }

    public User getUserById(Long id){return userDao.findById(id).orElseGet(() -> new User());}
}
