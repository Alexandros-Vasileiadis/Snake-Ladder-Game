# SnakeAndLadder

SnakeAndLadder is a Java program designed to simulate a Snakes and Ladders game board and find the minimum number of dice throws required to reach the end point. It utilizes graph representation and BFS (Breadth-First Search) algorithm to explore the game board and find the shortest path to the end position.

## How to Use

To run the program, follow these steps:

1. Compile the Java files.
   ```bash
   javac SnakeAndLadder/*.java
   ```

2. Run the `SnakeAndLadders` class.
   ```bash
   java SnakeAndLadder.SnakeAndLadders
   ```

3. The program will display the graph representation of the Snakes and Ladders game board and print the minimum number of dice throws required to reach the end position.

## File Description

- `Graph.java`: Represents a graph object, which simulates the Snakes and Ladders game board. It constructs the graph using a list of edges and provides methods to visualize the graph.
- `Node.java`: Represents a node in the graph, containing information about the destination position, distance from the source, dice value, and path.
- `SnakeAndLadders.java`: Contains the main method responsible for running the Snakes and Ladders game simulation. It initializes the game board, defines the positions of snakes and ladders, and calculates the minimum number of dice throws using BFS algorithm.

## How the Code Works

The program first initializes the Snakes and Ladders game board using a graph representation. It defines the positions of snakes and ladders as edges in the graph. Then, it applies BFS algorithm to find the minimum number of dice throws required to reach the end position.

The BFS algorithm explores all possible moves from the starting position, marking visited positions and calculating distances. It continues until the end position is reached or all possible moves are exhausted. Finally, the program prints the shortest path from the source to the destination, demonstrating the dice throws made and the resulting distances.

If the end position cannot be reached, the program returns -1, indicating the absence of a feasible path.