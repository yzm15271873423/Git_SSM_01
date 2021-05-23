package com.yzm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: yzm
 * @Date: 2021/5/23 - 05 - 23 - 11:18
 * @Description: com.yzm.pojo
 * @version: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
}
