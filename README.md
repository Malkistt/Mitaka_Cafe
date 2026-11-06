# ☕ Mitaka Cafe (Kopi dan Nyemil) - Android App

Aplikasi **Mitaka Cafe (Kopi dan Nyemil)** adalah purwarupa (prototype) aplikasi pemesanan makanan dan minuman berbasis Android. Aplikasi ini dirancang dengan antarmuka pengguna (UI) yang modern, hangat, dan minimalis ala kafe kekinian. 

Proyek ini dibuat untuk mendemonstrasikan implementasi *User Interface* (UI) dan navigasi di Android Studio menggunakan XML dan Kotlin, tanpa menggunakan integrasi *database* (menggunakan *dummy data* statis).

## ✨ Fitur Utama

Aplikasi ini mencakup beberapa alur layar utama:
1. **Splash Screen & Welcome**: Layar pembuka dengan logo kafe.
2. **Autentikasi (UI)**: Halaman *Sign Up*, *Login*, dan *Register* dengan desain form yang rapi menggunakan `TextInputLayout`.
3. **Katalog Menu (Home)**: Menampilkan daftar menu makanan dan minuman spesial hari ini menggunakan `RecyclerView`.
4. **Pemesanan (Order)**: Halaman untuk mengisi alamat pengiriman dan ringkasan pesanan.
5. **Konfirmasi Pesanan**: Halaman notifikasi ketika pesanan berhasil dibuat.
6. **Profil Pengguna**: Halaman untuk melihat dan mengubah nama pengguna.
7. **Bottom Navigation**: Navigasi bawah yang mulus untuk berpindah antara halaman Home, Order, dan Profile.

## 📱 Screenshot Tampilan

*(Catatan: Ganti URL gambar di bawah ini dengan path atau link gambar screenshot aplikasi Anda yang sudah diunggah ke folder `screenshots/` di GitHub)*

| Splash / Welcome | Sign Up | Login / Register |
| :---: | :---: | :---: |
| ![Splash](screenshot/splash.png) | ![SignUp](screenshot/signup.png) | ![Register](screenshot/register.png) |

| Home (Menu) | Order (Checkout) | Profile |
| :---: | :---: | :---: |
| ![Home](screenshot/home.png) | ![Order](screenshot/order.png) | ![Profile](screenshot/profile.png) |

## 🛠️ Teknologi yang Digunakan

*   **Bahasa Pemrograman**: [Kotlin](https://kotlinlang.org/)
*   **Desain Antarmuka (UI)**: XML
*   **IDE**: Android Studio
*   **Komponen Utama**: 
    *   `ConstraintLayout` (Tata letak responsif)
    *   `RecyclerView` (Daftar menu dinamis)
    *   `CardView` (Desain kartu menu dan form)
    *   `BottomNavigationView` (Navigasi utama)
    *   Material Design Components (`TextInputLayout`, `TextInputEditText`)

## 🚀 Cara Menjalankan Aplikasi Secara Lokal

Ikuti langkah-langkah berikut untuk menjalankan aplikasi ini di komputer Anda:

1. **Clone Repositori ini:**
   Buka terminal atau command prompt, lalu jalankan perintah berikut:
   ```bash
   git clone https://github.com/username-anda/nama-repositori-anda.git
   ```
2. **Buka di Android Studio:**
   * Buka Android Studio.
   * Pilih **File > Open**, lalu cari folder hasil *clone* repositori tadi.
3. **Sinkronisasi Gradle:**
   Tunggu beberapa saat hingga Android Studio selesai mengunduh semua *dependencies* dan melakukan proses *Gradle Sync*.
4. **Jalankan Aplikasi:**
   * Pastikan Anda sudah menyiapkan *Emulator* (Android Virtual Device) atau menyambungkan *smartphone* Android secara fisik (dengan USB Debugging aktif).
   * Klik tombol **Run** (ikon segitiga hijau  ▶️) di bagian atas panel Android Studio atau tekan `Shift + F10`.

## 📌 Catatan Pengembang
* Aplikasi ini tidak terhubung ke *database* asli (seperti Firebase atau SQLite). Semua data menu, harga, dan proses login/register menggunakan manipulasi alur navigasi (Intent) dan data statis (List) pada kode Kotlin.
* Fitur *Edge-to-Edge* telah dioptimalkan agar UI tidak tertutup oleh *System Bars* (Status Bar & Navigation Bar).