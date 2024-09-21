package com.systex.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class LotteryService {
	
	public LotteryService() {
		super();
	}
	
	public ArrayList<String> getNumber(int groups , LinkedList<String> excludes){
		ArrayList<String> t = new ArrayList<>();
		String group = String.valueOf(groups);
		Set<Integer> notpickNumber = new TreeSet<>();
		Set<Integer> pickNumberGroup = new TreeSet<>();
		int randomnum;
			
		for (String exclude : excludes) {
	        String[] e = exclude.trim().split("\\s+");
	        for (String num : e) {
	            notpickNumber.add(Integer.parseInt(num));
	        }
	    }

		for (int i=0;i<Integer.parseInt(group);i++) {
			while(pickNumberGroup.size()<6) {
				randomnum = (int)(Math.random()*49)+1;
				if (!notpickNumber.contains(randomnum)) {
					pickNumberGroup.add(randomnum);
				}
			}
			for (int pn : pickNumberGroup) {
				t.add(String.valueOf(pn));
			}
			pickNumberGroup.clear();
		}
		
		return t;
	}
}
