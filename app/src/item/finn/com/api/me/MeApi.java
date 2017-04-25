package item.finn.com.api.me;

import java.util.Map;

import item.finn.com.model.logic.me.bean.PersonInfoBean;
import item.finn.com.net.response.HttpResponse;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

import static item.finn.com.api.NetWorkApi.getPersonInfo;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public interface MeApi {
    /**
     * 推荐---最热
     *
     * @return
     */
    @GET(getPersonInfo)
    Observable<HttpResponse<PersonInfoBean>> getPersonInfos(@QueryMap Map<String, String> params) ;
}
