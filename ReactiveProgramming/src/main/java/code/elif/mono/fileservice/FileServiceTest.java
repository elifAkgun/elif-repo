package code.elif.mono.fileservice;

import code.elif.ReactiveStreamUtil;

public class FileServiceTest {

    public static void main(String[] args) {
        FileService fileService = new FileServiceAsyncImpl();

        fileService.writeContent("Hello.txt", "Hello")
                .subscribe(fileName -> System.out.println("File is crated : " + fileName),
                        ReactiveStreamUtil.handleError(),
                        ReactiveStreamUtil.complete()
                );

        fileService.readContent("Hello.txt")
                .subscribe(content -> System.out.println("File is read : " + content),
                        ReactiveStreamUtil.handleError(),
                        ReactiveStreamUtil.complete());

     /*   fileService.deleteFile("Hello.txt").subscribe(
                fileName -> System.out.println("File is deleted" + fileName),
                ReactiveStreamUtil.handleError(),
                ReactiveStreamUtil.complete());*/

    }
}
