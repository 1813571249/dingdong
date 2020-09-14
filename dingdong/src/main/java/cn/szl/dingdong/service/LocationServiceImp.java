package cn.szl.dingdong.service;

import cn.szl.dingdong.mapper.LocationMapper;
import cn.szl.dingdong.pojo.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImp {

    @Autowired
    private LocationMapper locationMapper;

    public List<Location> queryByusername(String username){

        return locationMapper.queryByusername(username);

    }

    public Boolean add_location(Location location){

        return locationMapper.add_location(location);
    }

}
