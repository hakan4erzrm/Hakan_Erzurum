package ZarAt;

/**
* @author HAKAN ERZURUM - 15.HAZ.2022
*
*/


import java.util.Random;
import java.util.Scanner;

public class Main {
	
	/* 
	 * -- Zar1 - Zar2 --
	 * 
	 * 0-6 Arası rastgele sayı üretebilmek için "Random" Kütüphanesini kullanılıyoruz. 
	 * Üretilen sayıların 0-6 arası olacağı için öncelikle 0 sayısını kaldırmamız gerekecek.
	 * Bu durumu "ZarlarinKarsiligi" tanımlamasında 1 ekleyerek gidereceğiz.
	 * */
	
	public static int Zar1() {
		
		Random rnd1 = new Random();
		int sayi1 = rnd1.nextInt(6);
		
		return(sayi1);
	}
	
	public static int Zar2() {
		
		Random rnd2 = new Random();
		int sayi2 = rnd2.nextInt(6);
		
		return(sayi2);
	}

	/* 
	 * -FarscaSayilar-
	 * 
	 * Sayıların Farsça karşılıklarını Göstermek için bir Array(Dizi) Kullanıyoruz.
	 * Zar üzerinde 0 olmayacağı için İlk dizi terimini boş bırakıyoruz.
	 * */
	
	public static void FarscaSayilar() {
		String[] FarscaSayilar = {"", "YEK", "DU", "SE", "CIHAR", "PENC", "SES"};
		
		System.out.println(" ------------------------------ \n SAYILARIN FARSCA KARSILIKLARI \n ------------------------------");
		System.out.println("        1 ---> " + FarscaSayilar[1]);
		System.out.println("        2 ---> " + FarscaSayilar[2]);
		System.out.println("        3 ---> " + FarscaSayilar[3]);
		System.out.println("        4 ---> " + FarscaSayilar[4]);
		System.out.println("        5 ---> " + FarscaSayilar[5]);
		System.out.println("        6 ---> " + FarscaSayilar[6]);
	}
	
    /*
     * - ZarlarinKarsiligi -
     * 
     * Ürettiğimiz sayılar 0 ve 6 dahil 7 tane olduğu için dizimizde de 7 tane terim yaratmıştık.
     * 1 - YEK / 2 - DU / 3 - SE / 4 - CIHAR / 5 - PENC / 6 - SES eşleşmesini yapabilmek için,
     * Rastgele üretilen sayılarımıza 1 ekliyoruz böylelikle 0 sayısını ortadan kaldırmış ve 
     * Eşleşmeyi tamamlamız olacağız. 0 sayısına karşılık boş dizi terimi gelecek. 
     * 
     * */
	
	public static void ZarlarinKarsiligi() {
		
		String[] FarscaSayilar = {"", "YEK", "DU", "SE", "CIHAR", "PENC", "SES"};
		
		int FZar1 = Zar1() + 1;
		int FZar2 = Zar2() + 1;
		
		System.out.println(" \n ZARLAR ATILDI!\n -----------");
		System.out.println(" 1. Zar : " + FZar1 + "  / FARSCA KARSILIGI : " + FarscaSayilar[FZar1]);
		System.out.println(" - - - - - - - - - - - - - - - - - - - ");
		System.out.println(" 2. Zar : " + FZar2 + "  / FARSCA KARSILIGI : " + FarscaSayilar[FZar2] + "\n");
	}
	
	/*
	 *  - EkranaYazdirma -
	 *  
	 *  Kullanıcı ile etkileşime girebilmek ve klavyeden tuş girdisini okuyabilmek için "Scanner" kütüphanesini kullanacağız.
	 *  Aldığımız değerin sadece harf olmasından dolayı "Char" olarak almamız eşleştirme işimizi kolaylaştıracak. "Char(0)" olarak
	 *  almamız Evet veya Hayır yazması halinde Kelimeyi Karakterlerine ayırıp ilk karakteri almamızı sağlayacaktır.
	 *  Küçük büyük yazı problemini Uppercase/ Lowercase ile çözebilirdik fakat "if" dögüsü içerisinde "||" veya ile çözüm daha kolay geldi,
	 *  
	 * */
	
	public static void EkranaYazdirma() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" SAYILARIN FARSCA KARSILIGINI GORMEK ISTER MISINIZ ? (E/H)");
		char GirilenTus = sc.next().charAt(0);
		
		if (GirilenTus == 'E' || GirilenTus == 'e') {
			FarscaSayilar();
		}else if(GirilenTus == 'H' || GirilenTus == 'h') {
			System.out.println(" PROGRAM KAPATILIYOR!");
			System.exit(0);
		}else{
			System.out.println(" GECERSIZ TUS'A BASTINIZ! / LUTFEN PROGRAMI TEKRAR BASLATIN");
		}
	}
	
	/*
	 * - ProgarmiTekrarla -
	 * 
	 * Programımızın Döngüsü ve devamlılığı için tekrarlama ekledim. "if" döngüsü içerisinde Tekrarlamak için E/e basıldığında 
	 * direkt "ZarlarinKarsiligi" ve "EkranaYazdirma" Methodlarını tekrar çalıştırıyoruz, zarlar tekrar atılıyor ve ekrana tekrar yazdırılıyor.
	 * Programdan çıkmak istenirse "System.exit(0)" protokolünü kullanıyoruz. Programı kapatmaya zorluyor ve kapanıyor. İşlem yapılmamasına ve
	 * yanlış tuşlama sonucu program otomatik sonlanıyor.
	 * 
	 * */
	
	public static void ProgarmiTekrarla() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println(" \n PROGRAMI TEKRARLAMAK ISTER MISINIZ ? (E/H)");
		char Cevap = scn.next().charAt(0);
		
		if (Cevap == 'E' || Cevap == 'e') {
			ZarlarinKarsiligi();
			
			EkranaYazdirma();
		}else if(Cevap == 'H' || Cevap == 'h') {
			System.out.println(" PROGRAM KAPATILIYOR!");
			System.exit(0);
		}else{
			System.out.println(" GECERSIZ TUS'A BASTINIZ! / LUTFEN PROGRAMI TEKRAR BASLATIN");
		}
		
	}
	
	public static void main(String[] args) {
		
		ZarlarinKarsiligi();
		
		EkranaYazdirma();
		
		ProgarmiTekrarla();
	}

}