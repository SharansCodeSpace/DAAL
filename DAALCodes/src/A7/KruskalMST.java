import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {
    static class Edge {
        char src, dest;
        int weight;
    
        Edge(char src, char dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int findParent(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = findParent(parent, parent[i]);
    }

    static void unionSets(int[] parent, int[] rank, int x, int y) {
        int xroot = findParent(parent, x);
        int yroot = findParent(parent, y);

        if (rank[xroot] < rank[yroot])
            parent[xroot] = yroot;
        else if (rank[xroot] > rank[yroot])
            parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    static void kruskalMST(List<Edge> edges, int V) {
        List<Edge> result = new ArrayList<>();
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int v = 0; v < V; ++v) {
            parent[v] = v;
            rank[v] = 0;
        }

        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        for (Edge edge : edges) {
            int x = findParent(parent, edge.src - 'A');
            int y = findParent(parent, edge.dest - 'A');

            if (x != y) {
                result.add(edge);
                unionSets(parent, rank, x, y);
            }

            if (result.size() == V - 1) break;
        }

        System.out.println("Kruskal's MST:");
        for (Edge edge : result) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge('A', 'B', 15));
        edges.add(new Edge('A', 'C', 10));
        edges.add(new Edge('B', 'D', 7));
        edges.add(new Edge('B', 'E', 17));
        edges.add(new Edge('C', 'D', 19));
        edges.add(new Edge('C', 'F', 16));
        edges.add(new Edge('D', 'E', 12));
        edges.add(new Edge('D', 'F', 6));
        edges.add(new Edge('E', 'G', 20));
        edges.add(new Edge('F', 'G', 9));
        edges.add(new Edge('G', 'H', 4));
        edges.add(new Edge('G', 'I', 1));
        edges.add(new Edge('G', 'J', 11));
        edges.add(new Edge('H', 'J', 2));
        edges.add(new Edge('I', 'J', 18));
        edges.add(new Edge('F', 'I', 5));

        int V = 10;

        kruskalMST(edges, V);
    }
}
