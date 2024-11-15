import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5 {

    public static class Edge implements Comparable<Edge> {
        int weight;
        Node node1;
        Node node2;

        public Edge(int weight, Node node1, Node node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static class Node {
        int number;

        public Node(int number) {
            this.number = number;
        }
    }



    public static void main(String[] args) {
        Node[] nodes = new Node[]{
            new Node(0),
            new Node(1),
            new Node(2),
            new Node(3),
            new Node(4),
            new Node(5),
            new Node(6),
            new Node(7),
            new Node(8),
            new Node(9),
            new Node(10),
            new Node(11),
        };

        List<Edge> graph = new ArrayList<>();
        graph.add(new Edge(1, nodes[0], nodes[1]));
        graph.add(new Edge(6, nodes[0], nodes[2]));
        graph.add(new Edge(8, nodes[1], nodes[2]));
        graph.add(new Edge(14, nodes[2], nodes[3]));
        graph.add(new Edge(1, nodes[0], nodes[4]));
        graph.add(new Edge(2, nodes[0], nodes[5]));
        graph.add(new Edge(3, nodes[2], nodes[5]));
        graph.add(new Edge(1, nodes[3], nodes[6]));
        graph.add(new Edge(1, nodes[3], nodes[7]));
        graph.add(new Edge(20, nodes[5], nodes[6]));
        graph.add(new Edge(4, nodes[6], nodes[7]));
        graph.add(new Edge(7, nodes[4], nodes[8]));
        graph.add(new Edge(3, nodes[5], nodes[8]));
        graph.add(new Edge(5, nodes[5], nodes[9]));
        graph.add(new Edge(8, nodes[5], nodes[10]));
        graph.add(new Edge(8, nodes[6], nodes[11]));
        graph.add(new Edge(3, nodes[7], nodes[11]));
        graph.add(new Edge(4, nodes[8], nodes[9]));
        graph.add(new Edge(2, nodes[9], nodes[10]));
        graph.add(new Edge(5, nodes[10], nodes[11]));
    }

    public static List<Edge> sortEdgesByWeight(List<Edge> graph) {
        Collections.sort(graph);
        return graph;
    }


}
