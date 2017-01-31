package org.janardhan.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

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

	// Driver method
	public static void main(String[] args) {
		Graph graph = new Graph(6);

		/**
		 * For DFS and BFS
		 */
		// graph.addEdge(0, 1);
		// graph.addEdge(0, 2);
		// graph.addEdge(1, 2);
		// graph.addEdge(2, 0);
		// graph.addEdge(2, 3);
		// graph.addEdge(3, 3);

		/**
		 * For Topological Sort
		 */
		// graph.addEdge(5, 0);
		// graph.addEdge(5, 2);
		// graph.addEdge(4, 0);
		// graph.addEdge(4, 1);
		// graph.addEdge(2, 3);
		// graph.addEdge(3, 1);

		/**
		 * For Cycle detection in Directed Graph
		 */

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.print("Breadth-First-Traversal for the graph is >> ");
		graph.BFS(5);

		System.out.print("\nDepth-First-Traversal for the graph is >> ");
		graph.DFS(5);

		System.out.print("\nTopological Sort for the graph is >> ");
		graph.topologicalSort();

		if (graph.isCyclc())
			System.out.println("\n Graph is cyclic");
		else
			System.out.println("\n Graph is acyclic");

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

	private void topologicalSort() {

		// Label all vertices as unvisited
		boolean[] visited = new boolean[V];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < V; i++) {

			// If the node is not visited, visit it
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		// Finally pop all nodes from the stack
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void topologicalSortUtil(int source, boolean[] visited, Stack<Integer> stack) {

		// Mark node as visited
		visited[source] = true;

		// Get the adjacent node for the visiting node and recur for the nodes
		Iterator<Integer> it = adj[source].listIterator();

		while (it.hasNext()) {
			int i = it.next();
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		stack.push(source);
	}

	private boolean isCyclc() {
		// TODO Auto-generated method stub
		return false;
	}
}
