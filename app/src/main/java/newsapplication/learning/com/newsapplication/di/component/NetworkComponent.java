package newsapplication.learning.com.newsapplication.di.component;

import javax.inject.Singleton;

import dagger.Component;
import newsapplication.learning.com.newsapplication.di.module.NetworkModule;
import newsapplication.learning.com.newsapplication.network.NetworkService;
import retrofit2.Retrofit;

    @Singleton
    @Component(modules = NetworkModule.class)
    public interface NetworkComponent {
        Retrofit retrofit();
        void inject(NetworkService networkService);
    }
