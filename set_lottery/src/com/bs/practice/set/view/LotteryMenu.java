package com.bs.practice.set.view;

import java.util.Iterator;
import java.util.Scanner;

import com.bs.practice.set.controller.LotteryController;
import com.bs.practice.set.model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc=new Scanner(System.in);
	private LotteryController lc= new LotteryController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("===== BS 추첨 프로그램 =====");
			System.out.println("======= 메인 메뉴 =======");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 추첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			int cho=sc.nextInt();
			switch(cho) {
				case 1 : insertObject();break;
				case 2 : deleteObject();break;
				case 3 : winObject();break;
				case 4 : sortedWinObject();break;
				case 5 : searchWinner();break;
				case 9 : System.out.println("프로그램 종료");return;
				default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");break;
			}
		}
	}
	
	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int add=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<add;i++) {
			boolean result=false;
			while(!result) {
				System.out.print("이름 : ");
				String name=sc.nextLine();
				System.out.print("핸드폰 번호('-'빼고) : ");
				String phone=sc.nextLine();
				result=lc.insertObject(new Lottery(name,phone));
				if(result==false) {
					System.out.println("중복된 대상입니다. 다시 입력하세요.");
				}
			}
		}
		System.out.println(add+"명 추가 완료되었습니다");
		
		
	}
	public void deleteObject() {
		sc.nextLine();
		System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name=sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone=sc.nextLine();
		System.out.println(lc.deleteObject(new Lottery(name,phone))?"삭제 완료 되었습니다":"존재하지 않는 대상입니다");
	}
	public void winObject() {
		System.out.println("메인");
		if(lc.winObject().size()<4) {System.out.println("추첨자가 4명 미만입니다");
		}else lc.winObject().forEach((e)->{System.out.println(e);});
	}
	public void sortedWinObject() {
		Iterator it=lc.sorteWinObject().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public void searchWinner() {
		sc.nextLine();
		System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력해주세요.");
		System.out.print("이름 : ");
		String name=sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone=sc.nextLine();
		System.out.println(lc.searchWinner(new Lottery(name,phone))?"축하합니다. 당첨 목록에 존재합니다":"안타깝지만 당첨목록에 존재하지 않습니다");
	}

}
