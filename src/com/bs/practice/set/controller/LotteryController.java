package com.bs.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.bs.practice.set.view.LotteryMenu;
import com.bs.practice.set.vo.Lottery;

public class LotteryController {
	
	private HashSet lottery=new HashSet();
	private HashSet win=new HashSet();
	
	//셋에 값 저장
	public boolean insertObject(Lottery l) {
		if(l!=null) {
			lottery.add(l); return true;
		}
		return false;
	}
	
	//셋에 있는 값을 삭제
	public boolean deleteObject(Lottery l) {
		for(Object o:lottery) {
			Lottery lottery=(Lottery)o;
			if(lottery.equals(l)) {
				this.lottery.remove(lottery);
				if(win.equals(l)) win.remove(lottery);
				return true;
			}
		}
		return false;
	}
	
	//모든 당첨자 출력
	public HashSet winObject() {
		while (true) {
			ArrayList lotteryList = new ArrayList();
			lotteryList.addAll(lottery);
			if (lottery.size() >= 4) {
				while (win.size()<5) {
					win.add(lotteryList.get((int)Math.random() * 4));
					System.out.println(lotteryList.get((int)Math.random() * 4));
					System.out.println(win.size());
				}
				break;
			} else if (lottery.size() < 4) {
				System.out.println("4명 이상의 인원이 있어야합니다.");
				new LotteryMenu().insertObject();
				break;
			}
		}
		return win;
	}
	
	//정렬된 당첨자 목록을 출력
	public TreeSet sortedWinObject() {
		return null;
	}
	
	//특정 당첨자를 검색
	public boolean searchWinner(Lottery l) {
		return false;
	}
	
}
