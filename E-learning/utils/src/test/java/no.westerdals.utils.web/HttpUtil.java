package no.westerdals.utils.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;

/**
 * Class with methods to do low-level HTTP communications using raw TCP sockets.
 * Not something you should use, but just to understand what HTTP communications
 * actually are.
 */
public class HttpUtil {

    /**
        Connect to given host:port via direct TCP socket, send the input string, and
        return the result (if any) as a string
     */
    public static String executeHttpCommand(String host, int port, String request) throws Exception {
        Objects.requireNonNull(host);
        Objects.requireNonNull(request);

        try (Socket socket = new Socket(host, port)) {
            socket.getOutputStream().write(request.getBytes());
            socket.shutdownOutput();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String response = "";
            String line = in.readLine();

            while (line != null) {
                response += line + "\n";
                line = in.readLine();
            }
            return response;
        }
    }

    /**
     * Get the heards in the HTTP message
     *
     * @param message
     * @return
     */
    public static String getHeaderBlock(String message){
        Objects.requireNonNull(message);

        String[] lines = message.split("\n");
        String headers = "";
        for(int i=0; i<lines.length; i++){
            if(lines[i].isEmpty()){
                //empty line defines the end of the header section
                break;
            }
            headers += lines[i] + "\n";
        }
        return headers;
    }

    /**
     * Get the body of the HTTP message (if any).
     * Body block comes after the headers
     *
     * @param message
     * @return
     */
    public static String getBodyBlock(String message){
        Objects.requireNonNull(message);

        String[] lines = message.split("\n");
        String body = "";
        boolean isHeader = true;
        for(int i=0; i<lines.length; i++){
            if(isHeader && lines[i].isEmpty()){
                isHeader = false;
                continue;
            }
            if(!isHeader) {
                body += lines[i] + "\n";
            }
        }
        return body;
    }

    /**
     *
     * @param name the name of the header, eg "Content-Type"
     * @param message
     * @return {@code null} if the header is not present, otherwise its value as string
     */
    public static String getHeaderValue(String name, String message){
        Objects.requireNonNull(name);
        Objects.requireNonNull(message);

        String[] lines = message.split("\n");

        for(int i=0; i<lines.length; i++){
            String h = lines[i];
            if(h.isEmpty()){
                break;
            }
            if(h.toLowerCase().startsWith(name.toLowerCase())){
                int splitPoint = h.indexOf(':');
                return h.substring(splitPoint+1, h.length()).trim();
            }
        }
        return null;
    }
}
