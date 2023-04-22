package model.vo;

import java.util.Comparator;

import model.vo.Music;

public class AscTitle implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		Music prev=(Music)o1;
		Music next=(Music)o2;
		return prev.getTitle().compareTo(next.getTitle());
	}
}
