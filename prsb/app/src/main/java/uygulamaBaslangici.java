import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class uygulamaBaslangici {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> urunler = new ArrayList<String>();
        ArrayList<Integer> urunFiyati = new ArrayList<Integer>();
        ArrayList<Integer> urunMiktari = new ArrayList<Integer>();
        int sayac;
        while (1 == 1) {
            System.out.println("Market Uygulamasına Hoşgeldiniz");
            System.out.println();
            System.out.println("1- Ürünü Ekle");
            System.out.println("2- Ürünü Ara");
            System.out.println("3- Ürünü Sil");
            System.out.println("4- Ürünü Listele");
            System.out.println("5- Çıkış Yap");
            System.out.print("Seçiminiz: ");
            System.out.println();
            sayac = input.nextInt();

            while (sayac > 5) {
                System.out.println("Yanlış Değer");
                break;
            }
            //Ürün Ekleme
            while (sayac == 1) {
                System.out.print("Eklenecek Ürün Adı: ");
                String urunadi = input.next();
                urunler.add(urunadi);

                System.out.print("Eklenecek Ürünün Fiyatı: ");
                int urunFiyatiValue = input.nextInt();
                urunFiyati.add(urunFiyatiValue);

                System.out.print("Eklenecek Ürünün Miktarı: ");
                int urunMiktariValue = input.nextInt();
                urunMiktari.add(urunMiktariValue);

                System.out.println("Devam Etmek İçin 1 Tuşlayın");
                System.out.println("Çıkmak İçin 0 Tuşlayın");

                sayac = input.nextInt();
            }
            //Ürün Arama
            while (sayac == 2) {
                System.out.print("Aranacak Ürün Adı: ");
                String urunadi = input.next();
                for (int i = 0; i < urunler.size(); i++) {
                    if (urunler.get(i).equals(urunadi)) {
                        System.out.println("Ürün Adı:" + urunler.get(i));
                        System.out.println("Ürün Fiyatı:" + urunFiyati.get(i));
                        System.out.println("Ürün Miktarı:" + urunMiktari.get(i));
                    }
                }
                System.out.println("Devam Etmek İçin 1 Tuşlayın");
                System.out.println("Çıkmak İçin 0 Tuşlayın");

                sayac = input.nextInt();
                if (sayac == 1) {
                    sayac = 2;
                }

            }

            //Ürün Silme
            while (sayac == 3) {

                System.out.print("Silinecek Ürün Adı: ");
                String urunadi = input.next();

                for (int i = 0; i < urunler.size(); i++) {
                    if (urunler.get(i).equals(urunadi)) {
                        urunler.remove(i);
                        urunFiyati.remove(i);
                        urunMiktari.remove(i);
                    }
                }
                for (int i = 0; i < urunler.size(); i++) {
                    System.out.println();
                    System.out.println("Ürün Adı:" + urunler.get(i));
                    System.out.println("Ürün Fiyatı:" + urunFiyati.get(i));
                    System.out.println("Ürün Miktarı:" + urunMiktari.get(i));
                    System.out.println();
                }
                System.out.println("Devam Etmek İçin 1 Tuşlayın");
                System.out.println("Çıkmak İçin 0 Tuşlayın");

                sayac = input.nextInt();
                if (sayac == 1) {
                    sayac = 3;
                }
            }

            //Ürün Listeleme
            while (sayac == 4) {
                for (int i = 0; i < urunler.size(); i++) {
                    System.out.println("Ürün Adı:" + urunler.get(i));
                    System.out.println("Ürün Fiyatı:" + urunFiyati.get(i));
                    System.out.println("Ürün Miktarı:" + urunMiktari.get(i));
                    System.out.println();
                }
                System.out.println("Devam Etmek İçin 1 Tuşlayın");
                System.out.println("Çıkmak İçin 0 Tuşlayın");

                sayac = input.nextInt();
                if (sayac == 1) {
                    sayac = 4;
                }
            }

            //Çıkış
            if (sayac == 5) {
                System.out.println("Çıkış Yapılıyor");
                break;
            }
        }
    }
}

