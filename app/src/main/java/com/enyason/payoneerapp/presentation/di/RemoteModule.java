package com.enyason.payoneerapp.presentation.di;


import com.enyason.payoneerapp.core.api.PayoneerApi;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class RemoteModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        String BASE_URL = "https://raw.githubusercontent.com";
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkhttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient
                .Builder()
                .addNetworkInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideLoggerInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    public PayoneerApi providePayoneerApi(Retrofit retrofit) {
        return retrofit.create(PayoneerApi.class);
    }
}
