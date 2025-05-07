package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 6장 구현 실습과제2
 */

class PhyscData implements Comparable<PhyscData>{
    String name;              // 이름
    int    height;            // 키
    double vision;            // 시력
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

	@Override
	public int compareTo(PhyscData o) {
		// TODO Auto-generated method stub
		
		if(!this.name.equals(o.getName()))
			return this.height - o.getHeight();
		else if(this.getHeight() - o.getHeight() == 0){
			return Double.compare(this.vision, o.getVision());
		}
		
		return this.name.compareTo(o.getName());
	}
    
}

class Point7 {
	private int left;
	private int right;

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public Point7(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}

}

public class train_try6_2_ObjectmergeSort {
	

	static public void swap(PhyscData[] a, int i, int j) {
		PhyscData pd = a[i];
		a[i] = a[j];
		a[j] = pd;
	}

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb) {
		
		int pl = lefta;
		int pr = righta;
		int i = 0;
		
		PhyscData[] temp = new PhyscData[30];
		
		while(pl <= righta && pr <= rightb) {
			if(a[pl].compareTo(a[pr]) < 0) temp[i++] = a[pl++];
			else if(a[pl].compareTo(a[pr]) > 0) temp[i++] = a[pr++];
			else {
				temp[i++] = a[pl++];
				temp[i++] = a[pr++];
			}
		}
		
		while(pl < righta)
			temp[i++] = a[pl++];
		while(pr < rightb)
			temp[i++] = a[pr++];
		
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		MergeSort(a, left, mid);
		MergeSort(a, mid + 1, right);
		merge(a, left, mid, mid + 1, right);

		int pl = left;
		int pr = right;
		PhyscData pevot = a[(pl + pr) / 2];

		Stack<Point7> st = new Stack<>();
		// 처음 위치 저장

		Point7 p = new Point7(left, right);
		
		st.push(p);

		while (!st.isEmpty()) {
			// 종료조건이 오면 팝!
			if (left >= right) {
				p = st.pop();

				pl = p.getLeft();
				pr = p.getRight();
				left = p.getLeft();
				right = p.getRight();

				pevot = a[(pl + pr) / 2];
				continue;
			}

			while (true) {

				if(pl>=pr)
				{
					st.push(new Point7(pl, right));
					right = pr;
					
					pl = left;
					pr = right;
					pevot =  a[(pl + pr) / 2];
					
					
					break;
				}
				
				while (a[pl].compareTo(pevot) < 0) pl++;
				while (a[pr].compareTo(pevot) > 0) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
				
			}

			// 정렬 끝
			

		}

	}

	public static void main(String[] args) {

		PhyscData[] x = { new PhyscData("황지안", 169, 0.8), new PhyscData("김찬우", 173, 0.7),
				new PhyscData("박준서", 171, 2.0), new PhyscData("유서범", 171, 1.5), new PhyscData("이수연", 168, 0.4),
				new PhyscData("장경오", 171, 1.2), new PhyscData("강민하", 162, 0.3), new PhyscData("강민하", 162, 0.1)};
		int nx = x.length;

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
		System.out.println("오름차순으로 정렬했습니다.");
		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름     키  시력");
		System.out.println("------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
