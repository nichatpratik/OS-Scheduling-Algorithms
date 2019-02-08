import java.util.Scanner;
class SSTF
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of queue : ");
		int n = sc.nextInt(),q[] = new int[n],i,seek=0,d[] = new int[n],temp;
		System.out.print("Enter Queue : ");
		for(i=0;i<n;i++)
			q[i]=sc.nextInt();
		System.out.print("Enter head position : ");
		int h = sc.nextInt();
		for(i=0;i<n;i++)
			d[i]=Math.abs(h-q[i]);
		for(i=0;i<n;i++)
			for(int j=0;j<n-i-1;j++)
				if(d[j]>d[j+1])
				{	
					temp=d[j];
					d[j]=d[j+1];
					d[j+1]=temp;
					temp=q[j];
					q[j]=q[j+1];
					q[j+1]=temp;
				}
		System.out.print("\nPath = "+h);
		for(i=0;i<n;i++)
		{
			seek+=Math.abs(h-q[i]);
			System.out.print(" --> "+q[i]);
			h=q[i];
		}
		System.out.println("\n\nTotal Seek Time : "+seek);
	}
}