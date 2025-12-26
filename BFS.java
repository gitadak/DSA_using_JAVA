import java.util.*;

public class BFS
{
    private static final int MAX_NODES = 100;
    private static int[][] adjMatrix = new int[MAX_NODES][MAX_NODES];

    // Adds edge (Considering Directed Graph)
    // 1 → forward direction, -1 → reverse direction
    private static void addEdge(int u, int v)
    {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = -1;
    }

    // Displays adjacency matrix
    private static void displayMatrix(int nodes)
    {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < nodes; i++)
        {
            for (int j = 0; j < nodes; j++)
            {
                System.out.printf("%3d ", adjMatrix[i][j]);
            }
            System.out.println();
        }
    }

    // BFS traversal using Java Queue
    private static void bfs(int startNode, int nodes)
    {
        boolean[] visited = new boolean[nodes];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[startNode] = true;
        queue.offer(startNode);

        System.out.print("BFS Traversal starting from node " + (startNode + 1) + ": ");

        while (!queue.isEmpty())
        {
            int current = queue.poll();
            System.out.print((current + 1) + " ");

            for (int i = 0; i < nodes; i++)
            {
                if (adjMatrix[current][i] == 1 && !visited[i])
                {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes in the graph: ");
        int nodes = sc.nextInt();

        System.out.print("Enter number of edges in the graph: ");
        int edges = sc.nextInt();

        System.out.println("Enter the edges (format: from_node to_node) (node value starts from 1):");
        for (int i = 0; i < edges; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(u - 1, v - 1);
        }

        displayMatrix(nodes);

        System.out.print("Enter the starting node for BFS traversal: ");
        int startNode = sc.nextInt();

        bfs(startNode - 1, nodes);

        sc.close();
    }
}


/*
Sample Input
------------
Enter number of nodes in the graph: 5
Enter number of edges in the graph: 5
Enter the edges (format: from_node to_node) (node value starts from 1):
1 2
1 3
1 4
3 4
3 5
Enter the starting node for BFS traversal: 1

Sample Output
-------------
Adjacency Matrix:
  0   1   1   1   0
 -1   0   0   0   0
 -1   0   0   1   1
 -1   0  -1   0   0
  0   0  -1   0   0
BFS Traversal starting from node 1: 1 2 3 4 5
*/
