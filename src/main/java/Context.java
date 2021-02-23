
/**
 *
 * @author ea
 */
public class Context {
    
    private final SortInterface si;

    public Context(SortInterface si) {
        this.si = si;
    }

    public void sort(int arr[]){
        si.execute(arr);
    }
    
}
