package Graphs;

import util.Pair;

import java.util.*;

public class GraphUtil {
    public static Graph prismMst(Graph graph) {

        PriorityQueue<Pair<String, Pair<String, Integer>>> queue = new PriorityQueue<>(Comparator.comparing((Pair<String, Pair<String, Integer>> p) -> p.getSecond().getSecond()));
        String curr = null;
        Graph graph1 = new Graph();
        for(String vertex : graph.graph.keySet()) {
            graph1.addVertex(vertex);
        }
        HashSet<String> visited = new HashSet<>();
        HashSet<Pair<String, Pair<String, Integer>>> isAdded = new HashSet<>();
        //single edge with cost
        Pair<String, Pair<String, Integer>> minimum = graph.findMinimumEdge("A", new HashSet<>(), null, null);

        //added to check if node is visited or not
        visited.add(minimum.getFirst());
        visited.add(minimum.getSecond().getFirst());

        graph1.addEdge(minimum.getFirst(), minimum.getSecond().getFirst(), minimum.getSecond().getSecond());

        queue.add(minimum);

        HashMap<String, Integer> childs  = graph.graph.get(minimum.getFirst());

        addIntoQueue(queue, childs, minimum.getFirst(), isAdded);

        curr = minimum.getSecond().getFirst();

        while (!queue.isEmpty()) {

            HashMap<String, Integer> allChilds = graph.graph.get(curr);
            addIntoQueue(queue, allChilds, curr, isAdded);
            Pair<String, Pair<String, Integer>> pair = queue.poll();

            if(!visited.contains(pair.getSecond().getFirst())) {
                visited.add(pair.getSecond().getFirst());
                curr = pair.getSecond().getFirst();
                graph1.addEdge(pair.getFirst(), pair.getSecond().getFirst(), pair.getSecond().getSecond());
            }

        }
        System.out.println(graph1);
        return graph1;
    }

    public static void addIntoQueue(PriorityQueue queue, HashMap<String, Integer> childs, String source, HashSet<Pair<String, Pair<String, Integer>>> isAdded) {

        for(Map.Entry<String, Integer> singleChild :childs.entrySet()) {
            if(!isAdded.contains(new Pair<>(source, new Pair<>(singleChild.getKey(), singleChild.getValue())))) {
                queue.add(new Pair<>(source, new Pair<>(singleChild.getKey(), singleChild.getValue())));
                isAdded.add(new Pair<>(source, new Pair<>(singleChild.getKey(), singleChild.getValue())));
            }
        }

    }
}
