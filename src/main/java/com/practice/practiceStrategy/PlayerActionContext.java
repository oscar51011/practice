package com.practice.practiceStrategy;

import com.practice.practiceStrategy.dto.Players;
import com.practice.practiceStrategy.playerAction.PlayerAction;

/**
 * 用來執行 PlayerAction
 * @author 林聖凱
 *
 */
public class PlayerActionContext {
	
	private PlayerAction playerAction;
	
	public PlayerActionContext(PlayerAction playerAction) {
		this.playerAction = playerAction;
	}

	// 設定 player
	public Players setPlayer(Players players) {
		return playerAction.setPlayer(players);
	}
	
	// 顯示 player
	public void showPlayerInfo(Players players) {
		playerAction.showPlayerInfo(players);
	}

	

}
