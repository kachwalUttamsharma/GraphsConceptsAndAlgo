package com.cycle.undirected;

import java.util.ArrayList;

/*
 * simple pass parent in dfs traversal O(N) & O(N)
 */
public class DFSCycleDetection {
	
	public static boolean checkForCycle(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
		vis[node] = true;
		for(Integer it: adj.get(node)) {
			if(vis[it] == false) {
				if(checkForCycle(it, node, vis, adj) == true) {
					return true;
				}	
			} else if(it != parent) {
					return true;
				}
		}
		
		return false;
	}
	public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(vis[i] == false) {
				if(checkForCycle(i, -1, vis, adj) == true) {
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<5; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(3).add(4);
		adj.get(4).add(3);
		
		adj.get(1).add(4);
		adj.get(4).add(1);
		
		boolean ans = isCycle(5, adj);
		System.out.println(ans);
	}

}
