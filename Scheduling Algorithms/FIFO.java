import java.util.Scanner;
class FIFO
{
	public static void main(String args[])
	{
		int hits=0,no=0,j,faults=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter frame size : ");
		int size = sc.nextInt(),frame[] = new int[size];
		for(int i=0;i<size;i++)
			frame[i] = -1;
		System.out.print("Enter number of pages : ");
		int n = sc.nextInt(),page[] = new int[n];
		System.out.print("Enter page numbers one by one : ");
		for(int i=0;i<n;i++)
			page[i] = sc.nextInt();
		for(int i=0;i<n;i++)
			for(j=0;j<size;j++)
				if(frame[j]==-1)
				{
					faults++;
					frame[j]=page[i];
					if(j==size-1)
						i=n;
					break;
				}
				else if(frame[j]==page[i])
				{
					hits++;
					break;
				}
		System.out.print("\nFrame : ");
			for(j=0;j<size;j++)
				System.out.print(frame[j]+" ");
		for(int i=size;i<n;i++)
		{
			for(j=0;j<size;j++)
				if(page[i]==frame[j])
				{
					hits++;
					break;
				}
			if(j==size)
			{
				faults++;
				frame[no++] = page[i];
				if(no==size)
					no=0;
			}
			System.out.print("\nFrame : ");
			for(j=0;j<size;j++)
				System.out.print(frame[j]+" ");
		}
		System.out.println("\n\nNumber of Page Hits : "+hits+"\nNumber of Page Faults : "+faults);
	}
}