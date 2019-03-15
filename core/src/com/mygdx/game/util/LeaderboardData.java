package com.mygdx.game.util;

public class LeaderboardData {
    
	private String player;
	private Double score;
	private Long rank;
	
	public LeaderboardData(String player, Double score, Long rank) {
		this.player = player;
		this.score = score;
		this.rank = rank;
	}
	
	public String getPlayer() {
		return player;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}
	
	public Double getScore() {
		return score;
	}
	
	public void setScore(Double score) {
		this.score = score;
	}
	
	public Long getRank() {
		return rank;
	}
	
	public void setRank(Long rank) {
		this.rank = rank;
	}
}
