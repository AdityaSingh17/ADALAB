import java.util.*;
public class prog10b {
	final static int max=100;
	final static int inf=999;
	static int tsp(int c[][],int tour[],int start,int n)
	{
		int i,j,k;
		int temp[]=new int[max];
		int mint[]=new int[max];
		int mincost,cost;
		if(start == n-2 )
		{
			return(c[tour[n-2]][tour[n-1]]+c[tour[n-1]][0]);
		}
		mincost=inf;
		for(i=start+1;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				temp[j]=tour[j];
				temp[start+1]=tour[i];
				temp[i]=tour[start+1];
			}
			if(c[tour[start]][tour[i]] + (cost = tsp(c,temp,start+1,n)) < mincost)
			{
				mincost = cost+c[tour[start]][tour[i]];
				for(k=0;k<n;k++)
					mint[k]=temp[k];
			}
		}
		for(i=0;i<n;i++)
		{
			tour[i]=mint[i];
		}
		tour[i]=start;
		return mincost;
		
	}
	public static void main(String[] args) {
		int n,i,j,cost;
		int c[][]=new int[max][max];
		int tour[]=new int[max];
		Scanner in = new Scanner(System.in);
		System.out.println("CITIES?");
		n=in.nextInt();
		System.out.println("Enter cost");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				c[i][j]=in.nextInt();
			}
		}
		for(i=0;i<n;i++)
			tour[i]=i;
		cost = tsp(c,tour,0,n);
		System.out.println(" COST ="+cost);
		System.out.println("TREE");
		for(i=0;i<n;i++)
			System.out.println(tour[i]+1);
	}

}
