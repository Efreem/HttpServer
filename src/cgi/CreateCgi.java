package cgi;

import java.util.Map;

public class CreateCgi {
    private String readycgi;
    public static String httpheader = "HTTP/1.0 ";
    public static Map<String,String> code_status = Map.of(
            "200", "200 OK\n",
            "204", "204 No Response\n",
            "404", "404 Not Found\n");
    public static String content_type = "Content-Type: text/html\n";
    public static String content_length = "Content-Length: ";

    public CreateCgi() {
        readycgi = "";
    }

    public String getReadyCgi() {
        return readycgi;
    }

    public CreateCgi addHttpHeader() {
        readycgi += httpheader;
        return this;
    }

    public CreateCgi addCodeStatus(String code_status) {
        readycgi += CreateCgi.code_status.get(code_status);
        return this;
    }

    public CreateCgi addContentType() {
        readycgi += content_type;
        return this;
    }

    public CreateCgi addContentLength(Integer Content_Length) {
        readycgi += content_length + Content_Length.toString() + "\n\n";
        return this;
    }

    public void addContent(String content) {
        readycgi += content;
    }
}
