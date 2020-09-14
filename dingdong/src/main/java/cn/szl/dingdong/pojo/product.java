package cn.szl.dingdong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {

    private int id;
    private double price;
    private String name;
    private int number;
    private int m10;
    private int m13;
    private int m16;

}
