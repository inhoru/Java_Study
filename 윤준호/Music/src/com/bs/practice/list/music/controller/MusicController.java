package com.bs.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bs.practice.list.music.model.compare.AscTitle;
import com.bs.practice.list.music.model.vo.Music;

public class MusicController {
	List list = new ArrayList();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	public List printAll() {
		List music=list;
		return music;
	}
	public Music searchMusic(String title) {
		for(Object o : list) {
			Music m=(Music)o;
			if(m.getTitle().equals(title)) {
				return m;
			}
		}
		return null;
	}
	public Music removeMusic(String title) {
		for(Object o : list) {
			Music m=(Music)o;
			if(m.getTitle().equals(title)) {
				list.remove(m);
				return m;
			}
		}
//		Music remove=null;
//		for(int i=0;i<list.size();i++) {
//			if(list.get(i).equals(title)) {
//			remove = list.remove(i);
//			}
//		}
//		return remove;
		return null;
	}
	public Music setMusic(String title, Music music) {
		for(int i=0;i<list.size();i++) {
			Music m=(Music)list.get(i);
			if(m.getTitle().equals(title)) {
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
		Collections.sort(list);
		return 1;
	}
	
}
