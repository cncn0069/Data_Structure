package Chap2_기본자료구조;
/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;

public class train_실습2_4메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	static final int MAX_VALUE = 100;

	public static void showData(String msg, int[] data) {
		// top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		
		System.out.print("[");
		switch (msg) {
		case "소스데이터": {
			
			

			for (int i = 0; i < top; i++) {
				System.out.print(data[i] + ",");

			}
			// 마지막 한번 출력
			System.out.print(data[top]);
			
			
			break;
		}
		case "역순 데이터": {

			

			for (int i = top; i > 0; i--) {
				System.out.print(data[i] + ",");

			}
			// 마지막 한번 출력
			System.out.print(data[0]);
			
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + msg);
		}
		System.out.println("]");

	}

	public static void inputData(int[] data) {// 교재 63 - 난수의 생성
		// top이 배열에 저장된 갯수를 저장
		Random rd = new Random();

		// 랜덤한 만큼 배열에 채우기
		for (int i = 0; i < rd.nextInt(MAX_LENGTH); i++) {
			// 0~99까지 값을 랜덤하게 저장
			data[i] = rd.nextInt(MAX_VALUE);
			top++;
		}

	}

	public static int findMax(int[] data) {
		// 최대값을 리턴한다

		int max = 0;

		for (int i = 0; i <= top; i++) {
			// 데이타가 맥스보다 크면
			if (max < data[i]) {
				max = data[i];
			}
		}

		return max;

	}

	public static boolean findValue(int[] data, int value) {
		// items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		for (int i = 0; i <= top; i++) {
			// 데이타가 맥스보다 크면
			if (value == data[i]) {
				return true;
			}
		}
		return false;
	}

	public static void reverse(int[] data) {
		for (int i = top; i >= 0; i--) {
			System.out.println(data[i]);
		}
	}

	public static void main(String[] args) {
		int[] data = new int[MAX_LENGTH];
		inputData(data);
		showData("소스데이터", data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 출력
		showData("역순 데이터", data);

	}
}
