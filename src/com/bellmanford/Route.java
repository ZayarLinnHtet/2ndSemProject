package com.bellmanford;


public class Route {
    String  vertices;
    Double distance;

    public Route(String vertices, Double distance) {
        this.vertices = vertices;
        this.distance = distance;
    }

    public String getVertices() {
        return vertices;
    }

    public void setVertices(String vertices) {
        this.vertices = vertices;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
