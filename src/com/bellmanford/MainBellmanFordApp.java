package com.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class MainBellmanFordApp {

    public static void main(String args[]){

        List<String> vertixList = new ArrayList<>();
        List<Edge> edgeList = new ArrayList<>();

        vertixList.add("A");
        vertixList.add("B");
        vertixList.add("C");
        vertixList.add("D");
        vertixList.add("E");

        edgeList.add(new Edge("A", "B", 1.0));
        edgeList.add(new Edge("A", "D", 2.0));
        edgeList.add(new Edge("B", "C", 2.0));
        edgeList.add(new Edge("C", "D", 2.0));
        edgeList.add(new Edge("C", "E", 8.0));
        edgeList.add(new Edge("D", "C", 2.0));
        edgeList.add(new Edge("D", "E",3.0));

        String start = "A";
        String end = "E";

        BellmanFord bellmanFord = new BellmanFord(vertixList, edgeList, start);
        bellmanFord.CalculateDistance();
        bellmanFord.findingPath(start, end, edgeList);
        bellmanFord.getShortestPath();
    }

}
