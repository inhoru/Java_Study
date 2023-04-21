package com.bs.practice.set.model.compare;

import java.util.Comparator;

import com.bs.practice.set.model.vo.Lottery;

public class SortedLottery implements Comparator{
	public int compare(Object o1,Object o2) {
		Lottery prev=(Lottery)o1;
		Lottery next=(Lottery)o2;
		if(prev.getName().compareTo(next.getName())==0) {
			return prev.getPhone().compareTo(next.getPhone());
		}
		return prev.getName().compareTo(next.getName());
	}
}
