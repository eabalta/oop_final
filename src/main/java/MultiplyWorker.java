
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ea
 */

public class MultiplyWorker implements Runnable {

    private final Buffer buffer;
    public int satirSayisi;
    public int[] matrisSatiri;
    ArrayList<int[]> matris2;
    public int hesaplananSutunSayisi = 0;
    public boolean isFull = false;

    public MultiplyWorker(int rowNumber, Buffer buffer, int[] matrisSatiri, ArrayList<int[]> matris2) {
        this.satirSayisi = rowNumber;
        this.buffer = buffer;
        this.matrisSatiri = matrisSatiri;
        this.matris2 = matris2;
    }

    @Override
    public void run() {
        try {
            while (!isFull) {
                int tempResult = 0;
                for (int i = 0; i < matris2.size(); i++) {
                    tempResult += matrisSatiri[i] * matris2.get(i)[hesaplananSutunSayisi];
                }

                buffer.put(satirSayisi, hesaplananSutunSayisi++, tempResult);

                if (hesaplananSutunSayisi == matris2.get(satirSayisi).length) {
                    isFull = true;
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(MultiplyWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}