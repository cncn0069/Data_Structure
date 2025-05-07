package chap1_기본알고리즘;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */
    // 문자열을 공백으로 분리하여 배열에 저장하고 정렬하는 함수
	public static void printIntArray(int[] arr) {
		for(int n:arr)
		{
			System.out.println(n);
		}
	}

    // 문자열 배열을 정수 배열로 변환한 후 정렬하는 함수
	 public static int[] convertSortToIntArray(String[] arr) {
		 int[] convertArr = new int[arr.length];
		 
		 for(int i = 0; i < arr.length;i++)
			{
			 convertArr[i] = Integer.parseInt(arr[i]);
			}
		 Arrays.sort(convertArr);
		 return convertArr;
		 
	 }
			
		

    // 문자열 배열 출력 함수
    public static void printStringArray(String[] arr) {
		for(String n:arr)
		{
			System.out.println(n);
		}
	}

    // 정수 배열 출력 함수
    
	public static String[] splitSortString(String input) {
		String[] temp = input.split(" ");
		Arrays.sort(temp);
		
		return temp;
	}
    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
