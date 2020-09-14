package io;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketReadContent {
    private Socket socket;

    public SocketReadContent(Socket socket) {
        this.socket = socket;
    }

    public String getContent() throws IOException {
        InputStream input = socket.getInputStream();
        String result = "";
        int char_elem = 0;

        while (true) {
            if (char_elem == -1) {
                break;
            } else {
                result += (char)input.read();
            }
        }

        return result;
    }
}
