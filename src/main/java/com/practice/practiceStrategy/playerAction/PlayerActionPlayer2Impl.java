package com.practice.practiceStrategy.playerAction;

import org.springframework.stereotype.Component;

import com.practice.practiceStrategy.dto.Player2;
import com.practice.practiceStrategy.dto.Players;

@Component("playerActionPlayer2Impl")
public class PlayerActionPlayer2Impl implements PlayerAction {

	@Override
	public Players setPlayer(Players players) {
		Player2 player2 = new Player2();
		player2.setName("Merry");
		player2.setScore(15);
		players.setPlayer2(player2);
		System.out.println("two");
		return players;
	}

	@Override
	public void showPlayerInfo(Players players) {
		Player2 palyer2 = players.getPlayer2();
		System.out.println("玩家名稱:"+palyer2.getName() + "分數差:" +palyer2.getScoreDiff());	
	}
	
}
