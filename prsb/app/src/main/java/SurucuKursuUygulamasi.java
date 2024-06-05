import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SurucuKursuUygulamasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String>adayİsimleri=new ArrayList<String>();
        ArrayList<String>kayıtTarihi=new ArrayList<String>();
        ArrayList<String>kayıtFiyati=new ArrayList<String>();
        int sayac=0;

        while(1==1){
            System.out.println("1-Kayıt Ekle");
            System.out.println("2-Kayıt Ara");
            System.out.println("3-Kayıt Sil");
            System.out.println("4-Kayıtları Listele");
            System.out.println("5-Çıkış");
            System.out.println("Seçiminiz");
            System.out.println();

            sayac = input.nextInt();

            while(sayac>5){
                System.out.println("Yanlış Değer");
                break;
            }
            //Kayıt Ekle
            if (sayac == 1) {
                System.out.println("Adınız");
                String ad = input.next();
                adayİsimleri.add(ad);

                System.out.println("Kayıt Tarihi");
                String tarih = input.next();
                kayıtTarihi.add(tarih);

                System.out.println("Kayıt Fiyatı");
                String fiyat = input.next();
                kayıtFiyati.add(fiyat);

                System.out.println("Devam Etmek İçin 1 Tıkla");
                System.out.println("Çıkmak İçin 0 Tıkla");

                sayac = input.nextInt();
            }
            //Kayıt Ara
            if (sayac == 2) {
                System.out.println("Sürücünün Adı");
                String ad = input.next();
                for (int i = 0; i < adayİsimleri.size(); i++) {
                    if (adayİsimleri.get(i).equals(ad)) {
                        System.out.println("Sürücü Adı   :" + adayİsimleri.get(i));
                        System.out.println("Kayıt Tarihi :"+ kayıtTarihi.get(i));
                        System.out.println("Kayıt Fiyatı :"+ kayıtFiyati.get(i));
                    }
                }
                System.out.println("Devam Etmek İçin 1 Tıkla");
                System.out.println("Çıkmak İçin 0 Tıkla");

                sayac = input.nextInt();
            }
            //Kayıt Sil
            if (sayac == 3) {
                System.out.println("Sürücünün Adı");
                String ad = input.next();
                for (int i = 0; i < adayİsimleri.size(); i++) {
                    if (adayİsimleri.get(i).equals(ad)) {
                        adayİsimleri.remove(i);
                        kayıtTarihi.remove(i);
                        kayıtFiyati.remove(i);
                    }
                }
                System.out.println("Devam Etmek İçin 1 Tıkla");
                System.out.println("Çıkmak İçin 0 Tıkla");

                sayac = input.nextInt();
            }
            //Kayıtları Listele
            if (sayac == 4) {
                for (int i = 0; i < adayİsimleri.size(); i++) {
                    System.out.println("Sürücü Adı   :" + adayİsimleri.get(i));
                    System.out.println("Kayıt Tarihi :"+ kayıtTarihi.get(i));
                    System.out.println("Kayıt Fiyatı :"+ kayıtFiyati.get(i));
                }
                System.out.println("Devam Etmek İçin 1 Tıkla");
                System.out.println("Çıkmak İçin 0 Tıkla");

                sayac = input.nextInt();
            }
            //Çıkış
            if (sayac == 5) {
                System.out.println("Çıkış Yapılıyor");
                break;
            }
        }
    }
}
