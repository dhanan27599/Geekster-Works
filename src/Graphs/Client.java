package Graphs;

public class Client {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "D", 40);
        graph.addEdge("C", "B", 10);
        graph.addEdge("C", "D", 10);
        graph.addEdge("D", "E", 2);
        graph.addEdge("E", "F", 3);
        graph.addEdge("F", "G", 3);
        graph.addEdge("E", "G", 8);
//        System.out.println(graph);
//        graph.removeEdge("D", "E");
//        System.out.println(graph);
//        graph.removeVertex("D");
//        System.out.println(graph);
//        System.out.println(graph.countVertices());
//        System.out.println(graph.countEdges());

//        System.out.println(graph.hasPath("A", "G"));
//        graph.printPath("A", "G");
//        graph.printSmallestPath("A", "G");
//        graph.bfs("A", "G");
//        graph.dfs("A", "G");
        System.out.println(graph.getConnectedComponents());
//        System.out.println(graph.isCycle());
    }
}
