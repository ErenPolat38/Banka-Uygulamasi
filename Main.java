// Dosya Adı: Main.java
import java.util.Scanner;

public class Main {

    private static Banka banka = new Banka();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Basit Banka Simülasyonuna Hoş Geldiniz!");

        while (true) {
            System.out.println("\n--- ANA MENÜ ---");
            System.out.println("1. Yeni Hesap Aç");
            System.out.println("2. Para Yatır");
            System.out.println("3. Para Çek");
            System.out.println("4. Bakiye Görüntüle");
            System.out.println("5. Hesap Kapat");
            System.out.println("6. Faiz İşlet (Sadece Vadeli Hesaplar)");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    hesapAc();
                    break;
                case 2:
                    paraYatir();
                    break;
                case 3:
                    paraCek();
                    break;
                case 4:
                    bakiyeGoster();
                    break;
                case 5:
                    hesapKapat();
                    break;
                case 6:
                    faizIslet();
                    break;
                case 0:
                    System.out.println("Simülatörden çıkılıyor...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }

    private static void hesapAc() {
        System.out.println("Hesap Tipi Seçin: (1: Vadesiz, 2: Vadeli)");
        int tip = scanner.nextInt();
        scanner.nextLine(); // newline

        System.out.print("Müşteri Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Hesap Numarası (Örn: 1001): ");
        String hesapNo = scanner.nextLine();

        if (tip == 1) {
            VadesizHesap vh = new VadesizHesap(hesapNo, ad);
            banka.hesapAc(vh);
        } else if (tip == 2) {
            System.out.print("Faiz Oranı (Örn: 0.05): ");
            double faiz = scanner.nextDouble();
            VadeliHesap vdh = new VadeliHesap(hesapNo, ad, faiz);
            banka.hesapAc(vdh);
        } else {
            System.out.println("Geçersiz hesap tipi.");
        }
    }

    private static void paraYatir() {
        System.out.print("Hesap Numarası: ");
        String hesapNo = scanner.nextLine();
        Hesap hesap = banka.hesapBul(hesapNo);

        if (hesap != null) {
            System.out.print("Yatırılacak Miktar: ");
            double miktar = scanner.nextDouble();
            // ÇOK BİÇİMLİLİK:
            // 'hesap' değişkeninin türü 'Hesap' olmasına rağmen,
            // eğer bu VadesizHesap ise onun paraYatir'ı,
            // VadeliHesap ise onun paraYatir'ı çalışır.
            hesap.paraYatir(miktar);
        } else {
            System.out.println("Hesap bulunamadı.");
        }
    }

    private static void paraCek() {
        System.out.print("Hesap Numarası: ");
        String hesapNo = scanner.nextLine();
        Hesap hesap = banka.hesapBul(hesapNo);

        if (hesap != null) {
            System.out.print("Çekilecek Miktar: ");
            double miktar = scanner.nextDouble();
            // ÇOK BİÇİMLİLİK:
            // 'hesap.paraCek()' çağrısı, nesnenin gerçek türüne
            // (Vadesiz/Vadeli) göre farklı çalışacaktır.
            hesap.paraCek(miktar);
        } else {
            System.out.println("Hesap bulunamadı.");
        }
    }

    private static void bakiyeGoster() {
        System.out.print("Hesap Numarası: ");
        String hesapNo = scanner.nextLine();
        Hesap hesap = banka.hesapBul(hesapNo);
        if (hesap != null) {
            hesap.bakiyeGoster();
        } else {
            System.out.println("Hesap bulunamadı.");
        }
    }

    private static void hesapKapat() {
        System.out.print("Kapatılacak Hesap Numarası: ");
        String hesapNo = scanner.nextLine();
        banka.hesapKapat(hesapNo);
    }

    private static void faizIslet() {
        System.out.print("Hesap Numarası: ");
        String hesapNo = scanner.nextLine();
        Hesap hesap = banka.hesapBul(hesapNo);

        if (hesap == null) {
            System.out.println("Hesap bulunamadı.");
            return;
        }

        // 'instanceof' kontrolü ile nesnenin tipini kontrol ediyoruz
        if (hesap instanceof VadeliHesap) {
            // Güvenli tip dönüşümü (Casting)
            VadeliHesap vadeliHesap = (VadeliHesap) hesap;
            vadeliHesap.faizIslet();
        } else {
            System.out.println("Bu işlem sadece vadeli hesaplar için geçerlidir.");
        }
    }
}