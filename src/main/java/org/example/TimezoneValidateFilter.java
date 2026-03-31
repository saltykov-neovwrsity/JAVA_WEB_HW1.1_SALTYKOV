package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneOffset;

@WebFilter("/time")
public class TimezoneValidateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String timezone = req.getParameter("timezone");

        try {
            ZoneOffset offset = TimezoneUtil.parse(timezone);

            int hours = offset.getTotalSeconds() / 3600;

            if (hours < -12 || hours > 14) {
                throw new Exception();
            }

        } catch (Exception e) {
            resp.setStatus(400);
            resp.getWriter().write("Invalid timezone");
            return;
        }

        chain.doFilter(request, response);
    }
}