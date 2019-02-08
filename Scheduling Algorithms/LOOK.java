import java.util.Scanner;
class LOOK
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of queue : ");
		int n = sc.nextInt(),q[] = new int[n+2],i,seek=0,d[] = new int[n],temp;
		System.out.print("Enter Queue (Considering limits 0 and 199) : ");
		for(i=0;i<n;i++)
			q[i]=sc.nextInt();
		System.out.print("Enter head position : ");
		int h = sc.nextInt(),h2 = h;
		for(i=0;i<n;i++)
			for(int j=0;j<n-i-1;j++)
				if(q[j]>q[j+1])
				{
					temp=q[j];
					q[j]=q[j+1];
					q[j+1]=temp;
				}
		System.out.print("\nSorted Queue : ");
		for(i=0;i<n;i++)
			System.out.print(q[i]+" ");
		for(i=0;i<n;i++)
			if(q[i]>h)
				break;
		int x=i-1,y=i;
		System.out.print("\n\nMoving first Right : \nPath = "+h);
		for(i=y;i<n;i++)
		{
			seek+=Math.abs(h-q[i]);
			System.out.print(" --> "+q[i]);
			h=q[i];
		}
		for(i=x;i>=0;i--)
		{
			seek+=Math.abs(h-q[i]);
			System.out.print(" --> "+q[i]);
			h=q[i];
		}
		System.out.println("\n\nTotal Seek Time : "+seek);
		seek=0;
		System.out.print("\n\nMoving first Left : \nPath = "+h2);
		for(i=x;i>=0;i--)
		{
			seek+=Math.abs(h2-q[i]);
			System.out.print(" --> "+q[i]);
			h2=q[i];
		}
		for(i=y;i<n;i++)
		{
			seek+=Math.abs(h2-q[i]);
			System.out.print(" --> "+q[i]);
			h2=q[i];
		}
		System.out.println("\n\nTotal Seek Time : "+seek);
	}
}