package ac.id.pnj.utsaldydataalumni;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailBeritaActivity extends AppCompatActivity {

    ImageView imgBerita;
    TextView txtJudul, txtIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        imgBerita = findViewById(R.id.imgBerita);
        txtJudul = findViewById(R.id.txtJudul);
        txtIsi = findViewById(R.id.txtIsiBerita);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Glide.with(this).load(extras.getString("image", "")).placeholder(R.drawable.progress_bar).diskCacheStrategy(DiskCacheStrategy.NONE).into(imgBerita);
            txtIsi.setText(extras.getString("isi", ""));
            txtJudul.setText(extras.getString("judul", ""));
        }
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
                Intent intent1 = new Intent(DetailBeritaActivity.this, TambahAlumniActivity.class);
                startActivity(intent1);
                break;
            case R.id.actionMenu2:
                Intent intent2 = new Intent(DetailBeritaActivity.this, DataAlumniActivity.class);
                startActivity(intent2);
                break;
            case R.id.actionMenu3:
                SharedPreferences sharedPreferences = getSharedPreferences("UtsAldyDataAlumni", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();

                Intent intent3 = new Intent(DetailBeritaActivity.this, LoginActivity.class);
                startActivity(intent3);
                finish();

                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}