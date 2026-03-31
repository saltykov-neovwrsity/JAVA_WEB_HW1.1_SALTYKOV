package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String timezone = req.getParameter("timezone");

        ZoneOffset offset = TimezoneUtil.parse(timezone);

        timezone = TimezoneUtil.normalize(timezone);

        ZonedDateTime now = ZonedDateTime.now(offset);

        String time = now.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write("""
                <html>
                    <body>
                        <h1>%s %s</h1>
                    </body>
                </html>
                """.formatted(time, timezone));
    }
}