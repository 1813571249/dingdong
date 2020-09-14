package cn.szl.dingdong.service;

import cn.szl.dingdong.mapper.OrderMapper;
import cn.szl.dingdong.pojo.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp {

    @Autowired
    private OrderMapper orderMapper;

    public List<order> queryByusername(String username){

        return orderMapper.queryByusername(username);
    }


}
