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

	/*
	 * In case of undirected graph a back edge also needs to be added ie.
	 * adj[w].add(v)
	 */
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

		// Mark all the vertices as not visited and not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i])
				if (isCyclicUtil(i, visited, recStack)) {
					return true;
				}
		}

		return false;
	}

	/**
	 * To detect a back edge, we can keep track of vertices currently in
	 * recursion stack of function for DFS traversal. If we reach a vertex that
	 * is already in the recursion stack, then there is a cycle in the tree
	 * 
	 * @param source
	 * @param visited
	 * @param recStack
	 * @return
	 */
	private boolean isCyclicUtil(int source, boolean[] visited, boolean[] recStack) {

		// Marks root as visited and add to recursion stack
		visited[source] = true;
		recStack[source] = true;

		// Get the adjacent node for the visiting node and recur for the nodes
		Iterator<Integer> it = adj[source].listIterator();

		while (it.hasNext()) {

			int i = it.next();

			if (!visited[i]) {
				if (isCyclicUtil(i, visited, recStack)) {
					return true;
				}
			}
			// If the node is visited and present in the recursion stack that
			// means its the part of the cycle
			else if (recStack[i]) {
				return true;
			}
		}
		recStack[source] = false; // remove the vertex from recursion stack
		return false;
	}

	// A recursive function that uses visited[] and parent to detect
	// cycle in subgraph reachable from vertex v.
	private boolean isCyclicUtilUndirectedGraph(int v, Boolean visited[], int parent) {
		// Mark the current node as visited
		visited[v] = true;
		Integer i;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();

			// If an adjacent is not visited, then recur for that
			// adjacent
			if (!visited[i]) {
				if (isCyclicUtilUndirectedGraph(i, visited, v))
					return true;
			}

			// If an adjacent is visited and not parent of current
			// vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	private boolean isCyclicUnDirectedGraph() {
		// Mark all the vertices as not visited and not part of
		// recursion stack
		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function to detect cycle in
		// different DFS trees
		for (int u = 0; u < V; u++)
			if (!visited[u]) // Don't recur for u if already visited
				if (isCyclicUtilUndirectedGraph(u, visited, -1))
					return true;

		return false;
	}
}
