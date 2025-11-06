class Vertex {
    int vertexId;
    boolean offline = false;
    int powerGridId = -1;
    public Vertex(int vertex){
        this.vertexId = vertex;
    }
}

class Graph {
    HashMap<Integer, List<Integer>> adj;
    HashMap<Integer, Vertex> vertices;

    public Graph(){
        adj = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(int v){
        vertices.put(v, new Vertex(v));
        adj.put(v, new ArrayList<Integer>());
    }

    public void addEdges(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


}
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> res = new ArrayList<Integer>();
        Graph graph = new Graph();
        for(int i = 0; i < c; i++){
            graph.addVertex(i + 1);
        }

        for(int i = 0; i < connections.length; i++){
            graph.addEdges(connections[i][0], connections[i][1]);
        }

        List<PriorityQueue<Integer>> powerGrids = new ArrayList<>();
        int powerGridId = 0;
        for(int i = 1; i <= c; i++){
            if(graph.vertices.get(i).powerGridId == -1){
                PriorityQueue<Integer> powerGrid = new PriorityQueue<Integer>();
                traverse(graph, i, powerGridId, powerGrid);
                powerGrids.add(powerGrid);
                powerGridId++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            int opType = queries[i][0];
            int node = queries[i][1];

            if(opType == 1){
                if(!graph.vertices.get(node).offline){
                    res.add(node);
                } else {
                    int powerGridIdValue = graph.vertices.get(node).powerGridId;
                    PriorityQueue<Integer> pqueue = powerGrids.get(powerGridIdValue);
                    while(!pqueue.isEmpty() && graph.vertices.get(pqueue.peek()).offline){
                        pqueue.poll();
                    }
                    if(!pqueue.isEmpty()){
                        res.add(pqueue.peek());
                    } else {
                        res.add(-1);
                    }
                } 
            } else {
                graph.vertices.get(node).offline = true;
            }
        }

        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void traverse(Graph graph, int node, int powerGridId, PriorityQueue<Integer> powerGrid){
        graph.vertices.get(node).powerGridId = powerGridId;
        powerGrid.add(node);
        List<Integer> connections = graph.adj.get(node);
        for(int i = 0; i < connections.size(); i++){
            if(graph.vertices.get(connections.get(i)).powerGridId == -1){
                traverse(graph, connections.get(i), powerGridId, powerGrid);
            }
        }
        return;
    }
}