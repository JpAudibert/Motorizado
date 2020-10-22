package interfaces;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 * This controller is made for usage with models that have larger
 * concentration of data, that will make a lazy load needed.
 * I thought it would be useful to spread the interfaces, because 
 * the basic one started to grow a lot and loosing its purpose.
 * 
 * @author Joao Pedro Audibert
 */

public interface IIncrementedController<T> {
    public ArrayList<T> index(String criteria);
    
    public ArrayList<T> indexLazy(String criteria, int skip, int limit);
    
    public ArrayList<T> indexDeleted();

    public T show(int id);

    public boolean create(T object);

    public boolean update(T object, int id);

    public boolean delete(int id);
    
    public boolean hardDelete(int id);
    
    public boolean undoSoftDelete(int id);
    
    public void populateTable(JTable table, String criteria);
    
    public void populateTableLazy(JTable table, String criteria);
}
