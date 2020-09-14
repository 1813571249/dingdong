package cn.szl.dingdong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private int id;
    private String username;
    private String address;
    private String telephone;
    private String postal;
    private String receiver;

}
