package com.bs.practice.list.music.view;

import java.util.Scanner;

import com.bs.practice.list.music.controller.MusicController;
import com.bs.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	// 메인메뉴
	public void mainMenu() {
		while(true) {
			System.out.println("=====***** 메인 메뉴 *****=====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
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
				case 9 : System.out.println("===== 프로그램 종료 ====="); return;
				
			}
		}
	
	}
	
	// 마지막 위치에 곡 추가
	public void addList() {
		System.out.println("=====***** 마지막 위치에 곡 추가 *****=====");
		sc.nextLine();
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		int Compelete = mc.addList(new Music(title, singer));
		
		System.out.println(Compelete > 0 ? "추가 성공 :)" : "추가 실패 :(");
	}
	
	// 첫 인덱스에 곡 추가
	public void addAtZero() {
		System.out.println("=====***** 첫 위치에 곡 추가 *****=====");
		sc.nextLine();
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		int Compelete = mc.addAtZero(new Music(title, singer));
		
		System.out.println(Compelete > 0 ? "추가 성공 :)" : "추가 실패 :(");
	}
	
	// 전체 곡 목록 출력
	public void printAll() {
		System.out.println("=====***** 전체 곡 목록 *****=====");
		mc.printAll().forEach((m) -> System.out.println(m));
	}
	
	// 특정 곡 검색
	public void searchMusic() {
		System.out.println("=====***** 특정 곡 검색 *****=====");
		System.out.print("찾으실 곡 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		Music search = mc.searchMusic(title);
		
		if(search != null && search.getTitle().equals(title)) {
			System.out.println("검색하신 곡은 \"" + search + "\"입니다.");
		} else {
			System.out.println("검색한 곡이 없습니다.");
		}
	}
	
	// 특정 곡 삭제
	public void removeMusic() {
		System.out.println("=====***** 특정 곡 삭제 *****=====");
		System.out.print("삭제할 곡 : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		Music remove = mc.removeMusic(title);
		
		if(remove != null) {
			System.out.println("\"" + remove + "\" 곡을 삭제했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	
	// 특정 곡 정보 수정
	public void setMusic() {
		System.out.println("=====***** 특정 곡 정보 수정 *****=====");
		System.out.print("검색할 곡 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String newTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String singer = sc.nextLine();
		
		Music setMusic = new Music(newTitle, singer);
		Music update = mc.setMusic(title, setMusic);
		
		if(update != null) {
			System.out.println("\"" + update + "\" 곡을 수정했습니다.");
		} else {
			System.out.println("검색한 곡이 없습니다.");
		}
	}
	
	// 곡 명 오름차순 정렬
	public void ascTitle() {
		if(mc.ascTitle() > 0) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
	
	// 가수 명 내림차순 정렬
	public void descSinger() {
		if(mc.descSinger() < 0) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
}