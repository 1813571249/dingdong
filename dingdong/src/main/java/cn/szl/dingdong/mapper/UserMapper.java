package cn.szl.dingdong.mapper;

import cn.szl.dingdong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    User queryByusername(String username);

    User queryByemail(String email);

    Boolean addUser(String username,String password,String email,String telephone);

    Boolean update_username(String username,String password);

    Boolean update_email(String email,String password);

}
