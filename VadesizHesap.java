// Dosya Adı: VadesizHesap.java

/*
 * KALITIM (Inheritance):
 * 'VadesizHesap', 'Hesap' sınıfının tüm özelliklerini
 * (bakiye, hesapNumarasi, bakiyeGoster() vb.) miras alır.
 * 'extends Hesap' anahtar kelimesi ile kalıtım sağlanır.
 *
 * ÇOK BİÇİMLİLİK (Polymorphism):
 * Ana 'Hesap' sınıfında 'abstract' olarak tanımlanan 'paraYatir' ve 'paraCek'
 * metotları burada '@Override' edilerek VadesizHesap'a özel olarak
 * yeniden yazılmıştır.
 */
public class VadesizHesap extends Hesap {

    public VadesizHesap(String hesapNumarasi, String musteriAdi) {
        // 'super()' anahtar kelimesi, üst sınıfın (Hesap)
        // constructor'ını çağırmak için kullanılır.
        super(hesapNumarasi, musteriAdi);
    }

    @Override
    public void paraYatir(double miktar) {
        if (miktar > 0) {
            this.bakiye += miktar; // 'bakiye' alanı 'protected' olduğu için erişilebilir
            System.out.println(miktar + " TL yatırıldı. Yeni bakiye: " + this.bakiye + " TL");
        } else {
            System.out.println("Geçersiz miktar.");
        }
    }

    @Override
    public void paraCek(double miktar) {
        if (miktar <= 0) {
            System.out.println("Geçersiz miktar.");
        } else if (miktar > this.bakiye) {
            System.out.println("Yetersiz bakiye! Çekilebilecek maksimum tutar: " + this.bakiye + " TL");
        } else {
            this.bakiye -= miktar;
            System.out.println(miktar + " TL çekildi. Yeni bakiye: " + this.bakiye + " TL");
        }
    }
}