package assignment;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;

	@Override
	public String toString() {//Object 클래스 상속
		return " ";
	}
	@Override
	public int compareTo(PhyscData2 p) {

			return name.compareTo(p.getName());
	}
	

	public boolean equals(Object ob) {//Object 클래스 상속
		 return name.equals((String) ob);
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
	public PhyscData2(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
}
public class train_실습2_14_1객체배열정렬 {
	public static void swap(PhyscData2[] data, int i, int j) {
		PhyscData2 temp = data[i];
		
		data[i] = data[j];
		data[j] = temp;
	}
	public static void sortData(PhyscData2[] data) {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		//compareTo()를 사용하여 구현
		for(int i = 0; i < data.length-1; i++) {
			//i가 > i+1 이라면
			for(int j = 0 ; j < data.length -1 -i;j++)
			{
				if(data[j].compareTo(data[j+1]) > 0)
				{
					swap(data,j,j+1);
				}
				else if(data[j].compareTo(data[j+1]) == 0){
					//같으면 키로 변경
						if(data[j].getHeight() - data[j+1].getHeight()>0)
						{
							swap(data,j,j+1);
						}//시력이 크면
						else if(data[j].getVision() - data[j+1].getVision()>0){
							swap(data,j,j+1);
						}
				}
			}
			
		}
		

	}
	public static int binarySearch(PhyscData2[] data,String key) {
		//if (data[i].equals(key)) ***으로 구현
		//equals를 안썼었음}
		
		int pl = 0;
		int pr = data.length-1;
		int pc = (pl + pr)/2;
		
		do {
			//이름이 같은지
			//같으면 찾음
			if(data[pc].equals(key))
			{
				return pc;
			}//key가 오른쪽이면
			else if(data[pc].getName().compareTo(key) < 0){
				pl = pc +1;
				pc = (pl + pr)/2;
			}else {
				pr = pc - 1;
				pc = (pl + pr)/2;
			}
					
		}while(pr>=pl);
		
		
		return -1;
	}
	public static PhyscData2[] insertObject(PhyscData2[] data,PhyscData2 insert){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		PhyscData2[] temp = new PhyscData2[data.length + 1];//하나 더 크게
		
		//insert가 됐는지 안됐는지
		int count = 0;
		
		for(int i = 0;i < temp.length;i++)
		{
			//정렬된 데이터가 insert보다 크면 삽입
			if(data[i-count].compareTo(insert)>0 && count == 0)
			{
				temp[i] = insert;
				
				//삽입되면 더하기 temp의 인덱스가 1 늘게
				count++;
			}
			else {
				//삽입되면 data에 들어가는 값은 i-count!
				temp[i] = data[i-count];
			}
		}
		
		
		
		return temp;
	}
	
	public static void showData(String msg, PhyscData2[] data) {
		//교재 89 printf() 사용 
		System.out.println("*".repeat(8));
		System.out.println(msg);
		System.out.println("*".repeat(8));
		
		for(PhyscData2 da:data)
		{
			System.out.printf("%-8s%3d%5.1f\n",da.getName(),da.getHeight(),da.getVision());
		}
		
		System.out.println("*".repeat(8));
		
	}
	
	//equals()를 사용하여 구현
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍길동", 162, 0.1),
				new PhyscData2("이기자", 164, 1.3),
				new PhyscData2("나가자", 162, 0.7),
				new PhyscData2("사이다", 172, 0.3),
				new PhyscData2("신정신", 182, 0.6),
				new PhyscData2("원더풀", 167, 0.2),
				new PhyscData2("다정해", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);
		int resultIndex = binarySearch(data, "사이다");
		if (resultIndex >= 0)
			System.out.println("사이다가 존재하면 인덱스 = "+resultIndex);
		else
			System.out.println("사이다가 존재하지 않는다");
		PhyscData2[] newData= insertObject(data, new PhyscData2("소주다", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
		
	}
	
	

}
