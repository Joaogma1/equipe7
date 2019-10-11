
import java.util.List;


public interface BaseInterface<TEntity> {

    void Add(TEntity obj);

    TEntity GetById(int id);

        List<TEntity> GetAll();

        void Update(String id, TEntity obj);

        void Update(TEntity obj);

        void Remove(int id);
}
