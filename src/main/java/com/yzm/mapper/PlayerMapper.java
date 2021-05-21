package com.yzm.mapper;

import com.yzm.pojo.Player;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2021/5/21 - 05 - 21 - 10:46
 * @Description: com.yzm.mapper
 * @version: 1.0
 */
public interface PlayerMapper {
    int addPlayer(Player player);

    @Select("select * from player")
    List<Player> findAllPlayer();
}
