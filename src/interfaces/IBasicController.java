package interfaces;

import java.util.ArrayList;

public interface IBasicController<T> {

    public ArrayList<T> index();

    public T show(int id);

    public boolean create(T object);

    public boolean update(T object, int id);

    public boolean delete(int id);
    
    public boolean hardDelete(int id);
    
    public boolean undoSoftDelete(int id);
}