package com.bs.practice.set.view;

import java.util.Scanner;
import java.util.TreeSet;

import com.bs.practice.set.controller.LotteryController;
import com.bs.practice.set.vo.Lottery;

public class LotteryMenu {
	Scanner sc=new Scanner(System.in);
	LotteryController lc=new LotteryController();
	
	//메인메뉴 선택
	public void mainMenu() {
		int order=0;
		System.out.println("=========BS 추첨 프로그램=========");
		while(true) {
			System.out.println("*****Main Menu*****");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			order=sc.nextInt();
			
			switch(order) {
			case 1 : insertObject(); break;
			case 2 : deleteObject(); break;
			case 3 : winObject(); break;
			case 4 : sortedWinObject(); break;
			case 5 : searchWinner(); break;
			case 9 : System.out.println("프로그램 종료."); return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요."); break;
			}
		}
		
	}
	
	//추첨 대상 추가 정보 받는 메소드
	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int num = sc.nextInt();
		boolean result = false;
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			System.out.print(i + 1 + "추첨자 이름 : ");
			String name = sc.nextLine();
			System.out.print(i + 1 + "추점자 번호 : ");
			String phone = sc.nextLine();
			Lottery l = new Lottery(name, phone);
			result = lc.insertObject(l);
			if (!result) {
				System.out.println("중복된 대상입니다. 다시 입력하세요");
				i--;
			}
		}
		System.out.println(num + "명 추가 되었습니다.");
	}
	
	//특정 추첨 대상 삭제 결과 출력
	public void deleteObject() {
		boolean result=false;
		sc.nextLine();
		System.out.println("추첨 대상 삭제");
		System.out.print("삭제할 이름 : ");
		String name=sc.nextLine();
		System.out.print("삭제할 번호 : ");
		String phone=sc.nextLine();
		Lottery l=new Lottery(name, phone);
		result=lc.deleteObject(l);
		System.out.println(result?"삭제 완료 되었습니다.":"존재하지 않는 대상입니다.");
	}
	
	//println메소드를 이용해서 당첨 대상자 출력
	public void winObject() {
		System.out.println("당첨자 목록");
		System.out.println(lc.winObject());
	}
	
	public TreeSet sortedWinObject() {
		return null;
	}
	
	//당첨자 중 특정 대상이 있는지 결과를 출력
	public void searchWinner() {
		
	}
}
