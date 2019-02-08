import java.util.Scanner;
class SRTF
{
public static void main(String args[])
{	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the number of processes : ");
	int n = sc.nextInt(),burst[] = new int[n],arrival[] = new int[n],i,no[] = new int[n],burst2[] = new int[n];
	System.out.println("Enter the Burst Time for");
	for(i=0;i<n;i++)
	{	System.out.print("Process "+(i+1)+" : ");
		burst[i]=sc.nextInt();
		burst2[i]=burst[i];
		no[i]=i;		}
	System.out.println("\nEnter the Arrival Time for");
	for(i=0;i<n;i++)
	{	System.out.print("Process "+(i+1)+" : ");
		arrival[i]=sc.nextInt();	}
	int gnatt[] = new int[20],time=0,order[] = new int[19],j=0,total=0,temp,temp2,finaltime=0,k=0,l=0,start=0,w[] = new int[n],time1=0,time2=0,t[] = new int[n];
	for(i=0;i<n;i++)
		total+=burst[i];
	while(time<total)
	{	for(i=0;i<n;i++)
			if(arrival[i]==time)
				if(time!=0)
					{	if(burst[i]<burst[order[j-1]])
						{	order[j++]=i;
							gnatt[j-1]=time;
							burst[i-1]-=time-start;
							start=time;
							finaltime=time;	 }	}
				else
				{	order[j++]=i;
					gnatt[j-1]=time;
					start=time;	 }
		time++;
		k=l=j;		 }
	for(i=0;i<n;i++)
		for(j=i;j<n-i-1;j++)
			if(burst[j]>burst[j+1])
			{	temp=burst[j];
				temp2=no[j];
				burst[j]=burst[j+1];
				no[j]=no[j+1];
				burst[j+1]=temp;
				no[j+1]=temp2;	 }
	if(order[k-1]!=no[0])
		order[k++]=no[0];
	for(i=1;i<n;i++)
		order[k++]=no[i];
	while(finaltime<total)
	{	for(i=0;i<n;i++)
		{	while(burst[i]>0)
			{	finaltime++;		burst[i]-=1;	}
			gnatt[l++]=finaltime;	}	}
	for(i=0;i<n;i++)
	{	time2=finaltime=0;
		for(j=0;j<k;j++)
			if(order[j]==i)
				if(time2==0)
				{	time1=gnatt[j];		 time2=gnatt[j+1];	 }
				else
					finaltime=gnatt[j];
		if(finaltime==0)
			w[i]=time1-arrival[i];
		else
			w[i]=finaltime-time2;	 }
	for(i=0;i<n;i++)
		for(j=0;j<k;j++)
			if(order[j]==i)
				t[i]=gnatt[j+1]-arrival[i];
	System.out.print("\nGnatt Chart :\nProcess - \t   ");
	for(i=0;i<k;i++)
		System.out.print("P"+(order[i]+1)+"\t    ");
	System.out.print("\nTime - \t\t");
	for(i=0;i<=k;i++)
		System.out.print(gnatt[i]+"\t");
	System.out.println("\n\nProcess\tBurst Time\tArrival Time\tTurnaround Time\t\tWaiting Time");
	for(i=0;i<n;i++)
		System.out.println((i+1)+"\t"+burst2[i]+"\t\t"+arrival[i]+"\t\t"+t[i]+"\t\t\t"+w[i]);
	float at=0,aw=0;
	for(i=0;i<n;i++)
	{	at+=t[i];		 aw+=w[i];	 }
System.out.println("\nAverage Turnaround Time = "+(at/=n)+"\nAverage Waiting Time = "+(aw/=n));   }	}
