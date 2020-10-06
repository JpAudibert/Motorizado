package interfaces;

import java.util.ArrayList;

public interface IBasicController<T> {

    public ArrayList<T> index();

    public T show(int id);

    public boolean store(T object);

    public boolean update(T object, int id);

    public boolean delete(int id);
}