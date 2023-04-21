package com.bs.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.bs.practice.set.model.compare.SortedLottery;
import com.bs.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet lottery=new HashSet();
	private HashSet win=new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		boolean result=lottery.add(l);
//		System.out.println(result);
//		lottery.forEach((e)->System.out.println(e));
		return result;
	}
	public boolean deleteObject(Lottery l) {
		boolean result=lottery.remove(l);
		if(result==true && win!=null) {
			win.remove(l);
		}
		return result;
	}
	public HashSet winObject() {
		List ls=new ArrayList(lottery);
		if(win.size()<4) {
			boolean flag=true;
			while(flag) {
				for(int i=0;i<4-win.size();i++) {
					win.add(ls.get((int)(Math.random()*ls.size())));
				}
				if(win.size()==4) {
					flag=false;
					
				}
			}
			
		}
		return win;
	}
	public HashSet winObject2() {
		List ls=new ArrayList(lottery);
		if(win.size()<4) {
			while(win.size()==4) {
				win.add(ls.get((int)(Math.random()*ls.size())));
				
			}
		}
		return win;
	}
	public TreeSet sorteWinObject() {
		TreeSet ts=new TreeSet(new SortedLottery());
		ts.addAll(win);
		return ts;
	}
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}

}
