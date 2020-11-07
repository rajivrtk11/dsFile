import java.util.*;
class construct{
    static class Edge{
        int v = 0;
        int w = 0;
        Edge(int v , int w){
            this.v = v;
            this.w = w;
        }
    }

    static int N = 7;
    static ArrayList<Edge>[] graph = new ArrayList[N];

    static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    static void display(){
        for(int i = 0; i < graph.length; i++){
            System.out.print(i +"->");
            for(Edge e: graph[i]){
                System.out.print("("+e.v+"),");
            }
            System.out.println();
        }
    }

    static int searchVtx(int u, int v){
        for(int i = 0; i<graph[u].size(); i++){
            Edge e = graph[u].get(i);
            if(e.v == v) return i;
        }
        return 0;
    }

    static void removeEdge(int u, int v){
        int l1 = searchVtx(u,v);
        graph[u].remove(l1);
        int l2 = searchVtx(v,u);
        graph[v].remove(l2);
    }

    static void removeVtx(int u){
        System.out.println(graph[u].size());
        for(int i = graph[u].size()-1; i>=0; i--){
            Edge e = graph[u].get(i);
            removeEdge(u,e.v);
        }
    }
    public static boolean hasPath(int src, int dest, boolean[] visited){
        if(src == dest) return true;
        visited[src] = true;
        for(Edge e: graph[src]){
            if(!visited[e.v]){
                boolean res = hasPath(e.v, dest, visited);
                if(res) return true;
            }
        }
        return false;
    }
    public static int allPath(int src , int dest, boolean[] visited, String psf, int wsf){
        if(src == dest){
            System.out.println(psf + src + "@" + wsf);
            return 1;
        }
        visited[src] = true;
        int count = 0;
        for(Edge e : graph[src]){
            if(!visited[e.v]){
                count += allPath(e.v, dest, visited, psf+src+" ", wsf+e.w);
            }
        }
        visited[src] = false;
        return count;
    }
    public static void main(String[] args){
        for(int i = 0; i<7; i++) graph[i] = new ArrayList<Edge>();
        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(5,6,3); 
        addEdge(4,6,8);
        display();
        // has path
        boolean visited[] = new boolean[7];
        

        int val = allPath(0,6,visited,"",0);
        System.out.println(val);
    }
}