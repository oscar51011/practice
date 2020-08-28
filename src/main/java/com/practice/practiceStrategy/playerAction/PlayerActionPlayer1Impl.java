package com.practice.practiceStrategy.playerAction;

import org.springframework.stereotype.Component;

import com.practice.practiceStrategy.dto.Player1;
import com.practice.practiceStrategy.dto.Players;

@Component("playerActionPlayer1Impl")
public class PlayerActionPlayer1Impl implements PlayerAction {

	@Override
	public Players setPlayer(Players players) {
		Player1 player1 = new Player1();
		player1.setName("Tom");
		player1.setScore(10);
		players.setPlayer1(player1);
		System.out.println("one");
		return players;
	}

	@Override
	public void showPlayerInfo(Players players) {
		Player1 palyer1 = players.getPlayer1();
		System.out.println("玩家名稱:"+palyer1.getName() + "分數差:" +palyer1.getScoreDiff());	
	}

}
