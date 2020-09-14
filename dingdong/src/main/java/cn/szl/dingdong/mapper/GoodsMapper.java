package cn.szl.dingdong.mapper;

import cn.szl.dingdong.pojo.product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {

    product queryById(int Id);
    List<product> queryProductList();
}
