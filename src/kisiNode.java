import java.util.ArrayList;


public class kisiNode {
	private String ad, adres, e_posta, uyruk, dogum_yeri, medeni_durum, cinsiyet, tarih;
	private String ogrenci;
	public kisiNode rightchild;
	public kisiNode leftchild;
	public ArrayList<eskiBilgiler> eskiBilgiler;
	public ArrayList<Integer> satinAlinanlar;
	public ArrayList<icDonanim> donanim;
	
	public kisiNode()
	{
		eskiBilgiler = new ArrayList<eskiBilgiler>();
		satinAlinanlar = new ArrayList<Integer>();
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getE_posta() {
		return e_posta;
	}

	public void setE_posta(String e_posta) {
		this.e_posta = e_posta;
	}

	public String getUyruk() {
		return uyruk;
	}

	public void setUyruk(String uyruk) {
		this.uyruk = uyruk;
	}

	public String getDogum_yeri() {
		return dogum_yeri;
	}

	public void setDogum_yeri(String dogum_yeri) {
		this.dogum_yeri = dogum_yeri;
	}

	public String getMedeni_durum() {
		return medeni_durum;
	}

	public void setMedeni_durum(String medeni_durum) {
		this.medeni_durum = medeni_durum;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(String ogrenci) {
		this.ogrenci = ogrenci;
	}

	
}
