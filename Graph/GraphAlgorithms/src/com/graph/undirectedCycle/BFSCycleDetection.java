package com.graph.undirectedCycle;

import java.util.*;

class Node {
	int node;
	int parent;
	public Node(int f, int s) {
		node = f;
		parent = s;
	}
}
public class BFSCycleDetection {

	private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(i, -1));
		vis[i] = true;
		
		while(!q.isEmpty()) {
			int currNode = q.peek().node;
			int parentNode = q.peek().parent;
			q.poll();
			
			for(Integer it: adj.get(currNode)) {
				if(vis[it] == false) {
					q.add(new Node(it, currNode));
					vis[it] = true;
				} else if(parentNode != it) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	private static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[v];
		for(int i=0; i<v; i++) {
			if(vis[i] == false) {
				if(checkForCycle(adj, i ,vis)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	


	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj  = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		adj.get(0).add(2);
		adj.get(2).add(0);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(1).add(3);
		adj.get(3).add(1);
		
		adj.get(2).add(4);
		adj.get(4).add(2);
		
		boolean ans = isCycle(v, adj);
		System.out.println(ans);
	}

	

}
