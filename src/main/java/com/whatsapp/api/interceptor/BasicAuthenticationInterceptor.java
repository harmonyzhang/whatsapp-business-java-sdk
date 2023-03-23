package com.whatsapp.api.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * The type Authentication interceptor.
 */
public class BasicAuthenticationInterceptor implements Interceptor {

    private final String token;

    /**
     * Instantiates a new Authentication interceptor.
     *
     * @param token the token
     */
    public BasicAuthenticationInterceptor(String token) {
        this.token = token;
    }


    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request() //
                .newBuilder() //
                .addHeader("Authorization", "Basic " + token) //
                .build();

        return chain.proceed(newRequest);
    }
}
