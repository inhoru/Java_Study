package com.bs.map.view;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.bs.map.controller.MemberController;
import com.bs.map.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	// 메인메뉴
	public void mainMenu() {
		System.out.println("=====***** BS 사이트 *****=====");
		
		while(true) {
			System.out.println("***** 메인메뉴 *****");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : joinMembership(); break;
				case 2 : logIn(); break;
				case 3 : sameName(); break;
				case 9 : System.out.println("===== 프로그램 종료 ======"); return;
				default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요."); break;
			}
		}
	}
	
	// 회원메뉴
	public void memberMenu() {
		while(true) {
			System.out.println("=====***** 회원메뉴 *****=====");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 이름 변경");
			System.out.println("3. 로그아웃");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : changePassword(); break; 
				case 2 : changeName(); break;
				case 3 : System.out.println("로그아웃 되었습니다. 메인메뉴로 돌아갑니다."); return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}
		}
	}
	
	// 회원가입
	public void joinMembership() {
		System.out.println("=====***** 회원가입 *****=====");
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			Member member = new Member(password, name);
			
			if(mc.joinMembership(id, member)) {
				System.out.println("성공적으로 회원가입 완료하였습니다. :)");
				return;
			} else {
				System.out.println("중복된 아이디입니다. 다시입력해주세요. :(");
			}
		}
	}
	
	// 로그인
	public void logIn() {
		System.out.println("=====***** 로그인 메뉴 *****=====");

		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			
			String name = mc.logIn(id, password);

			if(name == null) {
				System.out.println("틀린 아이디 또는 비밀번호입니다.");
				System.out.print("메인 메뉴로 돌아가겠습니까(Y/N)?");
				char choice = sc.next().charAt(0);
				
				if(choice == 'Y' || choice == 'y') {
					return;
				}
			} else {
				System.out.println(name + "님, 환영합니다!");
				break;
			}
		} memberMenu();
	}
	
	// 비밀번호 변경
	public void changePassword() {
		System.out.println("=====***** 비밀번호 변경 *****=====");
		
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			System.out.print("변경할 비밀번호 : ");
			String newPassword = sc.next();
			
			if(mc.changePassword(id, password, newPassword)) {
				System.out.println("비밀번호 변경에 성공했습니다. :)");
				return;
			} else {
				System.out.println("비밀번호 변경에 실패했습니다. :( 다시입력해주세요.");
			}
		}
	}
	
	// 이름변경
	public void changeName() {
		System.out.println("=====***** 이름 변경 *****=====");
		
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			
			String name = mc.logIn(id, password);
			
			if(name == null) {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
			} else {
				System.out.println("변경 전 이름 : " + name);
				sc.nextLine();
				System.out.print("변경할 이름 : ");
				String newName = sc.nextLine();
				
				System.out.println("이름 변경에 성공했습니다.");
				mc.changeName(id, newName);
				return;
			}
		}
	}
	
	// 같은 이름 조회
	public void sameName() {
		System.out.println("=====***** 같은 이름 조회 *****======");
		System.out.print("검색할 이름 : ");
		sc.nextLine();
		
		TreeMap<String, String> nameMap = mc.sameName(sc.nextLine());
		
		Set<String> keys = nameMap.keySet();
		
		keys.forEach(k -> System.out.println(k + " - " + nameMap.get(k)));
		
	}
}
