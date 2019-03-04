package newsapplication.learning.com.newsapplication.view;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import newsapplication.learning.com.newsapplication.NewsItemAdapter;
import newsapplication.learning.com.newsapplication.R;
import newsapplication.learning.com.newsapplication.data.models.Article;

public class MainActivity extends BaseActivity implements MainActivityPresenter.View {

    private NewsItemAdapter newsItemAdapter;
    private RecyclerView recyclerView;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeRecyclerView();
        initializePresenter();
        presenter.fetchArticles();

    }

    private void initializePresenter(){
        presenter=new MainActivityPresenter(this);
    }

    private void initializeViews(){
        recyclerView=findViewById(R.id.recycler_view);
    }

    private void initializeRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        newsItemAdapter = new NewsItemAdapter(this);
        recyclerView.setAdapter(newsItemAdapter);

    }

    @Override
    public void showNewsArticlesInList(List<Article> articleList) {
        newsItemAdapter.setData(articleList);

    }

    @Override
    protected void onResume() {
        super.onResume();
       // presenter.fetchArticles();

    }

}
