/**
 * Created by Kenan McCracken on 2/1/2018.
 */
import java.io.*;
import java.util.*;
public class TopologicalSort {
    //Adjacency list representation of a directed graph
    //See the class discussion for the details of the representation.
    private VertexNode vertices; //head of the list of vertex nodes
    private int numVertices;

    private class VertexNode {
        private String name;
        private VertexNode nextV;
        private EdgeNode edges;
        private int indegree;

        private VertexNode(String n, VertexNode v) {
            name = n;
            nextV = v;
            edges = null;
            indegree = 0;
        }
    }

    private class EdgeNode {
        private VertexNode vertex1;
        private VertexNode vertex2;
        private EdgeNode nextE;
        private EdgeNode(VertexNode v1, VertexNode v2,EdgeNode e) {
            vertex1 = v1;
            vertex2 = v2;
            nextE = e;
        }
    }

    public TopologicalSort(){
        vertices = null;
        numVertices = 0;
    }

    public void addVertex(String s) {
        //PRE: the vertex list is sorted in ascending order using the name as the key
        //POST: a vertex with name s has been add to the vertex list and the vertex
        // list is sorted in ascending order using the name as the key
        if(this.vertices == null){
            this.vertices = new VertexNode(s, null);
        }
        else {
            VertexNode temp = new VertexNode(null, this.vertices);
            while(temp.nextV != null){
                temp = temp.nextV;
            }
            temp.nextV = new VertexNode(s,null);
        }
        this.numVertices++;
    }

    public void addEdge(String n1, String n2) {
        //PRE: the vertices n1 and n2 have already been added
        //POST:the new edge (n1, n2) has been added to the n1 edge list
        if(findNode(n1).edges == null){
            findNode(n1).edges = new EdgeNode(findNode(n1),findNode(n2),null);
            findNode(n2).indegree++;
        }
        else{
            EdgeNode temp = new EdgeNode(null,null,findNode(n1).edges);
            while(temp.nextE != null){
                temp = temp.nextE;
            }
            temp.nextE = new EdgeNode(findNode(n1),findNode(n2),null);
            findNode(n2).indegree++;
        }
    }

    public String topoSort() {
        //if the graph contains a cycle return null
        //otherwise return a string containing the names of vertices separated by
        //blanks in a topological order.
        String topoOrder = "";
        VertexNode temp = this.vertices;
            while (temp != null) {
                while (temp.indegree == 0) {
                    topoOrder += temp.name + " ";
                    decrementInDegree(temp);
                    temp = this.vertices;
                }
                temp = temp.nextV;
            }
        if(topoOrder.split(" ").length != this.numVertices){
            return "No topological ordering exists for the graph";
        }
        else {
            return topoOrder;
        }
    }

    /*
        Decrements the degree of the nodes that have an edge from the @param temp Node
        and sets the indegree of the @param temp Node to -1
     */
    private void decrementInDegree(VertexNode temp){
        temp.indegree = -1;
        EdgeNode decrement = new EdgeNode(null,null,temp.edges);
        while(decrement.nextE != null){
            if(decrement.nextE.vertex2.indegree <= 0){
                decrement = decrement.nextE;
                continue;
            }
            decrement.nextE.vertex2.indegree--;
            decrement = decrement.nextE;
        }
    }

    /*
        Finds a VertexNode with the String argument as its name
     */
    private VertexNode findNode(String nodeName){
        VertexNode tempNode = new VertexNode(null, this.vertices);
        while(tempNode.nextV != null){
            if(tempNode.nextV.name.equals(nodeName)){
                break;
            }
            tempNode = tempNode.nextV;
        }
        return tempNode.nextV;
    }

    public static void main(String args[]) throws IOException{
        //see problem statement
        TopologicalSort graph = new TopologicalSort();
        Scanner scan = new Scanner(new File("data"));

        String[] input = scan.nextLine().split(" ");

        for(int x = 0; x < input.length; x++){
            graph.addVertex(input[x]);
        }
        while (scan.hasNextLine()) {
            graph.addEdge(scan.next(), scan.next());
        }

        String finalAnswer = graph.topoSort();
        System.out.println(finalAnswer);
    }
}
