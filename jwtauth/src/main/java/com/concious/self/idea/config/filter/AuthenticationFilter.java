package com.concious.self.idea.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.concious.self.idea.jpa.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            System.out.println("Inside Auth Filter");
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            user.getUserName();
            System.out.println(user);
        } catch (IOException e) {
            System.out.println("Got Exception in Auth Filter");
            throw new RuntimeException();
        }

        return super.attemptAuthentication(request, response);
    }
}
