// Dosya Adı: Banka.java
import java.util.ArrayList;
import java.util.List;

public class Banka {

    // ÇOK BİÇİMLİLİK (Polymorphism):
    // Bu liste 'Hesap' türünde nesneleri tutar.
    // Ama biz bu listeye 'VadesizHesap' ve 'VadeliHesap' da ekleyebiliriz.
    // Çünkü ikisi de "bir Hesap" türüdür (Inheritance).
    private List<Hesap> hesapListesi;

    public Banka() {
        this.hesapListesi = new ArrayList<>();
    }

    public void hesapAc(Hesap yeniHesap) {
        if (yeniHesap != null) {
            this.hesapListesi.add(yeniHesap);
            System.out.println(yeniHesap.getHesapNumarasi() + " numaralı hesap başarıyla açıldı.");
        }
    }

    public void hesapKapat(String hesapNumarasi) {
        Hesap kapatilacakHesap = hesapBul(hesapNumarasi);
        if (kapatilacakHesap == null) {
            System.out.println("Hata: " + hesapNumarasi + " numaralı hesap bulunamadı.");
            return;
        }

        if (kapatilacakHesap.getBakiye() > 0) {
            System.out.println("Hesabı kapatmak için bakiye 0 olmalıdır. (Mevcut Bakiye: " + kapatilacakHesap.getBakiye() + ")");
        } else {
            this.hesapListesi.remove(kapatilacakHesap);
            System.out.println(hesapNumarasi + " numaralı hesap başarıyla kapatıldı.");
        }
    }

    // Hesap Numarasına göre hesabı bulan yardımcı bir metot
    public Hesap hesapBul(String hesapNumarasi) {
        for (Hesap hesap : this.hesapListesi) {
            if (hesap.getHesapNumarasi().equals(hesapNumarasi)) {
                return hesap;
            }
        }
        return null; // Bulunamadı
    }
}