
public class ArraySum {

	public int sumOfArray (Integer[] a,int index)
	{
		
		if(index <= 0) return a[index];
		else
		{
			while(a[index] == null)
				index--;
			return (a[index] + sumOfArray(a , index - 1));
		}
		
	}

}
