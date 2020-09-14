package cn.szl.dingdong.mapper;

import cn.szl.dingdong.pojo.Location;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocationMapper {

    List<Location> queryByusername(String username);

    Boolean add_location(Location location);



}
