package cn.szl.dingdong.service;

import cn.szl.dingdong.mapper.UserMapper;
import cn.szl.dingdong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp {

    @Autowired
    private UserMapper userMapper;

    public Boolean update_username(String username,String password){
        return userMapper.update_username(username,password);
    }

    public Boolean update_email(String email,String password){
        return userMapper.update_email(email,password);
    }

    public User queryByusername(String username){
        return userMapper.queryByusername(username);
    }

    public User query_email(String email){
        return userMapper.queryByemail(email);
    }


    public Boolean queryBytelephone(String telephone){

        User user = userMapper.queryByusername(telephone);

        if(user==null){
            return true;
        }else
            return false;

    }

    public Boolean queryByemail(String email){

        User user = userMapper.queryByusername(email);

        if (user==null){
            return true;
        }else
            return false;

    }

    public Boolean addUser(String username,String password,String email,String telephone){
        return userMapper.addUser(username,password,email,telephone);
    }
}
