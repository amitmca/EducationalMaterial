import java.util.Random;

class TestRandom
	{
	public static void main(String args[])
		{
		Random rand = new Random();
		int prob = rand.nextInt();
		System.out.println("Number Generated is:::"+prob);
		}
	}