package cgi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseCgi {
    public static String getPathPattern() {
        return "/[a-zA-Z0-9]* HTTP";
    }

    public static String getPathFromCgi(String cgi_req) {
        Pattern pattern = Pattern.compile(getPathPattern());
        Matcher matcher = pattern.matcher(cgi_req);

        if (matcher.find()) {
            String group = matcher.group(0);
            return group.split(" ")[0];
        } else {
            return null;
        }
    }
}