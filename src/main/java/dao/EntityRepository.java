package dao;

import java.util.List;

public interface EntityRepository<T> {
    public T save(T p);
    public T findOne(Long id);
    public List<T>findAll();
    public List<T>findParMC(String mc);
    public T update(T p);
    public void delete(Long id);

}
