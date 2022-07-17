package com.cycle.directed;
import java.util.*;
/*
 * Khan's algo (indegree logic) if you are unable to generate topological sort then it is cyclic graph
 * Topological sort applied on only DAG
 */
public class BFSCycleDetectionDirected {
	
	private static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
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
		int cnt = 0;
		while(!q.isEmpty()) {
			Integer node =q.poll();
			cnt++;
			for(Integer it: adj.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		if(cnt == N) return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(1).add(5);
		adj.get(2).add(3);
		adj.get(3).add(4);
		adj.get(4).add(0);
		adj.get(4).add(1);
		
		if(isCyclic(6, adj)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
