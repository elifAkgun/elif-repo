package code.elif.batch.buffer;

import code.elif.ReactiveStreamUtil;
import code.elif.domain.model.BookOrder;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class BufferDemo {

    public static void main(String[] args) throws InterruptedException {

        getEvents().bufferWhile(item -> "Science fiction".equals(item.getBook().genre())
                        || "Fantasy".equals(item.getBook().genre())
                        || "Suspense/Thriller".equals(item.getBook().genre()))
                .map(books -> books.stream().mapMultiToDouble((book, i) -> i.accept(book.getPrice())).sum())
                .subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(10000);
    }

    private static Flux<BookOrder> getEvents() {
        return Flux.interval(Duration.ofMillis(20))
                .map(i -> BookOrder.builder().book(Faker.instance().book())
                        .price(Faker.instance().number().numberBetween(10, 100))
                        .build());
    }
}

