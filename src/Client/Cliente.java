import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import Server.Servidor;

public class Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Crear un socket UDP
            socket = new DatagramSocket();
            
            // Lista de palabras a enviar al servidor
            String[] words = {"manzana", "banana", "kiwi", "sandía", "fresa"};
            StringBuilder message = new StringBuilder();
            
            // Construir el mensaje concatenando las palabras separadas por comas
            for (String word : words) {
                message.append(word).append(",");
            }
            
            // Convertir el mensaje a bytes
            byte[] buffer = message.toString().getBytes();
            
            // Obtener la dirección del servidor
            InetAddress address = InetAddress.getByName("localhost");
            
            // Crear un paquete UDP con el mensaje, la dirección y el puerto del servidor
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9876);
            
            // Enviar el paquete al servidor
            socket.send(packet);

            // Buffer para recibir la respuesta del servidor
            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            
            // Recibir la respuesta del servidor
            socket.receive(responsePacket);
            
            // Convertir la respuesta a una cadena y mostrarla
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Respuesta del servidor: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el socket
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}