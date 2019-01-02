public class Pascal {

    public static void main(String[] args) {
	
	int n=7;
	int p[][] = new int[n][n];
	
	
	for(int i=0;i<n;i++)
	{
	    for(int j=0;j<n-i;j++)
	        System.out.print("  ");
		for(int j=0; j<=i; j++)
		{
		    if(j==0)
		      p[i][j]=1;
		    else
			 p[i][j]=p[i-1][j-1]+p[i-1][j];
			 
			 System.out.printf("%4d",p[i][j]);
		}
		System.out.println();
    }
    }
}
