package com.burk.cyclefinding;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;




public class GraphGenerator {

    public int v;
    public int e = 0;
    public String[] edges;

    public GraphGenerator(int v){
        Random rand = new Random();
        this.v = v;
        e = Math.abs(rand.nextInt(v * (v - 1) / 2)); // tips: e <= v * (v-1)/2
        edges = new String[e];
        for(int i = 0; i < e; i++){
            edges[i] = "";
        }

        label:for(int i = 0; i < e;i++){
            int start = Math.abs(rand.nextInt(v));
            int end = Math.abs((rand.nextInt(v)));
            if(start == end){
                i--;
            }
            else{
                String temp = start + " " + end;
                for(int j = 0; j < e; j++){
                    if (edges[j].equals(temp) || edges[j].equals(StringUtils.reverse(temp))){
                        i--;
                        continue label;
                    }
                }
                edges[i] = temp;
            }
        }

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/com/burk/cyclefinding/graph2.txt"));
            out.write(v + "");
            out.write("\n");
            out.write(e + "");
            out.write("\n");

            for(int i = 0; i < e; i++){
                if(i != e - 1){
                    out.write(edges[i]);
                    out.write("\n");
                }
                else{
                    out.write(edges[i]);
                }
            }
            out.close();
        } catch (IOException exception) {}
    }
}
