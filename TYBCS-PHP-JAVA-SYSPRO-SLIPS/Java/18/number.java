class MyNumber
{
      private int x;
      public MyNumber()
      {
            x=0;
      }
      public MyNumber(int x)
      {
            this.x=x;
      }
      public boolean isNegative()
      {
            return(x<0);
      }
      public boolean isPositive()
      {
            return(x>0);
      }
      public boolean isZero()
      {
            return(x==0);
      }
      public boolean isEven()
      {
            return(x%2==0);
      }
      public boolean isOdd()
      {
            return(x%2==1);
      }
}
public class number
{
      public static void main(String[] args)
      {
            MyNumber n=new MyNumber(Integer.parseInt(args[0]));
            System.out.println("Is Zero? "+n.isZero());
            System.out.println("Is +Ve? "+n.isPositive());
            System.out.println("Is -Ve? "+n.isNegative());
            System.out.println("Is Even? "+n.isEven());
            System.out.println("Is Odd? "+n.isOdd());
      }
}

