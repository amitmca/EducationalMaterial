import series.*;

public class prime
{
      public static void main(String[] args)
      {
            int n=10;
            
            Prime p=new Prime(n);
            Square s=new Square(n);
      
            System.out.println("Prime Numbers");
            System.out.println(p);
      
            System.out.println("Square of Numbers");
            System.out.println(s);
      }
}


package series;
public class Prime {
      int n;
      public Prime()
      {
            this.n=0;
      }
      public Prime(int n)
      {
            this.n=n;
      }
      public String toString()
      {
            int cnt=0;
            for(int i=1;i<=n;i++)
            {
                        cnt=0;
                        for(int j=2;j<i;j++)
                        {
                              if(i%j==0)
                              {
                                    cnt++;
                              }
                        }
                        if(cnt==0)
                        {
                              System.out.println(i);
                        }
            }
            return("");
      }
}

package series;
public class Square
{
	  int n;
	  public Square()
	  {
	  }
	  public Square(int n)
	  {
	        this.n=n;
	  }
	  public String toString()
	  {
	        for (int i = 0; i < n; i++)
	        {
	              System.out.println(i*i);
	        }
	        return("");
	  }
}

