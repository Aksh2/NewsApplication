package newsapplication.learning.com.newsapplication.view;

import android.util.Log;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import newsapplication.learning.com.newsapplication.data.models.Article;
import newsapplication.learning.com.newsapplication.data.models.Response;
import newsapplication.learning.com.newsapplication.network.NetworkService;

public class MainActivityPresenter {
    String TAG=MainActivityPresenter.class.getSimpleName();
    private View view;
    public interface View{
        void showNewsArticlesInList(List<Article> articleList);
    }

    public MainActivityPresenter(View view){
        this.view=view;
    }


    public void fetchArticles(){
       NetworkService.getInstance().queryArticle().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Response>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response response) {
                Log.d(TAG,"response: " +response.getArticleList());
                view.showNewsArticlesInList(response.getArticleList());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

         }



}
