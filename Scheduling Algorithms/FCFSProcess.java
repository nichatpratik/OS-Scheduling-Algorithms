import java.util.Scanner;
class FCFSProcess
{	public static void main(String args[])
{	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the number of processes : ");
	int n = sc.nextInt(),a[] = new int[n],w[] = new int[n],t[] = new int[n],i;
	System.out.print("Enter the Burst Time for\n");
	for(i=0;i<n;i++)
	{       System.out.print("Process "+(i+1)+" : ");	  a[i]=sc.nextInt();	 }
	w[0]=0;
	for(i=1;i<n;i++)
		w[i]=(a[i-1]+w[i-1]);
	for(i=0;i<n;i++)
		t[i]=w[i]+a[i];
	System.out.println("\nProcess\t\tBurst Time\tTurnaround Time\t\tWaiting Time");
	for(i=0;i<n;i++)
		System.out.println((i+1)+"\t\t"+a[i]+"\t\t"+t[i]+"\t\t\t"+w[i]);
	float at=0,aw=0;
	for(i=0;i<n;i++)
	{	at+=t[i];		 aw+=w[i];	 }
	System.out.println("\nAverage Turnaround Time = "+(at/=n)+"\nAverage Waiting Time = "+(aw/=n));		}
	}
