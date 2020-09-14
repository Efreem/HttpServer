package io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketWriteContent {
    private Socket socket;

    public SocketWriteContent(Socket socket) {
        this.socket = socket;
    }

    public void SocketWriteContent(String content) throws IOException {
        OutputStream output = socket.getOutputStream();
        output.write(content.getBytes());
    }
}
