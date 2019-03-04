package newsapplication.learning.com.newsapplication.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import newsapplication.learning.com.newsapplication.NewsApplication;

@Module
public class ApplicationModule {

    private final NewsApplication application;


    public ApplicationModule(NewsApplication application) {
        this.application = application;
    }


    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }
}

