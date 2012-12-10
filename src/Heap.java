import java.util.ArrayList;


public class Heap {
	public ArrayList<yeniBilgi> kuyruk;
	
	public Heap()
	{
		kuyruk = new ArrayList<yeniBilgi>();
	}
	
	public yeniBilgi sil()
	{
		return kuyruk.remove(0);
	}

	public void ekle(yeniBilgi biryeniBilgi)
	{
		float k = (float)biryeniBilgi.getFiyat()/biryeniBilgi.getAlan();
		float j;
		
		if(kuyruk.isEmpty())
			kuyruk.add(biryeniBilgi);
		else
		{
			int i;
			for(i=0; i<kuyruk.size();i++)
			{
				j=(float)kuyruk.get(i).getFiyat()/kuyruk.get(i).getAlan();
				if(k<j)
					break;
			}
			kuyruk.add(i,biryeniBilgi);
		}
	}
}
