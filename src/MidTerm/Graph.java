package MidTerm;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

//Kruskal's Algos
class Graph 
{ 
	
	class Edge implements Comparable<Edge> 
	{ 
		int src, dest, weight; 

		public int compareTo(Edge compareEdge) 
		{ 
			return this.weight-compareEdge.weight; 
		} 
	}; 
	// A class to represent a subset for union-find
	class subset 
	{ 
		int parent, rank; 
	}; 

	int V, E; 
	Edge edge[]; 

	Graph(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[E]; 
		for (int i=0; i<e; ++i) 
			edge[i] = new Edge(); 
	} 
	// A utility function to find set of an element i 
    // (uses path compression technique) 
	int find(subset subsets[], int i) 
	{ 
		// find root and make root as parent of i (path compression) 
		if (subsets[i].parent != i) 
			subsets[i].parent = find(subsets, subsets[i].parent); 

		return subsets[i].parent; 
	} 

	// A function that does union of two sets of x and y 
	// (uses union by rank) 
	void Union(subset subsets[], int x, int y) 
	{ 
		int xroot = find(subsets, x); 
		int yroot = find(subsets, y); 

		// Attach smaller rank tree under root of high rank tree 
		// (Union by Rank) 
		if (subsets[xroot].rank < subsets[yroot].rank) 
			subsets[xroot].parent = yroot; 
		else if (subsets[xroot].rank > subsets[yroot].rank) 
			subsets[yroot].parent = xroot; 

		// If ranks are same, then make one as root and increment 
		// its rank by one 
		else
		{ 
			subsets[yroot].parent = xroot; 
			subsets[xroot].rank++; 
		} 
	} 

	
	void KruskalMST() 
	{ 
		Edge result[] = new Edge[V]; 
		int e = 0; //index for result[]
		int i = 0; //index for sorted edges
		for (i=0; i<V; ++i) 
			result[i] = new Edge(); 

		//step 1
		Arrays.sort(edge); 
		
		
		subset subsets[] = new subset[V]; 
		for(i=0; i<V; ++i) 
			subsets[i]=new subset(); 

		for (int v = 0; v < V; ++v) 
		{ 
			subsets[v].parent = v; 
			subsets[v].rank = 0; 
		} 

		i = 0; // Index used to pick next edge 
		// Number of edges to be taken is equal to V-1 
		while (e < V - 1) 
		{ 
			// Step 2
			Edge next_edge = new Edge(); 
			next_edge = edge[i++]; 

			int x = find(subsets, next_edge.src); 
			int y = find(subsets, next_edge.dest); 

			// If including this edge does't cause cycle, 
			// include it in result and increment the index 
			// of result for next edge 
			if (x != y) 
			{ 
				result[e++] = next_edge; 
				Union(subsets, x, y); 
			} 
			// Else discard the next_edge 
		} 

		// print the contents of result[] to display 
		// the built MST 
		System.out.println("Edge \tWeight"); 
		for (i = 0; i < e; ++i) 
			System.out.println(result[i].src+" - " + result[i].dest+"\t" + result[i].weight); 
		System.out.println(find(subsets, 2));
	} 
	
	private static void addEdge(Graph graph, int input[][]) {
		int numOfE= 0; //index
		 for (int i = 0; i < input.length; i++) {
			for (int j = i+1; j < input[0].length; j++) {
				if(input[i][j] != 0) {
					graph.edge[numOfE].src= i;
					graph.edge[numOfE].dest= j;
					graph.edge[numOfE].weight= input[i][j];
					numOfE++;
				}
			}
		}
	}

	// Driver Program 
	public static void main (String[] args) 
	{ 

		
		int V = 7; // Number of vertices in graph 
		int E = 11; // Number of edges in graph 
		Graph graph = new Graph(V, E); 

		int[][] input= {{0, 7, 0, 5, 0, 0, 0}, 
				{7, 0, 8, 9, 7, 0, 0}, 
				{0, 8, 0, 0, 5, 0, 0}, 
				{5, 9, 0, 0, 15, 6, 0}, 
				{0, 7, 5, 15, 0, 8, 9},
				{0, 0, 0, 6, 8, 0, 11},
				{0, 0, 0, 0, 9, 11, 0}};
		addEdge(graph, input);
		graph.KruskalMST(); 
	} 
} 
