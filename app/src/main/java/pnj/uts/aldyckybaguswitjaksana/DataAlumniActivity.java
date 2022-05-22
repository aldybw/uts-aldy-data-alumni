package pnj.uts.aldyckybaguswitjaksana;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pnj.uts.aldyckybaguswitjaksana.adapter.AdapterAlumni;
import pnj.uts.aldyckybaguswitjaksana.database.DatabaseHelper;
import pnj.uts.aldyckybaguswitjaksana.model.AlumniModel;

public class DataAlumniActivity extends AppCompatActivity {

    ListView listView;
    AdapterAlumni adapterAlumni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_alumni);
        listView = findViewById(R.id.listView);
        adapterAlumni = new AdapterAlumni(this, R.layout.layout_item_list_alumni);
        listView.setAdapter(adapterAlumni);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlumniModel model = (AlumniModel) adapterView.getAdapter().getItem(i);

                Intent intent = new Intent(DataAlumniActivity.this, DetailAlumniActivity.class);
                intent.putExtra("id", model.getId());
                intent.putExtra("nim", model.getNim());
                intent.putExtra("namaAlumni", model.getNamaAlumni());
                intent.putExtra("tempatLahir", model.getTempatLahir());
                intent.putExtra("tanggalLahir", model.getTanggalLahir());
                intent.putExtra("alamat", model.getAlamat());
                intent.putExtra("agama", model.getAgama());
                intent.putExtra("hp", model.getHp());
                intent.putExtra("tahunMasuk", model.getTahunMasuk());
                intent.putExtra("tahunLulus", model.getTahunLulus());
                intent.putExtra("pekerjaan", model.getPekerjaan());
                intent.putExtra("jabatan", model.getJabatan());

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionMenu1:
                Intent intent1 = new Intent(DataAlumniActivity.this, TambahAlumniActivity.class);
                startActivity(intent1);
                break;
            case R.id.actionMenu2:
                Intent intent2 = new Intent(DataAlumniActivity.this, DataAlumniActivity.class);
                startActivity(intent2);
                break;
            case R.id.actionMenu3:
                SharedPreferences sharedPreferences = getSharedPreferences("UtsAldyDataAlumni", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();

                Intent intent3 = new Intent(DataAlumniActivity.this, LoginActivity.class);
                startActivity(intent3);
                finish();

                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    void getData() {
        adapterAlumni.clear();
        ArrayList<AlumniModel> datas = new ArrayList<>();
        SQLiteDatabase database = new DatabaseHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM tb_alumni", null);

        if (cursor.moveToFirst()) {
            do {
                AlumniModel model = new AlumniModel();
                model.setId(cursor.getInt(0));
                model.setNim(cursor.getString(1));
                model.setNamaAlumni(cursor.getString(2));
                model.setTempatLahir(cursor.getString(3));
                model.setTanggalLahir(cursor.getString(4));
                model.setAlamat(cursor.getString(5));
                model.setAgama(cursor.getString(6));
                model.setHp(cursor.getString(7));
                model.setTahunMasuk(cursor.getString(8));
                model.setTahunLulus(cursor.getString(9));
                model.setPekerjaan(cursor.getString(10));
                model.setJabatan(cursor.getString(11));
                datas.add(model);
            } while (cursor.moveToNext());
        }
        adapterAlumni.addAll(datas);
        adapterAlumni.notifyDataSetChanged();
    }
}