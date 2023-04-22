package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.vo.AscTitle;
import model.vo.Music;

public class MusicController {
	private List<Music> list=new ArrayList<>();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	public int addAtZero(Music music) {
		list.add(0,music);
		return 1;
	}
	public List printAll() {
		return list;
	}
	public List searchMusic(String title) {
		//문제에서는 리턴타입 뮤직이었지만, 같은 키워드를 포함한 다수의 뮤직객체 존재 가능성 고려,
		//리스트로 리턴타입 변경함.
//		for(int i=0;i<list.size();i++) {
//			Music m=(Music)list.get(i);
//			if(m.getTitle().contains(title)) {
//				return m;
//			}
//		}
//		return null;
		List matches=new ArrayList();
		for(Music m:list) {
			if(m.getTitle().equals(title)) {
				matches.add(m);
			}
		}
		return matches;
		
	}
	public Music removeMusic(String title) {
		Music m=null;
		for(int i=0;i<list.size();i++) {
			m=(Music)list.get(i);
			if(m.getTitle().equals(title)) {
				list.remove(i);
				return m;
			}
		}
		return null;
		//자동으로 인덱스 0번이 삭제됨
		//서치에서도 뮤직객체로 리턴받았을때 같은 문제 발생했음
	}
	public Music setMusic(String title, Music music) {
		//곡명으로 객체 검색, 객체가 있으면 객체정보 수정, 없으면 null리턴
		for(int i=0;i<list.size();i++) {
			Music m=(Music)list.get(i);
			if(m.getTitle().contains(title)) {
				list.set(i, music);
				return m;
			}
		}
		return null;
		
	}
	public int ascTitle() {
		list.sort(new AscTitle());
		return 1;
	}
	public int descSinger() {
		Collections.sort(list, new Comparator<Music>() {
			@Override
			public int compare(Music m1, Music m2) {
				return m2.getSinger().compareTo(m1.getSinger());
			}
		});
		return 1;
		
	}
}