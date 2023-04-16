package com.bs.practice.list.music.model.compare;

import java.util.Comparator;

import com.bs.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Music prev=(Music)o1;
		Music next=(Music)o2;
		if(prev.getTitle().equals(next.getTitle())) {
			return prev.getSinger().compareTo(next.getSinger());
		}
		return prev.getTitle().compareTo(next.getTitle());
	}
}

