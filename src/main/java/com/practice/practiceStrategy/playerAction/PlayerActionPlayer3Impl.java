package com.practice.practiceStrategy.playerAction;

import org.springframework.stereotype.Component;

import com.practice.practiceStrategy.dto.Player3;
import com.practice.practiceStrategy.dto.Players;

@Component("playerActionPlayer3Impl")
public class PlayerActionPlayer3Impl implements PlayerAction {

	@Override
	public Players setPlayer(Players players) {
		Player3 player3 = new Player3();
		player3.setName("John");
		player3.setScore(11);
		players.setPlayer3(player3);
		System.out.println("three");
		return players;
	}

	@Override
	public void showPlayerInfo(Players players) {
		Player3 palyer3 = players.getPlayer3();
		System.out.println("玩家名稱:"+palyer3.getName() + "分數差:" +palyer3.getScoreDiff());		
	}
	
}
