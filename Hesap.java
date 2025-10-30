// Dosya Adı: Hesap.java

/*
 * SOYUTLAMA (Abstraction):
 * Bu sınıf 'abstract' (soyut) olarak tanımlanmıştır.
 * Çünkü her banka hesabı bir türe (Vadesiz, Vadeli) sahip olmalıdır.
 * Doğrudan "Hesap" nesnesi oluşturulmasını engeller, alt sınıfların
 * oluşturulmasını zorunlu kılar.
 *
 * KAPSÜLLEME (Encapsulation):
 * Alanlar (bakiye, hesapNumarasi) 'private' veya 'protected' yapılarak
 * dışarıdan doğrudan erişim engellenmiştir. Erişime 'public' metotlar
 * (getter'lar ve paraYatir/paraCek) ile izin verilir.
 */
public abstract class Hesap {

    // protected: Bu sınıftan türeyen alt sınıflar (VadesizHesap gibi)
    // bu alana doğrudan erişebilir.
    protected double bakiye;

    // private: Sadece bu sınıf içinden erişilebilir.
    private String hesapNumarasi;
    private String musteriAdi;

    public Hesap(String hesapNumarasi, String musteriAdi) {
        this.hesapNumarasi = hesapNumarasi;
        this.musteriAdi = musteriAdi;
        this.bakiye = 0.0; // Her hesap 0 bakiye ile başlar
    }

    // --- Soyut Metotlar ---
    // Bu metotların içeriği burada yazılmaz.
    // Bu sınıfı 'extend' eden (miras alan) her alt sınıf,
    // bu metotları KENDİSİNE GÖRE doldurmak (override etmek) ZORUNDADIR.
    // Bu, aynı zamanda ÇOK BİÇİMLİLİK (Polymorphism) için zemin hazırlar.
    public abstract void paraYatir(double miktar);
    public abstract void paraCek(double miktar);

    // --- Somut (Concrete) Metot ---
    // Bu metot tüm alt sınıflar için ortaktır.
    public void bakiyeGoster() {
        System.out.println("--------------------");
        System.out.println("Hesap No: " + this.hesapNumarasi);
        System.out.println("Müşteri: " + this.musteriAdi);
        System.out.println("Bakiye: " + this.bakiye + " TL");
        System.out.println("--------------------");
    }

    // --- Getter Metotları (Kapsülleme) ---
    public String getHesapNumarasi() {
        return this.hesapNumarasi;
    }

    public double getBakiye() {
        return this.bakiye;
    }
}