package com.whatsapp.api.test.interceptor;

import com.whatsapp.api.interceptor.BasicAuthenticationInterceptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BasicAuthenticationInterceptorTest {

    /**
     * Method under test: {@link BasicAuthenticationInterceptor#BasicAuthenticationInterceptor(String)}
     */
    @Test
    void testConstructor() {

        BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor("ABC123");
        Assertions.assertNotNull(interceptor);

    }
}

