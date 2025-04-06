package assignment;

import java.util.*;

class Edge3 implements Comparable<Edge3> {
    int src;
    int dest;
    int weight;

    public Edge3() {}

    public Edge3(int src, int dest, int weight) {
    	this.src = src;
    	this.dest = dest;
    	this.weight = weight;
    }

    @Override
    public String toString() {
    	return src + "(" + weight + ")->" + dest;
    }

    @Override
    public int compareTo(Edge3 e) {
    	return weight - e.weight;
    }
}

class Graph_MST {
    int n; // Number of nodes
    LinkedList<Edge3>[] adjacencyList;

    public Graph_MST(int n) {
    	
    	adjacencyList = new LinkedList[n];
    	
    	this.n = n;
    	for(int i = 0; i < n;i++) {
    		adjacencyList[i] = new LinkedList<>();
    	}
    	
    }

    public void insertEdge3(int src, int dest, int weight) {
    	
    	adjacencyList[src].add(new Edge3(src,dest,weight));
    	
    }

    public void displayAdjacencyLists() {
    	for(int i = 0; i < n; i++) {
    		for(Edge3 n : adjacencyList[i]) {
    			System.out.print(n.toString() +", ");
    		}
    		System.out.println();
    	}
    }
}

class Sets {
    int[] parent;

    public Sets(int n) {
    	//0은 비워둠 구현 편의성을 위해
    	//아닌가..,? 일단 없애 보자
    	//parent = new int[n+1];
    	parent = new int[n];
    	
    	for(int i = 0; i < parent.length;i++) {
    		parent[i] = -1;
    	}
    }

    public int find(int i) {
    	
    	if(parent[i]<0) return i;
    	
    	return parent[i];
    }

    public void union(int x, int y) {
    	//루트를 써야한다.
    	int root1 = find(x);
    	int root2 = find(y);
    	
    	//루트가 같을 때 싸이클 형성
    	if(root1 == root2) return;
    	//루트가 다를 때
    	
    	//크기구나?
    	//각 루트들은 weight 값을 가지고 있음
    	//예) -1 -2 -5 -3 등등
    	int total = parent[root1] + parent[root2];
    	if(parent[root1] > parent[root2]) {
    		parent[root1] = root2;
    		parent[root2] = total;
    	}else {
    		parent[root1] = root1;
    		parent[root2] = total;
    	}
    			
    }
}
public class train_실습과제11_3최소spanningtree_리스트 {
    static void KruskalMST(Graph_MST graph) {
        int n = graph.n;
        List<Edge3> listEdges = new ArrayList<>();

        // 모든 간선을 리스트에 추가
        for (int i = 0; i < n; i++) {
        	for(Edge3 temp : graph.adjacencyList[i]) {
        		listEdges.add(temp);
        	}
        }

        // Arrays.sort()를 사용하여 간선을 가중치 기준으로 정렬
        
        
        Arrays.sort(listEdges.toArray(),(a,b)-> HEIGHT_ORDER.compare((Edge3)a, (Edge3)b));

        // Kruskal 알고리즘을 위한 Disjoint Set 초기화
        Sets ds = new Sets(n);
        List<Edge3> mst = new ArrayList<>();

        for (Edge3 edge : edgeArray) {
     
        }

        // MST 출력
        if (mst.size() != n - 1) {
            System.out.println("No spanning tree found.");
        } else {
            System.out.println("Minimum Spanning Tree:");
            for (Edge3 edge : mst) {
                System.out.println(edge);
            }
        }
    }

    static final int N = 7;
    static final Comparator<Edge3> HEIGHT_ORDER =(a,b) -> a.compareTo(b);

    static int[][] makeGraph() {
        return new int[][]{
            {0, 28, 0, 0, 0, 10, 0},
            {28, 0, 16, 0, 0, 0, 14},
            {0, 16, 0, 12, 0, 0, 0},
            {0, 0, 12, 0, 22, 0, 18},
            {0, 0, 0, 22, 0, 25, 24},
            {10, 0, 0, 0, 25, 0, 0},
            {0, 14, 0, 18, 24, 0, 0},
        };
    }
    static void showMatrix(int[][]m) {
    	System.out.println("adjacency matrix::");
    	for (int[] row : m) {
    		for (int num: row) {
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
    public static void main(String[] args) {
        int[][] matrix = makeGraph();
        showMatrix(matrix);
        Graph_MST graph = new Graph_MST(N);

        // 인접 행렬을 사용해 그래프 초기화
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    graph.insertEdge3(i, j, matrix[i][j]);
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n명령선택:: 1. Adjacency Lists 출력, 2. spanningTree (Kruskal), 3: Quit => ");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    graph.displayAdjacencyLists();
                    break;
                case 2:
                    System.out.println("\nMinimal Spanning Tree 작업 시작");
                    KruskalMST(graph);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}
