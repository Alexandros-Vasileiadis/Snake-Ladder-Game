package SnakeAndLadder;

import java.util.*;

public class SnakeAndLadders {

    /**
     * This function finds the minimum number of dice throws required to reach the end point in a Snakes and Ladders game.
     * This method employs Breadth-First Search (BFS) on the graph representation of the game board.
     *
     * @param adjList The adjacency list representing the Snakes and Ladders game board graph.
     *                It encapsulates the potential moves from each position on the board.
     * @param n       The total number of positions on the game board.
     *                In the context of the Snakes and Ladders game, 'n' signifies the maximum board position.
     * @return The minimum number of dice throws needed to reach the end position on the game board.
     *         If reaching the end position is not feasible, the method returns -1.
     *
     * This method starts from the initial position (node 0) and explores all possible moves through the board positions
     * utilizing BFS. It marks each visited position, simulating dice rolls by exploring potential moves from each position.
     * Once the end position 'n' is reached, the method prints the shortest path from the source to the destination,
     * demonstrating the dice throws made and the resulting distances.
     *
     * If the end position cannot be reached, the method returns -1, indicating the absence of a feasible path.
     */
    static int getMinDiceThrows(List<List<Integer>> adjList, int n) {
        // Boolean array to track visited nodes
        boolean[] visited = new boolean[n+1];
        // Queue to perform BFS
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0,"Game-->"));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.dest == n) {
                System.out.println("The shortest path from source to destination is: "
                        + (node.path += "["+node.dest+"|"+node.dist+"]"));
                return node.dist;
            }
            int dice_num = 0;
            for (int adjacent : adjList.get(node.dest)) {
                node.dice = ++dice_num;
                if(visited[adjacent]) continue;
                visited[adjacent] = true;
                q.add(new Node(adjacent, node.dist + 1, 0, node.path + node));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Node> edges = new ArrayList<>();
        int boardSize = 100;
        for (int i = 0; i <= boardSize; i++)
            edges.add(new Node(i));

        // Snakes
        edges.get(17).dest = 7;
        edges.get(54).dest = 34;
        edges.get(62).dest = 19;
        edges.get(64).dest = 60;
        edges.get(87).dest = 24;
        edges.get(93).dest = 73;
        edges.get(95).dest = 75;
        edges.get(98).dest = 79;

        // Ladders
        edges.get(1).dest = 38;
        edges.get(4).dest = 14;
        edges.get(9).dest = 31;
        edges.get(21).dest = 42;
        edges.get(28).dest = 84;
        edges.get(51).dest = 67;
        edges.get(72).dest = 91;
        edges.get(80).dest = 99;

        Graph graph = new Graph(edges, boardSize);
        System.out.println(graph);
        int min_dist = getMinDiceThrows(graph.adjList, boardSize);
        System.out.println("\nMin Dice throws required is " + min_dist);

    }
}
