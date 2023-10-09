import java.util.Random;

public class Gen 
{
	private byte gen[];
	private float fitness;
	
	public Gen(byte cant)
	{
		gen = new byte[cant];
		
		byte k = 1;
		
		for (byte i = 0; i < cant; i++)
		{
			/*if (k % 2 == 0)
				gen[i] = 1;
			
			else
				gen[i] = 0;
			
			k++;*/
			
			int val = 0;
			
			Random random = new Random();
			val = random.nextInt(2);
			
			gen[i] = (byte) val;
		}
		
		fitness = 0f;
	}
	
	public void setFitness(float f){ fitness = f; }
	public void setGen(byte g[]){ gen = g; }
	
	public byte[] getGen(){ return gen; }
	public float getFitness(){ return fitness; }
}
