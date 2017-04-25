package item.finn.com.net.http;

/**
 * Created by finn on 17/4/20.
 */

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import item.finn.com.utils.L;
import item.finn.com.utils.NetworkUtil;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 1.对外职责(功能)是什么? a.将封装好的数据发送服务器,提供发送请求方法 b.将得到响应数据返回,http异常 组合处理 扩展功能:cookia,https,上传,下载
 * <p>
 * <p>
 * 2.如何实现()? 如何采用原生的API对各种功能需要封装,使用三方Retrofit 性能有保障,功能相对齐全 eg: https ,上传,下载 2.1 如何封装,才能让上层更好的调用
 * 只关心我需要什么,
 * <p>
 * 根据面向对象思想(OOP）继承,多态 ,抽象,封装(内部属性不能被外部)
 * <p>
 * 3.异常处理? a.http连接异常 statecode != 200 b.请求协议异常 errcode != 0
 */
public class HttpUtils {
  private static HttpUtils instance;
  private static NetWorkConfiguration configuration;
  private final Context context;
  private OkHttpClient mOkHttpClient;
  private boolean isLoadDiskCache;
  private boolean isLoadMemoryCache;

  public static HttpUtils getInstance(Context context) {// 单例传参
    if (null == instance) {
      synchronized (HttpUtils.class) {
        if (null == instance) {
          instance = new HttpUtils(context);
        }
      }
    }
    return instance;
  }

  /**
   * 无网络是否作用本地缓存
   *
   * @param isCache
   * @return
   */
  public HttpUtils setLoadDiskCache(boolean isCache) {
    this.isLoadDiskCache = isCache;
    return this;
  }

  /**
   * 是否使用内存缓存
   *
   * @param isCache
   * @return
   */
  public HttpUtils setLoadMemoryCache(boolean isCache) {
    this.isLoadMemoryCache = isCache;
    return this;
  }


  public HttpUtils(Context context) {
    // 创建默认 okHttpClient对象
    this.context = context;
    /**
     * 进行默认配置 未配置configuration ,
     *
     */
    if (configuration == null) {
      configuration = new NetWorkConfiguration(context);
    }
    if (configuration.getIsCache()) {
      mOkHttpClient = new OkHttpClient.Builder()
          // 网络缓存拦截器
          .addInterceptor(interceptor).addNetworkInterceptor(interceptor)
          // 自定义网络Log显示
          .addInterceptor(new LogInterceptor()).cache(configuration.getDiskCache())
          .connectTimeout(configuration.getConnectTimeOut(), TimeUnit.SECONDS)
          .connectionPool(configuration.getConnectionPool()).retryOnConnectionFailure(true).build();
    } else {
      mOkHttpClient = new OkHttpClient.Builder().addInterceptor(new LogInterceptor())
          .connectTimeout(configuration.getConnectTimeOut(), TimeUnit.SECONDS)
          .connectionPool(configuration.getConnectionPool()).retryOnConnectionFailure(true).build();

    }
    /**
     *
     * 判断是否在AppLication中配置Https证书
     *
     */
    if (configuration.getCertificates() != null) {
      mOkHttpClient =
          getOkHttpClient().newBuilder()
              .sslSocketFactory(
                  HttpsUtils.getSslSocketFactory(configuration.getCertificates(), null, null))
              .build();
    }
  }

  /**
   * 网络配置
   *
   * @param configuration
   */
  public static void setConFiguration(NetWorkConfiguration configuration) {
    if (configuration == null) {
      throw new IllegalArgumentException(
          "ImageLoader configuration can not be initialized with null");
    } else {
      if (HttpUtils.configuration == null) {
        L.d("Initialize NetWorkConfiguration with configuration");
        HttpUtils.configuration = configuration;
      } else {
        L.e("Try to initialize NetWorkConfiguration which had already been initialized before. To re-init NetWorkConfiguration with new configuration ");
      }
    }
    if (configuration != null) {
      L.i("ConFiguration" + configuration.toString());
    }
  }

  /**
   * 请求拦截器
   */
  final Interceptor interceptor = new Interceptor() {
    @Override
    public Response intercept(Chain chain) throws IOException {
      Request request = chain.request();
      /**
       * 断网后是否加载本地缓存数据
       *
       */
      if (!NetworkUtil.isNetworkAvailable(configuration.context) && isLoadDiskCache) {
        request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
      }
      // 加载内存缓存数据
      else if (isLoadMemoryCache) {
        request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
      }
      /**
       * 加载网络数据
       */
      else {
        request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
      }
      Response response = chain.proceed(request);
      // 有网进行内存缓存数据
      if (NetworkUtil.isNetworkAvailable(configuration.context)
          && configuration.getIsMemoryCache()) {
        response.newBuilder()
            .header("Cache-Control", "public, max-age=" + configuration.getmemoryCacheTime())
            .removeHeader("Pragma").build();
      } else {
        // 进行本地缓存数据
        if (configuration.getIsDiskCache()) {
          response.newBuilder()
              .header("Cache-Control",
                  "public, only-if-cached, max-stale=" + configuration.getDiskCacheTime())
              .removeHeader("Pragma").build();
        }
      }
      return response;
    }

  };

  public OkHttpClient getOkHttpClient() {
    return mOkHttpClient;
  }

  // public Retrofit getRetrofitClient(String url,OkHttpClient client ,) {
  // return new RetrofitClient(url,client).builder();
  // }

}
