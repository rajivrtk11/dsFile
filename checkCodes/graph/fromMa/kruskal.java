class graph{

    class Edge{
        int u = 0;
        int w = 0;
        Edge(int u, int w){
            this.u = u;
            this.w = w;
        }
    }

    public static addEdge(int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    static int N = 9;
    static ArrayList<Integer> graph[] = new ArrayList[N];

    public static void main(String[] args){

    }
}