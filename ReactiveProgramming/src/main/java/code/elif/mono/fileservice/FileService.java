package code.elif.mono.fileservice;

import reactor.core.publisher.Mono;

public interface FileService {

    Mono<Void> writeContent(String fileName, String content);

    Mono<String> readContent(String fileName);

    Mono<Void> deleteFile(String fileName);

}
