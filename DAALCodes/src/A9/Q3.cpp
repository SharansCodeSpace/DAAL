#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int minimumTimeForHandshakes(int N, vector<vector<int>> &preferences)
{
    vector<vector<int>> adj(N + 1);
    vector<int> indegree(N + 1, 0);

    // Build the adjacency list and calculate indegrees
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < preferences[i].size() - 1; j++)
        {
            int u = preferences[i][j];
            int v = preferences[i][j + 1];
            adj[u].push_back(v);
            indegree[v]++;
        }
    }

    queue<int> q;
    vector<int> topological_order;
    vector<int> level(N + 1, 0);

    // Initialize the queue with nodes having zero indegree
    for (int i = 1; i <= N; i++)
    {
        if (indegree[i] == 0)
        {
            q.push(i);
            level[i] = 1;
        }
    }

    // Perform topological sort and calculate levels
    while (!q.empty())
    {
        int u = q.front();
        q.pop();
        topological_order.push_back(u);

        for (int v : adj[u])
        {
            indegree[v]--;
            if (indegree[v] == 0)
            {
                q.push(v);
                level[v] = level[u] + 1;
            }
        }
    }

    // Check for cycles (inconsistent data)
    if (topological_order.size() != N)
    {
        return 0; // Return 0 for inconsistent data
    }

    // Find the maximum level
    int max_level = 0;
    for (int i = 1; i <= N; i++)
    {
        max_level = max(max_level, level[i]);
    }

    return max_level * 3; // Each level takes 3 seconds
}

int main()
{
    int N;
    cout << "Enter the number of guests: ";
    cin >> N;

    vector<vector<int>> preferences(N);

    cout << "Enter the handshake sequence for each guest (0 to terminate input for a guest):\n";
    for (int i = 0; i < N; i++)
    {
        while (true)
        {
            int guest;
            cin >> guest;
            if (guest == 0)
                break; // 0 indicates the end of input for this guest
            preferences[i].push_back(guest);
        }
    }

    int result = minimumTimeForHandshakes(N, preferences);

    if (result == 0)
    {
        cout << "Inconsistent handshake data\n";
    }
    else
    {
        cout << "Minimum time required: " << result << " seconds\n";
    }

    return 0;
}
