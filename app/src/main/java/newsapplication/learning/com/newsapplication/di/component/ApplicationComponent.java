package newsapplication.learning.com.newsapplication.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import newsapplication.learning.com.newsapplication.di.module.ApplicationModule;
import newsapplication.learning.com.newsapplication.view.BaseActivity;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
    Context context();

}
