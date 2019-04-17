package MidTerm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vetcan {
	static int min = Integer.MAX_VALUE;
	static List<Edge> minRes = new ArrayList<>();
	public class Edge {
		int begin;
		int end;
		int val;
		
		Edge(int begin, int end, int val) {
			this.begin = begin;
			this.end = end;
			this.val = val;
		}

		public int getBegin() {
			return begin;
		}

		public int getEnd() {
			return end;
		}

		public int getVal() {
			return val;
		}

		public String toString() {
			return begin + " -> " + end + ": " + val;
		}
		
		public List<Edge> findEdge(List<Edge> edges, int begin) {
			List<Edge> res = new ArrayList<>();
			for (Edge edge : edges) 
				if (edge.getBegin() == begin)
					res.add(edge);
			return res;
		}
	}
	public static void main(String[] args) {
		
		int[][] input = {
                {0,7,0,5,0,0,0},
                {7,0,8,9,7,0,0},
                {0,8,0,0,5,0,0},
                {5,9,0,0,15,6,0},
                {0,7,5,15,0,8,9},
                {0,0,0,6,8,0,11},
                {0,0,0,0,9,11,0}
        };
		Vetcan Vetcan = new Vetcan();
		List<Edge> edges = toEdge(input);
		Set<Integer> listVerticals = getVerticals(edges);
		System.out.println(edges); // cac canh cua input
		System.out.println(listVerticals); // Cac dinh cua input
		List<Edge> res ;//ket qua ne`
		long now = System.nanoTime();
		for (Edge edge : edges) {
//			System.out.println(edge);
			res = new ArrayList<>();
			res.add(edge);
			dequy(edges, listVerticals, res);
		}
		
		System.out.println(System.nanoTime()-now);
		System.out.println(minRes + " " + min);
	} 
	public static void dequy(List<Edge> edges, Set<Integer> listVerticals, List<Edge> res) {
		int t = sum(res);
		
		Set<Integer> verticals = getVerticals(res);
		if (verticals.containsAll(listVerticals)) {
			if (t < min) {
				minRes = new ArrayList<>();
				min = t;
				minRes.addAll(res);
//				System.out.println(res + " " + min);
			}
			return;
		}
			
		for (Edge edge : edges) {
			if (checkEdge(edge, verticals)) {
				res.add(edge);
				dequy(edges, listVerticals, res);
				res.remove(edge);
			}
				
			
		}
	}
	public static int sum(List<Edge> edges) {
		int s = 0;
		for (Edge edge : edges) 
			s += edge.getVal();
		return s;
	}
	
	public static List<Edge> toEdge(int[][] input) {
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				int val = input[i][j]; 
				if (val != 0) {
					Edge edge = new Vetcan().new Edge(i,j,val);
					edges.add(edge);
				}
					
			}
		}
		
		return edges;
	}
	
	public static boolean checkEdge(Edge edge, Set<Integer> verticals) {
		if (!verticals.contains(edge.getBegin()))
			return false;
		if (verticals.contains(edge.getEnd()))
			return false;
		return true;
	}
	
	public static Set<Integer> getVerticals(List<Edge> edges) {
		Set<Integer> set = new HashSet<>();
		for (Edge edge : edges) {
			set.add(edge.getBegin());
			set.add(edge.getEnd());
		}
			
		return set;
	} 
} 