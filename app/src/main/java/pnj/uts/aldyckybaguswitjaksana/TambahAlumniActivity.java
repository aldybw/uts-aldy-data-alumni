package pnj.uts.aldyckybaguswitjaksana;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import pnj.uts.aldyckybaguswitjaksana.database.DatabaseHelper;

public class TambahAlumniActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNim, edtNamaAlumni, edtTempatLahir, edtTanggalLahir, edtAlamat, edtAgama, edtHp, edtTahunMasuk, edtTahunLulus, edtPekerjaan, edtJabatan;
    Button actionSimpan;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_alumni);
        edtNim = findViewById(R.id.edtNim);
        edtNamaAlumni = findViewById(R.id.edtNamaAlumni);
        edtTempatLahir = findViewById(R.id.edtTempatLahir);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtAgama = findViewById(R.id.edtAgama);
        edtHp = findViewById(R.id.edtHp);
        edtTahunMasuk = findViewById(R.id.edtTahunMasuk);
        edtTahunLulus = findViewById(R.id.edtTahunLulus);
        edtPekerjaan = findViewById(R.id.edtPekerjaan);
        edtJabatan = findViewById(R.id.edtJabatan);
        actionSimpan = findViewById(R.id.actionSimpan);

        edtTanggalLahir.setOnClickListener(this);
        actionSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtTanggalLahir:
                new DatePickerDialog(this, onDateSetListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.actionSimpan:
                if (edtNim.getText().toString().length() > 0 && edtNamaAlumni.getText().toString().length() > 0 && edtTempatLahir.getText().toString().length() > 0 && edtTanggalLahir.getText().toString().length() > 0 && edtAlamat.getText().toString().length() > 0 && edtAgama.getText().toString().length() > 0 && edtHp.getText().toString().length() > 0 && edtTahunMasuk.getText().toString().length() > 0 && edtTahunLulus.getText().toString().length() > 0 && edtPekerjaan.getText().toString().length() > 0 && edtJabatan.getText().toString().length() > 0) {
                    simpan();
                } else {
                    Toast.makeText(this, "Mohon Lengkapi Data", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }

    void simpan() {
        SQLiteDatabase database = new DatabaseHelper(this).getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nim", edtNim.getText().toString());
        contentValues.put("nama_alumni", edtNamaAlumni.getText().toString());
        contentValues.put("tempat_lahir", edtTempatLahir.getText().toString());
        contentValues.put("tanggal_lahir", edtTanggalLahir.getText().toString());
        contentValues.put("alamat", edtAlamat.getText().toString());
        contentValues.put("agama", edtAgama.getText().toString());
        contentValues.put("hp", edtHp.getText().toString());
        contentValues.put("tahun_masuk", edtTahunMasuk.getText().toString());
        contentValues.put("tahun_lulus", edtTahunLulus.getText().toString());
        contentValues.put("pekerjaan", edtPekerjaan.getText().toString());
        contentValues.put("jabatan", edtJabatan.getText().toString());

        long insert = database.insert("tb_alumni", null, contentValues);

        if (insert != -1) {
            Toast.makeText(this, "Tambah Alumni Berhasil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TambahAlumniActivity.this, DataAlumniActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Tambah Alumni Gagal", Toast.LENGTH_SHORT).show();
        }

        database.close();
    }

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
            edtTanggalLahir.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

}