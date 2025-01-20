gi### Funcionamiento

1. **Cliente**:
    - Crea un socket UDP.
    - Envía una lista de palabras al servidor.
    - Recibe la palabra más larga y su longitud desde el servidor.
    - Muestra la respuesta del servidor.

2. **Servidor**:
    - Crea un socket UDP en el puerto 8080.
    - Espera a recibir un paquete del cliente.
    - Procesa el paquete recibido para encontrar la palabra más larga.
    - Envía la palabra más larga y su longitud de vuelta al cliente.

### Ejecución del Proyecto

1. **Compilar los Archivos**:
    ```sh
    javac -d bin src/utils/WordUtils.java src/server/Servidor.java src/client/Cliente.java
    ```

2. **Ejecutar el Servidor**:
    ```sh
    java -cp bin server.Servidor
    ```

3. **Ejecutar el Cliente**:
    ```sh
    java -cp bin client.Cliente
    ```

### Notas

- Asegúrate de que el servidor esté en ejecución antes de iniciar el cliente.
- El servidor escucha en el puerto 8080, asegúrate de que este puerto esté disponible.

### Dependencias

Este proyecto no tiene dependencias externas y utiliza únicamente las bibliotecas estándar de Java.

### Autor

Este proyecto fue desarrollado por Joel Pita Vidal.

