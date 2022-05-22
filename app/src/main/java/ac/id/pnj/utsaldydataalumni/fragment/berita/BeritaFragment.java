package ac.id.pnj.utsaldydataalumni.fragment.berita;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ac.id.pnj.utsaldydataalumni.DetailBeritaActivity;
import ac.id.pnj.utsaldydataalumni.R;
import ac.id.pnj.utsaldydataalumni.adapter.AdapterBerita;
import ac.id.pnj.utsaldydataalumni.model.BeritaModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeritaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeritaFragment extends Fragment {

    GridView gridView;
    AdapterBerita adapterBerita;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = view.findViewById(R.id.gridView);

        adapterBerita = new AdapterBerita(getActivity(), R.layout.layout_item_list_berita);
        gridView.setAdapter(adapterBerita);
        loadDataList();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BeritaModel model = (BeritaModel) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getActivity(), DetailBeritaActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("judul", model.getJudulBerita());
                intent.putExtra("isi", model.getIsiBerita());
                startActivity(intent);

            }
        });
    }

    void loadDataList() {

        String[] image = new String[]{"https://akcdn.detik.net.id/community/media/visual/2022/05/22/mbappe_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/06/25/juru-bicara-pemerintah-untuk-penanganan-covid-19-achmad-yurianto-dok-bnpb_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/09/15/menkes-terawan-agus-putranto_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2020/06/28/jalur-sepeda-dibuka-meski-cfd-di-sudirman-thamrin-ditiadakan-7_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2022/02/01/kylian-mbappe-2_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2022/05/14/advbiznet-1.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2022/05/22/1132764528_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2022/05/21/pur-42-pria-asal-garut-yang-mencabuli-dua-orang-kakek_169.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2022/05/21/pria-di-bekasi-marah-saat-ditegur-untuk-tak-membuang-sampah-sembarangan_43.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2019/03/26/90d47c6a-9617-4d85-bbaf-a1c8e77d229b.jpeg?w=700&q=90"};

        String[] judul = new String[]{"Resmi! PSG Umumkan Mbappe Teken Kontrak Baru Sampai 2025",
                "Achmad Yurianto Dimakamkan di TPU Dadaprejo Kota Batu Besok Pagi",
                "Terawan Kenang Achmad Yurianto Sosok Gigih dan Pantas Diteladani",
                "Catat! Ini 6 Titik Car Free Day Jakarta yang Digelar Lagi Hari Ini",
                "Mbappe Batal ke Madrid, Presiden LaLiga Kecam Bos PSG",
                "Ini Dia Cara Speedtest Internet Biznet dengan Mudah",
                "Bukan Cuma Buat Gaya, Ini Lho Manfaat Pakai Compression Saat Olahraga",
                "Pria Beristri Diduga 4 Kali Cabuli Kakek di Garut",
                "Marah Ditegur Buang Sampah Sembarangan Bikin Pria di Bekasi Diburu Pemkot",
                "Ramai-ramai Kecam Kedubes Inggris Gegara Kibarkan Bendera LGBT"};

        String[] isiBerita = new String[]{"Kylian Mbappe diketahui memilih bertahan di Paris Saint-Germain. Kini PSG resmi mengumumkan Mbappe telah meneken kontrak baru berdurasi tiga tahun.\n" +
                "\n" +
                "\"Paris Saint-Germain dengan gembira mengumumkan bahwa Kylian Mbappe telah menandatangani perpanjangan kontrak dengan klub. Striker internasional Prancis itu telah membubuhkan tanda tangannya pada sebuah kesepakatan baru dengan the Parisians sampai 30 Juni 2025,\" bunyi pernyataan di laman resmi klub.\n" +
                "\n" +
                "Mbappe semula digadang-gadang akan bergabung dengan Real Madrid secara gratis karena kontrak awalnya dengan PSG akan habis pada musim panas nanti. Los Blancos sempat optimistis bisa mendaratkan pemenang Piala Dunia 2018 itu, dengan total investasi yang ditaksir sekitar 300 juta pound sterling (Rp 5,49 triliun).\n" +
                "\n" +
                "Mbappe juga disebut-sebut mendapat beberapa privilese. Pesepakbola berusia 23 tahun itu bisa ikut memutuskan pelatih, bisa bersuara pada kebijakan direktur olahraga, dan memiliki kewenangan terkait belanja dan penjualan pemain.\n" +
                "\n" +
                "\"Saya sangat bangga sekali dan sangat gembira - untuk Kylian, untuk suporter kami, dan seluruh keluarga PSG di seluruh dunia - bahwa kita akan melanjutkan perjalanan yang sangat indah ini bersama-sama. Untuk suporter dan klub kita, masa-masa terhebat klub kita ada di depan.\"\n" +
                "\n" +
                "Kylian Mbappe bisa dibilang tampil sebagai pemain paling berpengaruh bagi PSG sejak bergabung pada 2017. Mbappe telah mencetak 168 gol plus 87 assist dalam 216 penampilan di seluruh kompetisi, untuk membantu PSG memenangi 11 trofi domestik di antaranya empat titel Ligue 1, serta menjejak final Liga Champions untuk pertama kalinya.",
                "Jenazah eks Jubir Satgas COVID-19 Achmad Yurianto akan dimakamkan di di TPU Dadaprejo, Kota Batu, Jawa Timur (Jatim). Proses pemakaman akan dilakukan besok pagi.\n" +
                        "\n" +
                        "Dilansir detikJatim, Minggu (21/5/2022), jenazah Yuri malam ini disemayamkan di rumah duka Jalan Ir Soekarno, Kecamatan Junrejo, Kota Batu. Jenazah Yuri tiba di rumah duka sekitar pukul 21.17 WIB, diantar ambulans milik RS dr Syaiful Anwar (RSSA) Kota Batu.\n" +
                        "\n" +
                        "\"Keluarga sepakat, rencana dimakamkan besok (Minggu). Untuk waktunya kapan, belum ada kesepakatan, kemungkinan besok pagi di dekat sini (TPU),\" kata Yuliarti ditemui wartawan di rumah duka, Sabtu malam (21/5)\n" +
                        "\n" +
                        "Sri Yuliarti mengatakan Yuri dirujuk ke RS dr Syaiful Anwar (RSSA) Kota Malang sejak Kamis (19/5). Dia mengatakan Yuri sempat mengalami gejala stroke.\n" +
                        "\n" +
                        "\"Sejak Kamis kemarin dirujuk ke RSSA, sakitnya gejala stroke. Atas kesepakatan keluarga dirujuk ke RSSA,\" sebutnya.",
                "Mantan Menteri Kesehatan Terawan Agus Putranto ikut berduka atas meninggalnya Achmad Yurianto, Dewan Pengawas BPJS Kesehatan. Seperti diketahui, Achmad Yurianto juga menjabat sebagai Direktur Jenderal Pencegahan dan Pengendalian Penyakit Menular (P2P) Kementerian Kesehatan RI, di masa periode Terawan menjabat sebagai Menkes.\n" +
                        "\n" +
                        "\"Saya turut berbelasungkawa. Saya bersaksi beliau orang baik. Saya juga berterima kasih almarhum telah membantu negara dalam mengedukasi serta memberikan informasi kepada masyarakat di masa awal pandemi COVID-19,\" jelas Terawan, Sabtu (21/5/2022).\n" +
                        "\n" +
                        "\"Semoga beliau mendapat tempat terbaik disisiNya, dan keluarga yang ditinggalkan diberi ketabahan,\" kata dia.\n" +
                        "\n" +
                        "Sebagai informasi, Achmad Yurianto sempat mengemban amanah menjadi juru bicara pemerintah untuk penanganan COVID-19 bersamaan dengan Dirjen P2P. Yuri juga pernah menjabat staf ahli Menteri Kesehatan Bidang Teknologi Kesehatan dan Globalisasi hingga kemudian menjadi Ketua Dewan Pengawas BPJS Kesehatan.",
                "Car free day (CFD) atau hari bebas kendaraan bermotor (HBKB) diterapkan lagi di Jakarta mulai hari ini. Sebanyak 6 titik akan diterapkan CFD setiap akhir pekan.\n" +
                        "\n" +
                        "\"Seluruh masyarakat pengunjung HBKB yang akan beraktivitas di lokasi pelaksanaan HBKB terbatas agar memenuhi ketentuan-ketentuan yang telah ditetapkan untuk kebaikan bersama. Serta kami imbau untuk tetap membawa masker untuk digunakan saat suasana sangat ramai,\" kata Kepala Dinas Perhubungan DKI Jakarta Syafrin Liputo dalam keterangan tertulis, Jumat (20/5/2022).\n" +
                        "\n" +
                        "Syafrin mengatakan para pengunjung CFD diwajibkan untuk scan QR code PeduliLindungi atau menunjukkan sertifikat vaksin COVID-19 kedua. Syafrin mengimbau masyarakat agar taat protokol kesehatan.\n" +
                        "\n" +
                        "\"Pengunjung diwajibkan untuk scan QR code PeduliLindungi atau menunjukkan minimal sertifikat vaksin kedua,\" ujar Syafrin.\n" +
                        "\n" +
                        "Berikut daftar 6 lokasi CFD Jakarta:\n" +
                        "\n" +
                        "1. Jalan Jend. Sudirman-Jl MH Thamrin (Patung Arjuna Wijaya s.d. Patung Pemuda Membangun)\n" +
                        "2. Jalan Sisingamangaraja (Patung Pemuda Membangun s.d. CSW), Jakarta Selatan\n" +
                        "3. Jalan Tomang Raya (Simpang Tomang s.d. Business Hotel Tomang), Jakarta Barat\n" +
                        "4. Jalan Danau Sunter Selatan (Simpang Karya Beton s.d. GOR Sunter), Jakarta Utara\n" +
                        "5. Jalan Suryo Pranoto (Simpang Harmoni s.d. Simpang RSUD Tarakan), Jakarta Pusat\n" +
                        "6. Jalan Pemuda (Simpang Arion s.d. Simpang TU-GAS), Jakarta Timur\n" +
                        "\n" +
                        "Lansia-Komorbid Diminta Pake Masker\n" +
                        "Wagub DKI Jakarta Ahmad Riza Patria memberikan sejumlah imbauan kepada warga yang hendak hadir ke CFD. Riza meminta kepada lansia dan orang yang memiliki penyakit penyerta untuk memakai masker.\n" +
                        "\n" +
                        "\"Alhamdulillah, Presiden (Joko Widodo) mengumumkan sudah diberi kesempatan di tempat-tempat terbuka. Tapi seperti yang disampaikan Presiden, bagi lansia, komorbid, yang sakit ada gejala, batuk, pilek, dan lain-lain disarankan pakai masker,\" kata Wakil Gubernur DKI Jakarta Ahmad Riza Patria kepada wartawan di Politeknik Ahli Usaha Perikanan, Jakarta Selatan, Sabtu (21/5).\n" +
                        "\n" +
                        "\"Kita minta masyarakat jaga jarak, cuci tangan. Sekalipun diberi kesempatan untuk melepas masker di tempat terbuka, yang luas, yang bebas, kita minta tetap perhatikan prokes,\" imbau Riza.",
                "Javier Tebas tak habis pikir bagaimana Paris-Saint Germain bisa mempertahankan Kylian Mbappe dari kejaran Real Madrid. Dia pun mengecam Nasser Al-Khelaifi.\n" +
                        "\n" +
                        "Saga transfer Mbappe nampaknya menemui titik akhir. Bintang 23 tahun itu kabarnya memilih bertahan di PSG ketimbang bergabung ke Madrid.\n" +
                        "\n" +
                        "Mbappe sebelumnya sempat diisukan setuju dengan penawaran Madrid. Namun, pihak PSG juga memberinya iming-iming menggiurkan guna memperpanjang kontraknya.\n" +
                        "\n" +
                        "Kendati demikian, PSG juga menawarkan keuntungan lebih buat Mbappe. Juara Piala Dunia 2018 itu disebut-sebut akan diberi suara dalam pemilihan pelatih dan juga direktur olahraga klub.\n" +
                        "\n" +
                        "Tidak hanya itu, Mbappe juga diberi suara untuk menilai siapa-siapa saja yang perlu direkrut PSG demi memantapkan skuad menjadi yang terbaik di Eropa. Hal ini yang tidak diberikan Madrid.\n" +
                        "\n" +
                        "Kabar pembatalan transfer Mbappe ke Madrid mendapat komentar pedas dari Javier Tebas. Menurutnya, tidak masuk akal PSG jor-joran mempertahankan Mbappe di saat keuangan klub bermasalah.\n" +
                        "\n" +
                        "\"Apa yang PSG lakukan dengan memperpanjang Mbappe melalui sejumlah uang yang amat besar... setelah kehilangan 700 juta euro musim ini dan memiliki lebih dari 600 juta euro untuk bayaran gaji adalah penghinaan bagi sepakbola,\" kata Tebas dalam cuitannya di Twitter.\n" +
                        "\n" +
                        "\"Al-Khelaifi sama berbahayanya dengan Super League,\" pungkasnya.",
                "Internet kini menjadi kebutuhan yang tidak dapat dipisahkan. Terutama saat ini semua kegiatan membutuhkan jaringan Internet, mulai dari bekerja, sekolah, bermain game, streaming video hingga berbelanja online. Ketika kecepatan internet terasa lambat tentu akan mengganggu aktivitas kita, nah untuk itu penting bagi kita mengetahui berapa kecepatan dari jaringan internet yang kita gunakan.\n" +
                        "\n" +
                        "Mengetahui dengan pasti kecepatan internet yang kamu gunakan terkadang memberikan satu kepuasan, terlebih lagi jika hasilnya menunjukkan angka yang cukup tinggi. Tentu test kecepatan internet yang dilakukan akan bisa membawa pengaruh baik untuk mood kamu. Kamu bisa cek koneksi internet dengan mudah melalui situs web, dan tentunya kamu akan mendapat informasi mengenai kecepatan download, upload, hingga ping jaringan Internet yang digunakan.\n" +
                        "\n" +
                        "Speedtest dari Biznet\n" +
                        "\n" +
                        "Kamu dapat mencoba web speedtest dari Biznet dengan cepat dan mudah. Karena pengecekan kecepatan internet akan berlangsung secara otomatis sesaat setelah web terbuka melalui perangkat yang kamu gunakan, dan kamu sudah bisa mendapat informasi lengkap mengenai kecepatan download dan kecepatan upload internet yang kamu gunakan di rumah. Untuk itu kamu dapat mencobanya dengan mengakses ke https://speedtest.biznetnetworks.com.\n" +
                        "\n" +
                        "Nah, itu tadi salah satu cara untuk melakukan test kecepatan Internet yang kamu miliki. Namun perlu diketahui bahwa sifat dari hasil yang ditunjukkan tidak benar-benar menunjukkan angka pasti. Hal ini karena naik-turunnya hasil kecepatan yg ditampilkan akan sangat dinamis, tergantung dari beberapa faktor.\n" +
                        "\n" +
                        "Apa yang Mempengaruhi Hasil Speedtest?\n" +
                        "\n" +
                        "1. Kualitas Internet\n" +
                        "\n" +
                        "Kualitas Internet bisa di lihat dari modem dan bandwidth yang digunakan, karena kecepatan modem biasanya bervariasi. Perlu diketahui, bahwa semakin cepat kecepatan modem tersebut, maka akan semakin cepat pula kecepatan akses yang didapat.\n" +
                        "\n" +
                        "Bandwidth adalah luas cakupan frekuensi yang digunakan oleh sinyal dalam medium transmisi. Semakin besar bandwidth yang disediakan oleh ISP, maka kecepatan internet juga akan menjadi semakin cepat.\n" +
                        "\n" +
                        "2. Letak Posisi WiFi\n" +
                        "\n" +
                        "Posisi WiFi bisa mempengaruhi kecepatan akses internet. Pasalnya, ada beberapa tempat yang support dengan akses internet jika sinyal WiFi kurang menjangkau area rumah. Maka kamu harus memilih perangkat dengan teknologi yang ter-update, agar jaringan WiFi kamu bisa lebih cepat dan terkoneksi ke semua ruangan. Selain itu kamu juga harus tau posisi meletakkan perangkat yang tepat, serta melakukan pengaturan Access Point yang sesuai.\n" +
                        "\n" +
                        "3. Perangkat yang Digunakan\n" +
                        "\n" +
                        "Seperti smartphone, komputer, dan gadget lainnya juga sangat berperan dalam cepat atau tidaknya akses internet yang didapat. Karena di dalamnya terdapat perangkat keras yang mempengaruhi. Di antaranya adalah RAM, prosesor, dan harddisk yang berperan pada proses kerja komputer. Jika salah satunya saja memiliki kecepatan rendah, maka kecepatan akses pada internet juga akan menjadi rendah.\n" +
                        "\n" +
                        "Untuk mendapatkan hasil yang simetris antara download dan upload, kamu bisa menggunakan layanan Biznet Home. Dengan layanan ini kamu akan mendapatkan kecepatan Internet yang tinggi serta stabil. Hal tersebut dibuktikan dengan Biznet berhasil menduduki peringkat teratas sebagai provider fixed broadband internet tercepat berdasarkan Speed Score tertinggi di angka 42.17 yang resmi dikeluarkan oleh Speedtest dari hasil pengujian yang dilakukan Ookla.\n" +
                        "\n" +
                        "Jadi tunggu apa lagi? Cek layanan yang sesuai kebutuhan kamu serta cakupan areanya, dan rasakan pengalaman Internet terbaik dari Biznet Home sekarang juga!\n" +
                        "\n" +
                        "Untuk informasi tentang perusahaan dan layanan Biznet Home, kamu dapat mengunjungi:\n" +
                        "\n" +
                        "biznethome.net\n" +
                        "Biznet Store terdekat di kota kamu, untuk daftar lokasi dapat dilihat di https://www.biznetnetworks.com/location\n" +
                        "Live Chat di biznethome.net\n" +
                        "Call Center Biznet Home 1500933. (adv/adv)",
                "Compression garment atau pakaian kompresi merupakan setelan pakaian olahraga yang didesain khusus sangat pas dan ketat di kulit. Dalam konteks olahraga, pakaian kompresi memberikan dukungan bagi otot untuk untuk melakukan proses recovery (penyembuhan) lebih cepat.\n" +
                        "\n" +
                        "Hal tersebut sebagaimana dikatakan oleh dr Bernadette Laura dari Royal Sports Performance Centre. Menurutnya, memakai pakaian kompresi membuat peradangan otot lebih cepat sembuh.\n" +
                        "\n" +
                        "\"Setiap habis olahraga kan pasti otot itu mengalami nyeri atau peradangan karena proses latihan, nah menurut penelitian yang saya baca dengan memakai compression garment itu bisa mengurangi peradangan 3% lebih cepat. Ini tidak bisa dilakukan pakaian biasa,\" ujar dr Laura di sela Workout Class 2XU di Mall Kota Kasablanka, Sabtu (21/5/2022).\n" +
                        "\n" +
                        "\"Tapi ini penelitian yang perlu dilanjutkan karena yang saya baca itu tahun 2013,\" sambungnya.\n" +
                        "\n" +
                        "\"Kalau untuk pakaian olahraga nggak perlu nunggu jago dulu ya baru ganti yang bagus, senyaman kita aja pakainya. Memang apapun itu olahraganya, mau jogging atau bersepeda tetap butuh namanya recovery outfit. Jangan sampai olahraga ringan malah cedera,\" bebernya.\n" +
                        "\n" +
                        "Pakaian kompresi untuk olahraga memang terbilang cukup mahal, namun mengandung fungsi recovery yang penting bagi tubuh.\n" +
                        "\n" +
                        "\"Memang kalau harga lebih mahal yah, tapi penting untuk mengoptimalkan olahraga yang ditekuni. Tapi senyamannya aja,\" tambahnya.\n" +
                        "\n" +
                        "Dikutip dari WebMD, dalam olahraga memang dikenal konsep RICE (Rest, Ice, Compression, Elevation) yang berfungsi sebagai proses penyembuhan (recovery) setelah berolahraga atau ketika mengalami cedera ringan.\n" +
                        "\n" +
                        "Berikut ini uraian tentang konsep RICE sebagai proses recovery setelah berolahraga:\n" +
                        "\n" +
                        "Ice (Es)\n" +
                        "Es terbukti ampuh untuk mengurangi rasa sakit dan pembengkakan. Kompres es (ditutupi dengan handuk penyerap ringan untuk membantu mencegah terlalu dingin) selama 15-20 menit setiap dua hingga tiga jam. Lakukan ini selama 24 hingga 48 jam pertama setelah cedera.\n" +
                        "\n" +
                        "Compression (Kompresi)\n" +
                        "Kompresi berarti membungkus area yang terluka untuk mencegah pembengkakan. Bungkus area yang terkena dengan perban medis elastis. Saat ini pakaian kompresi bisa dipakai untuk membantu proses penyembuhan cedera.\n" +
                        "\n" +
                        "Elevation (Meninggikan)\n" +
                        "Konsepnya yaitu meninggikan posisi bagian tubuh yang cedera sejajar dengan dada atau jantung. Misal ketika kaki sakit bisa disandarkan pada bantal atau sofa dengan posisi sedikit lebih tinggi dari tubuh yang berbaring.",
                "PUR (42) ditangkap usai dilaporkan warga mencabuli 2 orang kakek di Garut, Jawa Barat (Jabar). Polisi mengungkap PUR sudah 4 kali melakukan aksi bejatnya itu.\n" +
                        "\n" +
                        "Dikutip dari detikJabar, Minggu (22/5/2022), kasus pencabulan dilakukan pria asal Kecamatan Banjarwangi terhadap dua orang korban yang masing-masing berusia 70 dan 79 tahun. Aksi bejat itu berlangsung beberapa kali pada bulan Maret hingga Mei tahun lalu.\n" +
                        "\n" +
                        "\"Sehingga total ada 4 kali kejadian pencabulan yang dilakukan tersangka,\" ujar Wirdhanto, Sabtu (21/5).\n" +
                        "\n" +
                        "Polisi menyebut aksi bejat pria beristri itu terungkap setelah keluarga mendapatkan pengakuan mengejutkan dari korban. Keluarga pun membuat laporan kepada polisi.\n" +
                        "\n" +
                        "\"Dari laporan tersebut, tersangka kemudian kita amankan,\" kata Wirdhanto.",
                "Seorang pria paruh baya kedapatan membuang sekarung sampah di sebuah lahan, Bekasi, Jawa Barat (Jabar). Aksinya dilihat oleh warga yang melintas, kemudian berujung teguran agar tak membuang sampah sembarangan.\n" +
                        "\n" +
                        "Pria paruh baya tersebut lantas membela diri dan terlibat perdebatan dengan penegur. Sosok pembuang sampah itu kemudian direkam dalam video dan viral di media sosial.\n" +
                        "\n" +
                        "\"Ini video diambil 5 Mei 2022, berawal kami menegur dengan baik terhadap bapak di video ini, dikarenakan membuang sampah berkarung dan plastik dengan jumlah banyak. Bapak dan ibu ini membuang sampah bukan pada tempat pembuangan sampah (TPS/TPA), melainkan di lahan ruko perumahan. Tapi tanggapan bapak ini berbicara dengan tidak sopan,\" ucap akun TikTok @orieyancelia, seperti dilihat detikcom dalam video tersebut, Sabtu (21/5/2022).\n" +
                        "\n" +
                        "Kejadian tersebut terjadi di Rawalumbu, Kota Bekasi, Jawa Barat (Jabar). Pria paruh baya yang terlihat mengenakan topi abu, baju hitam, jaket biru dan celana panjang hitam itu bicara berhadap-hadapan dengan pria yang menegurnya.\n" +
                        "\n" +
                        "Perekam juga merekam sosok perempuan yang diduga istri pembuang sampah. Perekam terdengar sesekali menimpali perdebatan antara penegur dengan pembuang sampah.\n" +
                        "\n" +
                        "Menyikapi perilaku pria paruh baya dalam video yang viral itu, Kepala Dinas Lingkungan Hidup Pemerintah Kota Bekasi Yayan Yuliana mengatakan akan mencari identitas pembuang sampah. Nantinya, jika ketemu, petugas kebersihan Pemkot Bekasi akan memberikan pemahaman tentang perilaku bapak tersebut yang salah.\n" +
                        "\n" +
                        "\"Kita sudah memerintahkan kepada Kepala Unit Pelayanan Teknis Dinas (UPTD) Rawalumbu, supaya melihat langsung ke lokasi. Kalau ada si yang buang sampah itu, Bapak yang ngamuk ditegur. Kita coba cari identitasnya, kemudian menemui orangnya, ya kita akan mengasih pemahaman, karena tindakan mereka yang salah,\" ujarnya kepada detikcom.\n" +
                        "\n" +
                        "Yayan kemudian mengapresiasi si penegur, lantaran berani bersuara dan peduli terhadap kebersihan lingkungan. Yayan berharap dengan viralnya video tersebut, maka akan tumbuh kesadaran masyarakat untuk tak membuang sampah sembarangan.\n" +
                        "\n" +
                        "\"Saya mengapresiasi kepada warga yang masih peduli terhadap kebersihan, peduli pada lingkungan di sekitarnya, saya tidak apa-apa menjadi viral. Dengan viralnya itu, tumbuh kesadaran masyarakat, dan masyarakat tidak membuang sampah sembarangan dan mengingatkan kepada masyarakat yang lain juga,\" kata Yayan.\n" +
                        "\n" +
                        "Yayan memang mengakui masih banyak masyarakat Kota Bekasi yang membuang sampah sembarangan, walaupun sudah ada sanksi yang mengatur hal tersebut. \"Saat ini kan kita sudah memberikan sanksi kepada masyarakat yang membuang sampah sembarangan, kan masih ada saja gitu (buang sampah sembarangan),\" imbuhnya.",
                "Bendera pelangi berkibar di Kedutaan Besar Inggris untuk Indonesia, di Jakarta. Pelbagai kelompok ini kemudian menyuarakan kecaman atas berkibarnya bendera Lesbian, Gay, Biseksual, dan Transgender (LGBT) itu.\n" +
                        "\n" +
                        "17 Mei 2020, bendera itu dikerek di tiang bendera Kedubes Inggris, berjejer dengan bendera Inggris Union Jack. Momen 17 Mei adalah Hari anti-homofobia diperingati dunia setiap 17 Mei. Dilansir situs resmi Organisasi Kesehatan Dunia (WHO), lembaga ini telah menghapus homoseksualitas dari klasifikasi internasional tentang penyakit pada 17 Mei 1990.\n" +
                        "\n" +
                        "\"Kemarin, pada Hari Internasional Melawan Homofobia, Bifobia, dan Transfobia (IDAHOBIT) - kami mengibarkan bendera LGBT+ dan menggelar acara, demi kita semua yang merupakan bagian dari satu keluarga manusia,\" demikian keterangan Kedutaan Besar Inggris untuk RI via akun resmi Instagram-nya, diakses detikcom, Sabtu (21/5) kemarin.\n" +
                        "\n" +
                        "Sejurus kemudian, meluncurlah kecaman-kecaman terhadap pengibaran bendera LGBT di Jakarta. Mayoritas kecaman berasal dari kalangan agama.\n" +
                        "\n" +
                        "Kedubes Inggris untuk RI memposting dukungan atas LGBT Foto: Kedubes Inggris untuk RI memposting dukungan atas LGBT (dok.Instagram @ukinindonesia)\n" +
                        "\n" +
                        "Muhammadiyah\n" +
                        "Ketua PP Muhammadiyah Anwar Abbas bereaksi. Mewakili ormasnya, Anwar mengemukakan penilaian bahwa Kedubes Inggris tidak menghormati Indonesia lantaran mengibarkan bendera LGBT itu.\n" +
                        "\n" +
                        "\"Muhammadiyah sangat menyesalkan sikap Kedubes Inggris yang tidak menghormati negara Republik Indonesia dengan mengibarkan bendera LGBT. Mereka harus tahu bahwa bangsa Indonesia punya falsafah Pancasila, di mana bangsa Indonesia sangat menghormati nilai-nilai dari ajaran agama,\" ucap Anwar Abbas seperti dalam keterangannya, Sabtu (21/5) kemarin.\n" +
                        "\n" +
                        "MUI\n" +
                        "Ketua MUI Bidang Fatwa Asrorun Niam Sholeh mengatakan bahwa aksi dari Kedubes Inggris ini bisa memicu ketegangan. Sebab, ini tidak sejalan dengan keadaban etika persahabatan.\n" +
                        "\n" +
                        "\"Langkah yang mempertontonkan pemihakan dan atau kampanye terhadap norma yang bertentangan dengan norma masyarakat Indonesia adalah tindakan yang tidak sejalan dengan keadaban etika persahabatan. Dan itu bisa memicu ketegangan yang seharusnya dihindari,\" kata Asrorun saat dihubungi detikcom, Sabtu (21/5/2022).\n" +
                        "\n" +
                        "\"Pengabaian terhadap norma yang hidup di masyarakat Indonesia adalah pelecehan,\" lanjutnya.\n" +
                        "\n" +
                        "PWNU Jatim\n" +
                        "Dari Ibu Kota Jawa Timur, Pengurus Wilayah Nahdlatul Ulama (PWNU) Jawa Timur mengecam keras pemasangan bendera LGBT tersebut. Wakil Ketua PWNU Jatim Abdussalam Shohib menegaskan, pengibaran bendera LGBT sama saja tidak menghormati Indonesia.\n" +
                        "\n" +
                        "\"Tentu kami, PWNU Jatim menyayangkan seharusnya mereka menghormati sikap Indonesia terkait LGBT. Indonesia sebagai negara mayoritas muslim kemudian punya adat ketimuran, selama ini tegas LGBT adalah ilegal,\" tegas pria yang akrab disapa Gus Salam tersebut kepada detikjatim, Sabtu (21/5).\n" +
                        "\n" +
                        "Pakar hukum internasional dari UI\n" +
                        "Pakar hukum internasional dari Universitas Indonesia menilai pemasangan bendera pelangi LGBT oleh Kedubes Inggris itu sebagai tindakan yang tidak baik. Kedubes Inggris tentu sadar sikap arus utama di Indonesia tidak suka dengan LGBT.\n" +
                        "\n" +
                        "\"Justru pengibaran bendera LGBT dipersepsi oleh sebagian besar publik Indonesia sebagai suatu tindakan provokatif,\" kata Hikmahanto kepada detikcom, Sabtu (21/5/2022).\n" +
                        "\n" +
                        "Guru Besar Hukum Internasional UI Hikmahanto Juwana dalam diskusi 'Warga Tanpa Warga Negara' di kantor Para Syndicate, Jakarta, Jumat (19/8/2016) Foto: Ari Saputra\n" +
                        "\n" +
                        "\"Buntut dari pengibaran bendera LGBT di Kedutaan Inggris sebaiknya Kemlu segera memanggil Dubes Inggris untuk Indonesia,\" kata Hikmahanto.\n" +
                        "\n" +
                        "Wakil rakyat dari PKB\n" +
                        "Wakil Ketua Komisi VIII DPR RI Marwan Dasopang mengaku prihatin atas pengibaran bendera pelangi LGBT di Kedutaan Besar Inggris. Kemlu RI dapat mempertanyakan maksud dari Kedubes Inggris mengibarkan bendera tersebut.\n" +
                        "\n" +
                        "\"LGBT di Indonesia itu masih dilarang, karena semua UU terkait dengan perkawinan itu semua pasalnya tidak memperbolehkan. Maka, ketika membahas UU penghapusan TPKS pada masa lalu kenapa menjadi alot karena beririsan dengan hasrat. Maka dapat dicerminkan bahwa masyarakat Indonesia memaknai hak asasi itu adalah yang tidak bertentangan juga dengan norma,\" kata Marwan saat dihubungi.\n" +
                        "\n" +
                        "Baca juga:\n" +
                        "Kemlu Bakal Minta Klarifikasi Dubes Inggris soal Bendera LGBT\n" +
                        "Ketua Gerindra Jatim\n" +
                        "Ketua DPD Gerindra Jatim Anwar Sadad menyebut Inggris seharusnya bisa menjaga hubungan baik dengan Indonesia. Salah satu caranya, tidak mengibarkan bendera LGBT.\n" +
                        "\n" +
                        "\"Tidak sepantasnya Kedubes Inggris mengibarkan bendera LGBT di kantornya di Jakarta. Persahabatan Inggris-Indonesia harusnya tidak dalam pengertian secara fisik, tapi juga dalam bentuk penghormatan terhadap prinsip dan keyakinan masing-masing,\" kata Sadad melalui keterangan yang diterima detikJatim.\n" +
                        "\n" +
                        "(dnu/lir)"};

        for (int i = 0; i < image.length; i++) {
            BeritaModel model = new BeritaModel();
            model.setImage(image[i]);
            model.setJudulBerita(judul[i]);
            model.setIsiBerita(isiBerita[i]);
            adapterBerita.add(model);
        }
        adapterBerita.notifyDataSetChanged();
    }
}