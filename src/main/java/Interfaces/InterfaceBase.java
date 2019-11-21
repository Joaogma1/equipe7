
package Interfaces;

import java.util.List;

public interface InterfaceBase<TEntity> {

    void Add(TEntity obj, int idFilial);

    TEntity GetById(int id);

        List<TEntity> GetAll(int idFilial);

        void Update(TEntity obj);

        void Remove(int id);
}