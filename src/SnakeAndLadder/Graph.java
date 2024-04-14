package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

//A class to represent a graph object
public class Graph {
	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	/**
	 * This function constructs a graph, which represents a Snakes and Ladders game board.
	 * The edges of the graph simulate the possible moves based on dice rolls.
	 *
	 * @param edges The list of edges represented as nodes. Each node in the edges list represents a possible move on the board.
	 *              The index of the node in the list corresponds to the position on the board where the move originates.
	 *              Each node contains the destination position to which the move leads.
	 * @param n     The number of vertices in the graph representing the board positions.
	 *              In the context of a Snakes and Ladders game, 'n' signifies the total number of positions on the board.
	 *              This parameter determines the size of the game board.
	 */
	Graph(List<Node> edges, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int i = 0; i < n; i++) {

			// add edges to the undirected graph
			for(int j = i + 1; j < i + 7 && j < edges.size(); j++) {
				int dest = edges.get(j).dest;
				adjList.get(i).add(dest);
			}
			// diff between the end of the board and the current position
			int diff = n - i;

			// if the difference is less than 6, we need to add the remaining elements
			if (diff < 6)  {
				// continues until the required number of elements for the remaining edge is added
				for (int k = n; k > n - (6 - diff); k--)
					adjList.get(i).add(edges.get(k-1).dest); // 'k - 1', so we do not write again the end of the board
															 // could be just 'k' if in prev 'for' we did not include the last element
			}
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		int j = 0;
		for (List l : adjList) {
			if (!l.isEmpty()) s.append("[").append(j).append("]");
			for (Object i : l)
				s.append("->").append(i);
			if (!l.isEmpty()) s.append("\n");
			j++;
		}
		return s.toString();
	}

}
