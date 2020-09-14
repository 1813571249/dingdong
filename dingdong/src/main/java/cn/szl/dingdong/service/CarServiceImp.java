package cn.szl.dingdong.service;

import cn.szl.dingdong.mapper.CarMapper;
import cn.szl.dingdong.pojo.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImp {

    @Autowired
    private CarMapper carMapper;


    public List<car> queryByusername(String username){

        return carMapper.queryByusername(username);
    }

    public Boolean add(String username,String goods_name,int number,String size,Double price){
        return carMapper.add(username,goods_name,number,size,price);
    }

    public Boolean delete(int id){
        return carMapper.delete(id);
    }
}
