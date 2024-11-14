import java.util.*;

public class PrimMST {
    static class Edge {
        int weight;
        char dest;
    
        Edge(int weight, char dest) {
            this.weight = weight;
            this.dest = dest;
        }
    }

    public static void primMST(List<List<Edge>> graph, int V, char start) {
        int[] key = new int[V];
        char[] parent = new char[V];
        boolean[] inMST = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, '-');
        Arrays.fill(inMST, false);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        int startIdx = start - 'A';
        pq.add(new Edge(0, start));
        key[startIdx] = 0;

        while (!pq.isEmpty()) {
            char u = pq.poll().dest;
            int uIdx = u - 'A';
            inMST[uIdx] = true;

            for (Edge edge : graph.get(uIdx)) {
                char v = edge.dest;
                int weight = edge.weight;
                int vIdx = v - 'A';

                if (!inMST[vIdx] && key[vIdx] > weight) {
                    key[vIdx] = weight;
                    pq.add(new Edge(key[vIdx], v));
                    parent[vIdx] = u;
                }
            }
        }

        System.out.println("Prim's MST:");
        for (int i = 1; i < V; ++i) {
            System.out.println(parent[i] + " -- " + (char) ('A' + i) + " == " + key[i]);
        }
    }

    public static void main(String[] args) {
        int V = 10;

        List<List<Edge>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(15, 'B'));
        graph.get(0).add(new Edge(10, 'C'));
        graph.get(1).add(new Edge(15, 'A'));
        graph.get(1).add(new Edge(7, 'D'));
        graph.get(1).add(new Edge(17, 'E'));
        graph.get(2).add(new Edge(10, 'A'));
        graph.get(2).add(new Edge(19, 'D'));
        graph.get(2).add(new Edge(16, 'F'));
        graph.get(3).add(new Edge(7, 'B'));
        graph.get(3).add(new Edge(19, 'C'));
        graph.get(3).add(new Edge(12, 'E'));
        graph.get(3).add(new Edge(6, 'F'));
        graph.get(4).add(new Edge(17, 'B'));
        graph.get(4).add(new Edge(12, 'D'));
        graph.get(4).add(new Edge(20, 'G'));
        graph.get(5).add(new Edge(16, 'C'));
        graph.get(5).add(new Edge(6, 'D'));
        graph.get(5).add(new Edge(9, 'G'));
        graph.get(5).add(new Edge(5, 'I'));
        graph.get(6).add(new Edge(20, 'E'));
        graph.get(6).add(new Edge(9, 'F'));
        graph.get(6).add(new Edge(4, 'H'));
        graph.get(6).add(new Edge(1, 'I'));
        graph.get(6).add(new Edge(11, 'J'));
        graph.get(7).add(new Edge(4, 'G'));
        graph.get(7).add(new Edge(2, 'J'));
        graph.get(8).add(new Edge(1, 'G'));
        graph.get(8).add(new Edge(5, 'F'));
        graph.get(8).add(new Edge(18, 'J'));
        graph.get(9).add(new Edge(11, 'G'));
        graph.get(9).add(new Edge(2, 'H'));
        graph.get(9).add(new Edge(18, 'I'));

        primMST(graph, V, 'A');
    }
}
