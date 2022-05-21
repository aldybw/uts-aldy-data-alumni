package ac.id.pnj.utsaldydataalumni.adapter;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import ac.id.pnj.utsaldydataalumni.R;
import ac.id.pnj.utsaldydataalumni.model.BeritaModel;

public class AdapterBerita extends ArrayAdapter<BeritaModel> {
    Context context;
    int resource;

    public AdapterBerita(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        BeritaModel model = getItem(position);

        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(resource,parent,false);
            holder = new Holder();
            holder.imageBerita = convertView.findViewById(R.id.imgBerita);
            holder.txtJudul = convertView.findViewById(R.id.txtJudul);
            holder.txtIsiBerita = convertView.findViewById(R.id.txtIsiBerita);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

//        Picasso.get().load(model.getImage()).into(holder.imageBerita);
        Glide.with(this.context).load(model.getImage()).placeholder(R.drawable.progress_bar).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.imageBerita);
        Log.e(this.context.toString(), model.getImage().toString());
        holder.txtJudul.setText(model.getJudulBerita());
        String isiBerita = model.getIsiBerita();
        String isiBeritaPendek = isiBerita.substring(0,40) + ". <font color=\"#40BFFF\">Read More</font>";
        holder.txtIsiBerita.setText(Html.fromHtml(isiBeritaPendek));

        return convertView;
    }

    class Holder {
        ImageView imageBerita;
        TextView txtJudul, txtIsiBerita;
    }
}
