package com.bs.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.bs.practice.list.music.model.compare.AscTitle;
import com.bs.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();

	public int addList(Music music) {
		list.add(music);
		return 1;

	}

	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;

	}

	public List printAll() {
		return list;
	}

	public Music searchMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.get(i);
			}

		}
		return null;
	}
	//이거왜 list.remove가 null을반환안하고 지우기전값을 반환하지?
	//집단지성이필료함;
	public Music removeMusic(String title) {
		Music remove = null; 
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				remove = list.remove(i);
			}
		}
		return remove;
	}

	public Music setMusic(String title, Music music) {
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getTitle().equals(title)){
				list.set(i, music);
				return list.get(i);
				
			}
		}
		return null;
	}

	public int ascTitle() {
		//곡명 오름차순
		list.sort(new AscTitle());
		return 1;
	}

	public int descSinger() {
		Collections.sort(list);
		//가수명 내림차순
		//list.sort((e1,e)->(e).getSinger().compareTo((e1).getSinger()));
		
		return 1;
		
	}

}
