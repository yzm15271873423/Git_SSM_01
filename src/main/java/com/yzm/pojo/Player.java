package com.yzm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: yzm
 * @Date: 2021/5/21 - 05 - 21 - 10:36
 * @Description: com.yzm.pojo
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String nickname;
    private String photo;
    private String filetype;

}
