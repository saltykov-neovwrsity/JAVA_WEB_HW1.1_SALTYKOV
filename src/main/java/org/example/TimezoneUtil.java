package org.example;

import java.time.ZoneOffset;

public class TimezoneUtil {

    public static ZoneOffset parse(String timezone) {
        if (timezone == null) {
            return ZoneOffset.UTC;
        }

        timezone = timezone.replace(" ", "+");

        return ZoneOffset.of(timezone.replace("UTC", ""));
    }

    public static String normalize(String timezone) {
        if (timezone == null) return "UTC";
        return timezone.replace(" ", "+");
    }
}