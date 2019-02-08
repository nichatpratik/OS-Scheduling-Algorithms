import java.util.Scanner;
class FCFSDisk
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of queue : ");
		int n = sc.nextInt(),q[] = new int[n],i,seek=0;
		System.out.print("Enter Queue : ");
		for(i=0;i<n;i++)
			q[i]=sc.nextInt();
		System.out.print("Enter head position : ");
		int h = sc.nextInt();
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