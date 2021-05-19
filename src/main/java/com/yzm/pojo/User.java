package com.yzm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: yzm
 * @Date: 2021/5/19 - 05 - 19 - 16:58
 * @Description: com.yzm.pojo
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String password;
}
