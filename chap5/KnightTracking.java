//package chap5;
//
//import java.util.Stack;
//
//class Offsets4 {
//	int a;
//	int b;
//
//	public Offsets4(int a, int b) {
//		this.a = a;
//		this.b = b;
//	}
//}
//
//public class KnightTracking {
//	static class Point {
//		int x, y, moveToward;
//
//		Point(int x, int y, int move) {
//			this.x = x;
//			this.y = y;
//			this.moveToward = move;
//		}
//
//	}
//
//	// 체스판을 초기화 (-1로 설정)
//	private static void initializeBoard() {
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				board[i][j] = -1;
//			}
//		}
//		
//		for (int ia = 0; ia < N; ia++)
//			moves[ia] = new Offsets4(0, 0);// 배열에 Offsets4 객체를 치환해야 한다.
//
//		
//		
//		moves[0].a=-2;moves[0].b=-1;// NW으로 이동
//
//		moves[1].a=-2;moves[1].b=1;// NE
//
//		moves[2].a=-1;moves[2].b=2;// EN
//
//		moves[3].a=1;moves[3].b=2;// ES
//
//		moves[4].a=2;moves[4].b=1;// SE
//
//		moves[5].a=2;moves[5].b=-1;// SW
//
//		moves[6].a=-1;moves[6].b=-2;// WS
//
//		moves[7].a=1;moves[7].b=-2;// WN
//		
//	}
//
//	static Offsets4[] moves = new Offsets4[8];// static을 선언하는 이유를 알아야 한다
//
//	
//
//	static final int N = 8;
//
//	private static int[][] board = new int[N][N];
//
//	public static void main(String[] args) {
//		
//		
//		initializeBoard();
//
//        // 나이트가 (0, 0)에서 시작
//        if (solveKnightTracking(0, 0)) {
//            showTracking();
//        } else {
//            System.out.println("해결할 수 없습니다.");
//        }
//    }
//
//}}