package pnj.uts.aldycky_bagus_witjaksana.fragment.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.aldycky_bagus_witjaksana.LoginActivity;
import pnj.uts.aldycky_bagus_witjaksana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    SharedPreferences sharedPreferences;
    EditText edtEmail, edtNim, edtNama, edtKelas;
    Button actionLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("UtsAldyDataAlumni", Context.MODE_PRIVATE);

        edtEmail = view.findViewById(R.id.edtEmail);
        edtNim = view.findViewById(R.id.edtNim);
        edtNama = view.findViewById(R.id.edtNama);
        edtKelas = view.findViewById(R.id.edtKelas);
        actionLogout = view.findViewById(R.id.actionLogout);

        edtEmail.setText(sharedPreferences.getString("email", ""));
        edtNim.setText(sharedPreferences.getString("nim", ""));
        edtNama.setText(sharedPreferences.getString("nama", ""));
        edtKelas.setText(sharedPreferences.getString("kelas", ""));

        actionLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UtsAldyDataAlumni", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();

                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}