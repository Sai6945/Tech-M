package Day10;

public class withoutSorting {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {0,1,1,1,0,1,0};
		int n=arr.length;
		
		int l=0;
		int r=n-1;
		while(l<r)
		{
			while(l<r && arr[l]==0)
				l++;
			while(l<r && arr[r]==1)
				r--;
			if(l<r)
			{
				int temp=arr[l];
				arr[l]=arr[r];
				arr[r]=temp;
				l++;
				r--;
			}
		}
		
		
		
				for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		
		
	}

}
