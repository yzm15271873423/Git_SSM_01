package com.yzm.controller;

import com.yzm.pojo.Player;
import com.yzm.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2021/5/21 - 05 - 21 - 10:33
 * @Description: com.yzm.controller
 * @version: 1.0
 */
@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping("addPlayer")
    public String phototype(Player player){
        System.out.println(player);
        playerService.addPlayer(player);

        return "forward:/showPlayer.jsp";
    }

    @RequestMapping("getAllPlayer")
    @ResponseBody
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayer();
    }
}
