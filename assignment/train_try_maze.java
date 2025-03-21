package assignment;
/*
 * 미로 찾기 문제
 * plato(LMS)의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

import java.util.Stack;

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 k;/'"사용 구분을 못하는 문제 => 선행 학습 필요
enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

class Items {
	int x;
	int y;
	int dir;
	public Items(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

}

class Offsets {
	int a;
	int b;

	public Offsets(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

}

public class  train_try_maze {

	static Offsets[] moves = new Offsets[8];// static을 선언하는 이유를 알아야 한다
	final static int N = 12;
	final static int M = 15;

	static int maze[][] = new int[14][17];
	static int mark[][] = new int[14][17];

	static void path(int maze[][], int mark[][], int m, int p){//m = 12, p = 15
	//출발점 (1,1), 이동 방향 dir = 2(2는 동쪽) 을 스택에 push
	//initialize stack to the maze entrance coordinates and direction east;
	Stack<Items> stk = new Stack<Items>();
	stk.push(new Items(1,1,2));
	mark[1][1] = 1;
	int curX = 0;
	int curY = 0;
	int dir = 0;
	
	int nextX = 0;
	int nextY = 0;
	
	while (!stk.isEmpty())
	{
	//(i,j,dir) = coordinates and direction deleted from top of stack;
	//현재 위치 (i,j)에 대하여 mark[][]을 1로 설정
		curX = stk.peek().x;
		curY = stk.peek().y;
		dir = stk.peek().dir;
		
	   if (dir<8)//8가지 방향중에서 남은 방향에 대하여
	   {
	      //(g,h) = coordinates of next move;//현재 위치 (i,j)에 대하여 이동 방향 계산
		   nextX = curX + moves[dir].a;
		   nextY = curY + moves[dir].b;
		   
	      if ((nextX == m) && (nextY == p)) {
	//success;
	//(i,j)와 (g,h)에 대하여 mark 표시
	    	  mark[nextX][nextY] = 1;
	    	  return;
	      }
	      
	      //0으로만 움직을 수 있으므로
	      if ((maze[nextX][nextY] == 0)//legal move
	         && (mark[nextX][nextY] == 0)) //haven't been here before
	      {
	         mark[nextX][nextY] = 1;
	         
	         //다음 곳으로 옮기고 dir 초기화
	         //x,y오타 났었음  ㅠㅠ
	         stk.push(new Items(nextX,nextY,0));
	        // i = g; j = h; dir = N;

	      }
	      else
	       stk.peek().dir++; //try next direction
	   }//모든 방향을 도전했을 경우 백트래킹
	   else {
		   stk.pop();
		   mark[curX][curY] = 0;
		   stk.peek().dir++;
		   //쓸대 없는걸 넣었었음...
		   //mark[curX][curY]=0
	   }
	   //(i,j) 현위치에 대한 mark를 취소
	
	}
	System.out.println("No path found");
	
	}
	
	public static boolean isSafe(int x,int y) {
		//n n 오타 났었음 ㅠㅠㅠ
		return x>=0 && y >=0 && x<N && y<M;
	}

	public static void show(String msg,int[][] temp) {
		
		System.out.println(msg);
		
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < M+2; j++) {
				// input[][]을 maze[][]로 복사

				System.out.print(temp[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);// 배열에 offsets 객체를 치환해야 한다.

		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;
		// Directions d;
		// d = Directions.N;
		// d = d + 1;//java는 지원안됨
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// input[][]을 maze[][]로 복사
				maze[i+1][j+1] = input[i][j];
				mark[i+1][j+1] = 0;
			}
		}
		//윗줄
		for(int i = 0; i<maze[0].length;i++)
		{
			maze[0][i] = 1;
		}
		//아랫줄
		for(int i = 0; i<maze[0].length;i++)
		{
			maze[maze.length-1][i] = 1;
		}
		//왼쪽줄
		for(int i = 0; i<maze.length;i++)
		{
			maze[i][0] = 1;
		}
		//오른줄
		for(int i = 0; i<maze.length;i++)
		{
			maze[i][maze[0].length-1] = 1;
		}
		
		
		
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

	}
}
