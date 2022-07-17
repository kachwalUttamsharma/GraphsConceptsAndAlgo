package com.graph.toposort;
import java.util.*;

public class BFSTopoSort {

	private static int[] isCycle(int N, ArrayList<ArrayList<Integer>> adj) {
		int[] topo = new int[N];
		int[] indegree = new int[N];
		
		for(int i=0; i<N; i++) {
			for(Integer it: adj.get(i)) {
				indegree[it]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		int ind = 0;
		
		while(!q.isEmpty()) {
			Integer node =q.poll();
			topo[ind++] = node;
			
			for(Integer it: adj.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		return topo;
	}
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		int n = 6;
		for(int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(5).add(2);
		adj.get(5).add(0);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(3).add(1);
		adj.get(2).add(3);
		
		int[] ans = isCycle(n, adj);
		
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	

}
