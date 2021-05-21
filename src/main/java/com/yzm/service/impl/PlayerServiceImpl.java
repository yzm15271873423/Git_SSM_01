package com.yzm.service.impl;

import com.yzm.mapper.PlayerMapper;
import com.yzm.pojo.Player;
import com.yzm.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2021/5/21 - 05 - 21 - 10:47
 * @Description: com.yzm.service.impl
 * @version: 1.0
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public int addPlayer(Player player) {
        return playerMapper.addPlayer(player);
    }

    @Override
    public List<Player> getAllPlayer() {
        return playerMapper.findAllPlayer();
    }
}
