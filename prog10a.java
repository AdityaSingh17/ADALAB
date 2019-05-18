import java.util.*;
public class prog10a {
	public static void floyd(int a[][],int n)
	{
		int i,j,k;
		int d[][]=new int[10][10];
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				d[i][j]=a[i][j];
			}
		}
		for(k=1;k<=n;k++)
		{
			for(j=1;j<=n;j++)
			{
				for(i=1;i<=n;i++)
				{
					d[i][j] = min(d[i][j],d[i][k]+d[k][j]);
				}
			}
		}
		System.out.println("DISTANCE ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print(" "+d[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	public static int min(int a,int b)
	{
		if(a<b)
			return a;
		else
			return b;
	}
	public static void main(String[] args) {
		int n,i,j;
		int a[][]=new int[10][10];
		Scanner in = new Scanner(System.in);
		System.out.println("NODES?");
		n=in.nextInt();
		System.out.println("MATRIX ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				a[i][j]=in.nextInt();
			}
		}
		floyd(a,n);
	}

}
