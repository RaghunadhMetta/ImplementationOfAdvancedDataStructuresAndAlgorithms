//package cs6301.g11;
/*
 * Authors 	: Abhitej Boorla
 * 			: Anvesh Mandanapu
 * 			: Chandrika Cherukuri
 * 			: Raghunadh Metta
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LP2 {
    static int VERBOSE = 1;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in;
        if (args.length > 0) {
            File inputFile = new File(args[0]);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }
	int start = 1;
        if(args.length > 1) {
	    start = Integer.parseInt(args[1]);
	}
	if(args.length > 2) {
            VERBOSE = Integer.parseInt(args[2]);
        }
        Graph g = Graph.readDirectedGraph(in);
	Graph.Vertex startVertex = g.getVertex(start);

	Euler euler = new Euler(g, startVertex);
	euler.setVerbose(VERBOSE);

	boolean eulerian = euler.isEulerian();
	if(!eulerian) {
	    return;
	}
	Timer timer = new Timer();
	euler.findEulerTour();
	timer.end();
    System.out.println(timer);
    }
}
