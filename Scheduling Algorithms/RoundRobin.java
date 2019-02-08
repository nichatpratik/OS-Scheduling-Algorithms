import java.util.Scanner;
class RoundRobin
{	public static void main(String args[])
	{	Scanner sc = new Scanner(System.in);
		System.out.print("Enter the time quantum : ");
		int n = sc.nextInt();
		System.out.print("Enter the number of processes : ");
		int np = sc.nextInt(),burst[] = new int[np],burst2[] = new int[np],i,j=0,time=0,k=0,process[] = new int[100],t[] = new int[np];
		System.out.println("\nEnter the Burst Time for");
		for(i=0;i<n;i++)
		{	System.out.print("Process "+(i+1)+" : ");
			burst[i]=sc.nextInt();
			burst2[i]=burst[i];	 }
	int gnatt[] = new int[100],total=0,times=0,m=1,finish=0,w[] = new int[np];
		for(i=0;i<np;i++)
			total+=burst[i];
		gnatt[0]=0;
		while(time<=total)
			for(i=0;i<np;i++) 
			{if(burst[i]>=n)
				{burst[i]-=n;
					process[k++]=i;
					time+=n;
					gnatt[m++]=time;	 }
				else
					if(burst[i]==0)
						if(times==n)
							time=total+1;
						else
							times++;
					else
					{	time+=burst[i];
						gnatt[m++]=time;
						process[k++]=i;
						burst[i]=0;	 }
				if(i==np-1&&time<=total)
					i=-1;	 }
		gnatt[--m]=total;
		System.out.println("\nGnatt Chart :");
		for(i=0;i<k;i++)
			System.out.print(gnatt[i]+"--"+"P"+(process[i]+1)+"--");
		System.out.print(gnatt[k]);
		for(i=0;i<n;i++)
			for(j=0;j<k;j++)
				if(process[j]==i)
					t[i]=gnatt[j+1];
		for(i=0;i<n;i++)
		{	for(j=0;j<k;j++)
			if(process[j]==i)
					{	w[i]+=(gnatt[j]-finish);
						finish=gnatt[j+1];	 }
			finish=0;	 }
		System.out.println("\n\nProcess\tBurst Time\tTurnaround Time\t\tWaiting Time");
		for(i=0;i<np;i++)
			System.out.println((i+1)+"\t"+burst2[i]+"\t\t"+t[i]+"\t\t\t"+w[i]);
		float at=0,aw=0;
		for(i=0;i<np;i++)
		{	at+=t[i];
			aw+=w[i];	}
System.out.println("\nAverage Turnaround Time = "+(at/=np)+"\nAverage Waiting Time = "+(aw/=np)); }	}
