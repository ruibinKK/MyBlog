package com.ruibin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//相册
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;
}
