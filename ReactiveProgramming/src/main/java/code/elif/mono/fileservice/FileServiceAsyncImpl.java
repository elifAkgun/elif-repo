package code.elif.mono.fileservice;

import reactor.core.publisher.Mono;

import java.io.IOException;

public class FileServiceAsyncImpl extends FileServiceImpl implements FileService {

    @Override
    public Mono<Void> writeContent(String fileName, String content) {
        Mono mono = Mono.fromRunnable(() -> {
            try {
                Thread.sleep(1000);
                writeFile(fileName, content);
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
                return readFile(fileName);
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
                delete(fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return mono;
    }


}
