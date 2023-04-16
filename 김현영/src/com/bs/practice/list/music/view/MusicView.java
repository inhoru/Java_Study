package com.bs.practice.list.music.view;

import java.util.Scanner;

import com.bs.practice.list.music.controller.MusicController;
import com.bs.practice.list.music.model.vo.Music;

public class MusicView {
	Scanner sc=new Scanner(System.in);
	MusicController mc=new MusicController();
	
	//사용자가 메인메뉴 선택하게 하는 메소드. 종료 전까지 반복실행
	public void mainMenu() {
		int order=0;
		while (true) {
			System.out.println("******main menu******");
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
			order = sc.nextInt();
			
			switch(order) {
			case 1 : addList(); break;
			case 2 : addAtZero(); break;
			case 3 : printAll(); break;
			case 4 : searchMusic(); break;
			case 5 : removeMusic(); break;
			case 6 : setMusic(); break;
			case 7 : ascTitle(); break;
			case 8 : descSinger(); break;
			case 9 : System.out.println("종료"); return;
			default : System.out.println("잘못 입력하셨습니다."); break;
			}
			
		}
		
		
	}
	
	//마지막 위치에 곡 추가 성공을 알리는 메소드
	public void addList() {
		String title="";
		String singer="";
		
		sc.nextLine();
		System.out.println("******마지막 위치에 추가******");
		System.out.print("노래 제목 입력 : ");
		title=sc.nextLine();
		System.out.print("가수 이름 입력 : ");
		singer=sc.nextLine();
		
		Music music=new Music(title, singer);
		
		if(mc.addList(music)==1) {
			System.out.println("추가 성공");
		}else System.out.println("추가 실패");
	}
	
	//첫 위치에 곡 추가 성공을 알리는 메소드
	public void addAtZero() {
		String title="";
		String singer="";
		
		sc.nextLine();
		System.out.println("******첫번째 위치에 추가******");
		System.out.print("노래 제목 입력 : ");
		title=sc.nextLine();
		System.out.print("가수 이름 입력 : ");
		singer=sc.nextLine();
		
		Music music=new Music(title, singer);
		
		if(mc.addAtZero(music)==1) {
			System.out.println("추가 성공");
		}else System.out.println("추가 실패");
	}
	
	//전체 곡 목록 출력 성공을 알리는 메소드
	public void printAll() {
		mc.printAll().forEach((m)->System.out.println(m));
		
	}
	
	//특정 곡 검색의 결과를 보여주는 메소드
	public void searchMusic() {
		System.out.println("********특정 곡 검색********");
		sc.nextLine();
		System.out.print("검색할 곡 제목 : ");
		String title=sc.nextLine();
		
		if(mc.searchMusic(title)!=null) {
		System.out.println(mc.searchMusic(title).getSinger()+" - "+mc.searchMusic(title).getTitle());
		}else System.out.println("해당하는 곡 정보가 없습니다.");
		
	}
	
	//특정 곡 삭제 결과를 보여주는 메소드
	public void removeMusic() {
		System.out.println("********특정 곡 삭제********");
		sc.nextLine();
		System.out.print("삭제할 곡 제목 : ");
		String title=sc.nextLine();
		
		if(mc.removeMusic(title)!=null) {
		System.out.println(title+"을(를) 삭제했습니다.");
		}else System.out.println("삭제할 곡이 없습니다.");
	}
	
	//특정 곡 정보 수정 결과를 보여주는 메소드
	public void setMusic() {
		sc.nextLine();
		System.out.println("********특정 곡 수정********");
		System.out.print("검색할 곡 제목 : ");
		String title=sc.nextLine();
		System.out.print("수정할 곡 제목 : ");
		String reTitle=sc.nextLine();
		System.out.print("수정할 가수 이름 : ");
		String reSinger=sc.nextLine();
		Music music=new Music(reTitle, reSinger);
		
		if(mc.setMusic(title, music)!=null) {
			System.out.println(title+" - "+reSinger+"(이)가 변경되었습니다.");
		}else System.out.println("수정할 곡이 없습니다.");
		
		
	}
	
	//곡 명으로 오름차순 정렬 성공을 알리는 메소드
	public void ascTitle() {
		if(mc.ascTitle()==1) {
			System.out.println("정렬 설공");
		}else System.out.println("정렬 실패");
	}
	
	//가수 명으로 내림차순 정렬 성공을 알리는 메소드
	public void descSinger() {
		if(mc.descSinger()==1) {
			System.out.println("정렬 설공");
		}else System.out.println("정렬 실패");
	}
	
	
	
}
