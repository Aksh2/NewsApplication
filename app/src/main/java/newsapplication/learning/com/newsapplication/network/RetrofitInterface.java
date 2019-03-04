package newsapplication.learning.com.newsapplication.network;


import io.reactivex.Observable;
import newsapplication.learning.com.newsapplication.data.models.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("v2/top-headlines")
    Observable<Response> queryNews(@Query("country")String country,
                                   @Query("apiKey")String apiKey);
}
