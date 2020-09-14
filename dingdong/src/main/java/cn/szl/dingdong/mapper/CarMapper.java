package cn.szl.dingdong.mapper;

import cn.szl.dingdong.pojo.car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CarMapper {

    List<car> queryByusername(String username);

    Boolean add(@Param("username") String username,
                @Param("goods_name")String goods_name,
                @Param("number")int number,
                @Param("size")String size,
                @Param("price")Double price);

    Boolean delete(int id);

}
