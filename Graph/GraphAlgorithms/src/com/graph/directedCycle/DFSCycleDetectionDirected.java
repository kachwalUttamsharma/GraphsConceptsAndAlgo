package com.graph.directedCycle;
import java.util.*;

public class DFSCycleDetectionDirected {
	
	private static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfsvis) {
		vis[node] = 1;
		dfsvis[node] = 1;
		
		for(Integer it: adj.get(node)) {
			if(vis[it] == 0) {
				if(checkCycle(it, adj, vis, dfsvis) == true) {
					return true;
				}
			} else if(dfsvis[it] == 1) {
				return true;
			}
		}
		dfsvis[node] = 0;
		return false;
	}
	
	
	private static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] vis = new int[v];
		int[] dfsvis = new int[v];
		
		for(int i=0; i<v; i++) {
			if(vis[i] == 0) {
				if(checkCycle(i, adj, vis, dfsvis)) return true;
			}
		}
		return false;
	}
	
	

	public static void main(String[] args) {
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
		
		if(isCycle(6, adj)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	
}
