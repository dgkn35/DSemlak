import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Emlak {


	public static void main(String[] args) {
		tree kisiAgaci = new tree();
		Heap heap = new Heap();
		Hashtable<Float, yeniBilgi> hashing = new Hashtable<Float,yeniBilgi>();

		init(kisiAgaci, heap, hashing);
		
		

		anamenu(kisiAgaci, heap, hashing);

	}

	public static void sat(Hashtable<Float, yeniBilgi> hashing,tree agac,Heap heap) {
		kisiNode birKisi;
		yeniBilgi birBilgi;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ev alacak kisinin adini giriniz:");
		String isim=scan.nextLine();
		System.out.println("Ilan numarasi gini:");
		float ilanno=scan.nextFloat();
		birKisi=agac.find(isim);
		birBilgi = hashing.remove(ilanno);
		birBilgi.setSatildi("E");
		birKisi.satinAlinanlar.add(birBilgi);


	}

	public static void emlakGuncelle(Hashtable<Float,yeniBilgi> hashing, Heap heap)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Guncellemek istediginiz ilanin numarasini giriniz:");
		float ilanno=scan.nextFloat();

		String il, ilce, yapi_tipi, durum, balkon, kullanim_durum, bahce, ogrenci;
		float fiyat, alan, yil, kat, oda, banyo, bina_kat;

		for (yeniBilgi birBilgi : hashing.values())
		{
			if(birBilgi.getIlanno()==ilanno)
			{
				System.out.println("De�i�meyen bilgiler i�in q girin.");
				System.out.println("Konutun ilan numarasini giriniz:");
				ilanno = scan.nextFloat();
				System.out.println("Konutun bulundugu ili giriniz:");
				il=scan.nextLine();
				System.out.println("Konutun bulundugu ilceyi giriniz:");
				ilce=scan.nextLine();
				System.out.println("Konutun fiyatini giriniz(Degismeyecekse -1 giriniz):");
				fiyat=scan.nextFloat();
				System.out.println("Konutun yapi tipini(D/M/V) giriniz:");
				yapi_tipi=scan.nextLine();
				System.out.println("Konutun alanini giriniz(Degismeyecekse -1 giriniz):");
				alan=scan.nextFloat();
				System.out.println("Konutun yapim yilini giriniz(Degismeyecekse -1 giriniz):");
				yil=scan.nextFloat();
				System.out.println("Konutun durumunu(I/S) giriniz:");
				durum=scan.nextLine();
				System.out.println("Konutun bulundugu kati giriniz(Degismeyecekse -1 giriniz):");
				kat=scan.nextFloat();
				System.out.println("Konutun oda sayisini giriniz(Degismeyecekse -1 giriniz):");
				oda=scan.nextFloat();
				System.out.println("Konutun banyo sayisini giriniz(Degismeyecekse -1 giriniz):");
				banyo=scan.nextFloat();
				System.out.println("Konutta balkon olup olmadigini giriniz(E/H):");
				balkon=scan.nextLine();
				System.out.println("Konutun kullanim durumunu(K/M/B) giriniz:");
				kullanim_durum=scan.nextLine();
				System.out.println("Bina kat sayisini giriniz(Degismeyecekse -1 giriniz):");
				bina_kat=scan.nextFloat();
				System.out.println("Bahce olup olmadigini giriniz(E/H):");
				bahce=scan.nextLine();
				System.out.println("Konutun ogrenciye uygun olup olmadigini giriniz(E/H):");
				ogrenci=scan.nextLine();

				if(il!="q")
					birBilgi.setIl(il);
				if(ilce!="q")
					birBilgi.setIlce(ilce);
				if(fiyat!=-1)
					birBilgi.setFiyat(fiyat);
				if(yapi_tipi!="q")
					birBilgi.setYapi_tipi(yapi_tipi);
				if(alan!=-1)
					birBilgi.setAlan(alan);
				if(yil!=-1)
					birBilgi.setYil(yil);
				if(durum!="q")
					birBilgi.setYapi_durum(durum);
				if(kat!=-1)
					birBilgi.setKat(bina_kat);
				if(oda!=-1)
					birBilgi.setOda_sayisi(oda);
				if(banyo!=-1)
					birBilgi.setBanyo(banyo);
				if(balkon!="q")
					birBilgi.setBalkon(balkon);
				if(kullanim_durum!="q")
					birBilgi.setKullanim_durumu(kullanim_durum);
				if(bina_kat!=-1)
					birBilgi.setBina_kat(bina_kat);
				if(ogrenci!="q")
					birBilgi.setUygun(ogrenci);
				if(bahce!="q")
					birBilgi.setBahce(bahce);
			
			}
			break;
		}
		yeniBilgi ikiBilgi;
		ArrayList<yeniBilgi> dizi = new ArrayList<yeniBilgi>();
		for(int i=0;i<heap.getSize();i++)
		{
			ikiBilgi=heap.sil();
			dizi.add(ikiBilgi);
		}

		for(int i=0;i<dizi.size();i++)
			heap.ekle(dizi.get(i));

	}

	public static void emlakSil(Hashtable<Float,yeniBilgi> hashing, Heap heap)
	{
		yeniBilgi birBilgi;
		Scanner scan = new Scanner(System.in);
		System.out.println("Silmek istediginiz konutun ilan numarasini giriniz:");
		float ilanno=scan.nextFloat();
		hashing.remove(ilanno);
		ArrayList<yeniBilgi> dizi = new ArrayList<yeniBilgi>();
		for(int i=0;i<heap.getSize();i++)
		{
			birBilgi=heap.sil();
			if(birBilgi.getIlanno()!=ilanno)
				dizi.add(birBilgi);
		}

		for (int i = 0; i < dizi.size();i++)
			heap.ekle(dizi.get(i));


	}

	public static void emlakKayit(Hashtable<Float,yeniBilgi> hashing, Heap heap)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Konutun ilan numarasini giriniz:");
		float ilanno = scan.nextFloat();
		System.out.println("Konutun bulundugu ili giriniz:");
		String il=scan.nextLine();
		System.out.println("Konutun bulundugu ilceyi giriniz:");
		String ilce=scan.nextLine();
		System.out.println("Konutun fiyatini giriniz:");
		float fiyat=scan.nextFloat();
		System.out.println("Konutun yapi tipini(D/M/V) giriniz:");
		String yapi_tipi=scan.nextLine();
		System.out.println("Konutun alanini giriniz:");
		float alan=scan.nextFloat();
		System.out.println("Konutun yapim yilini giriniz:");
		float yil=scan.nextFloat();
		System.out.println("Konutun durumunu(I/S) giriniz:");
		String durum=scan.nextLine();
		System.out.println("Konutun bulundugu kati giriniz:");
		float kat=scan.nextFloat();
		System.out.println("Konutun oda sayisini giriniz:");
		float oda=scan.nextFloat();
		System.out.println("Konutun banyo sayisini giriniz:");
		float banyo=scan.nextFloat();
		System.out.println("Konutta balkon olup olmadigini giriniz(E/H):");
		String balkon=scan.nextLine();
		System.out.println("Konutun kullanim durumunu(K/M/B) giriniz:");
		String kullanim_durum=scan.nextLine();
		System.out.println("Bina kat sayisini giriniz:");
		float bina_kat=scan.nextFloat();
		System.out.println("Bahce olup olmadigini giriniz(E/H):");
		String bahce=scan.nextLine();
		System.out.println("Konutun ogrenciye uygun olup olmadigini giriniz(E/H):");
		String ogrenci=scan.nextLine();

	
		System.out.println("Adsl(E/H)");
		String adsl = scan.nextLine();
		System.out.println("Asans�r(E/H)");
		String asan= scan.nextLine();
		System.out.println("�elik Kap�(E/H)");
		String celik= scan.nextLine();
		System.out.println("Du�akabin(E/H)");
		String kabin= scan.nextLine();
		System.out.println("Is�cam(E/H)");
		String isi= scan.nextLine();
		System.out.println("Kartonpiyer(E/H)");
		String karton= scan.nextLine();
		System.out.println("Laminant Parke(E/H)");
		String parke= scan.nextLine();
		System.out.println("PVC(E/H)");
		String pvc= scan.nextLine();
		
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
		
		birBilgi.icdonanim.add(adsl);
		birBilgi.icdonanim.add(asan);
		birBilgi.icdonanim.add(celik);
		birBilgi.icdonanim.add(kabin);
		birBilgi.icdonanim.add(isi);
		birBilgi.icdonanim.add(karton);
		birBilgi.icdonanim.add(parke);
		birBilgi.icdonanim.add(pvc);
		hashing.put(birBilgi.getIlanno(), birBilgi);
		heap.ekle(birBilgi);


	}

	public static void ogrenciFiyatOrtalama(Hashtable<Float,yeniBilgi> hashing)
	{
		float ortalama=0, toplam=0, sayac=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen ilce adi giriniz:");
		String ilce=scan.nextLine();
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

	}

	public static void hashingDolasIlce(Hashtable<Float,yeniBilgi> hashing)//ilan no
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen ilce bilgisini giriniz:");
		String ilce=scan.nextLine();
		System.out.println("Lutfen fiyat araligini(a-b) giriniz:");
		String aralik=scan.nextLine();
		String[] aralikDizisi=aralik.split("-");
		float altDeger=Float.parseFloat(aralikDizisi[0]);
		float ustDeger=Float.parseFloat(aralikDizisi[1]);
		for (yeniBilgi birBilgi : hashing.values()) {
			if(birBilgi.getIlce().compareTo(ilce)==0 && birBilgi.getFiyat()<ustDeger && birBilgi.getFiyat()>altDeger)
				birBilgi.yazdir();
		}

	}

	public static void hashingDolasIl(Hashtable<Float,yeniBilgi> hashing)//ilan no
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen il bilgisini giriniz:");
		String il=scan.nextLine();
		for (yeniBilgi birBilgi : hashing.values()) {
			if(birBilgi.getIl().compareTo(il)==0 && birBilgi.getKat()!=0 && birBilgi.getKat()!=birBilgi.getBina_kat() && birBilgi.getUygun().compareTo("E")==0)
				birBilgi.yazdir();
		}

	}

	public static void hashingDolasSat(Hashtable<Float, yeniBilgi> hashing, Heap heap, tree agac)
	{
		kisiNode birKisi;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen isminizi giriniz");
		String isim=scan.nextLine();
		birKisi=agac.find(isim);
		String devam;
		if(birKisi != null)
			for (yeniBilgi birBilgi : hashing.values()) {
				birBilgi.yazdir();
				System.out.println("Satin almak istermisiniz? Satin almak icin e, devam etmek icin herhangi bir tusa basin");
				devam=scan.nextLine();
				if(devam=="e" || devam=="E")
				{
					System.out.println("Daire satin alindi.");
					birKisi.satinAlinanlar.add(birBilgi);
					birBilgi.setSatildi("E");
					hashing.remove(birBilgi.getIlanno());
				}
			}

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
		String isim=scan.nextLine();
		System.out.println("Yatirim icin alinacak ev sayisi:");
		int n=scan.nextInt();
		birKisi=agac.find(isim);
		for (int i = 0; i < n; i++) {
			birBilgi=heap.sil();
			birKisi.satinAlinanlar.add(birBilgi);
			birBilgi.setSatildi("E");
		}

	}

	public static void kisiKayit(tree kisiAgaci){
		kisiNode birKisi = new kisiNode();
		Scanner scan = new Scanner(System.in);
		System.out.println("Isim:");
		String ad=scan.nextLine();
		System.out.println("Adres:");
		String adres=scan.nextLine();
		System.out.println("Tel:");
		String tel=scan.nextLine();
		System.out.println("E-posta:");
		String eposta=scan.nextLine();
		System.out.println("Uyruk:");
		String uyruk=scan.nextLine();
		System.out.println("Dogum yeri:");
		String yer=scan.nextLine();
		System.out.println("Dogum tarihi:");
		String tarih=scan.nextLine();
		System.out.println("Medeni durumu:");
		String medeni=scan.nextLine();
		System.out.println("Cinsiyet(e/k):");
		String cinsiyet=scan.nextLine();
		System.out.println("Ogrenci(e/h):");
		String ogrenci=scan.nextLine();
	
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



	}

	public static void sil(tree agac)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Silmek istediginiz kisinin adini giriniz:");
		String isim=scan.nextLine();
		if(isim!=null)
		{
			boolean flag=agac.sil(isim);
			if(flag)
				System.out.println("Kisi basariyla silindi !!!!1111!!!!");
			else
				System.out.println("Boyle bir kisi bulunmamaktadir !!!!1111!!!!");
		}

	}

	public static void guncelle(tree agac)
	{
		kisiNode birKisi;
		Scanner scan = new Scanner(System.in);
		System.out.println("Guncellemek istediginiz kisinin ismini giriniz:");
		String isim=scan.nextLine();
		birKisi=agac.find(isim);
		
		System.out.println("Değiştirmek istemediğiniz degerler yerine q harfi giriniz.");
		System.out.println("Isim:");
		String ad=scan.nextLine();
		System.out.println("Adres:");
		String adres=scan.nextLine();
		System.out.println("Tel:");
		String tel=scan.nextLine();
		System.out.println("E-posta:");
		String eposta=scan.nextLine();
		System.out.println("Uyruk:");
		String uyruk=scan.nextLine();
		System.out.println("Dogum yeri:");
		String yer=scan.nextLine();
		System.out.println("Dogum tarihi:");
		String tarih=scan.nextLine();
		System.out.println("Medeni durumu:");
		String medeni=scan.nextLine();
		System.out.println("Cinsiyet(e/k):");
		String cinsiyet=scan.nextLine();
		System.out.println("Ogrenci(e/h):");
		String ogrenci=scan.nextLine();
	

		if(ad.compareTo("q")!=0)
			birKisi.setAd(ad);
		if(adres.compareTo("q")!=0)
			birKisi.setAdres(adres);
		if(cinsiyet.compareTo("q")!=0)
			birKisi.setCinsiyet(cinsiyet);
		if(yer.compareTo("q")!=0)
			birKisi.setDogum_yeri(yer);
		if(eposta.compareTo("q")!=0)
			birKisi.setE_posta(eposta);
		if(medeni.compareTo("q")!=0)
			birKisi.setMedeni_durum(medeni);
		if(ogrenci.compareTo("q")!=0)
			birKisi.setOgrenci(ogrenci);
		if(tarih.compareTo("q")!=0)
			birKisi.setTarih(tarih);
		if(tel.compareTo("q")!=0)
			birKisi.setTelefon(tel);
		if(uyruk.compareTo("q")!=0)
			birKisi.setUyruk(uyruk);

		if(ad.compareTo("q")!=0)
		{
			agac.sil(isim);
			agac.ekle(birKisi);
		}
	}

	public static void init(tree kisiAgaci, Heap heap, Hashtable<Float,yeniBilgi> hashing){
		try {
			FileReader fr = new FileReader("kullanıcılar.txt");
			BufferedReader br= new BufferedReader(fr);

			String satir;
			ArrayList<String> kullanicilar = new ArrayList<String>();

			while((satir = br.readLine())!=null){kullanicilar.add(satir);}//kullanicilari ayir


			for (int i = 0; i < kullanicilar.size(); i++) {
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

				String[] bilgi = tmp[tmp.length-1].split(">>");//eski bilgileri ayir
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
				temp1.setKullanim_durumu(detay[13]);
				temp1.setBina_kat(Float.parseFloat(detay[14]));
				temp1.setBahce(detay[15]);
				temp1.setUygun(detay[17]);
				temp1.setAciklama(detay[18]);

				String[] ic = detay[15].split("_");
				ArrayList<String> icdonanim = new ArrayList<String>();

				for (String string2 : ic) {
					icdonanim.add(string2);//ic donanimi tutan arraylist.
				}
				temp1.icdonanim = icdonanim;
				hashing.put(temp1.getIlanno(), temp1);
				
				if(temp1.getBina_kat()!=temp1.getKat() && temp1.getKat()!=0)
				heap.ekle(temp1);//Oncelik kuyruguna ekleme
			}

			fr1.close();
			br1.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}


	public static void anamenu(tree agac,Heap heap, Hashtable<Float, yeniBilgi> hash){
		int secim;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		do{

			System.out.println("1.Satilik Konut Arayan Kisilerin Kullanacagi Bolum");
			System.out.println("2.Emlak Sahiplerinin Kullanacagi Bolum");
			System.out.println("3.Agac slemleri");
			System.out.println("4.Cikis");
			secim=scan.nextInt();


			switch (secim) {
			case 1:

				aramenu1(agac,heap,hash);

				break;
			case 2:

				aramenu2(agac,heap,hash);

			case 3:
				System.out.println("Bulmak istediginiz kisinin adini giriniz");
				String secim2=scan2.nextLine();
				kisiNode birkKisi = agac.find(secim2);
				birkKisi.display();
				System.out.println("\n\n");
				agac.traverse();
				
				agac.ogrBulmaca();
				
				System.out.println("D�zey bilgileri!!!!!!1!1!!!1!!!11!!!bir!!!!");
				agac.bulmaca();
				
				
				break;
			default:
				break;
			}

		}while(secim !=4);


	}

	public static void aramenu1(tree agac,Heap heap, Hashtable<Float, yeniBilgi> hash)
	{
		int secim;
		System.out.println("1.Sisteme kayit");
		System.out.println("2.Sistemdeki bilgileri guncelleme");
		System.out.println("3.Sistemden cikis(silme)");
		System.out.println("4.Verilen bir ilcedeki verilen fiyat araligindaki tum konutlarin listelenmesi");
		System.out.println("5.Verilen bir ildeki arakatlarda ogrenciye uygun tum konutlarin listelenmesi");
		System.out.println("6.Hash Table dolasilarak uygun olana gelindiginde satin alinmasi -tanimli kisiler alabilir");
		System.out.println("7.Ilan numarasi ile ev alinmasi");
		System.out.println("8.En iyi n adet konutun alinmasi");
		System.out.println("9.ogrenciye uygun konutlarin, ilçe bazinda ortalama fiyatlarinin bulunmasi");
		Scanner scan = new Scanner(System.in);
		secim=scan.nextInt();

		switch (secim) {
		case 1:

			kisiKayit(agac);
			break;
		case 2:

			guncelle(agac);
			break;
		case 3:

			sil(agac);
			break;
		case 4:

			hashingDolasIlce(hash);
			break;
		case 5:

			hashingDolasIl(hash);
			break;
		case 6:

			hashingDolasSat(hash, heap, agac);
			break;
		case 7:

			sat(hash, agac, heap);
			break;
		case 8:

			yatirim(agac, heap);
			break;
		case 9:

			ogrenciFiyatOrtalama(hash);
			break;

		default:
			break;
		}

	}

	public static void aramenu2(tree agac,Heap heap, Hashtable<Float, yeniBilgi> hash)
	{
		System.out.println("1.Sisteme kayit(yeni satilik konut ilan verme)");
		System.out.println("2.Sistemdeki ilan bilgileri guncelleme(numarasina gore)");
		System.out.println("3.Sistemde kayitli ilan bilgisini silme(numarasina gore)");
		Scanner scan = new Scanner(System.in);
		int secim=scan.nextInt();
		switch (secim) {
		case 1:

			emlakKayit(hash, heap);
			break;
		case 2:

			emlakGuncelle(hash, heap);
			break;
		case 3:

			emlakSil(hash, heap);
			break;
		default:
			break;
		}

	}
}