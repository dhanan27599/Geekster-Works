package Graphs;
import util.Pair;

import java.util.*;
public class Graph {
    HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

    public void addVertex(String vertex) {
        if(!graph.containsKey(vertex)) {
            graph.put(vertex, new HashMap<>());
        }
    }

    public boolean containsVertex(String vertex) {
        return graph.containsKey(vertex);
    }

    public void addEdge(String fromVertex, String toVertex, int weight) {
        if(containsVertex(fromVertex) && containsVertex(toVertex)) {
            graph.get(fromVertex).put(toVertex, weight);
            graph.get(toVertex).put(fromVertex, weight);
        }
    }

    public boolean containsEdge(String fromVertex, String toVertex) {
        if(!containsVertex(fromVertex) || !containsVertex(toVertex)) {
            return false;
        }

        return graph.get(fromVertex).containsKey(toVertex);
    }

    public int countVertices() {
        return graph.size();
    }

    public int countEdges() {
        int edges = 0;
        for(String s : graph.keySet()) {
            edges += graph.get(s).size();
        }
        return (edges / 2);
    }

    public void removeEdge(String fromVertex, String toVertex) {
        if(containsEdge(fromVertex, toVertex)) {
            graph.get(fromVertex).remove(toVertex);
            graph.get(toVertex).remove(fromVertex);
        }
    }

    public void removeVertex(String vertex) {
        if(containsVertex(vertex)) {
            ArrayList<String> neighbors = new ArrayList<>(graph.get(vertex).keySet());
            for(String neighbor : neighbors) {
                removeEdge(neighbor, vertex);
            }
            graph.remove(vertex);
        }
    }

    public boolean hasPath(String fromVertex, String toVertex) {
        return hasPath(fromVertex, toVertex, new HashSet<String>());
    }

    private boolean hasPath(String fromVertex, String toVertex, HashSet<String> visited) {
        if(fromVertex.equals(toVertex)) {
            return true;
        }
        visited.add(fromVertex);
        ArrayList<String> neighbors = new ArrayList<>(graph.get(fromVertex).keySet());
        for(String neighbor : neighbors) {
            if(!visited.contains(neighbor)) {
                if(hasPath(neighbor, toVertex, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printPath(String fromVertex, String toVertex) {
        printPath(fromVertex, toVertex, new HashSet<String>(), fromVertex);
    }

    private void printPath(String fromVertex, String toVertex, HashSet<String> visited, String ans) {
        if(fromVertex.equals(toVertex)) {
            System.out.println(ans);
            return;
        }
        visited.add(fromVertex);
        ArrayList<String> neighbors = new ArrayList<>(graph.get(fromVertex).keySet());
        for(String neighbor : neighbors) {
            if(!visited.contains(neighbor)) {
                printPath(neighbor, toVertex, visited, ans + neighbor);
            }
        }
        visited.remove(fromVertex);
    }

    private static String smallestPath;
    private static int smallestWeight;


    public void printSmallestPath(String fromVertex, String toVertex) {
        smallestPath = "";
        smallestWeight = Integer.MAX_VALUE;
        printSmallestPath(fromVertex, toVertex, new HashSet<String>(), fromVertex, 0);
        System.out.println(smallestPath + " -> " + smallestWeight);
    }

    private void printSmallestPath(String fromVertex, String toVertex, HashSet<String> visited, String ans, int weight) {
        if(fromVertex.equals(toVertex)) {
            if(smallestWeight > weight) {
                smallestWeight = weight;
                smallestPath = ans;
            }
//            System.out.println(ans);
            return;
        }
        visited.add(fromVertex);
        ArrayList<String> neighbors = new ArrayList<>(graph.get(fromVertex).keySet());
        for(String neighbor : neighbors) {
            if(!visited.contains(neighbor)) {
                printSmallestPath(neighbor, toVertex, visited, ans + neighbor, weight + graph.get(fromVertex).get(neighbor));
            }
        }
        visited.remove(fromVertex);
    }

    private class TraversePair {
        String vert;
        String path;
        int weight;

        public TraversePair(String vert, String path, int weight) {
            this.vert = vert;
            this.path = path;
            this.weight = weight;
        }
    }

    public boolean bfs(String s, String d) {
        TraversePair pair = new TraversePair(s, s, 0);
        HashSet<String> vis = new HashSet<>();
        Deque<TraversePair> q = new ArrayDeque<>();
        q.add(pair);
        while(q.size() > 0) {
            TraversePair rem = q.remove();
            vis.add(rem.vert);
            System.out.println(rem.vert + " # " + rem.path);
            if(rem.vert.equals(d)) {
                return true;
            }
            //! Traversing Through Vertices' Keys.
            for(String n : graph.get(rem.vert).keySet()) {
                if(!vis.contains(n)) {
                    TraversePair npair = new TraversePair(n, rem.path + n, rem.weight + graph.get(rem.vert).get(n));
                    q.add(npair);
                }
            }
        }
        return false;
    }

    public boolean dfs(String s, String d) {
        TraversePair pair = new TraversePair(s, s, 0);
        HashSet<String> vis = new HashSet<>();
        Stack<TraversePair> q = new Stack<>();
        q.push(pair);
        while(q.size() > 0) {
            TraversePair rem = q.pop();
            vis.add(rem.vert);
            System.out.println(rem.vert + " # " + rem.path);
            if(rem.vert.equals(d)) {
                return true;
            }
            //! Traversing Through Vertices' Keys.
            for(String n : graph.get(rem.vert).keySet()) {
                if(!vis.contains(n)) {
                    TraversePair npair = new TraversePair(n, rem.path + n, rem.weight + graph.get(rem.vert).get(n));
                    q.push(npair);
                }
            }
        }
        return false;
    }

    public int getConnectedComponents() {
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        for (String vertex : graph.keySet()) {
            if (visited.contains(vertex)) {
                continue;
            }
            TraversePair pair = new TraversePair(vertex, vertex, 0);
            String s = "";
            LinkedList<TraversePair> q = new LinkedList<>();
            q.addLast(pair);
            while (q.size() > 0) {
                TraversePair rem = q.removeFirst();
                if (visited.contains(rem.vert)) {
                    continue;
                }
                visited.add(rem.vert);
                s += rem.vert;
                for (String n : graph.get(rem.vert).keySet()) {
                    if (visited.contains(n) == false) {
                        TraversePair npair = new TraversePair(n, rem.path + n, rem.weight + graph.get(rem.vert).get(n));
                        q.addLast(npair);
                    }
                }
            }
            System.out.println(s);
            count += 1;
        }
        return count;
    }

    public boolean isCycle() {
        HashSet<String> visited = new HashSet<>();
        for (String vertex : graph.keySet()) {
            if(visited.contains(vertex)){
                continue;
            }
            TraversePair pair = new TraversePair(vertex, vertex, 0);

            LinkedList<TraversePair> q = new LinkedList<>();
            q.addLast(pair);
            while (q.size() > 0) {
                TraversePair rem = q.removeFirst();
                if (visited.contains(rem.vert)) {
                    return true;
                }
                visited.add(rem.vert);
                for (String n : graph.get(rem.vert).keySet()) {
                    if (visited.contains(n) == false) {
                        TraversePair npair = new TraversePair(n, rem.path + n, rem.weight + graph.get(rem.vert).get(n));
                        q.addLast(npair);
                    }
                }
            }
        }
        return false;
    }

    public Pair<String, Pair<String, Integer>> findMinimumEdge(String curr, Set<String> visited, String source, Integer cost) {

        if(visited.contains(curr)) {
            return new Pair<>(source, new Pair<>(curr, cost));
        }

        visited.add(curr);
        HashMap<String, Integer> childs = this.graph.get(curr);
        Pair<String, Pair<String, Integer>> result = new Pair<>("null", new Pair<>("null", Integer.MAX_VALUE));
        for(Map.Entry<String, Integer> singleChild : childs.entrySet()) {
            Pair<String, Pair<String, Integer>> currentMinimum =  findMinimumEdge(singleChild.getKey(), visited, curr, singleChild.getValue());
            if(currentMinimum.getSecond().getSecond() < result.getSecond().getSecond()) {
                result.setFirst(currentMinimum.getFirst());
                result.getSecond().setFirst(currentMinimum.getSecond().getFirst());
                result.getSecond().setSecond(currentMinimum.getSecond().getSecond());
            }
        }
        return result;
    }

    public int calculateCost(String curr, HashSet<String> visited, Integer cost) {

        if(visited.contains(curr))
            return 0;

        visited.add(curr);
        int sum = cost;

        HashMap<String, Integer> childs = graph.get(curr);

        for(Map.Entry<String, Integer> singleChild : childs.entrySet()) {
            sum+=calculateCost(singleChild.getKey(), visited, singleChild.getValue());
        }
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String vertices : graph.keySet()) {
            sb.append(vertices + "-" + graph.get(vertices) +"\n");
        }

        return sb.toString().trim();
    }

}

