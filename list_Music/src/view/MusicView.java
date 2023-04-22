package view;

import java.util.List;
import java.util.Scanner;

import controller.MusicController;
import model.vo.Music;

public class MusicView {
	private Scanner sc=new Scanner(System.in);
	private MusicController mc=new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("********메인 메뉴********");
			System.out.println("1.마지막 위치에 곡 추가");
			System.out.println("2.첫 위치에 곡 추가");
			System.out.println("3.전체 곡 목록 출력");
			System.out.println("4.특정 곡 검색");
			System.out.println("5.특정 곡 삭제");
			System.out.println("6.특정 곡 정보 수정");
			System.out.println("7.곡명 오름차순 정렬");
			System.out.println("8.가수명 내림차순 정렬");
			System.out.println("9.종료");
			switch(sc.nextInt()) {
				case 1: addList();break;
				case 2: addAtZero();break;
				case 3: printAll();break;
				case 4: searchMusic();break;
				case 5: removeMusic();break;
				case 6: setMusic();break;
				case 7: ascTitle();break;
				case 8: descSinger();break;
				case 9: System.out.println("종료");return;
				default: System.out.println("다시 입력해주세요.");//break;
			}
		}
		
	}
	public void addList() {
		System.out.println("****마지막 위치에 곡 추가****");
		sc.nextLine();
		System.out.println("곡 명: ");
		String title=sc.nextLine();
		System.out.println("가수 명: ");
		String singer=sc.nextLine();
		int result=mc.addList(new Music(title,singer));
		System.out.println(result>0?"추가 완료":"추가 실패");
		
	}
	public void addAtZero() {
		System.out.println("****첫 위치에 곡 추가****");
		sc.nextLine();
		System.out.println("곡 명: ");
		String title=sc.nextLine();
		System.out.println("가수 명: ");
		String singer=sc.nextLine();
		int result=mc.addAtZero(new Music(title,singer));
		System.out.println(result>0?"추가 완료":"추가 실패");
	}
	public void printAll() {
		System.out.println("****전체 곡 목록 출력****");
		List list=mc.printAll();
		list.forEach(m->System.out.println(m));
	}
	public void searchMusic() {
		System.out.println("****특정 곡 검색****");
		sc.nextLine();
		System.out.println("곡 명: ");
		String title=sc.nextLine();
		List<Music> matches=mc.searchMusic(title);
		if(matches!=null) {
			for(Music m:matches) {
			System.out.println(m.toString());
			}
		}else {
			System.out.println("검색한 곡이 없습니다");
		}
	}
	public void removeMusic() {
		System.out.println("****특정 곡 삭제****");
		System.out.println("곡 명: ");
		String title=sc.nextLine();
		Music remove=mc.removeMusic(title);
		if(remove!=null) {
			System.out.println(remove.toString()+"을 삭제했습니다.");
		}else {
			System.out.println("삭제할 곡이 없습니다");
		}
		
	}
	public void setMusic() {
		//수정할 곡을 입력하여 mc에 값을 넘긴다, 값을 넘기며 수정할 곡명과 가수명을 받아
		//setMusic으로 값을 넘긴다. 검색 결과 값이 없으면 "수정힐 곡이 없습니다"
		//반환값이 있으면 "곡명, 가수명을 삭제했습니다" 출력
		System.out.println("****특정 곡 정보 수정****");
		sc.nextLine();
		System.out.println("검색할 곡 명: ");
		String title=sc.nextLine();
		System.out.println("수정할 곡 명: ");
		String setTitle=sc.nextLine();
		System.out.println("수정할 가수 명: ");
		String singer=sc.nextLine();
		Music set=mc.setMusic(title,new Music(setTitle,singer));

		if(set!= null) {
			System.out.println(title+"-"+singer+"가 값이 변경되었습니다.");
		}else {
			System.out.println("수정할 곡이 없습니다.");
		}
	}
	public void ascTitle() {
		System.out.println("****곡 명 오름차순 정렬****");
		int result=mc.ascTitle();
		System.out.println(result>0?"정렬 완료":"정렬 실패");
	}
	public void descSinger() {
		System.out.println("****가수 명 내림차순 정렬****");
		int result=mc.descSinger();
		System.out.println(result>0?"정렬 완료":"정렬 실패");
	}
}