// Dosya Adı: VadeliHesap.java

/*
 * KALITIM ve ÇOK BİÇİMLİLİK:
 * Bu sınıf da 'Hesap' sınıfından miras alır.
 * Kendine ait 'faizOrani' gibi ekstra bir özelliği vardır.
 * 'paraCek' metodu, vadesiz hesaptan farklı bir uyarı mesajı verir.
 */
public class VadeliHesap extends Hesap {

    private double faizOrani; // Örn: 0.05 (%5)

    public VadeliHesap(String hesapNumarasi, String musteriAdi, double faizOrani) {
        super(hesapNumarasi, musteriAdi);
        this.faizOrani = faizOrani;
    }

    @Override
    public void paraYatir(double miktar) {
        if (miktar > 0) {
            this.bakiye += miktar;
            System.out.println(miktar + " TL yatırıldı. Yeni bakiye: " + this.bakiye + " TL");
        } else {
            System.out.println("Geçersiz miktar.");
        }
    }

    @Override
    public void paraCek(double miktar) {
        // Vadeli hesaptan normalde vade bozulmadan para çekilmez.
        // Simülasyon için buna izin verebiliriz ama bir uyarı ile.
        System.out.println("UYARI: Vadeli hesaptan para çekmek vadeyi bozabilir!");

        if (miktar <= 0) {
            System.out.println("Geçersiz miktar.");
        } else if (miktar > this.bakiye) {
            System.out.println("Yetersiz bakiye!");
        } else {
            this.bakiye -= miktar;
            System.out.println(miktar + " TL çekildi. Yeni bakiye: " + this.bakiye + " TL");
        }
    }

    // VadeliHesap'a özel metot (Finansal Hesaplama)
    public void faizIslet() {
        double faizGetirisi = this.bakiye * this.faizOrani;
        this.bakiye += faizGetirisi;
        System.out.println(faizGetirisi + " TL faiz işledi. Yeni bakiye: " + this.bakiye + " TL");
    }
}