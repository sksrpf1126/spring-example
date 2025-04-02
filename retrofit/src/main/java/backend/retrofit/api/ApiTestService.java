package backend.retrofit.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ApiTestService {
    // RestInterface는 Retrofit을 사용하여 API 호출을 위한 인터페이스
    private final RestInterface restInterface;

    public ApiTestResponse apiTest() throws IOException {
        Call<ApiTestResponse> call = restInterface.apiTest();
        // API 호출
        Response<ApiTestResponse> response = call.execute();

        return response.body();
    }

}
