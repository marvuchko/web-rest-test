package pro.programista.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T, K extends Serializable> {

  T createOrUpdate(T data);

  Optional<T> findById(K id);

  List<T> getPage(int page, int size);

  void delete(K id);

}