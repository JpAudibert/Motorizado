package interfaces;

import java.util.ArrayList;
import javax.swing.JTable;

public interface IApiController<T> {

    public ArrayList<T> index(String criteria);

    public T show(int id);

    public boolean create(T object);

    public boolean update(T object, int id);

    public boolean delete(int id);

    public void populateTable(JTable table, String criteria);
}
