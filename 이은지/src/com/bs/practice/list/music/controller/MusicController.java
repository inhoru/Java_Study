package com.bs.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bs.practice.list.music.model.compare.AscTitle;
import com.bs.practice.list.music.model.vo.Music;

public class MusicController{
	List<Music> musicList=new ArrayList();
	
	//리스트 마지막에 객체 저장
	public int addList(Music music) {
		if(!musicList.contains(music)) {//중복값 걸러내는 기능 추가
			musicList.add(music);
			return 1;
		}else return 0;
	}
	
	//리스트 처음에 객체 저장
	public int addAtZero(Music music) {
		if(!musicList.contains(music)) {//중복값 걸러내는 기능 추가
			musicList.add(0, music);
			return 1;
		}else return 0;
	}
	
	//모든 리스트를 반환
	public List printAll() {
		return musicList;
	}
	
	//곡명으로 검색하는 메소드
	public Music searchMusic(String title) {
		for(Music music:musicList) {
			if(musicList.contains(music)) {
				return music;
			}
		}
		return null;
	}
	
	//곡명으로 객체를 찾아 삭제하는 메소드
	public Music removeMusic(String title) {
		for(Music music:musicList) {
			if(music.getTitle().equals(title)) {
				musicList.remove(music);
				return music;
			}
		}
		return null;
	}
	
	//곡명으로 객체를 찾아 내용을 수정하는 메소드
	public Music setMusic(String title, Music music) {
		for(int i=0;i<musicList.size();i++) {
			if(musicList.get(i).getTitle().equals(title)) {
				musicList.remove(i);
				musicList.add(i, music);
				return music;
			}
		}
		return null;
	}
	
	//곡명을 오름차순으로 정렬하는 메소드
	public int ascTitle() {
		musicList.sort(new AscTitle());
		return 1;
	}
	
	//가수명을 내림차순으로 정렬하는 메소드
	public int descSinger() {
		//compareTo 기준으로 정렬
		Collections.sort(musicList);
		return 1;
	}

	
}
