package item.finn.com.zztest;

import android.os.Bundle;

import com.trello.rxlifecycle.components.RxActivity;

import item.finn.com.net.http.HttpUtils;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by finn on 17/4/20.
 */

public class TestActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        OkHttpClient okHttpClient = HttpUtils.getInstance(this).getOkHttpClient();
//        new Retrofit.Builder().
//                client(okHttpClient).
//                baseUrl()
    }
}
