package com.bs.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bs.practice.list.music.model.compare.AscTitle;
import com.bs.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();
	
	public int addList(Music music) {
		if(!list.contains(music)) {
			list.add(list.size(), music);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int addAtZero(Music music) {
		if(!list.contains(music)) {
			list.add(0, music);
			return 1;
		} else {
			return 0;
		}
	}
	
	public List<Music> printAll() {
		return list;
	}
	
	public Music searchMusic(String title) {
		Music search = null;
		
		for(Music m : list) {
			if(m.getTitle().equals(title)) {
				search = m;
			}
		} return search;
	}
	
	public Music removeMusic(String title) {
		Music remove = null;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				remove = list.get(i);
				list.remove(i);
			}
		} return remove;
	}
	
	public Music setMusic(String title, Music music) {
		Music update = null;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				update = list.get(i);
				list.set(i, music);
			}
		} return update;
	}
	
	public int ascTitle() {
		list.sort(new AscTitle());
		return 1;
	}
	
	public int descSinger() {
		Collections.sort(list);
		return 1;
	}
}