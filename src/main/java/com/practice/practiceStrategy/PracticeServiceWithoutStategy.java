package com.practice.practiceStrategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.practiceStrategy.dto.Player1;
import com.practice.practiceStrategy.dto.Player2;
import com.practice.practiceStrategy.dto.Player3;
import com.practice.practiceStrategy.dto.Players;

@Service
public class PracticeServiceWithoutStategy {
	
	public void practiceStrategy() {
	
		List<PracticeEnum> practices = getPractices();
		
		Players players = new Players();
		
		// 取得個人資料
		for(PracticeEnum practice: practices) {
			switch(practice) {
				case CASE1: {
					Player1 player1 = new Player1();
					player1.setName("Tom");
					player1.setScore(10);
					players.setPlayer1(player1);
					System.out.println("one");
					break;
				}
				case CASE2: {
					Player2 player2 = new Player2();
					player2.setName("Merry");
					player2.setScore(15);
					players.setPlayer2(player2);
					System.out.println("two");
					break;
				}
				case CASE3: {
					Player3 player3 = new Player3();
					player3.setName("John");
					player3.setScore(11);
					players.setPlayer3(player3);
					System.out.println("three");
					break;
				}
			}
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
			switch(practice) {
				case CASE1: {
					Player1 palyer1 = players.getPlayer1();
					System.out.println("玩家名稱:"+palyer1.getName() + "分數差:" +palyer1.getScoreDiff());
					break;
				}
				case CASE2: {
					Player2 palyer2 = players.getPlayer2();
					System.out.println("玩家名稱:"+palyer2.getName() + "分數差:" +palyer2.getScoreDiff());
					break;
				}
				case CASE3: {
					Player3 palyer3 = players.getPlayer3();
					System.out.println("玩家名稱:"+palyer3.getName() + "分數差:" +palyer3.getScoreDiff());
					break;
				}
			}
		}
	}
	
	
}
