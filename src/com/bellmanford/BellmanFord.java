package com.bellmanford;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BellmanFord {

    List<String> verticeList;
    List<Edge> edgeList;
    String source;


    HashMap<String, Double> distance;
    HashMap<String, ArrayList<Edge>> adjEdgeList;

    List<Route> routeList = new ArrayList<>();

    public BellmanFord(List<String> verticeList, List<Edge> edgeList, String source) {
        this.verticeList = verticeList;
        this.edgeList = edgeList;
        this.source = source;

    }

    public void CalculateDistance(){
        distance = new HashMap<>();

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

    public void findingPath(String source, String destination, List<Edge> edgeList){
        HashMap<String, Boolean> isVisited = new HashMap<>();
        ArrayList<String> pathList = new ArrayList<>();

        adjEdgeList = new HashMap<>();
        for (String s : verticeList){
            adjEdgeList.put(s, new ArrayList<>());
        }
        for (Edge edge: edgeList){
            adjEdgeList.get(edge.start).add(edge);
        }

        for (String s: verticeList){
            isVisited.put(s, false);
        }

        pathList.add(source);

        //Call recursive utility
        getAllPaths(source, destination, isVisited, pathList);
    }

    private void getAllPaths(String source, String destination, HashMap<String, Boolean> isVisited, List<String> localPathList){

        isVisited.put(source, true);

        if (source.equals(destination)){
            Double routeDistance = getRouteDistanceAndPrint(localPathList);
            routeList.add(new Route(localPathList.toString(), routeDistance));
            isVisited.put(source, false);
            return;
        }

        for (Edge edge : adjEdgeList.get(source)){
            if (!isVisited.get(edge.end)){
                localPathList.add(edge.end);
                getAllPaths(edge.end, destination, isVisited, localPathList);

                //remove current node in path[]
                localPathList.remove(edge.end);
            }
        }

        //Mark the current node
        isVisited.put(source, false);
    }

    private Double getRouteDistanceAndPrint(List<String> pathList){
        System.out.print(pathList + " => [");
        Double d = 0.0;
        for (String vertex : pathList){
            d += distance.get(vertex);
            System.out.print(" "+distance.get(vertex)+ " ");
        }
        System.out.println("] => "+d);

        return d;
    }

    public void getShortestPath(){
        Double d = Double.MAX_VALUE;
        String path = "";
        for (Route r : routeList){
            if (r.distance<d){
                d = r.distance;
                path= r.vertices;
            }
        }

        System.out.println();
        System.out.println("The best rout => "+ path +" => "+ d);

    }
}
