package SnakeAndLadder;

public class Node {

    // (x, y) represents matrix cell coordinates, and
    // `dist` represents their minimum distance from the source
    int dest, dist, dice;
    // 'path' stores the complete path from the source to the destination
    String path;

    Node(int dest ,int dist, int dice, String path)
    {
        this.dest = dest;
        this.dist = dist;
        this.dice = dice;
        this.path = path;
    }

    Node(int dest)
    {
        this.dest = dest;
    }
    
    public String toString() {
    	return "["+dest+"|"+dist+"]{"+dice+"}->";
    }

}
