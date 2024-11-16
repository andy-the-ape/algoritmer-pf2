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

    public static class Subset {
        int parent;
        int rank;
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

        int V = graph.size()-1;

        kruskalsAlgorithm(V, graph);
    }

    public static List<Edge> sortEdgesByWeight(List<Edge> graph) {
        Collections.sort(graph);
        return graph;
    }

    //Find the root of a subset
    public static int find(Subset[] subsets, int node) {
        if (subsets[node].parent != node) {
            subsets[node].parent = find(subsets, subsets[node].parent);
        }
        return subsets[node].parent;
    }

    //Union two subsets by rank
    public static void union(Subset[] subsets, int root1, int root2) {
        if (subsets[root1].rank > subsets[root2].rank) {
            subsets[root2].parent = root1;
        } else if (subsets[root1].rank < subsets[root2].rank) {
            subsets[root1].parent = root2;
        } else {
            subsets[root2].parent = root1;
            subsets[root1].rank++;
        }
    }

    public static void kruskalsAlgorithm(int V, List<Edge> graph) {
        List<Edge> sortedEdgesByWeight = sortEdgesByWeight(graph);
        List<Edge> mstEdges = new ArrayList<>();
        Subset[] subsets = new Subset[V];

        //We initialize the subsets array
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i; //Each node is its own parent initially
            subsets[i].rank = 0;   //All ranks start at 0
        }

        //Now we go through the edges in sorted order
        for (Edge edge : sortedEdgesByWeight) {
            int root1 = find(subsets, edge.node1.number);
            int root2 = find(subsets, edge.node2.number);

            //We check if this creates a cycle
            if (root1 != root2) {
                mstEdges.add(edge);
                union(subsets, root1, root2);
            }

            //If we have added enough edges to form the MST then we stop
            if (mstEdges.size() == V - 1) {
                break;
            }
        }

        //Finally we print the MST
        System.out.println("Edges in the MST:");
        int totalWeight = 0;
        for (Edge edge : mstEdges) {
            System.out.println(edge.node1.number + " - " + edge.node2.number + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of the MST: " + totalWeight);
    }


}
