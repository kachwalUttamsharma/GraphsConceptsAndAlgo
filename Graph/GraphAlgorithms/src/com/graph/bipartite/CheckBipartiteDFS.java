package com.graph.bipartite;
import java.util.*;
/*
 * that can be colored using 2 colors such that no two adj nodes have same color
 */
public class CheckBipartiteDFS {

	private static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {
		
		if(color[node] == -1) {
			color[node] = 1;
		}
		
		for(Integer it: adj.get(node)) {
			if(color[it] == -1) {
				color[it] = 1- color[node];
				
				if(!dfsCheck(adj, it, color)) {
					return false;
				}
			} else if(color[it] == color[node]) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
		 int color[] = new int[n];

	        for (int i = 0; i < n; i++) {
	            color[i] = -1;
	        }

	        for (int i = 0; i < n; i++) {
	            if (color[i] == -1) {
	                if (!dfsCheck(adj, i, color)) {
	                    return false;
	                }
	            }
	        }
	        return true;
	}
	
	

	public static void main(String[] args) {
		int n = 6;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<6; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(1).add(4);
		adj.get(4).add(1);
		
		adj.get(1).add(5);
		adj.get(5).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(3).add(4);
		adj.get(4).add(3);
		
		adj.get(3).add(5);
		adj.get(5).add(3);
		
		if (checkBipartite(adj, n))
            System.out.println("It is a Bipartite Graph");
        else
            System.out.println("It is not a Bipartite Graph");
	}

	
}
