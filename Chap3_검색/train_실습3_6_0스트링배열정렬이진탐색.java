package Chap3_검색;

/*
 * 3장 2번 실습과제 - 스트링 배열의 정렬과 이진검색 
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class train_실습3_6_0스트링배열정렬이진탐색 {
	
	public static void showData(String msg,String[] data) {
		
		System.out.println(msg);
		for(String n:data) {
			System.out.print(n + ", ") ;
		}
	}
	
	public static void sortData(String[] data) {
		int min = 0;
		
		for(int i = 0; i < data.length-1;i++) {
			
			min = i;
			for(int j = i; j<data.length;j++) {
							
				//j가 min보다 작으면
				if(data[j].compareTo(data[min]) < 0)
				{
					min=j;
				}
							
			}
			//선택정렬
			swap(data,i,min);
		}
	}
	
	public static int linearSearch(String[] data,String key) {
		for(int i = 0;i < data.length;i++)
		{
			if(data[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void swap(String[] data,int i,int j) {
		String temp = data[j];
		data[j] = data[i];
		data[i] = temp;
		
	}
	
	public static int binarySearch(String[] data,String key)
	{
		int pl = 0;
		int pr = data.length-1;
		int pc = 0;
		
		do {
			pc = (pl+pr)/2;
			//같으면
			if(data[pc].compareTo(key) == 0)
			{
			//key 값이 오른쪽 일때
				return pc;
			}else if(data[pc].compareTo(key) < 0)
			{
				pl = pc + 1;
			}else {
				pr = pc - 1;
			}
			
		}while(pr>=pl);
		
		return -1;
	}

	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("정렬전", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		showData("정렬후", data);

		String key = "포도";
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "포도";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
		key = "산딸기";
//		/*
//		 * 교재 115 Arrays.binarySearch에 의한 검색
//		 * public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
//		 *     @Override
//		 *     public int compareTo(String anotherString) {
//		 *             return this.compareTo(anotherString);
//		 *     }
//		 *	}
//		 *
//		 *  binarySearch(String[], String key)를 호출하면, 
//		 *  내부적으로 String 배열이 자동으로 Comparable<String>[]로 해석.
//		 */
		resultIndex = Arrays.binarySearch(data, key);//교재 120 페이지 API 참조
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}
}
