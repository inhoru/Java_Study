package com.bs.set.view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.bs.set.controller.LotteryController;
import com.bs.set.model.vo.Lottery;

public class LotteryMenu {
	Scanner sc = new Scanner(System.in);
	LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		System.out.println("***** BS 추첨 프로그램 ******");
		
		while(true) {
			System.out.println("***** 메인 메뉴 *****");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : insertObject(); break;
				case 2 : deleteObject(); break;
				case 3 : winObject(); break;
				case 4 : sortedWinObject(); break;
				case 5 : searchWinner(); break;
				case 9 : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("===== 잘못입력하셨습니다. 다시 입력해주세요. =====");
			}
		}
	}
	
	// 1. 추첨 대상 추가용 메서드
	public void insertObject() {
		int num = 0;
		
		System.out.println("=====***** 추첨 지원 *****=====");
		System.out.print("추가할 추첨 대상 수 : ");
		int much = sc.nextInt();
		sc.nextLine();
		
		while(num < much) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("핸드폰 번호(\'-\'빼고) : ");
			String phone = sc.nextLine();
			
			Lottery lottery = new Lottery(name, phone);
			
			if(lc.insertObject(lottery)) {
				System.out.println("추가 완료되었습니다.");
				num++;
			} else {
				System.out.println("중복된 대상입니다. 다시 입력해주세요.");
			}
		}
	}
	
	// 2. 추첨 대상 삭제용 메서드
	public void deleteObject() {
		System.out.println("=====***** 지원 취소 신청 *****=====");
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호(\'-\'빼고) : ");
		String phone = sc.nextLine();
		
		Lottery lottery = new Lottery(name, phone);
		
		if(lc.deleteObject(lottery)) {
			System.out.println("삭제 완료되었습니다.");
		} else {
			System.out.println("지원하지 않은 참가자입니다.");
		}
	}
	
	// 3. 당첨 대상 확인 메서드
	public void winObject() {
		System.out.println("=====***** 당첨자 *****=====");
		
		if(lc.winObject().size() < 4) {
			System.out.println("추첨 대상자가 4명 이상이어야합니다.");
		} else {
			lc.winObject().forEach(w -> System.out.println(w));
		}
	}
	
	// 4. 정렬된 당첨 대상 확인 메서드
	public void sortedWinObject() {
		System.out.println("=====***** 정렬된 당첨자 목록 *****=====");
		System.out.println("!!잠깐!! 당첨자 확인을 하셨나요?? 확인하셨다면 1번을 입력해주세요!");
		System.out.print("입력 : ");
		int check = sc.nextInt();
		
		if(check == 1) {
			TreeSet<Lottery> winner = lc.sortedWinObject();
			Iterator<Lottery> it = winner.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		} else {
			System.out.println("당첨자 확인을 먼저 해주세요.");
		}
	}
	
	// 5. 당첨 대상 검색 메서드
	public void searchWinner() {
		System.out.println("=====***** 당첨자 조회 *****=====");
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("번호 : ");
		String phone = sc.nextLine();
		
		Lottery lottery = new Lottery(name, phone);
		
		if(lc.searchWinner(lottery)) {
			System.out.println("축하합니다! 당첨 목록에 존재합니다!");
		} else {
			System.out.println("안타깝지만 당첨 목록에 존재하지않습니다.");
		}
	}
}
