package cn.szl.dingdong.mapper;

import cn.szl.dingdong.pojo.order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    List<order> queryByusername(String username);



}
