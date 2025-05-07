package Chap6_Sorting;

import java.util.Scanner;

public class QuickSort {
	void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	
	void quickSort(int [] a,int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl+pr)/2];
		
		do {
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if(pl<=pr)
				swap(a,pl++,pr--);
			
		}while(pr>=pl);
		
		if(left<pr) quickSort(a,left,pr);
		if(pl < right) quickSort(a, pl, right);

	}
	
	public static void main(String[] args) {
		System.out.println("퀵 정렬");
		System.out.println("요솟수 : ");
		
		Scanner sc = new Scanner(System.in);
		
		int nx = sc.nextInt();
		int [] x = new int[nx];
		
		for (int i=0; i < nx;i++)
		{
			System.out.println("x[" + i + "]: ");
			x[i] = sc.nextInt();
		}
		QuickSort qs = new QuickSort();
		
		qs.quickSort(x,0,nx-1);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]=" + x[i]);
			
		}
		
		
	}
	
}
