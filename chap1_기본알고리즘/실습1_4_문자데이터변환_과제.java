//package chap1_기본알고리즘;
//
//import java.lang.reflect.Array;
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.regex.Pattern;
//
//import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;
//
//public class 실습1_4_문자데이터변환_과제 {
//	/*
//	 * valueOf(boolVal) Arrays.sort(array)
//	 */
//	// 값을 문자열로 변환하여 배열에 저장하는 함수
//	public static String[] convertValuesToString(boolean cV1, char cV2, double cV3, int cV4, float cV5) {
//		String[] stringArray = new String[5];
//
//		stringArray[0] = String.valueOf(cV1);
//		stringArray[1] = String.valueOf(cV2);
//		stringArray[2] = String.valueOf(cV3);
//		stringArray[3] = String.valueOf(cV4);
//		stringArray[4] = String.valueOf(cV5);
//
//		return stringArray;
//	}
//
//	public static void showAllString(String[] stringArray) {
//		for (String n : stringArray) {
//			System.out.println(n);
//		}
//	}
//
//	public static void sortStringArray(String[] stringArray) {
//
//		Arrays.sort(stringArray, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				
//
//				int abc = 0;
//				String temp = "";
//				int count = 0;
//				
//				BigDecimal num1 = new BigDecimal("0");
//				BigDecimal num2 = new BigDecimal("0");
//
//				if (Pattern.matches("[A-Za-z]*", o1)) {
//					temp = o1;
//					//아스키 코드값으로 변경
//					if (o1.equals("true")) 
//						temp = "1";
//					
//					if(o1.equals("false"))
//						temp = "0";
//					
//					abc = (int) temp.charAt(0);
//					
//					
//					num1 = new BigDecimal(String.valueOf(abc));
//					count++;
//				}
//
//				if (Pattern.matches("[A-Za-z]*", o2)) {
//					temp = o2;
//					
//					if (o2.equals("true")) 
//						temp = "1";
//					if(o2.equals("false"))
//						temp = "0";
//					
//					abc = (int) temp.charAt(0);
//					num2 = new BigDecimal(String.valueOf(abc));
//					count++;
//				}
//				
//				if(count == 0)
//				{
//					num1 = new BigDecimal(o1);
//					num2 = new BigDecimal(o2);
//				}
//				
//				
//
//				return num1.compareTo(num2);
//
//			}
//
//		});
//
//	}
//
//
//	// 배열을 정렬하는 함수
//
//	// 배열을 출력하는 함수
//
//	public static void main(String[] args) {
//		// 정수, float, double, boolean 값을 문자열로 변환하여 배열에 저장
//		String[] stringArray = convertValuesToString(true, 'A', 3.14, 123, 45.67f);
//
//		// 정렬 전 배열 출력
//		System.out.println("정렬전:");
//		showAllString(stringArray);
//
//		// 배열 정렬
//		sortStringArray(stringArray);
//
//		// 정렬 후 배열 출력
//		System.out.println("\n정렬후:");
//		showAllString(stringArray);
//	}
//}
