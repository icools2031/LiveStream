package item.finn.com.api.home;

import java.util.List;
import java.util.Map;

import item.finn.com.model.logic.home.bean.HomeCarousel;
import item.finn.com.model.logic.home.bean.HomeCateList;
import item.finn.com.model.logic.home.bean.HomeColumnMoreAllList;
import item.finn.com.model.logic.home.bean.HomeColumnMoreOtherList;
import item.finn.com.model.logic.home.bean.HomeColumnMoreTwoCate;
import item.finn.com.model.logic.home.bean.HomeFaceScoreColumn;
import item.finn.com.model.logic.home.bean.HomeHotColumn;
import item.finn.com.model.logic.home.bean.HomeRecommendHotCate;
import item.finn.com.net.response.HttpResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

import static item.finn.com.api.NetWorkApi.getCarousel;
import static item.finn.com.api.NetWorkApi.getHomeCate;
import static item.finn.com.api.NetWorkApi.getHomeCateList;
import static item.finn.com.api.NetWorkApi.getHomeColumnMoreAllList;
import static item.finn.com.api.NetWorkApi.getHomeColumnMoreCate;
import static item.finn.com.api.NetWorkApi.getHomeColumnMoreOtherList;
import static item.finn.com.api.NetWorkApi.getHomeFaceScoreColumn;
import static item.finn.com.api.NetWorkApi.getHomeHotColumn;
import static item.finn.com.api.NetWorkApi.getHomeRecommendHotCate;

/**
 * 作者：finn
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 修改时间：2016/12/12 下午4:12
 **/
public interface HomeApi {

    /**
     * 首页分类列表
     *
     * @return
     */
    @GET(getHomeCateList)
    Observable<HttpResponse<List<HomeCateList>>> getHomeCateList(@QueryMap Map<String, String> params);

    /**
     * 首页 列表详情页
     *
     * @return
     */
    @GET(getHomeCate)
    Observable<HttpResponse<List<HomeRecommendHotCate>>> getHomeCate(@QueryMap Map<String, String> params);

    /**
     * 首页   推荐轮播图
     *
     * @return
     */
    @GET(getCarousel)
    Observable<HttpResponse<List<HomeCarousel>>> getCarousel(@QueryMap Map<String, String> params);

    /**
     * 推荐---最热
     *
     * @return
     */
    @GET(getHomeHotColumn)
    Observable<HttpResponse<List<HomeHotColumn>>> getHotColumn(@QueryMap Map<String, String> params);

    /**
     * 推荐---颜值
     *
     * @return
     */
    @GET(getHomeFaceScoreColumn)
    Observable<HttpResponse<List<HomeFaceScoreColumn>>> getFaceScoreColumn(@QueryMap Map<String, String> params);

    /**
     * 推荐---热门 种类
     *
     * @return
     */
    @GET(getHomeRecommendHotCate)
    Observable<HttpResponse<List<HomeRecommendHotCate>>> getHotCate(@QueryMap Map<String, String> params);


    /**
     * 栏目 更多   --二级分类列表
     *
     * @return
     */
    @GET(getHomeColumnMoreCate)
    Observable<HttpResponse<List<HomeColumnMoreTwoCate>>> getHomeColumnMoreCate(@QueryMap Map<String, String> params);

    /**
     * 栏目 更多   --其他列表
     *
     * @return
     */
    @GET(getHomeColumnMoreOtherList)
    Observable<HttpResponse<List<HomeColumnMoreOtherList>>> getHomeColumnMoreOtherList(@QueryMap Map<String, String> params);

    /**
     * 栏目 更多   --全部列表
     *
     * @return
     */
    @GET(getHomeColumnMoreAllList + "{cate_id}")
    Observable<HttpResponse<List<HomeColumnMoreAllList>>> getHomeColumnMoreAllList(@Path("cate_id") String cate_id, @QueryMap Map<String, String> params);



}
