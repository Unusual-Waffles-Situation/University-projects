public class QuickSort 
{	
	public QuickSort()
	{
		
	}
	
	public int particion(int arreglo[], int low, int high)
	{
		int eje = arreglo[high];
		int i = (low - 1);
		
		for (int j = low; j < high; j++)
		{
			if (arreglo[j] <= eje)
			{
				i++;
				
				int temporal = arreglo[i];
				
				arreglo[i] = arreglo[j];
				arreglo[j] = temporal;
			}
		}
		
		int temporal = arreglo[i + 1];
		
		arreglo[i + 1] = arreglo[high];
		arreglo[high] = temporal;
		
		return i + 1;
	}
	
	public void metodoQuickSort(int arreglo[], int low, int high)
	{
		if (low < high)
		{
			int pi = particion(arreglo, low, high);
			
			metodoQuickSort(arreglo, low, pi - 1);
			metodoQuickSort(arreglo, pi + 1, high);
		}
	}
}
