package com.bs.practice.set.compare;

import java.util.Comparator;

import com.bs.practice.set.model.vo.Lottery;

public class SortedLottery implements Comparator<Lottery>{
	@Override
	public int compare(Lottery l1, Lottery l2) {
		
		l1.getName().compareTo(l2.getName());
		if(l1.getName().compareTo(l2.getName())==0) {
			return l1.getPhone().compareTo(l2.getPhone());
		}else {
			return l1.getName().compareTo(l2.getName());
		}
	}
}
