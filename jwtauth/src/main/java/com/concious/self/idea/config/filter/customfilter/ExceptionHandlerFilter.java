package com.concious.self.idea.config.filter.customfilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.concious.self.idea.exception.EntityNotFoundException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            System.out.println("inside this exception filter");
            filterChain.doFilter(request, response);
        } catch (EntityNotFoundException e) {
            System.out.println("User Not Found Exception");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("User Not Found in our Base");
        } catch (RuntimeException e) {
            System.out.println("Caught Exception in handler");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}
