//package cs6301.g11;
/*
 * Authors 	: Abhitej Boorla
 * 			: Anvesh Mandanapu
 * 			: Chandrika Cherukuri
 * 			: Raghunadh Metta
 */

// change following line to your group number

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class Euler {
	//customized vertex for solving euler path
	class EulerVertex {
		Graph.Vertex element;
		boolean seen;
		Iterator<Graph.Edge> iterator;
		List<Graph.Edge> subTour;

		public EulerVertex(Graph.Vertex u) {
			element = u;
			this.iterator = u.iterator();
			seen = false;
			this.subTour = new LinkedList<>();
		}
	}

	int VERBOSE;
	List<Graph.Edge> tour;
	// Constructor
	Graph g;
	Graph.Vertex start;
	//used parallel array to store vertex information
	EulerVertex eulerVertex[];
	boolean isGraphReversed;

	
	Euler(Graph g, Graph.Vertex start) {
		this.g = g;
		this.start = start;
		isGraphReversed = false;
		VERBOSE = 1;
		tour = new LinkedList<>();
		eulerVertex = new EulerVertex[g.size()];
		for (Graph.Vertex v : g) {
			eulerVertex[v.name] = new EulerVertex(v);
		}
	}

	// To do: function to find an Euler tour
	public List<Graph.Edge> findEulerTour() {
		findTours();
		if (VERBOSE > 9) {
			printTours();
		}
		stitchTours();
		return tour;
	}

	/*
	 * To do: test if the graph is Eulerian. If the graph is not Eulerian, it prints
	 * the message: "Graph is not Eulerian" and one reason why, such as
	 * "inDegree = 5, outDegree = 3 at Vertex 37" or
	 * "Graph is not strongly connected"
	 */
	boolean isEulerian() {
		//checking if the graph is strongly connected or not
		boolean isStronglyConntected = isStrongltConnected();
		if (isStronglyConntected) {
			boolean balancedInOutDegrees = checkInOutDegrees();
			if (balancedInOutDegrees) {
				System.out.println("The Input Graph is Eulerian");
				return true;
			} else {
				System.out.println(
						"Graph is not Eulerian because the InDegree and OutDegrees of some vertices do not match");
				return false;
			}

		} else {
			System.out.println("Graph is not Eulerian because its not Strongly Connected");
			return false;
		}
		// System.out.println("Graph is not Eulerian");
		// System.out.println("Reason: Graph is not strongly connected");
	}
// method to check if graph has indegree and out degree same
	boolean checkInOutDegrees() {
		for (Graph.Vertex u : g) {
			if (u.adj.size() != u.revAdj.size()) {
				return false;
			}
		}
		return true;
	}
//method to check if a graph is strongly connected or not
	boolean isStrongltConnected() {
		dfs(start, start.adj);
		for (Graph.Vertex u : g) {
			if (seen(u)) {
				resetVisited(u);
			} else if (!seen(u)) {
				return false;
			}
		}
		isGraphReversed = true;
		dfs(start, start.revAdj);
		for (Graph.Vertex u : g) {
			if (!seen(u)) {
				return false;
			}
		}

		return true;

	}

	// depth first search implementation for traversing the graph
	void dfs(Graph.Vertex u, List<Graph.Edge> neighbour) {
		visit(u);
		for (Graph.Edge e : neighbour) {
			Graph.Vertex v = e.otherEnd(u);
			if (!seen(v)) {
				if (isGraphReversed) {
					dfs(v, v.revAdj);
				} else {
					dfs(v, v.adj);
				}

			}
		}
	}
//reset the seen variable to reuse it againg for second dfs
	void resetVisited(Graph.Vertex u) {
		EulerVertex eulerU = getEulerVertex(u);
		eulerU.seen = false;
	}

	// helper method to make a vertex into a visited vertex
	void visit(Graph.Vertex u) {
		EulerVertex eulerU = getEulerVertex(u);
		eulerU.seen = true;
	}
//helper function to check if vertex is visited or not
	boolean seen(Graph.Vertex u) {
		EulerVertex eulerU = getEulerVertex(u);
		return eulerU.seen;
	}

	// converting standard vertex into our DAGVertex
	EulerVertex getEulerVertex(Graph.Vertex u) {
		return eulerVertex[u.name];
	}

	// Find tours starting at vertices with unexplored edges
	void findTours() {
		for (Graph.Vertex u : g) {
			EulerVertex eulerU = getEulerVertex(u);
			if (eulerU.iterator.hasNext()) {
				subTours(eulerU);
			}
		}
	}
//function to find sub tours for a given graph
	void subTours(EulerVertex eulerU) {
		EulerVertex tourStartVertex = eulerU;
		while (eulerU.iterator.hasNext()) {
			Graph.Edge currentEdge = eulerU.iterator.next();
			tourStartVertex.subTour.add(currentEdge);
			eulerU = getEulerVertex(currentEdge.otherEnd(eulerU.element));

		}
	}

	/*
	 * Print tours found by findTours() using following format: Start vertex of
	 * tour: list of edges with no separators Example: lp2-in1.txt, with start
	 * vertex 3, following tours may be found. 3:
	 * (3,1)(1,2)(2,3)(3,4)(4,5)(5,6)(6,3) 4: (4,7)(7,8)(8,4) 5: (5,7)(7,9)(9,5)
	 *
	 * Just use System.out.print(u) and System.out.print(e)
	 */
	void printTours() {
		for(Graph.Vertex v : g){
        	Euler.EulerVertex temp = getEulerVertex(v);
        	if(temp.subTour.size() != 0){
        		System.out.print(v+": ");
        		System.out.print(temp.subTour);
        	}
        }
	}

	// Stitch tours into a single tour using the algorithm discussed in class
	void stitchTours() {
		EulerVertex eulerStartVertex = getEulerVertex(start);
			explore(eulerStartVertex);
	}
	//This function will explore the given vertex, adds the subtour at e to tour
	void explore(EulerVertex e){
		if(e.subTour.size()!=0){
			Graph.Vertex prev=e.element;
			for(Graph.Edge ed : e.subTour){
				tour.add(ed);
				Graph.Vertex exploreVertex = ed.otherEnd(prev);
				prev=exploreVertex;
				if(!prev.equals(e.element)){
					explore(getEulerVertex(exploreVertex));
				}
			}
		}
	}

	void setVerbose(int v) {
		VERBOSE = v;
	}
}
