
import java.util.*;
// 0 based indexing used
public class Dijkstra{
    static int findmin(int visited[],int dist[],int n){
        int min_indx, min;
        min_indx = -1;
        min = 999;
        for(int i = 0; i < n; i++){
            if(dist[i] < min  && visited[i] == 0){
                min = dist[i];
                min_indx = i;
            }
        }
        return min_indx;
    }
    static void dijkstra(int source, int cost[][],int n){
        int [] parent,visited,dist;//all are arrays
        dist = new int[n];
        parent = new int[n];
        visited = new int[n];
        int u,v;
        for(int i = 0; i < n; i++){
            visited[i] = parent[i] = 0;
            dist[i] = 999;
        }
        dist[source] = 0;
        for(int i = 0; i < n; i++){
            u = findmin(visited, dist, n);
            if(u == -1) break;
            for(int j = 0; j < n; j++){
                if(visited[j] == 0 && cost[u][j] != 999){
                    if(dist[j] > (dist[u] + cost[u][j])){
                        dist[j] = (dist[u] + cost[u][j]);
                        parent[j] = u;
                    }
                }
            }            
        }
        for(int i = 0; i < n; i++){
            if(dist[i] == 999){
                System.out.print("\nNo Path from source "+ source +" to "+i);
            }else{
                System.out.print("\nThe cost of path from "+source+" to "+ i+" is:" + dist[i]);
            }
        }
 
        for(int i = 0; i < n; i++){
            if(i != source && dist[i] != 999){
                System.out.print("\nPath to "+i+"\n\n");
                System.out.print(i);
                v = parent[i];
                while(v != source){
                    System.out.print(" <--- " + v);
                    v = parent[v];
                }
                System.out.print(" <--- "+source);
            }
            System.out.print("\n\n");
        }
 
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, source;
        System.out.print("\nEnter the number of nodes:\t");
        n = in.nextInt();
        int cost[][] = new int[n][n];
        System.out.print("\nEnter the cost matrix(999 for n edge):\n\n");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cost[i][j] = in.nextInt();
            }
        }
        System.out.print("\nEnter source:\t");
        source = in.nextInt();
        dijkstra(source, cost, n);
    }
}
