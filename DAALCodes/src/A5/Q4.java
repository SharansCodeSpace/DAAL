// Link - https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/practice-problems/algorithm/transportation-network-a3bc571b/

import java.util.*;

class UnionFind {
    private int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find function with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void unionSets(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

public class Q4 {

    public static String checkBalance(int n, UnionFind railwayUnion, UnionFind roadUnion) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (railwayUnion.connected(i, j) != roadUnion.connected(i, j)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        UnionFind railwayUnion = new UnionFind(n);
        UnionFind roadUnion = new UnionFind(n);

        List<String> results = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            if (t == 1) {
                railwayUnion.unionSets(u, v); // Railway union
            } else if (t == 2) {
                roadUnion.unionSets(u, v);    // Road union
            }

            results.add(checkBalance(n, railwayUnion, roadUnion));
        }

        for (String result : results) {
            System.out.println(result);
        }

        sc.close();
    }
}
