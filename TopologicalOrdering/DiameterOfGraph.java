/*
Authors : Abhitej Boorla
		: Mandanapu Anvesh
		: Chandrika Cherukuri
		: Raghunadh Metta
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class DiameterOfGraph {
	BFS bfs;
	//Method that returns the path of BFS based on the parent of vertex
	public LinkedList<Graph.Vertex> getDiameter(ArrayList<Graph.Vertex> bfs){
		LinkedList<Graph.Vertex> result = new LinkedList<>();
		Graph.Vertex parent = bfs.get(bfs.size()-1);
		while (parent != null) {
			result.add(parent);
			parent = this.bfs.getParent(parent);
		}
		return result;
	}
	/*Method that finds the diameter of given graph
	 * Step-1 : Performs BFS by choosing random vertex
	 * Step-2 : Gets the vertex at maximum distance from the random vertex and performs BFS from that vertex
	 * Step-3 : Gets the path of BFS performed in step-2
	 */
	public LinkedList<Graph.Vertex> diameter(Graph g){
		bfs = new BFS(g);
		Graph.Vertex randomVertex = g.getVertex(((int)(Math.random()*g.n))+1);//((int)(Math.random()*g.n))+1
		Graph.Vertex maxDistantNodeFromRandomVertex = bfs.nodeAtMaximumDistance(randomVertex);
		bfs.setVerticesUnseen();
		return getDiameter(bfs.getBFSFromVertex(maxDistantNodeFromRandomVertex));
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
	        if (args.length > 0) {
	            File inputFile = new File(args[0]);
	            in = new Scanner(inputFile);
	        } 
	        else {
	            in = new Scanner(System.in);
	        }
		Graph g = Graph.readGraph(in);
		
		DiameterOfGraph dG = new DiameterOfGraph();
		System.out.println(dG.diameter(g));
    }
}
