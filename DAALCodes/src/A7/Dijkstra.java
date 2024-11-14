import java.util.*;

public class Dijkstra {
    static class Edge {
        int weight;
        int vertex;

        Edge(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int V, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Edge(0, start));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            for (Edge edge : graph.get(u)) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Edge(dist[v], v));
                }
            }
        }

        System.out.printf("%-10s%-20s%n", "Vertex", "Distance from Start Vertex");
        for (int i = 0; i < V; i++) {
            System.out.printf("%-10c%-20d%n", (char) ('A' + i), dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6;

        List<List<Edge>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 1)); // A -> B (weight 1)
        graph.get(0).add(new Edge(2, 2)); // A -> C (weight 2)
        graph.get(1).add(new Edge(1, 0)); // B -> A (weight 1)
        graph.get(1).add(new Edge(3, 3)); // B -> D (weight 3)
        graph.get(1).add(new Edge(2, 2)); // B -> C (weight 2)
        graph.get(2).add(new Edge(2, 0)); // C -> A (weight 2)
        graph.get(2).add(new Edge(4, 4)); // C -> E (weight 4)
        graph.get(2).add(new Edge(1, 1)); // C -> B (weight 1)
        graph.get(3).add(new Edge(1, 4)); // D -> E (weight 1)
        graph.get(3).add(new Edge(5, 5)); // D -> F (weight 5)
        graph.get(4).add(new Edge(2, 2)); // E -> C (weight 2)
        graph.get(4).add(new Edge(3, 3)); // E -> B (weight 3)
        graph.get(4).add(new Edge(5, 5)); // E -> F (weight 5)
        graph.get(5).add(new Edge(4, 3)); // F -> E (weight 4)
        graph.get(5).add(new Edge(5, 4)); // F -> D (weight 5)

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting vertex (A-F): ");
        char startVertex = scanner.next().charAt(0);
        dijkstra(graph, V, startVertex - 'A');
        scanner.close();
    }
}
