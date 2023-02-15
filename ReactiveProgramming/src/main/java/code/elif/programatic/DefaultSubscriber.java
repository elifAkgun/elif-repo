package code.elif.programatic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@AllArgsConstructor
@NoArgsConstructor
public class DefaultSubscriber<T> implements Subscriber<T> {

    private String name;

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        System.out.println("Received : " + t);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println(Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName() + "-> Error: " + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(
                Thread.currentThread()
                        .getStackTrace()[2]
                        .getMethodName() + " -> Completed");
    }
}
