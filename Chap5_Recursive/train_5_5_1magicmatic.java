package Chap5_Recursive;

import java.util.Stack;

/*
 * 마방진: 마법 magic + 정방형 배열 + 배치 진열의 진 > 숫자를 특이하게 배열하여 모든 방향의 합이 일정
 * **매직 스퀘어(Magic Square)**는 n×n 크기의 정사각형 배열에 숫자를 배치하되, 
 * 모든 행, 열, 대각선의 숫자 합이 동일하게 되는 배열을 말합니다. 
 * 이때 이 동일한 합을 **매직 상수(Magic Constant)**라고 합니다.
 * n은 3,5,7 등 홀수일 때
 */

class rc {
	int row;
	int col;

	public rc(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public rc() {
		row = 0;
		col = 0;
	}

}

public class train_5_5_1magicmatic {

	public static void main(String[] args) {
		int n = 7; // 마방진의 크기
		int[][] magicSquare = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magicSquare[i][j] = 0;
			}
		}

		/*
		 * 루벤스의 방법 단계: 1. 첫 번째 숫자를 첫 번째 행의 가운데 열에 배치합니다. 2. 다음 숫자는 항상 대각선 위 오른쪽(북동쪽)으로
		 * 이동하여 배치합니다. 2.1 만약 배열의 경계를 벗어나면 반대편으로 이동합니다. 예를 들어, 열이 배열의 오른쪽 끝을 벗어나면 맨 왼쪽
		 * 열로 이동하고, 행이 배열의 맨 위를 벗어나면 맨 아래로 이동합니다. 3. 이미 숫자가 있는 칸에 도달한 경우, 현재 위치 바로 아래의
		 * 행으로 이동하여 다음 숫자를 배치합니다.
		 */
		// 마방진 생성 알고리즘 (루벤스의 방법)
		int row = 0, col = n / 2; // 시작 위치
		int NextRow = 0;
		int NextCol = n / 2;
		Stack<rc> stk = new Stack<rc>();

		// 처음 위치 저장
		stk.add(new rc(0, (int) n / 2));

		for (int num = 1; num <= n * n; num++) {
			row = stk.peek().row;
			col = stk.peek().col;

			magicSquare[row][col] = num; // 현재 위치에 숫자 배치
			// 구현

			// 대각선으로 이동 n보다 커지면 맨 앞으로
			// 음수가 될땐 capacity만큼 더 더해주기

			// 값이 있다면
			NextRow = (stk.peek().row - 1 + n) % n;
			NextCol = (stk.peek().col + 1 + n) % n;
			// 다르면 전위치를 팝
			
			if (magicSquare[NextRow][NextCol] != 0) {
				stk.peek().row = (stk.peek().row + 1) % n;

				continue;

			} // 값이 없다면 이동

			stk.add(new rc(NextRow, NextCol));

			
		}

		// 마방진 출력
		showSquare(magicSquare);

		// 마방진의 합 확인
		// 등차 수열의 합
		int magicSum = n * (n * n + 1) / 2;
		System.out.println("가로, 세로, 대각선의 합 =  " + magicSum);
		System.out.println("마방진 검사 = " + checkSquare(magicSquare, magicSum));
	}

	// 마방진 출력 메서드
	static void showSquare(int[][] magicSquare) {
		// 구현
		for (int[] n : magicSquare) {
			for (int m : n) {
				System.out.print(m + ", ");
			}
			System.out.println();
		}
	}

	// 마방진 유효성 검증 메서드
	static boolean checkSquare(int[][] magicSquare, int magicSum) {
		// 구현

		// 등차수열이 맞는지 확인하기 위한 거니깐 하나하나 다 더합니다.

		// 가로
		int sum1 = 0;

		for (int i = 0; i < magicSquare.length; i++) {

			sum1 = 0;
			for (int j = 0; j < magicSquare[0].length; j++) {
				sum1 = sum1 + magicSquare[i][j];
			}
		}
		// 세로
		int sum2 = 0;

		for (int i = 0; i < magicSquare.length; i++) {
			sum2 = 0;

			for (int j = 0; j < magicSquare[0].length; j++) {
				sum2 = sum2 + magicSquare[j][i];
			}
		}
		// 왼쪽 대각선
		int sum3 = 0;

		for (int i = 0; i < magicSquare.length; i++) {
			sum3 = sum3 + magicSquare[i][i];
		}
		// 오른쪽 대각선
		int sum4 = 0;

		for (int i = 0; i < magicSquare.length; i++) {
			sum4 = sum4 + magicSquare[magicSquare.length - 1 - i][i];
		}
		System.out.println(sum2);

		return (magicSum == sum1 && sum1 == sum2) && (sum2 == sum3 && sum3 == sum4);
	}

}
