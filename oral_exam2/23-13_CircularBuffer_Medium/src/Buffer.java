/**
 *
 */
public interface Buffer {
    /**
     * place int value into Buffer
     *
     * @param value integer
     * @throws InterruptedException if method is temporarily blocked from executing
     */
    public void blockingPut(int value) throws InterruptedException;

    /**
     * obtain int value from Buffer
     *
     * @return integer
     * @throws InterruptedException if method is temporarily blocked from executing
     */
    public int blockingGet() throws InterruptedException;
}