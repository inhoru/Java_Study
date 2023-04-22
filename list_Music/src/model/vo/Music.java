package model.vo;

import java.util.Objects;

public class Music implements Comparable{
	private String title;
	private String singer;
	
	public Music() {}
	public Music(String title, String singer) {
		this.title=title;
		this.singer=singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "["+ title + " - " + singer + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(singer, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(singer, other.singer) && Objects.equals(title, other.title);
	}
	@Override
	public int compareTo(Object o) {
		Music other=(Music) o;
		int titleCompare=this.title.compareTo(other.title);
		if(titleCompare!=0){ //두 제목이 같지 않을경우
			return titleCompare;//제목비교의 결과 리턴
		}//제목이 같을 경우
		return this.singer.compareTo(other.singer);//가수비교의 결과 리턴
	}
	
}
