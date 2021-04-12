package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Client {
    public static void main(String[] args) {
//        Graph g = new Graph();
//        g.addVertex("A");
//        g.addVertex("B");
//        g.addVertex("C");
//        g.addVertex("D");
//        g.addVertex("E");
//        g.addVertex("F");
//        g.addVertex("G");
//
//        g.addEdge("A", "B", 28);
//        g.addEdge("B", "A", 28);
//        g.addEdge("B", "C", 16);
//        g.addEdge("C", "B", 16);
//        g.addEdge("C", "D", 12);
//        g.addEdge("D", "C", 12);
//        g.addEdge("D", "E", 22);
//        g.addEdge("E", "D", 22);
//        g.addEdge("E", "F", 25);
//        g.addEdge("F", "E", 25);
//        g.addEdge("F", "A", 10);
//        g.addEdge("A", "F", 10);
//        g.addEdge("B", "G", 14);
//        g.addEdge("G", "B", 14);
//        g.addEdge("D", "G", 18);
//        g.addEdge("G", "D", 18);
//        g.addEdge("G", "E", 24);
//        g.addEdge("E", "G", 24);
//
//        System.out.println(g);
//
//        Graph graph = GraphUtil.prismMst(g, "A");
//        System.out.println(graph.calculateCost("A", new HashSet<>(), 0));
        //    g.removeEdge("D", "E");
        //    g.removeVertex("D");
        //    System.out.println(g.countEdges());
        //    System.out.println(g.countVertices());
        // System.out.println(g.hasPath("A", "G"));
        //   g.printHasPath("A","G");
        //   g.printSmallestPW("A","G");
        // g.bfs("A", "G");
        // System.out.println("`````````````````````````````");
        // g.dfs("A", "G");
        // g.gcc();
        // System.out.println(g.isCyclic());

        Integer[][] graph = new Integer[6][6];
        graph[0][1] = 2;
        graph[0][2] = 3;
        graph[1][3] = 5;
        graph[3][5] = 2;
        graph[2][3] = 1;
        graph[2][4] = 3;
        graph[4][5] = 7;
        Integer[][] res = Edge.kruskal(graph);
        for(int u = 0 ; u < graph.length ; u++) {
            for (int v = 0 ; v < graph.length ; v++) {
                System.out.print(res[u][v] != null ? res[u][v] + " " : "# ");
            }
            System.out.println();
        }
    }

    private static class Edge implements Comparable<Edge>{
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        public static class DSNode {
            int vertex;
            DSNode parent;
            int rank;

            public DSNode(int vertex) {
                this.vertex = vertex;
                this.rank = 0;
                this.parent = this;
            }
        }

        public static Integer[][] kruskal(Integer[][] graph) {
            HashMap<Integer, DSNode> disjointSet = new HashMap<>();
            Integer[][] mst = new Integer[graph.length][graph.length];
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            for(int u = 0 ; u < graph.length ; u++) {
                disjointSet.put(u, new DSNode(u));
                for(int v = 0 ; v < graph.length ; v++) {
                    if(graph[u][v] != null) {
                        pq.add(new Edge(u, v, graph[u][v]));
                    }
                }
            }

            while(pq.size() > 0) {
                Edge current = pq.remove();
                DSNode uLeader = find(disjointSet.get(current.u));
                DSNode vLeader = find(disjointSet.get(current.v));
                //! Check whether it forms cycle or not
                if(uLeader != vLeader) {
                    mst[current.u][current.v] = current.weight;
                    merge(uLeader, vLeader);
                }
            }

            return mst;
        }

        private static void merge (DSNode u, DSNode v) {
            if(u.rank < v.rank) {
                u.parent = v.parent;
            } else if(u.rank > v.rank){
                v.parent = u.parent;
            } else {
                u.parent = v.parent;
                v.rank += 1;
            }
        }

        private static DSNode find (DSNode v) {
            if(v.parent == v) {
                return v;
            } else {
                DSNode p = find(v.parent);
                v.parent = p;
                return p;
            }
        }
    }
}
