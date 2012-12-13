import java.util.ArrayList;


public class yeniBilgi {
	private String il, ilce, yapi_tipi, yapi_durum, kullanim_durumu, aciklama;
	private String uygun, satildi, balkon, bahce;
	private float ilanno, fiyat, alan, yil, kat, oda_sayisi, banyo, bina_kat;
	public ArrayList<String> icdonanim;
	
	public void yazdir()
	{
		System.out.println(ilanno + " " + satildi + " " + il + " " + ilce + " " + fiyat + " " + yapi_tipi );
		//TODO yazdir duzenlenecek
		System.out.println(alan + " " +  yil+ "  " + yapi_durum+ " " + kullanim_durumu+ "  " + fiyat+ " " + kat);
		System.out.println(oda_sayisi + " " +  banyo+ "  " +bina_kat+ " " + satildi+ "  " +balkon+ " " + bahce+ " "+ uygun);
		
		for(int i=0;i<icdonanim.size();i++){
			System.out.println(icdonanim.get(i));
		}
	}
	public yeniBilgi(){// Constructor
		icdonanim = new ArrayList<String>();
	}
	
	public String getIl() {
		return il;
	}
	public void setIl(String il) {
		this.il = il;
	}
	public String getIlce() {
		return ilce;
	}
	public void setIlce(String ilce) {
		this.ilce = ilce;
	}
	public String getYapi_tipi() {
		return yapi_tipi;
	}
	public void setYapi_tipi(String yapi_tipi) {
		this.yapi_tipi = yapi_tipi;
	}
	public String getYapi_durum() {
		return yapi_durum;
	}
	public void setYapi_durum(String yapi_durum) {
		this.yapi_durum = yapi_durum;
	}
	public String getKullanim_durumu() {
		return kullanim_durumu;
	}
	public void setKullanim_durumu(String kullanim_durumu) {
		this.kullanim_durumu = kullanim_durumu;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public String getUygun() {
		return uygun;
	}
	public void setUygun(String uygun) {
		this.uygun = uygun;
	}
	public String getSatildi() {
		return satildi;
	}
	public void setSatildi(String satildi) {
		this.satildi = satildi;
	}
	public String getBalkon() {
		return balkon;
	}
	public void setBalkon(String balkon) {
		this.balkon = balkon;
	}
	public String getBahce() {
		return bahce;
	}
	public void setBahce(String bahce) {
		this.bahce = bahce;
	}
	public float getIlanno() {
		return ilanno;
	}
	public void setIlanno(float ilanno) {
		this.ilanno = ilanno;
	}
	public float getFiyat() {
		return fiyat;
	}
	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}
	public float getAlan() {
		return alan;
	}
	public void setAlan(float alan) {
		this.alan = alan;
	}
	public float getYil() {
		return yil;
	}
	public void setYil(float yil) {
		this.yil = yil;
	}
	public float getKat() {
		return kat;
	}
	public void setKat(float kat) {
		this.kat = kat;
	}
	public float getOda_sayisi() {
		return oda_sayisi;
	}
	public void setOda_sayisi(float oda_sayisi) {
		this.oda_sayisi = oda_sayisi;
	}
	public float getBanyo() {
		return banyo;
	}
	public void setBanyo(float banyo) {
		this.banyo = banyo;
	}
	public float getBina_kat() {
		return bina_kat;
	}
	public void setBina_kat(float bina_kat) {
		this.bina_kat = bina_kat;
	}
	
	
	
}