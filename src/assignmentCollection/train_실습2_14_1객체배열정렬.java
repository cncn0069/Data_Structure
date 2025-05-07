package assignment;

/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 * 
 * 자바에서 **문자열(String)**을 비교할 때는 반드시 equals() 메소드를 사용해야 합니다.
 * 
 */
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	@Override
	public String toString() {// Object 클래스 상속
		return " ";
	}

	@Override
	public int compareTo(PhyscData p) {

		return name.compareTo(p.getName());
	}

	@Override
	public boolean equals(Object ob) {
		if (this == ob)
			return true;
		if (!(ob instanceof PhyscData))
			return false;
		PhyscData p = (PhyscData) ob;
		return this.name.equals(p.name)
				&& this.height == p.height
				&& Double.compare(this.vision, p.vision) == 0;
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

	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

}

public class train_실습2_14_1객체배열정렬 {
	public static void swap(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i];

		data[i] = data[j];
		data[j] = temp;
	}

	public static void sortData(PhyscData[] data) {// 객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로
		// compareTo()를 사용하여 구현
		for (int i = 0; i < data.length - 1; i++) {
			// i가 > i+1 이라면
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j].compareTo(data[j + 1]) > 0) {
					swap(data, j, j + 1);
				} else if (data[j].compareTo(data[j + 1]) == 0) {
					// 같으면 키로 변경
					if (data[j].getHeight() - data[j + 1].getHeight() > 0) {
						swap(data, j, j + 1);
					} // 시력이 크면
					else if (data[j].getVision() - data[j + 1].getVision() > 0) {
						swap(data, j, j + 1);
					}
				}
			}

		}

	}

	public static int binarySearch(PhyscData[] data, String key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].getName().equals(key))
				return i;
		}
		return -1;
	}

	public static PhyscData[] insertObject(PhyscData[] data, PhyscData insert) {
		PhyscData[] temp = new PhyscData[data.length + 1];
		int i = 0;

		// 삽입 위치 찾기
		while (i < data.length && data[i].compareTo(insert) < 0) {
			temp[i] = data[i];
			i++;
		}

		// 삽입
		temp[i] = insert;

		// 나머지 복사
		for (int j = i; j < data.length; j++) {
			temp[j + 1] = data[j];
		}

		return temp;
	}

	public static void showData(String msg, PhyscData[] data) {
		// 교재 89 printf() 사용
		System.out.println("*".repeat(8));
		System.out.println(msg);
		System.out.println("*".repeat(8));

		for (PhyscData da : data) {
			System.out.printf("%-8s%3d%5.1f\n", da.getName(), da.getHeight(), da.getVision());
		}

		System.out.println("*".repeat(8));

	}

	// equals()를 사용하여 구현
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍길동", 162, 0.1),
				new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7),
				new PhyscData("사이다", 172, 0.3),
				new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2),
				new PhyscData("다정해", 169, 0.5),
		};
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

	}

}
