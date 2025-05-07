package assignment;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 3장 4번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparator 구현
 * 3장 실습 3-8를 수정하여 객체 배열의 정렬 구현
 */

class PhyscData5 {
	private String name;
	private int height;
	private double vision;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getVision() {
		return vision;
	}
	public void setVision(double vision) {
		this.vision = vision;
	}
	public PhyscData5(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}


public class trainObjectComparator {	
	static final Comparator<PhyscData5> HEIGHT_ORDER =(a,b) -> a.getHeight() - b.getHeight();
	static final Comparator<PhyscData5> NAME_ORDER =(a,b) -> a.getName().compareTo(b.getName());
	static final Comparator<PhyscData5> VISION_ORDER =(a,b) -> Double.compare(a.getVision(), b.getVision());
	
	public static void showData(String msg,PhyscData5[] data) {
		System.out.println(msg);
		
		for(PhyscData5 n:data) {
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) {
		PhyscData5[] data = {
				new PhyscData5("홍길동", 162, 0.3),
				new PhyscData5("나가자", 164, 1.3),
				new PhyscData5("다정해", 152, 0.7),
				new PhyscData5("소주다", 172, 0.4),
				new PhyscData5("사이다", 182, 0.6),
				new PhyscData5("신정신", 166, 1.2),
				new PhyscData5("이기자", 167, 1.5),
		};
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER);	
		showData("height로 정렬후 객체 배열", data);
		
		PhyscData5 key = new PhyscData5("길동", 167, 0.2);
		
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);
		System.out.println("\nArrays.binarySearch(data, key, HEIGHT_ORDER): result = " + idx);
		
		Arrays.sort(data, (a,b) -> Double.compare(a.getVision(), b.getVision()));
		showData("vision로 정렬후 객체 배열", data);
		
		Arrays.sort(data, new Comparator<PhyscData5>() {
			@Override
			public int compare(PhyscData5 a1, PhyscData5 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		showData("name로 정렬후 객체 배열", data);
	}

}
