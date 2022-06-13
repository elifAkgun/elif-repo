package code.elif;

import lombok.ToString;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@ToString
public class ObjectPool<T extends Poolable> {

    private BlockingQueue<T> availablePoolItems;


    public ObjectPool(Supplier<T> creator, int count) {
        availablePoolItems = new LinkedBlockingQueue<>();

        for (int i = 0; i < count; i++) {
            availablePoolItems.offer(creator.get());
        }
    }

    public T get() {
        try {
            return availablePoolItems.take();
        } catch (InterruptedException e) {
            System.out.println("take method was interrupted");
        }
        return null;
    }

    public void release(T t) {
        t.reset();
        try {
            availablePoolItems.put(t);
        } catch (InterruptedException e) {
            System.out.println("put method was interrupted");
        }
    }

    public int getSize(){
        return availablePoolItems.size();
    }
}
