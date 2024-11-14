import java.util.*;

public class Q1 {

    static final int MAXN = 200005;
    static final int LOG = 20;
    static final int MOD = 1000000007;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] adj = new ArrayList[MAXN];
    static int[][] parent = new int[MAXN][LOG];
    static int[][] maxEdge = new int[MAXN][LOG];
    static int[] depth = new int[MAXN];
    static int N;

    static void dfs(int node, int par, int w) {
        parent[node][0] = par;
        maxEdge[node][0] = w;
        for (Edge e : adj[node]) {
            if (e.to != par) {
                depth[e.to] = depth[node] + 1;
                dfs(e.to, node, e.weight);
            }
        }
    }

    static void preprocess() {
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= N; i++) {
                if (parent[i][j - 1] != -1) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                    maxEdge[i][j] = Math.max(maxEdge[i][j - 1], maxEdge[parent[i][j - 1]][j - 1]);
                }
            }
        }
    }

    static int getMaxEdge(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int maxW = 0;
        int diff = depth[u] - depth[v];

        for (int i = LOG - 1; i >= 0; i--) {
            if ((diff & (1 << i)) != 0) {
                maxW = Math.max(maxW, maxEdge[u][i]);
                u = parent[u][i];
            }
        }

        if (u == v)
            return maxW;

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                maxW = Math.max(maxW, Math.max(maxEdge[u][i], maxEdge[v][i]));
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return Math.max(maxW, Math.max(maxEdge[u][0], maxEdge[v][0]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        dfs(1, -1, 0);
        preprocess();

        long E = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int maxW = getMaxEdge(i, j);
                E = (E + 1L * maxW * i * j) % MOD;
            }
        }

        System.out.println(E);
    }
}
