import java.util.Arrays;

public class AllPairsShortestPath {
    final static int INF = 99999, V = 4; // INF represents infinity

    // A function to print the solution matrix
    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    // All-pairs shortest path algorithm (Floyd-Warshall)
    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];

        // Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // Update the solution matrix with shortest paths
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest path matrix
        printSolution(dist);
    }

    public static void main(String[] args) {
        /* Input graph represented as adjacency matrix.
           INF means there is no edge between those vertices */
        int graph[][] = { 
            { 0, 3, INF, 5 }, 
            { 2, 0, INF, 4 }, 
            { INF, 1, 0, INF }, 
            { INF, INF, 2, 0 }
        };

        AllPairsShortestPath a = new AllPairsShortestPath();

        // Run Floyd-Warshall algorithm
        a.floydWarshall(graph);
    }
}
