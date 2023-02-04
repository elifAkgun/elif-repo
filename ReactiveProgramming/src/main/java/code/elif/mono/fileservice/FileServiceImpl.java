package code.elif.mono.fileservice;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService {

    @Override
    public Mono<Void> writeContent(String fileName, String content) {
        Mono mono = Mono.fromRunnable(() -> {
            try {
                Thread.sleep(1000);
                Files.writeString(Path.of(fileName), content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return mono;
    }

    @Override
    public Mono<String> readContent(String fileName) {
        Mono mono = Mono.fromSupplier(() -> {
            try {
                Thread.sleep(1000);
                return Files.readString(Path.of(fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return mono;
    }


    @Override
    public Mono<Void> deleteFile(String fileName) {
        Mono mono = Mono.fromRunnable(() -> {
            try {
                Thread.sleep(1000);
                Files.delete(Path.of(fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return mono;
    }
}
