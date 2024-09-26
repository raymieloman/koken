package nl.acme.koken.nio2.nonblocking;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NonBlockingExample {
    public static final int BUFSIZE = 4096;

    public static void main(String[] args) {
        demoOpenFileAndShowNonBlocking("pom.xml");
    }

    public static void demoOpenFileAndShowNonBlocking(String fileName) {
        // Open the file channel in asynchronous mode
        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                Paths.get(fileName), StandardOpenOption.READ)) {
            // Create a buffer to hold the data
            ByteBuffer buffer = ByteBuffer.allocate(BUFSIZE);

            // Start the read operation (non-blocking)
            Future<Integer> result = fileChannel.read(buffer, 0);

            // Do other work while the file is being read
            System.out.println("Doing something else while file is being read...");

            // Now check if the read operation is done (non-blocking)
            while (!result.isDone()) {
                // You can do more work here or just wait
                System.out.println("Waiting for the file to be read...");
            }

            // Once done, you can access the data
            int bytesRead = result.get(); // This blocks if not done, but we know it's done
            System.out.println("Read " + bytesRead + " bytes from file.");

            // Display the data read
            buffer.flip();  // Switch the buffer to read mode
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
        } catch (ExecutionException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}