package com.practice.practiceStrategy.dto;

/**
 * 記錄個人分數&差異
 * @author 林聖凱
 *
 */
public class Player3 {
	private String name;
	private int score;
	private int scoreDiff;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScoreDiff() {
		return scoreDiff;
	}
	public void setScoreDiff(int scoreDiff) {
		this.scoreDiff = scoreDiff;
	}
}
