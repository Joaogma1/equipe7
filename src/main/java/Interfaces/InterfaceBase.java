
package Interfaces;

import java.util.List;

public interface InterfaceBase<TEntity> {

    void Add(TEntity obj);

    TEntity GetById(int id);

        List<TEntity> GetAll();

        void Update(TEntity obj);

        void Remove(int id);
}