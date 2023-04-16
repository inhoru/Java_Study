package com.bs.practice.list.music.compare;

import java.util.Comparator;

import com.bs.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// 곡 명 오름 차순 정렬의 기준을 제공하는 메소드
		Music m1 = (Music)o1;
		Music m2 = (Music)o2;
		int result = m1.getTitle().compareTo(m2.getTitle());
		if(result != 0) {
			return result;
		} else {
			return m1.getSinger().compareTo(m2.getSinger());
		}
	}
	
}
