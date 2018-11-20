import java.io.IOException;
import java.net.ServerSocket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private Set<ChatHandler> chats = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {

        new ChatServer(8008);
    }

    public ChatServer(int port) {
        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Started on port " + port);
            while (true) {
                ChatHandler chat = new ChatHandler(this, s.accept());
                chats.add(chat);
                chat.start();
            }
        } catch (IOException e) {
            System.out.println("Failed on port " + port);
        }
    }

    public synchronized void send(String message) {
        System.out.println("New message -> " + message);
        for (ChatHandler chat : chats) {
            chat.sendMessage(message);
        }
    }

    public void chatDisconnect(ChatHandler chat) {
        chats.remove(chat);
        send(chat.name + " left");
    }

}