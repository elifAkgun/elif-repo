package code.elif.flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class FluxWithCustomSubscriber {

    public static void main(String[] args) throws InterruptedException {

        AtomicReference<Subscription> subscriptionAtomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .subscribeWith(new Subscriber<>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("Received sub: " + s);
                        subscriptionAtomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Next is : " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Error occurred" + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("On complete");
                    }
                });

        subscriptionAtomicReference.get().request(3);
        Thread.sleep(2000);
        subscriptionAtomicReference.get().request(2);
        Thread.sleep(2000);
        subscriptionAtomicReference.get().request(4);
        Thread.sleep(2000);
        subscriptionAtomicReference.get().cancel();
        System.out.println("Cancelled...");
        Thread.sleep(1000);
        subscriptionAtomicReference.get().request(4);
        System.out.println("Tried to receive new objects...");
    }
}
