package org.janardhan.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

	// number of vertices
	private int V;
	// Adjacency List
	private LinkedList<Integer>[] adj;

	// Constructor
	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	private void BFS(int source) {

		// Mark all vertives as not visited
		boolean[] visited = new boolean[V];

		// Create a new Queue
		LinkedList<Integer> queue = new LinkedList<>();

		visited[source] = true;
		queue.add(source);

		while (!queue.isEmpty()) {

			// Dequeue a vertex and print it
			source = queue.poll();
			System.out.print(source + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> it = adj[source].listIterator();

			while (it.hasNext()) {

				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	private void DFS(int source) {

		boolean[] visited = new boolean[V];
		DFSUtil(source, visited);
	}

	private void DFSUtil(int source, boolean[] visited) {

		// Mark the current node as visited and print it
		visited[source] = true;
		System.out.print(source + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[source].listIterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	// Driver method
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.print("Breadth-First-Traversal for the tree is >> ");
		graph.BFS(2);

		System.out.print("\nDepth-First-Traversal for the tree is >> ");
		graph.DFS(2);
	}

}
