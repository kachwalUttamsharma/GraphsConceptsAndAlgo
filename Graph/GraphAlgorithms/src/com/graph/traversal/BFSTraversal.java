package com.graph.traversal;
import java.util.*;

/*
 * BFS - Level Order Traversal using queue
 *  using visited array to mark vertex visited as true
 */
public class BFSTraversal {
	
	public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> bfsArr = new ArrayList<Integer>();
		
		boolean[] vis = new boolean[v];
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(0);
		vis[0] = true;
		
		while(!q.isEmpty()) {
			Integer node = q.poll();
			bfsArr.add(node);
			
			for(Integer it: adj.get(node)) {
				if(vis[it] == false) {
					vis[it] = true;
					q.add(it);
				}
			}
		}
		return bfsArr;
	}
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<5; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		adjList.get(0).add(1);
		adjList.get(1).add(0);
		
		adjList.get(0).add(2);
		adjList.get(2).add(0);
		
		adjList.get(2).add(4);
		adjList.get(4).add(2);
		
		adjList.get(0).add(3);
		adjList.get(3).add(0);
		
		ArrayList<Integer> ans = bfsOfGraph(5, adjList);
		
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
