package com.bs.practice.list.music.view;

import java.util.Scanner;

import com.bs.practice.list.music.controller.MusicController;
import com.bs.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
//	사용자가 직접 메인 메뉴를 선택할 수 있음. 종료 전까지 반복 실행.
//	각 메뉴를 누를 시 해당 메소드로 이동. 
	public void mainMenu() {
		while(true) {
			System.out.println("**** 메인 메뉴 ****");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int choice = sc.nextInt();
			switch(choice) {
				case 1 : addList(); break;
				case 2 : addAtZero(); break;
				case 3 : printAll(); break;
				case 4 : searchMusic(); break;
				case 5 : removeMusic(); break;
				case 6 : setMusic(); break;
				case 7 : ascTitle(); break;
				case 8 : descSinger(); break;
				case 9 : System.out.println("종료"); return;
			}
		}
	}
	
//	마지막 위치에 곡 추가 성공을 알리는 메소드
	public void addList() {
		System.out.println("**** 마지막 위치에 곡 추가 ****");
		System.out.print("곡 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		System.out.println(mc.addList(new Music(title, singer)) == 1 ? "추가 성공" : "추가 실패");
	}
	
//	첫 위치에 곡 추가 성공을 알리는 하는 메소드
	public void addAtZero() {
		System.out.println("**** 첫 위치에 곡 추가 ****");
		System.out.print("곡 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		System.out.println(mc.addAtZero(new Music(title, singer)) == 1 ? "추가 성공" : "추가 실패");
	}
	
//	전체 곡 목록을 출력 성공을 알리는 메소드
	public void printAll() {
		System.out.println("**** 전체 곡 목록 출력 ****");
		System.out.println(mc.printAll());
	}
	
//	 특정 곡 검색의 결과를 보여주는 메소드
	public void searchMusic() {
		System.out.println("**** 특정 곡 검색 ****");
		System.out.print("곡 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		if(mc.searchMusic(title) == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println("검색한 곡은 " + mc.searchMusic(title) + "입니다.");
		}
	}
	
//	특정 곡 삭제 결과를 보여주는 메소드
	public void removeMusic() {
		System.out.println("**** 특정 곡 삭제 ****");
		System.out.print("삭제할 곡 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		Music m = mc.removeMusic(title);
		if(m == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(m.getSinger() + " - " + m.getTitle() + "을(를) 삭제했습니다.");
		}
	}
	
//	특정 곡 정보 수정 결과를 보여주는 메소드
	public void setMusic() {
		System.out.println("**** 특정 곡 정보 수정 ****");
		// 사용자에게 수정할 곡을 입력 하여 MusicController에 setMusic으로 검색 할 수 있게
		// 값을 넘기며 수정할 곡 명과 가수 명을 받아 setMusic으로 값을 넘긴다.
		// 검색 결과 값이 없으면 “수정할 곡이 없습니다.”, 검색 결과 값이 있고
		// 수정 했으면 “000(곡 명, 가수 명)의 값이 변경 되었습니다.” 콘솔 창에 출력
		System.out.print("검색할 곡 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		Music m2 = mc.searchMusic(title);
		
		System.out.print("수정할 곡 명 : ");
		String setTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String setSinger = sc.nextLine();
		Music m = new Music(setTitle, setSinger);
		Music m1 = mc.setMusic(title, m);
		if(m1 == null) {
			System.out.println("수정할 곡이 없습니다.");
		} else {
			System.out.println(m2.getSinger() + " - " + m2.getTitle() + "의 값이 변경되었습니다.");
		}
	}
	
//	곡 명 오름차순 정렬 성공을 알리는 메소드
	public void ascTitle() {
		System.out.println("**** 곡 명 오름차순 정렬 ****");
		// MusicController에 ascTitle()의 값에 따라 성공 시 “정렬 성공”, 실패 시 “정렬 실패"
		int num = mc.ascTitle();
		if(num == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
	
//	가수 명 내림차순 정렬 성공을 알리는 메소드
	public void descSinger() {
		System.out.println("**** 가수 명 내림차순 정렬 ****");
		// musicController에 descSinger()의 값에 따라 성공 시 “정렬 성공”, 실패 시 “정렬 실패"
		int num = mc.descSinger();
		if(num == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
	
}
