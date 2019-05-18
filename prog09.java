import java.util.*;
public class prog9 
{
 public static void main(String[] args) {
	int n,i,j,min=0,a=0,b=0,u=0,v=0,source;
	int ne=1;
	int mincost=0;
	int cost[][] = new int[20][20];
	int visited[]=new int[20];
	Scanner in = new Scanner(System.in);
	
	System.out.println("Enter nodes");
	n=in.nextInt();
	
	System.out.println("Enter matrix");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			cost[i][j]=in.nextInt();
		}
	}
	
	for(i=1;i<=n;i++)
		visited[i]=0;
	
	System.out.println("Enter source");
	source=in.nextInt();
	
	visited[source]=1;
	System.out.println("Min tree");
	while(ne<n)
	{
		min=999;
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(cost[i][j]<min)
				{
					if(visited[i]==0)
						continue;
					else  //this else belongs to the inner if
					{
						min=cost[i][j];
						a=u=i;
						b=v=j;
					}
				}
				
			}
		}
		if(visited[u]==0 || visited[v]==0)
		{
			ne++;
			System.out.println("Edge"+ne+"\t"+a+"-->"+b+" = "+min);
			visited[b]=1;
			mincost = mincost+min;
		}
		cost[a][b]=cost[b][a]=999;
	}
	
	System.out.println("min cost "+mincost);
}
}
