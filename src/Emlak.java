import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Emlak {


	public static void main(String[] args) {
		tree kisiAgaci = new tree();



	}

	public static void kayit(){

	}

	public static void init(tree kisiAgaci, PriorityQueue<yeniBilgi> heap){
		try {
			FileReader fr = new FileReader("kullanıcılar.txt");
			BufferedReader br= new BufferedReader(fr);

			String satir;
			ArrayList<String> kullanicilar = new ArrayList<String>();
			//TODO initialize

			while((satir = br.readLine())!=null){kullanicilar.add(satir);}//kullanicilari ayır


			for (int i = 0; i < kullanicilar.size()-1; i++) {
				String[] tmp = kullanicilar.get(i).split("#");//bilgileri ayıkla

				kisiNode eklenen = new kisiNode();//eklenecek kişi
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

				String[] bilgi = tmp[tmp.length].split(">>");//eski bilgileri ayır
				if(bilgi[0].compareTo("0")!=0)//eski bilgilerde 1'den fazla değer varsa
					for (int j = 1; j < Integer.parseInt(bilgi[0])+1; j++) {
						String[] adres = bilgi[j].split("_") ;//Bilgileri ayıkla
						eskiBilgiler temp = new eskiBilgiler();//bilgileri ekle
						temp.setKira(adres[0]);
						temp.setIl(adres[1]);
						temp.setIlce(adres[2]);
						temp.setFiyat(Float.parseFloat(adres[3]));
						temp.setAlan(Float.parseFloat(adres[4]));
						temp.setYil(adres[5]);

						eklenen.eskiBilgiler.add(temp);//İlgili nesneye ekle
					}
				kisiAgaci.ekle(eklenen);// kisileri agaca ekle
			}
			br.close();
			fr.close();


		} catch (Exception e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			FileReader fr1 = new FileReader("emlaklar.txt");
			BufferedReader br1 = new BufferedReader(fr1);
			
			String satir1;
			ArrayList<String> emlaklar = new ArrayList<String>();
			
			while ((satir1 = br1.readLine())!= null){emlaklar.add(satir1);}//emlaklari ayir
			for (String string : emlaklar) {
				String[] detay = string.split("#");//Bilgileri ayikla
				yeniBilgi temp1 = new yeniBilgi();//eklenecekler
				
				temp1.setIlanno(Float.parseFloat(detay[0]));//Nesne oluşturma destani
				temp1.setSatildi(detay[1]);
				temp1.setIl(detay[2]);
				temp1.setIlce(detay[3]);
				temp1.setFiyat(Float.parseFloat(detay[4]));
				temp1.setYapi_tipi(detay[5]);
				temp1.setAlan(Float.parseFloat(detay[6]));
				temp1.setYil(Float.parseFloat(detay[7]));
				temp1.setYapi_durum(detay[8]);
				temp1.setKat(Float.parseFloat(detay[9]));
				temp1.setOda_sayisi(Float.parseFloat(detay[10]));
				temp1.setBanyo(Float.parseFloat(detay[11]));
				temp1.setBalkon(detay[12]);
				temp1.setBina_kat(Float.parseFloat(detay[13]));
				temp1.setBahce(detay[14]);
				temp1.setUygun(detay[16]);
				temp1.setAciklama(detay[17]);
				
				String[] ic = detay[15].split("_");
				ArrayList<String> icdonanim = new ArrayList<String>();
				
				for (String string2 : ic) {
					icdonanim.add(string2);//İc donanimi tutan arraylist.
				}
				temp1.icdonanim = icdonanim;
				
				//TODO çati veya zemin kat kontrolü yapilacak!
				heap.add(temp1);//Oncelik kuyruguna ekleme
			}
			
			

		}catch (Exception e){
			e.printStackTrace();
		}
	}


	public static void menu(){
		System.out.println("1.Satın alma işlemleri");
		System.out.println("2.Satis islemleri");
	}
}
