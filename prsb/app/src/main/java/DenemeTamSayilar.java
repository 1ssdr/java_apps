import java.sql.SQLOutput;

public class DenemeTamSayilar {
    public static void main(String[] args) {
        byte kucukSayi = 127;
        short kisaSayi = 32767;
        int tamSayi = 2147483647;
        long uzunSayi = 9223372036854775807L;

        System.out.println("byte: "+ kucukSayi);
        System.out.println("short: "+ kisaSayi);
        System.out.println("int: "+ tamSayi);
        System.out.println("long: "+ uzunSayi);

    }
}
