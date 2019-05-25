import java.util.*;
 
public class Hamiltonian{
    static boolean branchNbound(int pos, int x, int g[][], int path[]){
        if(g[ path[ pos - 1]][x] == 0) return false;
        for(int i = 0; i < pos; i++){
            if(path[i] == x) return false;
        }
        return true;
    }
 
    static boolean HamCycle(int pos, int g[][], int path[], int n){
 
        if(pos == n){
            if(g[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }
        for(int x = 1; x < n; x++){
            boolean nextnode = branchNbound(pos, x, g, path);//see if next node can be added
            if(nextnode){
                path[pos] = x;
                if(HamCycle( pos + 1, g, path, n)){
                    return true;
                }else{
                    path[pos] = -1;
                }
            }
        }
       
        return false;
    }
 
    public static void main(String[] args) {
        int n,source;
        boolean valid;
        char ans;
        Scanner in = new Scanner(System.in);
        do{
            System.out.print("\nEnter the number of nodes:\t");
            n = in.nextInt();
            int g[][] = new int[n][n];
            int path[] = new int[n];
            System.out.print("\nEnter the Adjacency Matrix(0/1):\n\n");
            for(int i = 0; i < n; i++){
                for(int j = 0 ; j < n; j++){
                    g[i][j] = in.nextInt();
                }
            }
            for(int i = 0; i < n; i++){
                source = i;
                valid = HamCycle(source + 1,g,path,n);
                if(valid){
                    System.out.print("\nHamiltonian cylce for source node "+source+":\n\n");//replace 0 by i
                    for (int j = 0; j < n; j++) {
                        System.out.print(path[j] + " ");
                    }
                    System.out.print(path[0]);
                }else{
                    System.out.print("\nHamiltonian cylce for source node doesn't exist!");
                }
 
                System.out.print("\n");
            }
           
            System.out.print("\nEnter another graph?(Y/n):\t");
            ans = in.next().charAt(0);
 
        }while(ans == 'Y' || ans == 'y');
    }
}
