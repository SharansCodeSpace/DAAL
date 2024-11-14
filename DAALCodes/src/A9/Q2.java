import java.util.*;

public class Q2 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // Graph representation using adjacency list
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = Math.max(u, v);
            graph[u].add(new int[]{v, weight});
            graph[v].add(new int[]{u, weight});
        }
        
        // Prime detection
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Multi-source Dijkstra's algorithm
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for (int i = 1; i <= N; i++) {
            if (isPrime[i]) {
                dist[i] = 0;
                pq.offer(new int[]{i, 0});
            }
        }
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int d = node[1];
            
            if (d > dist[u]) continue;
            
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];
                int newDist = d + weight;
                
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }
            }
        }
        
        // Output results
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == INF) {
                sb.append("-1 ");
            } else {
                sb.append(dist[i]).append(" ");
            }
        }
        System.out.println(sb.toString().trim());

        sc.close();
    }
}