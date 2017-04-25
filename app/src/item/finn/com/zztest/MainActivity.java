package item.finn.com.zztest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Comment;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import item.finn.com.R;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testRetrofit();
//        testRetrofit2_1();
    }

    private void testRetrofit2_1() {

        String BASE_URL = "http://102.10.10.132/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();

    }

    interface testService {
        //==================GET====================

        @GET("News")
        Call<NewsBean> getItem();

//        @GET("News/{newsId}")    // xxx.com/News/xxid
//        Call<NewsBean> getItem(@Path("newsId") String newsId);

//        @GET("News/{newsId}/{type}")
//        Call<NewsBean> getItem(@Path("newsId") String newsId, @Path("type") String type);

        @GET("News")
            //xx.com/News/?newsId={newsId}
        Call<NewsBean> getItem(@Path("newsId") String newsId);

        @GET("News")
        Call<NewsBean> getItem(@Query("newsId") String newsId, @Query("type") String type);

        @GET("News")
            //xx.com/News/? 参数不固定
        Call<NewsBean> getItem(@QueryMap Map<String, String> map);

        @GET("News")
        Call<NewsBean> getItem(@Query("newsId") String newsId, @QueryMap Map<String, String> map);

        //==================POST====================
        @FormUrlEncoded
        @POST("Comments/{newsId}")
        //xx.com/Comments/commentId  post表单只有"reason"一条记录  key=value
        Call<Comment> reportComment(@Path("newsId") String commentId, @Field("reason") String reason);

        @POST("Comments/{newsId}")
//xx.com/Comments/commentId?access_token=access_token  post表单JOBO  key=value
        Call<Comment> reportComment(@Path("newsId") String commentId, @Query("access_token") String access_token, @Body NewsBean bean);


    }


    private static class NewsBean {
    }


    private void textRxJava() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        }) //observable1
                .subscribeOn(Schedulers.io()) //observable2  call方法时schedule 在调用onSubscribe.call()
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return null;
                    }
                })  //observable3    newsubscriber
                .observeOn(Schedulers.immediate()) //observable4    newsubscriber
                .lift(new Observable.Operator<Object, Integer>() {
                    @Override
                    public Subscriber<? super Integer> call(final Subscriber<? super Object> subscriber) {
                        return new Subscriber<Integer>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Integer integer) {
                                subscriber.onNext(integer + "");
                            }
                        };
                    }
                })
                .observeOn(Schedulers.immediate())
                .lift(new Observable.Operator<Integer, Object>() {
                    @Override
                    public Subscriber<? super Object> call(Subscriber<? super Integer> subscriber) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .lift(new Observable.Operator<Object, Integer>() {
                    @Override
                    public Subscriber<? super Integer> call(final Subscriber<? super Object> subscriber) {
                        return new Subscriber<Integer>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Integer integer) {
                                subscriber.onNext(integer + "");
                            }
                        };
                    }
                })
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object integer) {
                        Log.i("test", integer + "");
                    }
                })
                .unsubscribe();


        Observable.just(1, 2, 3, 4).compose(new LiftAllTransform()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {

            }
        });
    }


    class LiftAllTransform implements Observable.Transformer<Object, Integer> {

        @Override
        public Observable<Integer> call(Observable<Object> objectObservable) {
            return null;
        }
    }


    public void testRetrofit() {

        /**
         * 获取版本号
         */
        String ContentType = "application/json; charset=utf-8";
        String directory = "/sdcard/retrofit/";
        long maxSize = 1000 * 60 * 30;
        long timeout = 30;

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        };
        Cache cache = new Cache(new File(directory), maxSize);
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
//                   网络缓存拦截器
                .addInterceptor(interceptor)
//                .addNetworkInterceptor(interceptor)
//                    自定义网络Log显示
//                .addInterceptor(interceptor)
                .cache(cache)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool())
                .retryOnConnectionFailure(true)
                .build();


        String baseUrl = "http://123.57.244.92:9310";
        String params = "{\"vehicleid\":\"-1\",\"plateno\":\"京RGH4\",\"devicetype\":0,\"ntspheader\":{\"apikey\":\"bda11d91-7ade-4da1-855d-24adfe39d174\",\"corpid\":\"1001\",\"errcode\":0,\"mdinfo\":\"null|AndroidGoogleNexus5-6.0.0-API23-1080x1920|Android6.0\",\"productid\":\"1002\",\"sessionid\":\"57eeef92-9d46-47dc-be2b-c12a097d0bce\",\"version\":\"5.7.7\",\"zjid\":\"95001257\"}}";
//        String params = "";

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(LosGsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(GitHubService.class)
                .getversion(new Gson().fromJson(params, VersionRequest.class))
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Version>() {
                    @Override
                    public void call(Version s) {
                        Log.i("test", s.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i("test", throwable.toString());
                    }
                });

    }

    public interface GitHubService {
        String versionPath = "dx/health/getwoclatest";
        String unreadPath = "system/messagenotice/unread";

        @POST(versionPath)
            //参数url基于BASE URL，服务调用的参数以'/'开头，其中{user}是从EditText获取的字符串。
        Observable<Version> getversion(@Body VersionRequest request);
//        List<Version> listRepos(@Path("user") String user);
    }
}

