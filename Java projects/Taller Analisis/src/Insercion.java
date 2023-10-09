public class Insercion 
{
	public Insercion()
	{
	
	}
	
	public void metodoInsercion(int arreglo[], int cantidad, int comienzo)
	{
		int j, temporal;

	    for (int i = comienzo; i < cantidad; i++)
	    {
	        j = i;

	        while (j > 0 && arreglo[j] < arreglo[j - 1])
	        {
	            temporal = arreglo[j];
	            arreglo[j] = arreglo[j - 1];
	            arreglo[j - 1] = temporal;
	            j--;
	        }
	    }
	}
}
