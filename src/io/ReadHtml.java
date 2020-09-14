package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadHtml {
    private String htmlfilepath;

    public ReadHtml(String htmlfilepath) {
        this.htmlfilepath = htmlfilepath;
    }

    public String getContent() throws IOException {
        String result = "";
        int char_elem = 0;

        if ((new File(htmlfilepath)).exists()) {
            FileReader reader = new FileReader(htmlfilepath);

            while (true) {
                char_elem = reader.read();

                if(char_elem == -1) {
                    break;
                } else {
                    result += (char)char_elem;
                }
            }

            return result;
        } else {
            return "Not Found";
        }
    }
}
