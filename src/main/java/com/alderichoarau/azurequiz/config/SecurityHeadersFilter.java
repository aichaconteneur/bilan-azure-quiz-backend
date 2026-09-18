package com.alderichoarau.azurequiz.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecurityHeadersFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        httpResponse.setHeader(
                "X-Content-Type-Options",
                "nosniff"
        );

        httpResponse.setHeader(
                "Strict-Transport-Security",
                "max-age=31536000; includeSubDomains"
        );

        httpResponse.setHeader(
                "Cross-Origin-Resource-Policy",
                "same-site"
        );

        httpResponse.setHeader(
                "Cache-Control",
                "no-store, no-cache, must-revalidate"
        );

        httpResponse.setHeader(
                "Pragma",
                "no-cache"
        );

        chain.doFilter(request, response);
    }
}
