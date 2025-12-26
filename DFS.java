import java.util.*;

public class DFS
{
    private static final int MAX_NODES = 100;
    private static int[][] adjMatrix = new int[MAX_NODES][MAX_NODES];

    // Adds edge (Considering Directed Graph)
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

    // Iterative DFS using stack (Java-optimized)
    private static void dfs(int startNode, int nodes)
    {
        boolean[] visited = new boolean[nodes];
        Deque<Integer> stack = new ArrayDeque<>();

        visited[startNode] = true;
        stack.push(startNode);

        System.out.print("DFS Traversal starting from node " + (startNode + 1) + ": ");

        while (!stack.isEmpty())
        {
            int current = stack.pop();
            System.out.print((current + 1) + " ");

            for (int i = 0; i < nodes; i++)
            {
                if (adjMatrix[current][i] == 1 && !visited[i])
                {
                    visited[i] = true;
                    stack.push(i);
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

        System.out.print("\nEnter the starting node for DFS traversal: ");
        int startNode = sc.nextInt();

        dfs(startNode - 1, nodes);

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
Enter the starting node for DFS traversal: 1

Sample Output
-------------
Adjacency Matrix:
  0   1   1   1   0
 -1   0   0   0   0
 -1   0   0   1   1
 -1   0  -1   0   0
  0   0  -1   0   0

DFS Traversal starting from node 1: 1 4 3 5 2
*/

/****************************************************************************************************************/

/*
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class GfG
{
    // Non-recursive DFS using stack (connected graph)
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj)
    {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // Start DFS from vertex 0
        stack.push(0);

        while (!stack.isEmpty())
        {
            int current = stack.pop();

            if (!visited[current])
            {
                visited[current] = true;
                result.add(current);

                // Push neighbours in reverse order
                // to match recursive DFS order
                for (int i = adj.get(current).size() - 1; i >= 0; i--)
                {
                    int neighbour = adj.get(current).get(i);
                    if (!visited[neighbour])
                    {
                        stack.push(neighbour);
                    }
                }
            }
        }
        return result;
    }

    // Add undirected edge
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }

        ArrayList<Integer> res = dfs(adj);

        System.out.println("\nDFS Traversal:");
        for (int x : res)
            System.out.print(x + " ");

        sc.close();
    }
}
*/

/*
Sample Input
------------
Enter number of vertices: 5
Enter number of edges: 5
Enter edges (u v):
1 2
1 0
2 0
2 3
2 4

Sample Output
-------------
DFS Traversal:
0 1 2 3 4
*/
