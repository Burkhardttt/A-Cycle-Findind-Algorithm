package com.burk.cyclefinding;

import java.io.*;
import java.util.*;

/**
 * To realize a graph by using adjacent list
 */
public class Graph {
//    number of vertices
    private int vertices;

//    number of edges
    private int edges;

//    adjacent list
    public LinkedList<Integer>[] adjacent_list;

    public Graph(){}

    public Graph(int vertices){
        this.init(vertices);
    }

    private void init(int vertices){
        this.vertices = vertices;
//      Initialize the adjacent list
        this.adjacent_list = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            this.adjacent_list[i] = new LinkedList<Integer>();
        }
    }

    /**
     *
     * @param v id of vertice v
     * @param w id of vertice w
     */
    public void addEdge(int v, int w){
        this.adjacent_list[v].add(w);
        this.adjacent_list[w].add(v);
        this.edges ++;
    }

    /**
     * to create a graph from a file
     * @param path
     * @throws Exception
     */
    public void createGraphByFile(String path) throws Exception{
        try(BufferedReader bufferedReader = new BufferedReader(new BufferedReader(new FileReader(new File(path))))){
            int numOfVertices = Integer.parseInt(bufferedReader.readLine().trim());
            int numOfEdges = Integer.parseInt(bufferedReader.readLine().trim());

            if(numOfVertices <= 0 ){
                throw new IllegalArgumentException("the number of vertices must be greater than 0!");
            }
            if(numOfEdges <= 0){
                throw new IllegalArgumentException("the number of edges must be greater than 0!");
            }

            this.init(numOfVertices);
            for(int i = 0; i < numOfEdges; i++){
                String[] vl = bufferedReader.readLine().trim().split(" ");
                this.addEdge(Integer.parseInt(vl[0].trim()), Integer.parseInt(vl[1].trim()));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param v id of a vertice a
     * @return a list of vertice that are connected to this vertice a
     */
    public Collection<Integer> adjList(int v){
        return adjacent_list[v];
    }

    /**
     *
     * @return number of edges
     */
    public int getEdges() {
        return edges;
    }

    /**
     *
     * @return number of vertices
     */
    public int getVertices() {
        return vertices;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder(this.edges * this.vertices);
        for(int i = 0; i < this.vertices; i++){
            stringBuilder.append(i).append("->").append(adjacent_list[i]).append("\n");
        }
        return stringBuilder.toString();
    }
}
