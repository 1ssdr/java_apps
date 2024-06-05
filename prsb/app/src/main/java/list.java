import java.util.ArrayList;
import java.util.Scanner;

public class list {
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            /*ArrayList<String> kullanicilar = new ArrayList<String>();
            kullanicilar.add("Serdar");
            kullanicilar.add("Ahmet");
            String isim = input.next();
            kullanicilar.add(isim);
            System.out.println(kullanicilar.get(2));

            /*ArrayList<String> ogrenciler = new ArrayList<String>();
            System.out.println("Kaydetmek İstediğiniz Öğrenci Sayısını Giriniz...");
            int sayi = input.nextInt();
            for (int i = 0; i < sayi; i++) {
                System.out.println((i + 1) + ".öğrenci adını giriniz:");
                String ogrenciAdi = input.next();
                ogrenciler.add(ogrenciAdi);
            }
            System.out.println("Tüm Öğrenciler Başarıyla Yüklendi");
            System.out.println("______________");
            System.out.println("EKLENECEK ÖĞRENCİLERİN LİSTESİ");
            for (int i = 0; i<sayi;i++) {
                System.out.println(ogrenciler.get(i));
            }*/
           /* ArrayList<String>isimler=new ArrayList<>();
            isimler.add("Serdar");
            isimler.add("Volkan");
            isimler.add("Kahraman");
            System.out.println(isimler.size());*/
            ArrayList<String> isimler = new ArrayList<>();
            isimler.add("Serdar");
            isimler.add("Volkan");
            isimler.add("Kahraman");
            isimler.remove(2);

        System.out.println(isimler.size());

            }
        }

