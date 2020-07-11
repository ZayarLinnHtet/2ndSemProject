package com.bellmanford;

import java.util.HashMap;
import java.util.List;

public class BellmanFord {

    List<String> verticeList;
    List<Edge> edgeList;
    String source;


    public BellmanFord(List<String> verticeList, List<Edge> edgeList, String source) {
        this.verticeList = verticeList;
        this.edgeList = edgeList;
        this.source = source;
    }

    public void CalculateDistance(){
        HashMap<String, Double> distance = new HashMap<>();

        for (String s : verticeList) {
            distance.put(s, Double.MAX_VALUE);
        }

        distance.put(source, 0.0);

        for (int i=0; i<verticeList.size()-2; i++){
            for (Edge edge : edgeList) {
                if (distance.get(edge.start) + edge.weight < distance.get(edge.end))
                    distance.put(edge.end, distance.get(edge.start) + edge.weight);
            }
        }

        //Check for negative
        for (Edge edge: edgeList){
            if (distance.get(edge.start) + edge.weight < distance.get(edge.end)){
                System.out.println("Graph contains a negative-weigth cycle");
            }
        }

        //Display Result
        for (String vertex: verticeList){
            System.out.println(vertex+"\t"+distance.get(vertex));
        }
    }
}
