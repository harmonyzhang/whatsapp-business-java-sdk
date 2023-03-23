package com.whatsapp.api.test.interceptor;

import com.whatsapp.api.interceptor.AuthenticationInterceptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AuthenticationInterceptorTest {

    /**
     * Method under test: {@link AuthenticationInterceptor#AuthenticationInterceptor(String)}
     */
    @Test
    void testConstructor() {

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor("ABC123");
        Assertions.assertNotNull(interceptor);

    }
}

