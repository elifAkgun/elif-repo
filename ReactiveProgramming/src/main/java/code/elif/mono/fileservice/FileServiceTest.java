package code.elif.mono.fileservice;

import code.elif.ReactiveStreamUtil;

public class FileServiceTest {

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();

        fileService.writeContent("Hello.txt", "Hello")
                .subscribe(fileName -> System.out.println("File is crated : " + fileName),
                        ReactiveStreamUtil.getThrowableConsumer(),
                        ReactiveStreamUtil.getCompleted()
                );

        fileService.readContent("Hello.txt")
                .subscribe(content -> System.out.println("File is read : " + content),
                        ReactiveStreamUtil.getThrowableConsumer(),
                        ReactiveStreamUtil.getCompleted());

        fileService.deleteFile("Hello.txt").subscribe(
                fileName -> System.out.println("File is deleted" + fileName),
                ReactiveStreamUtil.getThrowableConsumer(),
                ReactiveStreamUtil.getCompleted());

    }
}
