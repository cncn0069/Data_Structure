package Chap2_기본자료구조;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	@Override
	public String toString() {// Object 클래스 상속
		return "name : " + name + " height : " + height + " vision : " + vision;
	}

	@Override
	public int compareTo(PhyscData p) {
		// 이름이 같으면
		if (name.compareTo(p.getName()) == 0) {
			// 키가 같으면

			// 키로 비교

			if (height == p.getHeight()) {
				BigDecimal vision = new BigDecimal(String.valueOf(this.vision));
				BigDecimal pvision = new BigDecimal(String.valueOf(p.getVision()));
								
				// 시력으로 비교 키도 같고
				return Integer.parseInt(vision.subtract(pvision).toString());
			}

			// 이름은 같고 키는 다를때
			return height - p.getHeight();
		}
		return name.compareTo(p.getName());
	}

	public boolean equals(Object ob) {// Object 클래스 상속
		PhyscData p = (PhyscData) ob;

			return p.equals(ob);
	}

	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

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

}

public class train_실습2_14_1객체배열정렬 {
	public static void swap(PhyscData[] data,int p1, int p2) {
		PhyscData temp = data[p1];
		data[p1] = data[p2];
		data[p2] = temp;
	}

	public static void sortData(PhyscData[] p1) {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		//compareTo()를 사용하여 구현
		
		for(int i = 0; i < p1.length-1;i++)
		{
			for(int j = p1.length-1; j > 0;j--)
			{
							
				if(p1[i].compareTo(p1[i+1]) > 0)
				{
					
					swap(p1,i,i+1);
					break;
				}
			}
			
		}
		
	}

	public static int binarySearch(PhyscData[] data,String key) {
		//if (data[i].equals(key)) ***으로 구현
		for(int i = 0; i < data.length; i++) {
			if(data[i].getName().equals(key))
			{
				return i;
			}
		}
		return -1;
	} // equals()를 사용하여 구현
	
	public static void showData(String msg,PhyscData[] data) {
		System.out.println(msg);

		
		
		for(PhyscData n: data)
		{
			if(n == null) return;
			
			System.out.println(n.toString());
		}
	}
	
	public static PhyscData[] insertObject(PhyscData[] data,PhyscData insert){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		ArrayList<PhyscData> list = new ArrayList<PhyscData>(Arrays.asList(data));
		
		int ttt =list.size();
		
		for(int i = 0; i < ttt;i++)
		{
			if(insert.getName().compareTo(list.get(i).getName()) > 0)
			{
				list.add(i, insert);
				//추가후 for문 탈출했어야함;;
				break;
			}
		}
		
		return list.toArray(new PhyscData[list.size()]);
	}
	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7), new PhyscData("사이다", 172, 0.3), new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2), new PhyscData("다정해", 169, 0.5), };
		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		
		
		int resultIndex = binarySearch(data, "사이다");
		if (resultIndex >= 0)
			System.out.println("사이다가 존재하면 인덱스 = " + resultIndex);
		else
			System.out.println("사이다가 존재하지 않는다");
		PhyscData[] newData = insertObject(data, new PhyscData("소주다", 179, 1.5));// 배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰
																					// 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
		
		System.out.println(data[data.length -1].equals((Object)newData));

	}

}

	

	
