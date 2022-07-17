package com.graph.toposort;
import java.util.*;
/*
 * if there is vertex from u -> v then u should come before v
 */
public class DFSToposort {

	private static void findTopoSort(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		vis[node] = 1;
		for(Integer it: adj.get(node)) {
			if(vis[it] == 0) {
				findTopoSort(it, vis, adj, st);
			}
		}
		st.push(node);
	}
	
	private static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> st = new Stack<Integer>();
		int[] vis = new int[N];
		
		for(int i=0; i<N; i++) {
			if(vis[i] == 0) {
				findTopoSort(i, vis, adj, st);
			}
		}
		
		int[] topo = new int[N];
		int ind = 0;
		while(!st.isEmpty()) {
			topo[ind++] = st.pop();
		}
		return topo;
	}
	
	

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int n = 6;
		
		for(int i=0; i<6; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(5).add(2);
		adj.get(5).add(0);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(2).add(3);
		adj.get(3).add(1);
		
		int[] res = topoSort(6, adj);
		for(int i=0; i<6; i++) {
			System.out.println(res[i]);
		}
	}

	

}
