package com.yzm.service;

import com.yzm.pojo.Player;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2021/5/21 - 05 - 21 - 10:47
 * @Description: com.yzm.service
 * @version: 1.0
 */
public interface PlayerService {
    int addPlayer(Player player);

    List<Player> getAllPlayer();
}
