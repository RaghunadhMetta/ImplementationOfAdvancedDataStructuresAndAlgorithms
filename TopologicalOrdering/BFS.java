/*
Authors : Abhitej Boorla
		: Mandanapu Anvesh
		: Chandrika Cherukuri
		: Raghunadh Metta
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class BFS {
		Graph g;
		BFSVertex[] BFSvertices;
		class BFSVertex{
			boolean seen;
			Graph.Vertex v;
			Graph.Vertex parent;
			public BFSVertex(Graph.Vertex v){
				seen = false;
				this.v = v;
				parent= null;
			}
			public boolean seen(){
				return seen;
			}
		}
		public void setVerticesUnseen(){
			for(BFSVertex v : BFSvertices){
				v.seen = false;
				v.parent = null;
			}
		}
		public Graph getGraph(){
			return g;
		}
		public boolean seen(Graph.Vertex v){
			BFSVertex vertex = getBFSvertex(v);
			return vertex.seen;
		}
		public void setParent(Graph.Vertex v, Graph.Vertex parent){
			BFSVertex vertex = getBFSvertex(v);
			vertex.parent = parent;
		}
		public Graph.Vertex getParent(Graph.Vertex v){
			BFSVertex vertex = getBFSvertex(v);
			return vertex.parent;
		}
		public BFSVertex getBFSvertex(Graph.Vertex v){
			return BFSvertices[v.name];
		}
		public BFS(Graph g){
			this.g = g;
			BFSvertices = new BFSVertex[g.size()];
			for(Graph.Vertex vertex : g.v){
				BFSvertices[vertex.name] = new BFSVertex(vertex);
			}
		}
		//Method that marks the visited vertex in BFS as seen
		public void visted(Graph.Vertex v){
			BFSVertex bfsV = getBFSvertex(v);
			bfsV.seen = true;
		}
		//Method that performs BFS from the input vertex u and assigns parent to each visited vertex
		public ArrayList<Graph.Vertex> getBFSFromVertex(Graph.Vertex u){
			ArrayList<Graph.Vertex> bfs = new ArrayList<Graph.Vertex>();
			Queue<Graph.Vertex> queue = new LinkedList<>();
			queue.add(u);
			setParent(u, null);
			while(!queue.isEmpty()){
				Graph.Vertex temp = queue.poll();
				bfs.add(temp);
				visted(temp);
				for(Graph.Edge e : temp){
					Graph.Vertex otherVertex = e.otherEnd(temp);
					if(!seen(otherVertex)){
						setParent(otherVertex, temp);
						queue.offer(otherVertex);
					}
				}
			}
			return bfs;
		}
		//Method that returns the vertex at the maximum distance from the given vertex
		public Graph.Vertex nodeAtMaximumDistance(Graph.Vertex v){
			ArrayList<Graph.Vertex> bfs = getBFSFromVertex(v);
				return bfs.get(bfs.size()-1);
		}
}
