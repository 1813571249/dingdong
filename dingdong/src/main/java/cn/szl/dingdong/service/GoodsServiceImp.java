package cn.szl.dingdong.service;

import cn.szl.dingdong.mapper.GoodsMapper;
import cn.szl.dingdong.pojo.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class GoodsServiceImp {

    @Autowired
    private GoodsMapper goodsMapper;


    public product queryById(int Id){
        return goodsMapper.queryById(Id);
    }

    public List<product> queryProductList(){
        return goodsMapper.queryProductList();
    }
}
