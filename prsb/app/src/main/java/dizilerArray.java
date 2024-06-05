import androidx.annotation.BinderThread;

import java.util.Arrays;
import java.util.Scanner;

public class dizilerArray {
    public static void main(String[] args) {
        /*String[]kullanicilar=new String[6];
        kullanicilar[0]="Serdar";
        kullanicilar[1]="Volkan";
        kullanicilar[2]="Gökhan";
        kullanicilar[3]="Mehmet";
        kullanicilar[4]="Ece";
        kullanicilar[5]="Ahmet";
        System.out.println(kullanicilar[2]);*/

        //Scanner input = new Scanner(System.in);
        /*int[]ogrenciNo = new int[10];
        String[]ogrenciAdi = new String[10];
        for (int i=0; i<10; i++)
        {
            System.out.print(i +"_ogrenci numarasini giriniz");
            ogrenciNo[i] = input.nextInt();
            System.out.print(i+"_ogrenci adini girin");
            ogrenciAdi[i] = input.next();*/

        /*System.out.println("eleman sayisi");
        int a = input.nextInt();
        Integer[] diziler = new Integer[a];
        for (int i = 0; i < a; i++) {
            diziler[i] = input.nextInt();
            System.out.println(diziler[i]);
        }

        if (diziler.length <= 10) {
            System.out.println("eleman sayisi az");
        } else if (diziler.length <= 20) {
            System.out.println("eleman sayisi yeterli");
        } else
            System.out.println("eleman sayisi fazlar");*/

       /* int[] notlar = {65, 78, 50, 95, 80};
        Arrays.sort(notlar);
        for (int i = 0; i < notlar.length; i++) {
            System.out.println(notlar[i]);}*/

        /*int[] notlar = new int[5];
        for (int i = 0; i < notlar.length; i++) {
            System.out.println(i + ". ogrencinin notunu giriniz");
            notlar[i] = input.nextInt();
        }
        Arrays.sort(notlar);
        for (int i = 0; i < notlar.length; i++) {
            System.out.println(notlar[i]);}*/

        /*int[] notlar = {40, 100, 70, 85, 77, 20, 55};
        int aranan = Arrays.binarySearch(notlar, 55);
        if (aranan < 0) {
            System.out.println("Değer dizi içerisinde mevcut değildir");
        } else System.out.println("Aranan değer dizinin " + aranan + ". indisinde yer almaktadır");*/

       /* boolean varyok=false;
        int[] notlar = {45, 65, 65, 98, 75, 12, 97};
        for (int i = 0; i < notlar.length; i++) {
            if (75 == notlar[i]) {
                varyok = true;
                break;
            }
        }
        if (varyok == true) {
            System.out.println("Dizide var");
        } else {
            System.out.println("Dizide yok");}*/

       /* boolean bulundubulunamadi = false;
        String[] ogrenciAdi = new String[10];
        for (int i = 0; i < 10; i++) ;
        {
            System.out.println( i + "ögrenci Adi");
            ogrenciAdi[i] = input.next();
            for (int i = 0; i < 10; i++) {

            System.out.println(i + "Ögrenci Adı");}
            String kullanıcı = input.next();

            for (int i = 0; i < ogrenciAdi.length; i++) {
                if (ogrenciAdi[i] = kullanıcı) {
                    bulundubulunamadı = true;
                    break;
                }
            }
            if (bulundubulunamadi = true) {
                System.out.println("Bulundu");
            } else System.out.println("Bulunamadı");
        }*/
       /* boolean bulunduBulunamadi = false;
        String[] ogrenciAdi = new String[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "_ögrenci Adi");
            ogrenciAdi[i] = input.next();
        }

        System.out.println("Öğrenci Adı Giriniz:");
        String kullanici = input.next();

        for (int j = 0; j < ogrenciAdi.length; j++) {
            if (ogrenciAdi[j].equals(kullanici)) {
                bulunduBulunamadi = true;
                break;
            }
        }

        if (bulunduBulunamadi) {
            System.out.println("Bulundu");
        } else {
            System.out.println("Bulunamadı");}*/


       /* String[] ogrenciAdi = new String[3];
        double[] vizeNot = new double[3];
        double[] finalNot = new double[3];
        double[] ortalama = new double[3];
        boolean control = false;
        for (int i = 0; i < ogrenciAdi.length; i++) {
            System.out.println(i + "_ogrenci Adi");
            ogrenciAdi[i] = input.next();
            System.out.println("vize:");
            vizeNot[i] = input.nextInt();
            System.out.println("final");
            finalNot[i] = input.nextInt();
        }
        System.out.println("Bulunacak Öğrenci Adi");
        String bulunacakogreci = input.next();


        for (int i = 0; i < ogrenciAdi.length; i++) {
            if (ogrenciAdi[i].equals(bulunacakogreci)) {
                ortalama[i] = (vizeNot[i] * 0.4) + (finalNot[i] * 0.6);
                control = true;
                System.out.println(ogrenciAdi[i] + " " + ortalama[i]);
                break;
            }

        }
        if (!control) {
            System.out.println("Öğrenci Bulunamadı");
        }*/

        /*String[] muvekkil = new String[2];
        String[] durasmayeri = new String[2];
        int[] dosyanumarasi = new int[2];
        boolean control = false;
        for (int i = 0; i < dosyanumarasi.length; i++) {
            System.out.println(i + "dosyanumarasi");
            dosyanumarasi[i] = input.nextInt();
            System.out.println("durusmayeri");
            durasmayeri[i] = input.next();
            System.out.println("muvekkil");
            muvekkil[i] = input.next();
        }
        System.out.println("Aranacak Dosya Numarası");
        int aranacakDosya = input.nextInt();

        for (int i = 0; i < dosyanumarasi.length; i++) {
            if (dosyanumarasi[i]==aranacakDosya) {
                control = true;
                System.out.println(dosyanumarasi[i]+" " + durasmayeri[i]+" "+muvekkil[i]);
                break;
            }
        }
        if (!control) {
            System.out.println("Bulunamadı");
        }*/


    }
}