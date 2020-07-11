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
        vertixList.add("F");

        edgeList.add(new Edge("A", "B", 5.0));
        edgeList.add(new Edge("A", "D", 15.0));
        edgeList.add(new Edge("B", "C", 15.0));
        edgeList.add(new Edge("B", "D", 10.0));
        edgeList.add(new Edge("C", "F", 5.0));
        edgeList.add(new Edge("D", "C", 15.0));
        edgeList.add(new Edge("D","E",15.0));
        edgeList.add(new Edge("E","F",5.0));

        String start = "A";

        BellmanFord bellmanFord = new BellmanFord(vertixList, edgeList, start);
        bellmanFord.CalculateDistance();
    }

}
