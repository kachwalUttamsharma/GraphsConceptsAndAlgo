package com.graph.traversal;
import java.util.*;

/*
 * DFS - recursion 
 * using is array to mark visited node
 */
public class DFSTraversal {

	public static void helper(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsArr) {
		dfsArr.add(node);
		vis[node] = true;
		
		for(Integer it: adj.get(node)) {
			if(vis[it] == false) {
				helper(it, vis, adj, dfsArr);
			}
		}
		
	}
	public static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> dfsArr = new ArrayList<Integer>();
		boolean[] vis = new boolean[v+1];
		
		for(int i=1; i<=v; i++) {
			if(!vis[i]) {
				helper(i, vis, adj, dfsArr);
			}
		}
		return dfsArr;
	}
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<6; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(1).add(3);
		adj.get(3).add(1);
		
		adj.get(1).add(4);
		adj.get(4).add(1);
		
		adj.get(1).add(5);
		adj.get(5).add(1);
		
		adj.get(2).add(4);
		adj.get(4).add(2);
		
		ArrayList<Integer> ans = dfsOfGraph(5, adj);
		
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

}
