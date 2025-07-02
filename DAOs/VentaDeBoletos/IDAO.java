package DAOs.VentaDeBoletos;

import java.util.List;

public interface IDAO<T> {
    public boolean create(T entity) throws Exception;
    public List<T> readAll() throws Exception;
    public T readBy(String id) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(String id) throws Exception;
}
