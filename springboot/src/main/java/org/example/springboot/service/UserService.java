package org.example.springboot.service;
import org.example.springboot.entity.UserAccount;
import org.example.springboot.exception.CustomerException;
import org.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserAccount login(UserAccount user) {
        String username=user.getUsername() ;//账号名
        UserAccount dbUser =userMapper.selectByUsername(username);//先查有没有这个账号
        if(dbUser==null){
            throw new CustomerException("500","账号不存在");
        }
        String password =user.getPassword() ;//密码
        if (!dbUser.getPassword().equals(password)) {
            throw new CustomerException("500","账号密码错误");
        }
        if(dbUser.getIdentity()==null|| dbUser.getIdentity().isEmpty()){
            throw new CustomerException("500","角色名不能为空");
        }

        String Identity=user.getIdentity() ;
        if (!dbUser.getIdentity().equals(Identity)) {
            throw new CustomerException("500", "用户角色不匹配");
        }

return dbUser ;
    }

//    public UserAccount register(UserAccount user) {
//        String username=user.getUsername() ;//账号名
//
//        UserAccount dbUser =userMapper.selectByUsername(username);//先查有没有这个账号
//        if(dbUser!=null){
//            throw new CustomerException("500","账号已存在，请更换别的账号");
//        }
//        if(user.getPassword()==null||user.getPassword().isEmpty()){
//            throw new CustomerException("500","密码不能为空");
//        }
//        if(user.getUsername()==null|| user.getUsername().isEmpty()){
//            throw new CustomerException("500","账号名不能为空");
//        }
//userMapper.insert(user);
//return user ;
    }




