package com.bs.practice.list.music.view;

import java.util.Scanner;

import com.bs.practice.list.music.controller.MusicController;
import com.bs.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc=new Scanner(System.in);
	private MusicController mc= new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** 메인 메뉴 *****");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정령");
			System.out.println("8. 가수명 내림차순 정력");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int cho=sc.nextInt();
			switch(cho) {
				case 1 : addList();break;
				case 2 : addAtZero();;break;
				case 3 : printall();;break;
				case 4 : searchMusic();;break;
				case 5 : removeMusic();;break;
				case 6 : setMusic();;break;
				case 7 : ascTitle();;break;
				case 8 : descSinger();;break;
				case 9 : System.out.println("종료");return;
			}
		}
		
	}
	public void addList() {
		sc.nextLine();
		System.out.println("***** 마지막 위치에 곡 추가 *****");
		System.out.print("곡 명 : ");
		String title=sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		System.out.println(mc.addList(new Music(title,singer))== 1 ? "추가 성공" : "추가 실패");
		
	}
	public void addAtZero() {
		sc.nextLine();
		System.out.println("***** 첫 위치에 곡 추가 *****");
		System.out.print("곡 명 : ");
		String title=sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		System.out.println(mc.addAtZero(new Music(title,singer))== 1 ? "추가 성공" : "추가 실패");
	}
	public void printall() {
		System.out.println("***** 전체 곡 목록 출력 *****");
		System.out.println(mc.printAll());
//		for(int i=0;i<mc.printAll().size();i++) {
//			System.out.println(mc.printAll().get(i));
//		}
	}
	public void searchMusic() {
		sc.nextLine();
		System.out.println("***** 특정 곡 검색 *****");
		System.out.print("검색할 곡명 : ");
		String title=sc.nextLine();
		if(mc.searchMusic(title)== null) {
			System.out.println("검색한 곡이 없습니다.");
		}else {
			System.out.println(mc.searchMusic(title));
		}
	}
	public void removeMusic() {
		sc.nextLine();
		System.out.println("***** 특정 곡 삭제 *****");
		System.out.print("삭제할 곡명 : ");
		String title=sc.nextLine();
		Music m=mc.removeMusic(title);
		if(m == null) {
			System.out.println("삭제할 곡이 없습니다.");
		}else {
			System.out.println(m+"을(를) 삭제 했습니다.");
		}
	}
	public void setMusic() {
		sc.nextLine();
		System.out.println("***** 특정 곡 수정 *****");
		System.out.print("검색할 곡명 : ");
		String title=sc.nextLine();
		System.out.print("수정할 곡명 : ");
		String setTitle=sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String setSinger=sc.nextLine();
		Music m=mc.setMusic(title, new Music(setTitle,setSinger));
		if(m== null) {
			System.out.println("수정할 곡이 없습니다.");
		}else {
			System.out.println(m+"의 값이 변경 되었습니다.");
		}
	}
	public void ascTitle() {
		System.out.println(mc.ascTitle()==1 ? "정렬 성공" : "정렬 실패");
	
	}
	public void descSinger() {
		System.out.println(mc.descSinger()==1 ? "정렬 성공" : "정렬 실패");
	}
}
