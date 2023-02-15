package code.elif.programatic.example;

import reactor.core.publisher.Flux;

public interface FileService {
    Flux<String> readLines(String fileName);
}
