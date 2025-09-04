package com.trucdulieu.commoncategory.config;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import javax.servlet.*;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

// import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;

@Component
public class UserDetailsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String jws = httpRequest.getHeader("Authorization");
        String userName = "docker";
        if(jws!=null){
            jws= jws.replace("Bearer ", "");
            int i = jws.lastIndexOf('.');
            String withoutSignature = jws.substring(0, i+1);

            Object claims = Jwts.parserBuilder().build().parse(withoutSignature).getBody();
            UserContext userContext= new Gson().fromJson(new Gson().toJson(claims), UserContext.class);
            userName= userContext.getEmail();
        }

        UserContext context = new UserContext();
        context.setUserName(userName);
        UserContextHolder.setUserContext(context);
        chain.doFilter(request, response);
    }
}
