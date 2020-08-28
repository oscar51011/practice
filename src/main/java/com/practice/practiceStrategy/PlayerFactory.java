package com.practice.practiceStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.practice.practiceStrategy.playerAction.PlayerAction;

/**
 * 工廠模式初始化 bean
 * @author 林聖凱
 *
 */
@Component
public class PlayerFactory {
	
	@Qualifier("playerActionPlayer1Impl")
	@Autowired
	private PlayerAction playerActionPlayer1Impl;
	
	@Qualifier("playerActionPlayer2Impl")
	@Autowired
	private PlayerAction playerActionPlayer2Impl;
	
	@Qualifier("playerActionPlayer3Impl")
	@Autowired
	private PlayerAction playerActionPlayer3Impl;
	
	public PlayerAction getPlayActionInstance(PracticeEnum practiceEnum) {
		switch(practiceEnum) {
			case CASE1:
				return playerActionPlayer1Impl;
			case CASE2:
				return playerActionPlayer2Impl;
			case CASE3:
				return playerActionPlayer3Impl;
			default:
				throw new IllegalArgumentException("Initial Bean not foun");
		}
	}
	
	
}
