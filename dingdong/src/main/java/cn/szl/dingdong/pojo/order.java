package cn.szl.dingdong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class order {


    private String username;
    private String address;
    private int id;
    private int number;
    private String state;


}
