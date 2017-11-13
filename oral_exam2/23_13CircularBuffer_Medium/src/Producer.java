/**
 *
 */
public class Producer implements Runnable {

    /**
     *
     */
    private final CircularBuffer sharedLocation;

    /**
     *
     * @param sharedLocation
     */
    public Producer(CircularBuffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    /**
     *
     */
    @Override
    public void run() {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            try {
                sharedLocation.blockingPut(i);
                sum += i;
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf(
                "Producer done producing%nTerminating Producer%n"); //TODO: delete
    }
}
