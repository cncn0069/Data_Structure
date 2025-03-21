package assignment;
/*
 * 6장 구현과제3
 */

import java.util.Stack;

class Polynomial3 implements Comparable<Polynomial3> {
	double coef; // 계수
	int exp; // 지수

	Polynomial3() {
	}

	// --- 생성자(constructor) ---//
	Polynomial3(double coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public int compareTo(Polynomial3 o) {
		// TODO Auto-generated method stub
		return getExp() - o.getExp();
	}

}

class Merge {
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

	public Merge(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}

	public Merge() {
		super();
	}

}

public class try6_12_3MergeSortPolynomial {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb) {
		// body를 지우고 작성 훈련 연습이 도움이 된다
		Polynomial3 temp[] = new Polynomial3[30];
		// 구현코드
		int i = 0;

		while (lefta <= righta && leftb <= rightb) {
			if (a[lefta].compareTo(a[leftb]) > 0) {
				temp[i++] = a[lefta++];
			} else if (a[lefta].compareTo(a[leftb]) < 0) {
				temp[i++] = a[leftb++];
			} else {
				// 같으면
				temp[i++] = a[lefta++];
				leftb++;
			}
		}

		while (lefta < righta)
			temp[i++] = a[lefta++];
		while (leftb < rightb)
			temp[i++] = a[leftb++];

		// a에 저장
//		for(int j = 0; j < temp.length-7;j++)
//		{
//			if(temp != null)
//				a[j] = temp[j];
//		}
//		
	}

	static void swap(Polynomial3[] a, int pl, int pr) {
		Polynomial3 temp = a[pl];
		a[pl] = a[pr];
		a[pr] = temp;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		MergeSort(a, left, mid);
		MergeSort(a, mid + 1, right);
		merge(a, left, mid, mid + 1, right);

		if (left >= right)
			return;

		int pl = left;
		int pr = right;
		Polynomial3 pevot = a[(pl + pr) / 2];

		Stack<Merge> st = new Stack<Merge>();

		Merge mg = new Merge(left, right);

		st.push(mg);

		while (!st.isEmpty()) {
			mg = st.pop();
			left = mg.getLeft();
			right = mg.getRight();
			pl = left;
			pr = right;
			pevot = a[(pl + pr) / 2];

			if (left >= right) {
				continue;
			}

			while (pl <= pr) {
				// 내림차순으로 해야함
				while (a[pl].compareTo(pevot) > 0)
					pl++;
				while (a[pr].compareTo(pevot) < 0)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);

			}
			// 한번 정렬됨

			// 좌우로 나누기
			// 기준은...?
			// 왼쪽
			st.push(new Merge(left, pr));

			st.push(new Merge(pl, right));

		}

		return;
	}

	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
		// str 변수는 다항식 이름으로 스트링이다
		// count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다
		// 정렬후 다항식 x = 2.5x**7 + 3.8x**5 + 3.1x**4 + 1.5x**3 + 3.3x**2 + 4.0x**1 +
		// 2.2x**0
		int n = 0;
		if (count < 0)
			n = x.length;
		else
			n = count;
		// 구현코드

		System.out.print(str + "  =  ");

		for (int i = 0; i < n; i++) {
			if (i != 0)
				System.out.print("  +  ");

			System.out.print(x[i].getCoef() + "**" + x[i].getExp());

		}
		System.out.println();
	}

	static int AddPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
		// z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다
		int p = 0, q = 0, r = 0;
		int count = 0;

		int i = 0;

		while (p < x.length && q < y.length) {
			// 지수가 같으면
			if (x[p].compareTo(y[q]) == 0) {
				
				//지수가 같으면 계수 더하기
				z[i].setExp(x[p].getExp());
				z[i++].setCoef(x[p++].getCoef() + y[q++].getCoef());
				count++;

			} else if (x[p].compareTo(y[q]) > 0) {
				z[i].setExp(x[p].getExp());
				z[i++].setCoef(x[p++].getCoef());
				count++;
			} else {
				z[i].setExp(y[q].getExp());
				z[i++].setCoef(y[q++].getCoef());
				count++;
			}
			
		}

		while (p < x.length) {
			z[i++] = x[p++];
			count++;
		}
		while (q < y.length) {
			z[i++] = y[q++];
			count++;
		}
			

		int terms = count;
		// 구현코드
		return terms;

	}
	

	static int addTerm(Polynomial3[] z, Polynomial3 term, int terms) {
		// 다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		// 추가된 항의 수를 count하여 terms으로 리턴한다.
		// 구현코드
		
		//같은 지수인지 아닌지 찾는다
		//항의 수만큼 돌기
		for(int i = 0; i < terms;i++)
		{
			if(z[i].getCoef() == 0)
			{
				z[i].setCoef(term.getCoef());
				z[i].setExp(term.getExp());
				break;
			}
			if(z[i].getExp() == term.getExp()) {
				z[i].setCoef(z[i].getCoef() + term.getCoef());

				return terms;
			}
		}
		
		//MergeSort(z,0,terms);
		return ++terms;

	}

	static int MultiplyPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
		// z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다
		// terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
		int p = 0, q = 0, r = 0;
		int terms = 0;
		// 구현코드
		
		Polynomial3 pn = new Polynomial3();
		
		for(int i = 0; i < x.length;i++)
		{
			for(int j = 0; j < y.length;j++)
			{
				pn.setCoef(x[i].getCoef() * y[j].getCoef());
				pn.setExp(x[i].getExp() + y[j].getExp());
				
				terms = addTerm(z, pn, terms);
			}
		}
		
		
		return terms;
	}

	static double EvaluatePolynomial(Polynomial3[] z, int zTerms, int value) {
		// zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		// 다항식 계산 결과를 double로 리턴한다
		double result = 0.0;
		// 구현 코드
		
		for(int i = 0 ; i < zTerms;i++)
		{
			result += z[i].getCoef() * Math.pow(value, z[i].getExp());
		}
		
		return result;
	}

	public static void main(String[] args) {
		Polynomial3[] x = { new Polynomial3(1.5, 3), new Polynomial3(2.5, 7), new Polynomial3(3.3, 2),
				new Polynomial3(4.0, 1), new Polynomial3(2.2, 0), new Polynomial3(3.1, 4), new Polynomial3(3.8, 5), };
		Polynomial3[] y = { new Polynomial3(1.5, 1), new Polynomial3(2.5, 2), new Polynomial3(3.3, 3),
				new Polynomial3(4.0, 0), new Polynomial3(2.2, 4), new Polynomial3(3.1, 5), new Polynomial3(3.8, 6), };
		int nx = x.length;

		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);

		Polynomial3[] z = new Polynomial3[30];

		for (int i = 0; i < z.length; i++)
			z[i] = new Polynomial3();

		int zTerms = AddPolynomial(x, y, z);// 다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);
		
		
		for (int i = 0; i < z.length; i++)
			z[i] = new Polynomial3();
		
		zTerms = MultiplyPolynomial(x, y, z);// 다항식 곱셈 z = x * y
		MergeSort(z, 0, zTerms); // 배열 x를 퀵정렬
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
		double result = EvaluatePolynomial(z, zTerms, 1);// 다항식 값 계산 함수 z(10) 값 계산한다
		System.out.println(" result = " + result);
	}
}
