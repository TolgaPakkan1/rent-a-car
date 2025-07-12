# Rent A Car Projesi

**Geliştirici:** Tolga Pakkan  
**GitHub:** [github.com/TolgaPakkan1](https://github.com/TolgaPakkan1)

## Proje Amacı
Sayfaya kayıt olan müşteri login/logout işlemleri yapabilmeli, markaya göre araç sıralayıp seçebilmeli, seçilen tarih ve lokasyonlar doğrultusunda araçları görüntüleyebilmeli. Daha önce yaptığı kiralama işlemlerini görebilmeli.

Admin login/logout işlemleri yapabilmeli ve kendisi için tasarlanan sayfaya yönlendirilmelidir. Bütün araç ve markalar üzerinde silme/güncelleme/ekleme/görüntüleme işlemleri yapabilmeli, müşterilerin alışveriş detaylarını görüntüleyebilmeli ve araç teslim alındıktan sonra onay vermelidir.

---

## Kurulum ve Çalıştırma Adımları

### Gereksinimler
- Java 17
- Maven
- PostgreSQL
- IntelliJ IDEA (veya benzeri bir IDE)

### 1. Veritabanı Kurulumu
- PostgreSQL'de `rentacar` isimli bir veritabanı oluşturun.
- Kullanıcı adı ve şifreyi `application.properties` dosyasına uygun şekilde ayarlayın.

### 2. Projeyi Aç
- IntelliJ IDEA ile proje klasörünü açın (`pom.xml` dosyasını tanıyacaktır).

### 3. Maven ile Derle
```bash
mvn clean install
```

### 4. Projeyi Başlat
```bash
mvn spring-boot:run
```

### 5. Tarayıcıdan Erişim
- API Base URL: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`

---

## İndex Sayfası
Jwt token rölünüz User ise index sayfasına yönlendirilirsiniz.
İndex sayfasında araç alış/teslimat noktası ve alış/teslimat tarihi seçildikten sonra order sayfasına yönlendirilirsiniz.
Burada araçları markasına göre sıralayıp, seçtiğiniz tarihler arası toplam ödenecek tutar ve araç bilgilerini bulabilirsiniz.
Kiralama yapmadan önce araçların tamamına erişmek için index sayfasındayken navbar'da bulunan Cars'a tıklanarak bütün araçları görüntüleyebilirsiniz.
Order sayfasında kirala butonuna tıklandığında bir popup açılır, kiralamak istediğiniz araç bilgileri popupda gözükür ve son bir onay alır.
Ayrıca navbar üzerinden daha önce kiraladığınız araçların detaylarına erişebilirsiniz.
Kiraladığınız araç stoktan 1 adet düşer, kiralama sonrası stok 0'a inerse araç artık sistemde görüntülenmemektedir.

---

## Admin Sayfası
Jwt token rölünüz Admin ise admin sayfasına yönlendirilirsiniz. Burada tüm araçlar üzerinde güncelleme yapabilir (km,renk,görüntülenebilirlik,stok vb.), yeni araç ekleyebilir ve silebilirsiniz.
Araç markası silinirken içerisinde 1 yada daha fazla araç varsa, marka silme işlemi başarısız olur.
Bütün kullanıcıların kiralama geçmişini detaylı şekilde görüntüleyebilir ve Recieve Car butonuna tıklayarak aracın müşteriden alındığını teyit eder.
Araç müşteriden alındıktan sonra stoğu +1 olacak şekilde düzenlenir. Eğer aracın stoğu halihazırda 0 ve görüntülenmesi pasif ise stok 1 olur ve araç görünürlüğü aktif hale geçer.

---

## Kullanılan Teknolojiler
- Java
- Spring Boot
- Maven
- JWT
- HTML / CSS / JavaScript
- PostgreSQL
- Swagger