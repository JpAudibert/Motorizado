package interfaces;

import java.util.ArrayList;

public interface IAutomaticallyInsertedController<T> {

    public ArrayList<T> index(String criteria);

    public T show(int id);

    public boolean create(T object);

    public boolean update(T object, int id);

    public boolean delete(int id);
}
