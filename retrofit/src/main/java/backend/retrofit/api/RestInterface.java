package backend.retrofit.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RestInterface {

    // 반환 타입은 Call<타입>의 제네릭 형태
    @GET("api/test")
    Call<ApiTestResponse> apiTest();

}
