import java.util.*;
public class prog7 {
	public static int findmin()
	{
		int i,n,min=0;
		int d[] = new int [20];
		int s[] = new int [20];
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for(i=1;i<=n;i++)
		{
			if(s[i]==0)
			{
				min=i;
				break;
			}
		}
		for(i=1;i<=n;i++)
		{
			if(d[i]<d[min] && s[i]==0)
				min=i;
		}
		return min;		
		
	}
	public void dijkstra(int v,int w[][],int s[],int d[],int n)
	{
		int i,w1,u,k,j;
		int p[]=new int[20];
		for(i=1;i<=n;i++)
		{
			s[i]=0;
			d[i]=999;
			p[i]=0;
		}
		d[v]=0;
		for(k=1;k<=n;k++)
		{
			u=findmin();
			s[u]=1;
			for(w1=1;w1<=n;w1++)
			{
				if(w[u][w1]!=999 && s[w1]==0)
				{
					if(d[w1] > (d[u] +w[u][w1]))
					{
						d[w1]=d[u]+w[u][w1];
						p[w1]=u;
					}
				}
			}
		}
		System.out.println("SHORTEST PATH COST");
		for(i=1;i<=n;i++)
		{
			if(d[i] == 999)
			{
				System.out.println(" NO PATH FROM "+v+" TO "+i);
			}
			else
				System.out.println(" PATH FROM "+v+" TO "+i+" COSTS "+d[i]);
		}
		System.out.println("SHORTEST GROUP OF PATHS ARE");
		for(i=1;i<=n;i++)
		{
			if(i!=v && d[i]!= 999)
			{
				System.out.println(i);
				j=p[i];
				while(p[j]!=0)
				{
					System.out.println("<---"+j+" ");
					j=p[j];
				}
				System.out.println("<---"+v);
			}
		}
	}
	public static void main(String[] args) {
		int i,j,n,v;
		int d[]=new int[20];
		int s[]=new int[20];
		int w[][]=new int[20][20];
		prog7 d1= new prog7();
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER THE NUMBER OF VERTICES ");
		n=in.nextInt();
		System.out.println("ENTER COST ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				w[i][j]=in.nextInt();
			}
		}
		System.out.println("ENTER SOURCE");
		v=in.nextInt();
		d1.dijkstra(v, w, s, d, n);
	}

}
