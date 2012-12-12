import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Emlak {


	public static void main(String[] args) {
		tree kisiAgaci = new tree();
		Heap heap = new Heap();
		Hashtable<Float, yeniBilgi> hashing = new Hashtable<>();

		init(kisiAgaci, heap, hashing);

	}
	
	public static void emlakSil(Hashtable<Float,yeniBilgi> hashing, Heap heap)
	{
		yeniBilgi birBilgi;
		Scanner scan = new Scanner(System.in);
		System.out.println("Silmek istediginiz konutun ilan numarasini giriniz:");
		float ilanno=scan.nextFloat();
		hashing.remove(ilanno);
		ArrayList<yeniBilgi> dizi = new ArrayList<>();
		for(int i=0;i<heap.getSize();i++)
		{
			birBilgi=heap.sil();
			if(birBilgi.getIlanno()!=ilanno)
				dizi.add(birBilgi);
		}
		
		for (int i = 0; i < dizi.size();i++)
			heap.ekle(dizi.get(i));
		
		scan.close();
	}
	
	public static void emlakKayit(Hashtable<Float,yeniBilgi> hashing, Heap heap)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Konutun ilan numarasini giriniz:");
		float ilanno = scan.nextFloat();
		System.out.println("Konutun bulundugu ili giriniz:");
		String il=scan.next();
		System.out.println("Konutun bulundugu ilceyi giriniz:");
		String ilce=scan.next();
		System.out.println("Konutun fiyatini giriniz:");
		float fiyat=scan.nextFloat();
		System.out.println("Konutun yapi tipini(D/M/V) giriniz:");
		String yapi_tipi=scan.next();
		System.out.println("Konutun alanini giriniz:");
		float alan=scan.nextFloat();
		System.out.println("Konutun yapim yilini giriniz:");
		float yil=scan.nextFloat();
		System.out.println("Konutun durumunu(I/S) giriniz:");
		String durum=scan.next();
		System.out.println("Konutun bulundugu kati giriniz:");
		float kat=scan.nextFloat();
		System.out.println("Konutun oda sayisini giriniz:");
		float oda=scan.nextFloat();
		System.out.println("Konutun banyo sayisini giriniz:");
		float banyo=scan.nextFloat();
		System.out.println("Konutta balkon olup olmadigini giriniz(E/H):");
		String balkon=scan.next();
		System.out.println("Konutun kullanim durumunu(K/M/B) giriniz:");
		String kullanim_durum=scan.next();
		System.out.println("Bina kat sayisini giriniz:");
		float bina_kat=scan.nextFloat();
		System.out.println("Bahce olup olmadigini giriniz(E/H):");
		String bahce=scan.next();
		System.out.println("Konutun ogrenciye uygun olup olmadigini giriniz(E/H):");
		String ogrenci=scan.next();
		
		//TODO ic donanim ve aciklama
		
		yeniBilgi birBilgi = new yeniBilgi();
		
		birBilgi.setAlan(alan);
		birBilgi.setBahce(bahce);
		birBilgi.setBalkon(balkon);
		birBilgi.setBanyo(banyo);
		birBilgi.setBina_kat(bina_kat);
		birBilgi.setFiyat(fiyat);
		birBilgi.setIl(il);
		birBilgi.setIlanno(ilanno);
		birBilgi.setIlce(ilce);
		birBilgi.setKat(kat);
		birBilgi.setKullanim_durumu(kullanim_durum);
		birBilgi.setOda_sayisi(oda);
		birBilgi.setSatildi("H");
		birBilgi.setUygun(ogrenci);
		birBilgi.setYapi_durum(durum);
		birBilgi.setYapi_tipi(yapi_tipi);
		birBilgi.setYil(yil);
		
		hashing.put(birBilgi.getIlanno(), birBilgi);
		heap.ekle(birBilgi);
		
		scan.close();
	}
	
	public static void ogrenciFiyatOrtalama(Hashtable<Float,yeniBilgi> hashing)
	{
		float ortalama=0, toplam=0, sayac=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen ilce adi giriniz:");
		String ilce=scan.next();
		for (yeniBilgi birBilgi : hashing.values())
		{
			if(birBilgi.getUygun()=="E" && birBilgi.getIlce()==ilce)
			{
				sayac++;
				toplam=(float)toplam+birBilgi.getFiyat();
			}
		}
		ortalama=(float)toplam/sayac;
		System.out.println("Ortalama fiyat=" + ortalama);
		scan.close();
	}
	
	public static void hashingDolasIlce(Hashtable<Float,yeniBilgi> hashing)//ilan no
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen ilce bilgisini giriniz:");
		String ilce=scan.next();
		System.out.println("Lutfen fiyat araligini(a-b) giriniz:");
		String aralik=scan.next();
		String[] aralikDizisi=aralik.split("-");
		float altDeger=Float.parseFloat(aralikDizisi[0]);
		float ustDeger=Float.parseFloat(aralikDizisi[1]);
		for (yeniBilgi birBilgi : hashing.values()) {
			if(birBilgi.getIlce()==ilce && birBilgi.getFiyat()<ustDeger && birBilgi.getFiyat()>altDeger)
				birBilgi.yazdir();
		}
		scan.close();
	}

	public static void hashingDolasIl(Hashtable<Float,yeniBilgi> hashing)//ilan no
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen il bilgisini giriniz:");
		String il=scan.next();
		for (yeniBilgi birBilgi : hashing.values()) {
			if(birBilgi.getIl()==il && birBilgi.getKat()!=0 && birBilgi.getKat()!=birBilgi.getBina_kat() && birBilgi.getUygun()=="E")
				birBilgi.yazdir();
		}
		scan.close();
	}

	public static void hashingDolasSat(Hashtable<Float, yeniBilgi> hashing, Heap heap, tree agac)
	{
		kisiNode birKisi;
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen isminizi giriniz");
		String isim=scan.next();
		birKisi=agac.find(isim);
		String devam;
		for (yeniBilgi birBilgi : hashing.values()) {
			birBilgi.yazdir();
			System.out.println("Satin almak istermisiniz? Satin almak icin e, devam etmek icin herhangi bir tusa basin");
			devam=scan.next();
			if(devam=="e" || devam=="E")
			{
				birKisi.satinAlinanlar.add(birBilgi);
				birBilgi.setSatildi("E");
				hashing.remove(birBilgi.getIlanno());
			}
			break;
		}
		scan.close();
	}

	public static void yatirim(tree agac, Heap heap)
	{
		kisiNode birKisi;
		yeniBilgi birBilgi;
		ArrayList<yeniBilgi> dizi = new ArrayList<yeniBilgi>();

		for (int i = 0; i < heap.getSize(); i++) {
			birBilgi = heap.sil();
			if(birBilgi.getSatildi()!= "E"){
				dizi.add(birBilgi);
			}
		}
		
		for (int i = 0; i < dizi.size();i++){
			heap.ekle(dizi.get(i));
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("Yatirim yapacak kisinin adini giriniz:");
		String isim=scan.next();
		System.out.println("Yatirim icin alinacak ev sayisi:");
		int n=scan.nextInt();
		birKisi=agac.find(isim);
		for (int i = 0; i < n; i++) {
			birBilgi=heap.sil();
			birKisi.satinAlinanlar.add(birBilgi);
			birBilgi.setSatildi("E");
		}
		scan.close();
	}

	public static void kisiKayit(tree kisiAgaci){
		kisiNode birKisi = new kisiNode();
		Scanner scan = new Scanner(System.in);
		System.out.println("Isim:");
		String ad=scan.next();
		System.out.println("Adres:");
		String adres=scan.next();
		System.out.println("Tel:");
		String tel=scan.next();
		System.out.println("E-posta:");
		String eposta=scan.next();
		System.out.println("Uyruk:");
		String uyruk=scan.next();
		System.out.println("Dogum yeri:");
		String yer=scan.next();
		System.out.println("Dogum tarihi:");
		String tarih=scan.next();
		System.out.println("Medeni durumu:");
		String medeni=scan.next();
		System.out.println("Cinsiyet(e/k):");
		String cinsiyet=scan.next();
		System.out.println("Ogrenci(e/h):");
		String ogrenci=scan.next();
		System.out.println("Bilgiler:");
		//TODO while koy
		System.out.println("Satin alinanlar:");
		//TODO while koy

		birKisi.setAd(ad);
		birKisi.setAdres(adres);
		birKisi.setCinsiyet(cinsiyet);
		birKisi.setDogum_yeri(yer);
		birKisi.setE_posta(eposta);
		birKisi.setMedeni_durum(medeni);
		birKisi.setOgrenci(ogrenci);
		birKisi.setTarih(tarih);
		birKisi.setTelefon(tel);
		birKisi.setUyruk(uyruk);

		kisiAgaci.ekle(birKisi);

		scan.close();

	}

	public static void sil(tree agac)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Silmek istediginiz kisinin adini giriniz:");
		String isim=scan.next();
		if(isim!=null)
		{
			boolean flag=agac.sil(isim);
			if(flag)
				System.out.println("Kisi basariyla silindi !!!!1111!!!!");
			else
				System.out.println("Boyle bir kisi bulunmamaktadir !!!!1111!!!!");
		}
		scan.close();
	}

	public static void guncelle(tree agac)
	{
		kisiNode birKisi;
		Scanner scan = new Scanner(System.in);
		System.out.println("Guncellemek istediginiz kisinin ismini giriniz:");
		String isim=scan.next();
		birKisi=agac.find(isim);

		System.out.println("Isim:");
		String ad=scan.next();
		System.out.println("Adres:");
		String adres=scan.next();
		System.out.println("Tel:");
		String tel=scan.next();
		System.out.println("E-posta:");
		String eposta=scan.next();
		System.out.println("Uyruk:");
		String uyruk=scan.next();
		System.out.println("Dogum yeri:");
		String yer=scan.next();
		System.out.println("Dogum tarihi:");
		String tarih=scan.next();
		System.out.println("Medeni durumu:");
		String medeni=scan.next();
		System.out.println("Cinsiyet(e/k):");
		String cinsiyet=scan.next();
		System.out.println("Ogrenci(e/h):");
		String ogrenci=scan.next();
		System.out.println("Bilgiler:");
		//TODO while koy
		System.out.println("Satin alinanlar:");
		//TODO while koy

		if(ad!=null)
			birKisi.setAd(ad);
		if(adres!=null)
			birKisi.setAdres(adres);
		if(cinsiyet!=null)
			birKisi.setCinsiyet(cinsiyet);
		if(yer!=null)
			birKisi.setDogum_yeri(yer);
		if(eposta!=null)
			birKisi.setE_posta(eposta);
		if(medeni!=null)
			birKisi.setMedeni_durum(medeni);
		if(ogrenci!=null)
			birKisi.setOgrenci(ogrenci);
		if(tarih!=null)
			birKisi.setTarih(tarih);
		if(tel!=null)
			birKisi.setTelefon(tel);
		if(uyruk!=null)
			birKisi.setUyruk(uyruk);

		if(ad!=null)
		{
			agac.sil(isim);
			agac.ekle(birKisi);
		}
		scan.close();
	}

	public static void init(tree kisiAgaci, Heap heap, Hashtable<Float,yeniBilgi> hashing){
		try {
			FileReader fr = new FileReader("kullanicilar.txt");
			BufferedReader br= new BufferedReader(fr);

			String satir;
			ArrayList<String> kullanicilar = new ArrayList<String>();
			//TODO initialize

			while((satir = br.readLine())!=null){kullanicilar.add(satir);}//kullanicilari ayir


			for (int i = 0; i < kullanicilar.size()-1; i++) {
				String[] tmp = kullanicilar.get(i).split("#");//bilgileri ayikla

				kisiNode eklenen = new kisiNode();//eklenecek kisi
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

				String[] bilgi = tmp[tmp.length].split(">>");//eski bilgileri ayir
				if(bilgi[0].compareTo("0")!=0)//eski bilgilerde 1'den fazla deger varsa
					for (int j = 1; j < Integer.parseInt(bilgi[0])+1; j++) {
						String[] adres = bilgi[j].split("_") ;//Bilgileri ayikla
						eskiBilgiler temp = new eskiBilgiler();//bilgileri ekle
						temp.setKira(adres[0]);
						temp.setIl(adres[1]);
						temp.setIlce(adres[2]);
						temp.setFiyat(Float.parseFloat(adres[3]));
						temp.setAlan(Float.parseFloat(adres[4]));
						temp.setYil(adres[5]);

						eklenen.eskiBilgiler.add(temp);//ilgili nesneye ekle
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

				temp1.setIlanno(Float.parseFloat(detay[0]));//Nesne olusturma destani
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
					icdonanim.add(string2);//ic donanimi tutan arraylist.
				}
				temp1.icdonanim = icdonanim;
				hashing.put(temp1.getIlanno(), temp1);
				//TODO çati veya zemin kat kontrolü yapilacak!
				heap.ekle(temp1);//Oncelik kuyruguna ekleme
			}

			fr1.close();
			br1.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}


	public static void anamenu(){
		System.out.println("1.Satilik Konut Arayan Kisilerin Kullanacagi Bolum");
		System.out.println("2.Emlak Sahiplerinin Kullanacagi Bolum");
		System.out.println("3.Cikis");	
	}

	public static void aramenu1()
	{
		System.out.println("1.Sisteme kayit");
		System.out.println("2.Sistemdeki bilgileri guncelleme");
		System.out.println("3.Sistemden cikis");
		System.out.println("4.Verilen bir ilcedeki verilen fiyat araligindaki tum konutlarin listelenmesi");
		System.out.println("5.Verilen bir ildeki arakatlarda ogrenciye uygun tum konutlarin listelenmesi");
		System.out.println("6.Hash Table dolasilarak uygun olana gelindiginde satin alinmasi -tanimli kisiler alabilir");
		System.out.println("7.Ilan numarasi ile ev alinmasi");
		System.out.println("8.En iyi n adet konutun alinmasi");
		System.out.println("9.ogrenciye uygun konutlarin, ilçe bazinda ortalama fiyatlarinin bulunmasi");
	}

	public static void aramenu2()
	{
		System.out.println("1.Sisteme kayit(yeni satilik konut ilan verme)");
		System.out.println("2.Sistemdeki ilan bilgileri guncelleme(numarasina gore)");
		System.out.println("3.Sistemde kayitli ilan bilgisini silme(numarasina gore)");
	}
}
