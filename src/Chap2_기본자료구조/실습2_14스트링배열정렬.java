package Chap2_기본자료구조;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */

public class 실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후 크기가 증가된 정렬 배열", newData);
		
	}
	public static void showData(String msg,String[] data) {//확장된 for 문으로 출력 
		System.out.println(msg);
		for(String n: data)
		{
			System.out.println(n);
		}
	}

	public static void swap(String[] data, int i, int j) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
	public static void sortData(String[] data) {//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다 
		
		//n-1개까지 시행
		for(int i = 0; i < data.length-2;i++)
		{
			//큰수는 항상 마지막으로 가니깐 마지막은 비교할 필요 x
			for(int j = 0; j < data.length-1-i;j++)
			{
				if(data[j].compareTo(data[j+1]) > 0)
				{
					swap(data,j,j+1);
				}
			}
		}
	}
	public static String[] insertString(String[] data,String value){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		String[] temp = new String[data.length+1];
		
		for(int i = 0; i<data.length;i++)
		{
			temp[i] = data[i];
		}
		temp[temp.length-1] = value;
		
		sortData(temp);
		
		return temp;
	}
}
