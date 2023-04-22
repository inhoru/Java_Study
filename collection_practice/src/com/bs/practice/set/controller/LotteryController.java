package com.bs.practice.set.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import com.bs.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery=new HashSet<>();
	private HashSet<Lottery> win=new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		// 전달 받은 l을 lottery에 추가 후, 추가 결과인 boolean 값 반환
		return lottery.add(l);
		
	}
	public boolean deleteObject(Lottery l) {
		// 전달 받은 l을 lottery에서 삭제
		// 당첨자 목록(win) 중에 삭제된 추첨 대상자가 존재할 수 있으니
		// win에도 해당 추첨 대상자 삭제..무슨말이야 마지막
		boolean result=lottery.remove(l);
		if(result==true&&win!=null) {
			win.remove(l);
		}
		return result;
	}
	public HashSet winObject() {
		// 추첨 대상자 중에서 랜덤으로 뽑아 당첨 목록에 넣는 메소드
		// 랜덤으로 뽑기 위해 lottery를 ArrayList에 담고,
//		List<Lottery> list = new ArrayList<Lottery>(lottery);
//		int[] index=new int[4];
//		int count=0;
//		while(count<4) {
//			int randomIndex=(int)(Math.random()*list.size());
//			Lottery selected=list.get(randomIndex);
//			if(!win.contains(selected)) {
//				win.add(selected);
//				count++;
//			}
//			list.remove(randomIndex);
//		}
//		
//		return win;
		
		// 인덱스를 이용해 win에 당첨자 저장
		// 이 때, 당첨자 수는 무조건 4명이며 이를 위해 추첨자 수는 4명 이상이어야 함
		
		// 만일 당첨자 목록에 삭제된 추첨 대상자가 있다면
		// 기존에 당첨된 사람은 제외하고 삭제된 사람의 자리만 새로운 추첨자로 채움
		List<Lottery> list = new ArrayList<Lottery>(lottery);
		int[] index=new int[4];
		for(int i=0;i<4;i++) {
			index[i]=(int)(Math.random()*list.size());
			for(int j=0;j<i;j++) {
				if(index[i]==index[j]) {
					i--;
				}
			}
			if(win.size()<4) {
				win.add(list.get(index[i]));
			}else {
				break;
			}
		}
		return win;
		
		
	}
	public TreeSet sortedWinObject() {
		// 이름으로 오름차순 정렬하되, 이름이 같으면 번호로 오름차순 하는
		// 정렬기준을 가지고 정렬된 결과를 반환
		// 이 때, 미리 만들어진 win을 가지고 정렬하기 때문에
		// 당첨 대상 확인을 꼭 먼저 해야함
		TreeSet winTree=new TreeSet();
		winTree.addAll(win);
		return winTree;
		
	}
	public boolean searchWinner(Lottery l) {
		// 전달 받은 l을 win에서 찾고 찾은 결과인 boolean 값 반환
		return win.contains(l);
	}

}
