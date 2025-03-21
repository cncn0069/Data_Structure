package Chap5_Recursive;

import java.util.Stack;

public class train_5_5_2문자열순열실습 {

	Stack<Character> list = new Stack<Character>();
    // 주어진 문자 배열의 순열을 생성하는 함수
    public static void permutate(char[] arr, int index) {
    	
    	if(index == arr.length -1)
    		System.out.println(String.valueOf(arr));
    	
    	while(true)
    	{
    		
    	}

    }


    // 두 요소를 교환하는 함수
    public static void swap(char[] arr, int i, int j) {
    	char temp = arr[i];
    	arr [i] = arr[j];
    	arr [j] = temp;
    }

    public static void main(String[] args) {
        // 문자열을 문자 배열로 변환
        String l = "abcde";
        char[] arr = l.toCharArray();

        // 순열 생성 및 출력
        permutate(arr, 0);
    }
}


//if (index == arr.length - 1) {
//    // 모든 문자가 배치되었을 때 순열 출력
//    System.out.println(String.valueOf(arr));
//    return;
//}
////n개중 하나를 뽑으므로
//for(int i = index; i <arr.length;i++)
//{	
//
//	swap(arr, index, i);
//	permutate(arr, index+1);
//	swap(arr, index, i);    	
//}