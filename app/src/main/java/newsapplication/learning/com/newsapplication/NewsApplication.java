package newsapplication.learning.com.newsapplication;

import android.app.Application;

import newsapplication.learning.com.newsapplication.di.component.ApplicationComponent;
import newsapplication.learning.com.newsapplication.di.component.DaggerApplicationComponent;
import newsapplication.learning.com.newsapplication.di.module.ApplicationModule;

public class NewsApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();

    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
