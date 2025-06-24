package code.elif.programatic.example;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public Flux<String> readLines(String fileName) {
        return Flux.generate(() -> Files.newBufferedReader(Path.of(fileName)),
                (bufferedReader, fluxSink) -> {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            fluxSink.complete();
                        } else {
                            System.out.println("Emitting :" + line);
                            fluxSink.next(line);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return bufferedReader;
                }

        );
    }


    public Flux<String> readLines2(String fileName, int lineCount) {
        return Flux.create(
                fluxSink -> {
                    try {
                        List<String> lines = Files.readAllLines(Path.of(fileName));
                        for (int i = 0; i < lineCount && i < lines.size(); i++) {
                            fluxSink.next(lines.get(i));
                        }
                    } catch (IOException e) {
                        fluxSink.error(new RuntimeException(e));
                    }
                    fluxSink.complete();
                }
        );
    }
}
