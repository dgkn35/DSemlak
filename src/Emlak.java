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
