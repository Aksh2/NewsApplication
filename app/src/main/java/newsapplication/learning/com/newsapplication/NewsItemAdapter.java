package newsapplication.learning.com.newsapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import newsapplication.learning.com.newsapplication.data.models.Article;
import newsapplication.learning.com.newsapplication.view.WebviewActivity;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {
    final String TAG = NewsItemAdapter.class.getSimpleName();
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<Article> articleList=new ArrayList<>();
    public NewsItemAdapter(Context context){
        this.context=context;
        this.layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG,"OnCreateViewHolder");
        final View itemView = this.layoutInflater
                .inflate(R.layout.item_news_article, viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG,"onBindViewHolder");
        final Article article = articleList.get(position);
        if(article!=null){
            Log.d(TAG,"Page Object: " + article);
            viewHolder.itemName.setText(article.getTitle());

          Glide.with(context)
                   .load(article.getUrlToImage()!=null?article.getUrlToImage():"http://fag.nuol.edu.la/images/no_photo.png")
                       .into(viewHolder.thumbnail);
        }


    }

    @Override
    public int getItemCount() {
        Log.d(TAG,"size:"+articleList.size());
        return articleList.size();
    }

    public void setData(List<Article> articleList){
        Log.d(TAG,"articleList:" +articleList);
        this.articleList=articleList;
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView itemName,description;
        private ImageView thumbnail;


        public ViewHolder(final View view){
            super(view);
            itemName = view.findViewById(R.id.itemTv);
            thumbnail = view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        String url=articleList.get(getAdapterPosition()).getUrl();
                        Log.d(TAG,"adapter url:"+url);
                        Intent webview =new Intent(v.getContext(),WebviewActivity.class);
                        webview.putExtra("url",url);
                        v.getContext().startActivity(webview);


                }
            });
        }
    }
}
