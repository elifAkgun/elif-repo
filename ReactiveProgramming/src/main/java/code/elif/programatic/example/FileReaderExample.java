package code.elif.programatic.example;

import code.elif.ReactiveStreamUtil;

public class FileReaderExample {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();

        fileService.readLines("Hello.txt")
                .take(2)
                .subscribe(ReactiveStreamUtil.receiveData());
    }
}
