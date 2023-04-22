package com.bs.practice.set.model.compare;

import java.util.Comparator;

import com.bs.practice.set.model.vo.Lottery;

public class SortedLottery implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		Lottery l1 = (Lottery)o1;
		Lottery l2 = (Lottery)o2;
		int result = l1.getName().compareTo(l2.getName());
		if(result != 0) {
			return result;
		} else {
			return l1.getPhone().compareTo(l2.getPhone());
		}
	}
	
}
