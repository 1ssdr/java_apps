import java.util.Scanner;
public class DenemeIfElse {
    public static void main(String[] args) {
       /* int gun = 5;
        if (gun == 1) {
            System.out.println("pazartesi");
        } else if (gun == 2) {
            System.out.println("sali");
        } else if (gun == 3) {
            System.out.println("carsamba");
        } else if (gun == 4) {
            System.out.println("persembe");
        } else if (gun == 5) {
            System.out.println("cuma");
        } else if (gun == 6) {
            System.out.println("cumartesi");
        } else if (gun == 7) {
            System.out.println("pazar");}
        else if (gun >=8) {
            System.out.println("gecersiz gun");

        }


            if (gun<=5){
                System.out.println("haftaici");}
            else if (gun<=7){System.out.println("haftasonu");}
            else  {System.out.println("gecersiz gun");}*/
        /*int ogrenci_no = 1;
        switch (ogrenci_no) {
            case 1:
                System.out.println("serdar");
                break;
            case 2:
                System.out.println("mehmet");
                break;
            case 3:
                System.out.println("ece");
                break;
            default:
                System.out.println("gecersiz_no");
                break;*/
        /*for (int i = 0; i <=100;i+=3) {
            System.out.println(i);*/
       /* Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int sonuc=(a+b);
        System.out.println(sonuc);*/
        //Scanner input = new Scanner(System.in);
       /* int a=input.nextInt();
        int sonuc=0;
        for (int i = 1; i<=a ; i++) {
            sonuc += i;
        }
                System.out.println(sonuc);*/

        System.out.println("basamagı bulunacak sayı");
        /*int a = input.nextInt();
        int sonuc = 1;

        for (int i = 1; i <= a; i++) {
            sonuc *= i;
        }
        System.out.println(sonuc);*/
        /*for (int i=1; i<100;i*=3) {
            int sonuc=i%3;

            if (sonuc==0){
                System.out.println(i);}*/
        /*System.out.println("vize_notu");
        double a = input.nextDouble();
        System.out.println("final_notu");
        double b = input.nextDouble();
        double ortalama = (a * 0.4) + (b * 0.6);
        System.out.println(ortalama);*/
        /*int a = 1;

        int carpma;

        for (int i = 1; i <= 10; i++) {

            carpma = a * i;

       System.out.println(a + "X" + i + "=" + carpma);*/
        /*Scanner input = new Scanner(System.in);
        System.out.println("sayı gir");
        double a= input.nextDouble();
         double sayac=1;
         double fakto = 1;
        while (sayac <= a)
        {
            fakto *= sayac;
            sayac++;
        }
            System.out.println(fakto);*/
       /* Scanner input = new Scanner(System.in);
        System.out.println("bir sayı gir");
        int a = input.nextInt();
        while (a>0){
            a-=2;
                    System.out.println(a);*/

        Scanner input = new Scanner(System.in);
        System.out.println("bir sayı gir");
        int a = input.nextInt();
        int basamak=1;
        while (a>=10) {
            a /=10;
            basamak++;
        }
            System.out.println(basamak);






        }






        }














