package newsapplication.learning.com.newsapplication.network;

import javax.inject.Inject;

import io.reactivex.Observable;
import newsapplication.learning.com.newsapplication.data.models.Response;
import newsapplication.learning.com.newsapplication.di.component.DaggerNetworkComponent;
import newsapplication.learning.com.newsapplication.di.component.NetworkComponent;
import newsapplication.learning.com.newsapplication.di.module.NetworkModule;
import retrofit2.Retrofit;

public class NetworkService {
    private static final String BASE_URL = "https://newsapi.org";
    private RetrofitInterface retrofitInterface;
    public static NetworkService INSTANCE;

    NetworkComponent networkComponent;

    @Inject
    Retrofit retrofit;


    public static NetworkService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NetworkService();
        }
        return INSTANCE;
    }

    private NetworkService(){
        getNetworkComponent().inject(this);
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    private NetworkComponent getNetworkComponent() {
        networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule(BASE_URL)).build();
        return networkComponent;
    }


    public Observable<Response> queryArticle() {
        return retrofitInterface.queryNews("in", "9289cc3e1542467e9ed573c3d70749ca");
    }

}
