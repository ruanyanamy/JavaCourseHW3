package com.systex.model;

public class GuessGame {
	private int remains;
	private int luckynumber;
	
	public GuessGame(int range , int remains) {
		this.remains = remains;
		luckynumber = (int)(Math.random()*range) + 1;
	}
	
	public boolean guess(int number) {
		this.remains--;
		if (this.luckynumber == number) {
			return true;
		}else {
			return false;
		}	
	}
	
	public int getRemains() {
		System.out.println("remains: "+remains);
		return remains;
	}	
	
	public int getLuckyNumber() {
		return luckynumber;
	}
}
