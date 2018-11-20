import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatHandler extends Thread {
    private final ChatServer server;
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public final String name;

    public ChatHandler(ChatServer server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        name = in.readUTF();
        server.send("New chat member " + name + " from " + socket.getInetAddress());
    }

    public void run() {
        try (socket; in; out) {
            while (true) {
                if (in.available() > 0)
                    server.send(name + ": " + in.readUTF());
            }
        } catch (IOException e) {
            System.out.println("Connection is lost");
            server.chatDisconnect(this);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            System.out.println("Connection lost");
            server.chatDisconnect(this);
        }
    }
}
