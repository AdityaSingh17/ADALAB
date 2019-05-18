
public class prog12 {
 final int V=5;
 int path[];
 boolean issafe(int v,int graph[][],int path[],int pos)
 {
	 if(graph[path[pos-1]][v] == 0)
		 return false;
	 for(int i=0;i<pos;i++)
		 if(path[i]==v)
			 return false;
	return true;
 }
 boolean hamcycun(int graph[][],int path[],int pos)
 {
	 if(pos==V)
	 {
		 if(graph[path[pos-1]][path[0]]==1)
		 {
			 return true;
		 }
		 else 
			 return false;
	 }
	 for(int v=1;v<V;v++)
	 {
		 if(issafe(v,graph,path,pos))
		 {
			 path[pos]=v;
			 if(hamcycun(graph,path,pos+1))
				 return true;
			 path[pos]=-1;
		 }
	 }
	 return false;
	 
 }
 int hamcycle(int graph[][])
 {
	 path = new int[V];
	 for(int i=0;i<V;i++)
	 {
		 path[i]=-1;
	 }
	 path[0]=0;
	 if(hamcycun(graph,path,1)==false)
		 return 0;
	 printsol(path);
	 return 1;
 }
 void printsol(int path[])
 {
	 System.out.println("SOL EXISTS");
	 for(int i=0;i<V;i++)
	 {
		 System.out.println(" "+path[i]+" ");
	 }
	 System.out.println(" "+path[0]+ " ");
 }
 public static void main(String[] args) {
	prog12 h = new prog12();
	int graph[][] = {
			{0,1,0,1,0},{1,0,1,1,1},{0,1,0,0,1},{1,1,0,0,1},{0,1,1,1,0}
	};
	h.hamcycle(graph);
}
}
