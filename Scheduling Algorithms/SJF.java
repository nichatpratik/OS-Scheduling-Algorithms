import java.util.Scanner;
class SJF
{	public static void main(String args[])
{	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the number of processes : ");
	int n = sc.nextInt(),burst[] = new int[n],arrival[] = new int[n],i,no[] = new int[n],w[] = new int[n],t[] = new int[n],temp,gnatt[] = new int[n+1];
	gnatt[0]=0;
	System.out.println("Enter the Burst Time for");
	for(i=0;i<n;i++)
	{  System.out.print("Process "+(i+1)+" : ");   burst[i]=sc.nextInt();  no[i]=i;      }
	System.out.println("\nEnter the Arrival Time for");
	for(i=0;i<n;i++)
	{	System.out.print("Process "+(i+1)+" : ");		arrival[i]=sc.nextInt();		}
	for(i=0;i<n;i++)
	for(int j=0;j<n-i-1;j++)
	if(arrival[j]>arrival[j+1])
	{
		temp=arrival[j];
		arrival[j]=arrival[j+1];
		arrival[j+1]=temp;
		temp=no[j];
		no[j]=no[j+1];
		no[j+1]=temp;
		temp=burst[j];
		burst[j]=burst[j+1];
		burst[j+1]=temp;
	}
	temp=0;
	for(i=1;i<=n;i++)
	{	for(int j=0;j<i;j++)
			temp+=burst[j];
		gnatt[i]=temp;	    temp=0;	 }
	w[0]=0;
	for(i=1;i<n;i++)
		w[i]=gnatt[i]-arrival[i];
	for(i=0;i<n;i++)
		t[i]=gnatt[i+1]-arrival[i];
	System.out.print("\nGnatt Chart :\nProcess - \t   ");
	for(i=0;i<n;i++)
		System.out.print("P"+(no[i]+1)+"\t    ");
	System.out.print("\nTime - \t\t");
	for(i=0;i<=n;i++)
		System.out.print(gnatt[i]+"\t");
	System.out.println("\n\nProcess\tBurst Time\tArrival Time\tTurnaround Time\t\tWaiting Time");
	for(i=0;i<n;i++)
		System.out.println((no[i]+1)+"\t"+burst[i]+"\t\t"+arrival[i]+"\t\t"+t[i]+"\t\t\t"+w[i]);
	float at=0,aw=0;
	for(i=0;i<n;i++)
	{	at+=t[i];		 aw+=w[i];	}
System.out.println("\nAverage Turnaround Time = "+(at/=n)+"\nAverage Waiting Time = "+(aw/=n));      }      }
