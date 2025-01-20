package Server;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import Server.WordUtils;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Crear un socket UDP en el puerto 9876
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            while (true) {
                // Crear un paquete UDP para recibir datos
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                // Convertir los datos recibidos a una cadena de palabras
                String words = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                // Encontrar la palabra más larga utilizando WordUtils
                String longestWord = WordUtils.findLongestWord(words.split(","));
                String response = longestWord + "," + longestWord.length();
                
                // Obtener la dirección y el puerto del cliente
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                // Crear un paquete UDP con la respuesta
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                
                // Enviar el paquete al cliente
                socket.send(sendPacket);
            }
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