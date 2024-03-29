import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

public class ParallelTest {
    private static final Random rand = new Random();

    public static void main(String[] args) {

        Observable<Integer> vals = Observable.range(1, 10);

        vals.flatMap(val -> Observable.just(val)
                .subscribeOn(Schedulers.computation())
                .map(i -> intenseCalculation(i))
        ).subscribe(val -> System.out.println("Subscriber received "
                + val + " on "
                + Thread.currentThread().getName()));

        waitSleep();
    }

    public static void waitSleep() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int intenseCalculation(int i) {
        try {
            System.out.println("Calculating " + i + " on " + Thread.currentThread().getName());
            Thread.sleep(randInt(1000, 5000));
            return i;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
