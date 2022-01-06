package com.burk.cyclefinding;

import java.util.List;

public class GraphTest {

    public static void main(String[] args) throws Exception {
//        CycleDetect cd = new CycleDetect(graph);
//        boolean hasCycle = cd.hashCycle();
//        System.out.print("Has a cycle? : " + hasCycle);
        GraphGenerator graphGenerator = new GraphGenerator(600);
//        for(int i= 0; i < gg.e; i++){
//            System.out.println(gg.edges[i]);
//        }

        String filename = "src/com/burk/cyclefinding/graph2.txt";
        Graph graph = new Graph();
        graph.createGraphByFile(filename);
        System.out.println(graph);

        long startTime = System.currentTimeMillis();
        CycleDetect cycleDetect = new CycleDetect(graph);
        long endTime = System.currentTimeMillis();


        boolean hasCycle = cycleDetect.hashCycle();

        System.out.println("\nDoes this graph have a cycle? : " + hasCycle);
        System.out.println("This algorithm spend " + (endTime - startTime) + "ms.");



    }
}
