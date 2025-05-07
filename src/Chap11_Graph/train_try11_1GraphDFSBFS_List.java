package Chap11_Graph;

import java.util.*;

class Graph {
	LinkedList<Integer>[] adjacencyList;
	int n;
	boolean[] visited;

	public Graph(int vertices) {
		adjacencyList = new LinkedList[vertices];
		n = vertices;
		visited = new boolean[n];

	}

	void displayAdjacencyLists() {
		int i = 0;
		for (LinkedList<Integer> n : adjacencyList) {
			System.out.print(i + " -> ");
			for (int m : n) {
				System.out.print(m + " -> ");
			}
			System.out.println();
			i++;
		}
	}

	void insertEdge(int start, int end) {

		// 첫 노드가 없는경우
		if (adjacencyList[start] == null) {
			// 리스트 생성 해줘야함
			LinkedList<Integer> head = new LinkedList<Integer>();
			head.add(end);
			adjacencyList[start] = head;
		} else {

			// 있는경우
			adjacencyList[start].add(end);
		}

	}

	void bfs(int startNode) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		// 행렬 버젼에 Queue 설명 참조

		visited[startNode] = true;
		queue.add(startNode);

		System.out.print("BFS traversal: ");
		int next = 0;
		while (!queue.isEmpty()) {
			// 인접리스트가 null이 아니라면
			next = queue.poll();
			if(!visited[next]) System.out.print(next + "->");
			// 리스트 번호를 큐에 다 담기
			visited[next] = true;
			//방문을 안했다면
			for (int n : adjacencyList[next]) {
				if(!visited[n])
					queue.offer(n);
			}

		}
		System.out.println();
	}

	void dfs(int startNode) {
		Arrays.fill(visited, false);
		System.out.print("DFS traversal: ");
		nonRecursiveDfs(startNode);
		System.out.println();
	}

	void nonRecursiveDfs(int startNode) {
		Stack<Integer> stack = new Stack<>();
		/*
		 * Stack 클래스는 자바 표준 라이브러리에서 제공되는 클래스 stack.push(10); // 스택에 값 넣기 stack.pop(); //
		 * 스택에서 값 꺼내기 (제거) stack.peek(); // 맨 위 값 확인 (제거 X) stack.isEmpty(); // 비어있는지 확인
		 * 
		 * Stack은 오래된 클래스이고, 동기화(synchronized) 때문에 성능 떨어짐 Deque (예: ArrayDeque)를 사용해서
		 * 스택을 구현 추천 Deque<Integer> stack = new ArrayDeque<>();
		 *
		 * stack.push(10); // 값 넣기 stack.pop(); // 값 꺼내기 stack.peek(); // 맨 위 값 확인
		 */
		stack.push(startNode);
		visited[startNode] = false;

		int cur = 0;
		while (!stack.isEmpty()) {
			cur = stack.peek();
			
			//방문했다면
			if(visited[cur]) {
				stack.pop();
				continue;
			}
			System.out.print(cur + "->");
			visited[cur] = true;
			//방문하지 않았다면 방문가능한 모드 노드 넣기
			for(int n : adjacencyList[cur]) {
				stack.push(n);
			}
			
		}
	}
}

class InputGraph3 {
	int start, end;

	InputGraph3(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class train_try11_1GraphDFSBFS_List {
	static final int N = 8;

	static int[][] makeGraph() {
		return new int[][] { { 0, 1, 1, 0, 0, 0, 0, 0 }, { 1, 0, 0, 1, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 1, 1, 1, 0 } };
	}

	static void showMatrix(int[][] m) {
		System.out.println("adjacency matrix::");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = makeGraph();
		showMatrix(matrix);
		Scanner sc = new Scanner(System.in);
		Graph g = new Graph(N);

		while (true) {
			System.out
					.println("\nChoose Command: 1: Add edges, 2: Display Adjacency List, 3: BFS, 4: DFS, 5: Exit => ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				List<InputGraph3> inputData = new ArrayList<>();
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[0].length; j++) {
						if (matrix[i][j] == 1) {
							inputData.add(new InputGraph3(i, j));
						}
					}
				}
				for (InputGraph3 edge : inputData) {
					g.insertEdge(edge.start, edge.end);
				}
				break;

			case 2:
				g.displayAdjacencyLists();
				break;

			case 3:
				System.out.print("Enter starting node for BFS: ");
				int startBfsNode = sc.nextInt();
				g.bfs(startBfsNode);
				break;

			case 4:
				System.out.print("Enter starting node for DFS: ");
				int startDfsNode = sc.nextInt();
				g.dfs(startDfsNode);
				break;

			case 5:
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid input. Please re-enter.");
			}
		}
	}
}
