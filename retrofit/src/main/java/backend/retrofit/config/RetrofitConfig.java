package backend.retrofit.config;

import backend.retrofit.api.RestInterface;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfig {

    private static String API_TEST_URL = "http://localhost:8090/";

    @Bean(name="okHttpClient")
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Bean(name="commonRetrofit")
    public Retrofit retrofit(@Qualifier("okHttpClient") OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(API_TEST_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client).build();
    }

    @Bean(name="restService")
    public RestInterface restService(@Qualifier("commonRetrofit") Retrofit retrofit) {
        return retrofit.create(RestInterface.class);
    }

}
