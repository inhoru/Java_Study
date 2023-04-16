package com.bs.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bs.practice.list.music.compare.AscTitle;
import com.bs.practice.list.music.model.vo.Music;

public class MusicController {
	List list = new ArrayList();
	
//	리스트 마지막에 값 저장 메소드
	public int addList(Music music) {
		// 마지막 리스트에 객체 저장, 1 리턴
		list.add(music);
		return 1;
	}
	
//	리스트 첫 번째에 값 저장 메소드
	public int addAtZero(Music music) {
		// 첫 번째 리스트에 객체 저장, 1 리턴
		list.add(0, music);
		return 1;
	}
	
//	모든 리스트를 반환하는 메소드
	public List printAll() {
		return list;
	}
	
//	곡 명을 검색하는 메소드
	public Music searchMusic(String title) {
		for(int i = 0; i < list.size(); i++) {
			Music m = (Music)list.get(i);
			if(m.getTitle().equals(title)) {
				return m;
			}
		}
		return null;
	}
	
//	곡 명으로 찾아 삭제하는 메소드
	public Music removeMusic(String title) {
		for(int i = 0; i < list.size(); i++) {
			Music m = (Music)list.get(i);
			if(m.getTitle().equals(title)) {
				list.remove(i); 
				return m;
			}
		}
		return null;
	}
	
//	곡 명으로 찾아 내용을 수정하는 메소드
	public Music setMusic(String title, Music music) {
		for(int i = 0; i < list.size(); i++) {
			Music m = (Music)list.get(i);
			if(m.getTitle().equals(title)) {
				list.set(i, music);
				return m;
			}
		}
		return null;
	}
	
//	곡 명 오름차순 정렬하는 메소드
//	리스트 곡 명 오름차순 정렬, 제목이 같으면 가수 명으로 오름차순 정렬, 1 리턴
	public int ascTitle() {
		list.sort(new AscTitle());
		return 1;
	}
	
//	가수 명을 내림차순 정렬하는 메소드
//	리스트 가수 명 내림차순 정렬, 1 리턴
	public int descSinger() {
		Collections.sort(list);
		return 1;
	}
	
}
