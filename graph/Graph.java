/*
* Copyright (c) 2022 gaurav-kjain

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
* */

package graph;
// @author: Gaurav Kumar Jain (gaurav.kjain@gmail.com)
// This implements Graph data structure using HashMap with adjacency list implementation
// Vertex to be added are 0 indexed with [0, n-1] indexed vertex, where n is total nodes in a graph.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    HashMap<Integer, List<Integer>> graph;
    int totalNodes;

    public Graph(int totalNodes) {
        this.graph = new HashMap<>();
        this.totalNodes = totalNodes;
        //initialize all arraylist, with no adjacent nodes
        for (int nodeID = 0; nodeID < totalNodes; nodeID++) {
            this.graph.put(nodeID, new ArrayList<>());
        }
    }

    /**
     * Add edge  [from --> to], if undirected extra edge [to--> from] will be added
     * from and to limits are between 0 to n-1 inclusive, anything violating limits
     * will not be added ,and it will return false
     * @param from : from node ID
     * @param to   : to node ID
     * @param isUndirected : true if edge is undirected, false if directed
     * @return : true if edge is successfully added to graph, false otherwise
     */
    public boolean addEdge(int from, int to, boolean isUndirected){
        if(isNotValidNode(from) || isNotValidNode(to)){
            return false;
        }
        //both nodes are valid, edge can be added to graph
        //guaranteed to have valid Adjacency list within graph
        graph.get(from).add(to);
        if(isUndirected){
            graph.get(to).add(from);
        }
        return true;
    }
    private boolean isNotValidNode(int nodeID){
        return (nodeID <= 0 || nodeID >= totalNodes);
    }

}
