package com.practice.practiceStrategy.playerAction;

import com.practice.practiceStrategy.dto.Players;

/**
 * 定義interface決定處理行為
 * 1. 設定 player
 * 2. 顯示 player
 * @author 林聖凱
 *
 */
public interface PlayerAction {
	Players setPlayer(Players players);
	void showPlayerInfo(Players players);
}
