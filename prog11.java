import java.util.*;
public class prog11 
{
	private static int d;
	private static int count;
	private static int x[]=new int[20];
	private static int w[]=new int[20];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i,n,sum=0;
		System.out.println("NUMBER OF ELE?");
		n=in.nextInt();
		System.out.println("ENTER IN ASCENDING ORDER ");
		for(i=0;i<n;i++)
			w[i]=in.nextInt();
		System.out.println("ENTER SUM ");
		d=in.nextInt();
		for(i=0;i<n;i++)
		{
			sum = sum+w[i];
		}
		if(sum<d)
		{
			System.out.println("NO TREE");
			return;
		}
		
		subset(0,0,sum);
		
		if(count == 0)
		{
			System.out.println("NO TREE");
			return;
		}
	}
		static void subset(int cs,int k,int r)
		{
			int i;
			x[k]=1;
			if(cs+w[k] == d)
			{
				System.out.println("SUBSET "+(++count));
				for(i=0;i<=k;i++)
					if(x[i] == 1)
						System.out.println(w[i]+" ");
			}
			else if ( cs+w[k]+w[k+1] <= d)
			{
				subset((cs+w[k]),k+1,r-w[k]);
			}
			if(cs+r-w[k]>=d && cs+w[k]<=d)
			{
				x[k]=0;
				subset(cs,k+1,r-w[k]);
			}
			
		}
	}

