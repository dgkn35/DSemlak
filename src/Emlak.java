import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Emlak {

	
	public static void main(String[] args) {
		tree kisiAgaci = new tree();
		
		

	}
	
	public static void kayit(){
		
	}
	
	public static void init(tree kisiAgaci){
		try {
			FileReader fr = new FileReader("kullanıcılar.txt");
			BufferedReader br= new BufferedReader(fr);

			String satir;
			ArrayList<String> kullanicilar = new ArrayList<String>();
			//TODO initialize

			while((satir = br.readLine())!=null){kullanicilar.add(satir);}
			
			
			for (int i = 0; i < kullanicilar.size()-1; i++) {
				String[] tmp = kullanicilar.get(i).split("#");
				
				kisiNode eklenen = new kisiNode();
				eklenen.setAd(tmp[0]);
				eklenen.setAdres(tmp[1]);
				eklenen.setTelefon(tmp[2]);
				eklenen.setE_posta(tmp[3]);
				eklenen.setUyruk(tmp[4]);
				eklenen.setDogum_yeri(tmp[5]);
				eklenen.setTarih(tmp[6]);
				eklenen.setMedeni_durum(tmp[7]);
				eklenen.setCinsiyet(tmp[8]);
				eklenen.setOgrenci(tmp[9]);
				
				String[] bilgi = tmp[tmp.length].split(">>");
				if(bilgi[0].compareTo("0")!=0)//eski bilgilerde 1'den fazla değer varsa
				for (int j = 1; j < Integer.parseInt(bilgi[0])+1; j++) {
					String[] adres = bilgi[j].split("_") ;
					eskiBilgiler temp = new eskiBilgiler();
					temp.setKira(adres[0]);
					temp.setIl(adres[1]);
					temp.setIlce(adres[2]);
					temp.setFiyat(Float.parseFloat(adres[3]));
					temp.setAlan(Float.parseFloat(adres[4]));
					temp.setYil(adres[5]);
					
					eklenen.eskiBilgiler.add(temp);
				}

				//TODO kisileri agaca ekle
			}
			
			 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void menu(){
		System.out.println("1.Satın alma işlemleri");
		System.out.println("2.Satis islemleri");
	}
}
