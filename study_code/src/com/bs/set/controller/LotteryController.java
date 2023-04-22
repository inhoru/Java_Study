package com.bs.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.bs.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<Lottery>();
	private HashSet<Lottery> win = new HashSet<Lottery>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		
		if(win != null && win.contains(l)) {
			lottery.remove(l);
			return win.remove(l);
		} else if(lottery.contains(l)){
			return lottery.remove(l);
		} else {
			return false;
		}
	}
	
	public HashSet<Lottery> winObject() {
		ArrayList<Lottery> copy = new ArrayList<Lottery> (lottery);
		
		for(int i=0; i<copy.size(); i++) {
			win.add((copy.get(i)));
			if(win.size() == 4) {
				return win;
			}
		}
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject(){
		TreeSet<Lottery> treeWin = new TreeSet<Lottery>(win);
		return treeWin;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
}
