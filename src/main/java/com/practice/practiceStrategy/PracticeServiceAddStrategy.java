package com.practice.practiceStrategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.practiceStrategy.dto.Player1;
import com.practice.practiceStrategy.dto.Player2;
import com.practice.practiceStrategy.dto.Player3;
import com.practice.practiceStrategy.dto.Players;
import com.practice.practiceStrategy.playerAction.PlayerAction;

@Service
public class PracticeServiceAddStrategy {
	
	@Autowired
	private PlayerFactory factory;
	
	public void practiceStrategy() {
		
		List<PracticeEnum> practices = getPractices();
		
		Players players = new Players();
		
		// 取得個人資料
		for(PracticeEnum practice: practices) {
			// 利用工廠方法取得 bean 實體
			PlayerAction playerAction = factory.getPlayActionInstance(practice);
			// context執行實體
			PlayerActionContext context = new PlayerActionContext(playerAction);
			context.setPlayer(players);
		}
		
		calculateSocre(players);
		
		// 印出個人分數		
		showPersonalSocre(players);
		
	}
	
	private Players calculateSocre(Players players) {
		
		Player1 player1 = players.getPlayer1();
		Player2 player2 = players.getPlayer2();
		Player3 player3 = players.getPlayer3();
		
		int totalscore = player1.getScore() + player2.getScore() + player3.getScore();
		int avgScore = totalscore / 3;
		
		player1.setScoreDiff(player1.getScore() - avgScore);
		players.setPlayer1(player1);
		
		player2.setScoreDiff(player2.getScore() - avgScore);
		players.setPlayer2(player2);
		
		player3.setScoreDiff(player3.getScore() - avgScore);
		players.setPlayer3(player3);
			
		return players;
	}
	
	private List<PracticeEnum> getPractices() {
		
		List<PracticeEnum> practices = new ArrayList<PracticeEnum>();
		
		practices.add(PracticeEnum.CASE1);
		practices.add(PracticeEnum.CASE2);
		practices.add(PracticeEnum.CASE3);
		
		return practices;
	}
	
	private void showPersonalSocre(Players players) {
		
		List<PracticeEnum> practices = getPractices();
		
		for(PracticeEnum practice: practices) {
			// 利用工廠方法取得 bean 實體
			PlayerAction playerAction = factory.getPlayActionInstance(practice);
			// context執行實體
			PlayerActionContext context = new PlayerActionContext(playerAction);
			context.showPlayerInfo(players);
		}
	}
}
