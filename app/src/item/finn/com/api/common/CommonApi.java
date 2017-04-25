package item.finn.com.api.common;

import item.finn.com.model.logic.common.bean.LiveVideoInfo;
import item.finn.com.net.response.HttpResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import static item.finn.com.api.NetWorkApi.getLiveVideo;

/**
 *  作者：finn
 *  类描述：
 *  备注消息：
 *  修改时间：2017/2/10 下午7:15
 **/
public interface CommonApi {
    /**
     *  直播播放页
     * @return
     */
    @GET(getLiveVideo+"{room_id}")
    Call<HttpResponse<LiveVideoInfo>> getLiveVideoInfo(@Path("room_id") String room_id, @QueryMap Map<String, String> params);

}
