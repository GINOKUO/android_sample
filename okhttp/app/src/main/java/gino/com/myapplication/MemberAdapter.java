package gino.com.myapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gino_kuo on 2018/9/10.
 */

class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    private Context context;
    private List<Member> memberList;

    MemberAdapter(Context context, List<Member> memberList) {
        this.context = context;
        this.memberList = memberList;
    }

    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_cardview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberAdapter.ViewHolder holder, int position) {
        final Member member = memberList.get(position);
        //holder.imageId.setImageResource(member.getImage());

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        OkHttpClient client = new OkHttpClient();

        String url = "https://ws1.sinaimg.cn/large/610dc034ly1fitcjyruajj20u011h412.jpg";

        try {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            InputStream is = response.body().byteStream();
            Bitmap bm = BitmapFactory.decodeStream(is);
            holder.imageId.setImageBitmap(bm);
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.textId.setText(String.valueOf(member.getId()));
        holder.textName.setText(member.getName());
        holder.textUrl.setText(member.getUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(member.getImage());
                Toast toast = new Toast(context);
                toast.setView(imageView);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return memberList.size();
    }

    //Adapter 需要一個 ViewHolder，只要實作它的 constructor 就好，保存起來的view會放在itemView裡面
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageId;
        TextView textId, textName,textUrl;
        ViewHolder(View itemView) {
            super(itemView);
            imageId = (ImageView) itemView.findViewById(R.id.imageId);
            textId = (TextView) itemView.findViewById(R.id.textId);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textUrl = (TextView) itemView.findViewById(R.id.textUrl);
        }
    }
}

