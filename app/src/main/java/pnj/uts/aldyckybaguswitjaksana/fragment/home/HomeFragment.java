package pnj.uts.aldyckybaguswitjaksana.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.aldyckybaguswitjaksana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    TextView txtTitle, txtAbout1, txtAbout2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtTitle = view.findViewById(R.id.txtTitle);
        txtAbout1 = view.findViewById(R.id.txtAbout1);
        txtAbout2 = view.findViewById(R.id.txtAbout2);

        txtTitle.setText("Tentang Aplikasi");
        txtAbout1.setText("Aplikasi ini bernama Almabase. Semua nama-nama alumni kampus akan disimpan di sini. Anda juga bisa menambahkan data alumni terbaru dan mengedit nama alumni yang sudah ada serta menghapusnya.");
        txtAbout2.setText("Di dalam aplikasi ini juga, terdapat kumpulan berita yang bisa anda baca. Anda bisa login dan logout di dalam aplikasi ini sesuai dengan email dan password yang tertera di source code aplikasi ini. Ada juga halaman profile yang menyimpan data identitas anda sebagai user.");
    }
}