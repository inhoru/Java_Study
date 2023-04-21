package com.bs.practice.set.compare;

import java.util.Comparator;

import com.bs.practice.set.vo.Lottery;

public class SortedLottery implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		Lottery l1=(Lottery)o1;
		Lottery l2=(Lottery)o2;
		return (int)l1.getName().compareTo(l2.getName());
	}
}
