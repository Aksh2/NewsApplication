package newsapplication.learning.com.newsapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import newsapplication.learning.com.newsapplication.NewsApplication;
import newsapplication.learning.com.newsapplication.di.component.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((NewsApplication) getApplication()).getApplicationComponent();
    }


}
