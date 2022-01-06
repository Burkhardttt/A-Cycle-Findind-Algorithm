package com.burk.cyclefinding;

import java.util.*;

/**
 * To decect cycle by DFS
 */
public class CycleDetect {
    private Graph graph;
    private boolean[] visited;
    private boolean isHasCycle;
    private List<Integer> cyclePath;

    public CycleDetect(){}

    public CycleDetect(Graph graph){
        this.graph = graph;
        this.isHasCycle = false;
        visited = new boolean[graph.getVertices()];
        Arrays.fill(visited, Boolean.FALSE);
        this.dfs();
    }

    public void dfs(){
        for(int v = 0; v < graph.getVertices(); v++){
            if(!isVisited(v)){
                this.search(v,v);
            }
        }
    }

    /**
     *
     * @param v current visited vertice
     * @param prev precursor of v
     *        w subsequence of v
     */
    public void search(int v, int prev){
        System.out.print(v + " ");
        visited[v] = true;
        for(Integer w : graph.adjList(v)){
            if(!isVisited(w)){
                search(w, v);
            }
            else if(w != prev){
                isHasCycle = true;
            }
        }
    }

    public boolean isVisited(int v){
        return this.visited[v];
    }

    public boolean hashCycle(){
        return this.isHasCycle;
    }
}
