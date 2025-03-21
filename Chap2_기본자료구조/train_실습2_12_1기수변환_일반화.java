//package Chap2_기본자료구조;
//
///*
// * String: immutable(변경불가능) 객체, concat(), substring(), charAt(), equals(), 
// *          compareTo() 등 문자열 조작과 비교를 위한 메서드
// * String s = "hello"; s = s + "world";
// * 
// * StringBuilder: mutable - 문자열이 자주 변경시 사용, append, insert, delete, reverse 함수 사용
// * 
// */
//public class train_실습2_12_1기수변환_일반화 {
//
//	// n진수를 10진수로 변환하는 함수
//	public static int toDecimal(String number, int baseN) {
//		/*
//		 * charAt()를 사용하여 N 진법(baseN) 스트링을 10진수 바꾼다
//		 */
//		// 자릿수 저장
//		int temp = 0;
//		// 합한값 저장
//		int sum = 1;
//
//		int total = 0;
//		// 자릿수만큼 반복
//		for (int i = 0; i < number.length(); i++) {
//
//			temp = Character.getNumericValue(number.charAt(number.length() - i - 1));
//
//			sum = 1;
//
//			// 자릿수 만큼 곱하기
//			for (int j = i; j > 0; j--) {
//				sum = sum * baseN;
//			}
//
//			total = total + temp * sum;
//		}
//
//		return total;
//	}
//
//	// 10진수를 m진수로 변환하는 함수
//	public static String fromDecimal(int decimal, int baseM) {
//		/*
//		 * 10진수를 M 진법으로 바꾸려면 decimal % baseM은 나눈 나머지를 스트링으로 표현 decimal / baseM은 몫이므로 반복
//		 * 실행 M진법 스트링을 StringBuilder 객체로 저장
//		 * 
//		 */
//
//		String temp = "";
//
//		while (decimal > baseM) {
//			//ABCD로 변환
//			if (decimal % baseM > 9) {
//				char tempAlpha = (char)(decimal % baseM + 55);
//				temp = tempAlpha + temp;
//			} else {
//				temp = String.valueOf(decimal % baseM) + temp;
//			}
//
//			decimal = (int) (decimal / baseM);
//			}
//		
//		
//		//마지막에 한번더 추가
//		if (decimal % baseM > 9) {
//			char tempAlpha = (char)(decimal % baseM + 55);
//			temp = tempAlpha + temp;
//		} else {
//			temp = String.valueOf(decimal % baseM) + temp;
//		}
//
//
//		// 마지막 한번 추가
//		
//		System.out.println(temp);
//		return temp;
//	}
//
//	// n진수를 m진수로 변환하는 함수
//	public static String convertBase(String number, int baseN, int baseM) {
//		// n진수를 10진수로 변환
//		int decimal = toDecimal(number, baseN);
//		int i = Integer.parseInt(number);
//		// 10진수를 m진수로 변환
//		return fromDecimal(decimal, baseM);
//	}
//
//	public static void main(String[] args) {
//		String number = "60"; // 8진수 예시
//		int baseN = 10; // 입력 진법 (n진법)
//		int baseM = 16; // 출력 진법 (m진법)
//
//		// n진수 -> m진수 변환
//		String result = convertBase(number, baseN, baseM);
//		System.out.println(baseN + "진법 " + number + "-> " + baseM + "진법 숫자: " + result);
//
//		// 8진수 -> 2진수 변환 예시
//		baseM = 2;
//		result = convertBase(number, baseN, baseM);
//		System.out.println(baseN + "진법 " + number + "-> " + baseM + "진법 숫자: " + result);
//	}
//}
