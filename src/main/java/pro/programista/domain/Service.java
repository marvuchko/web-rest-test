package pro.programista.domain;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.Optional;

@Transactional(readOnly = true)
public abstract class Service<T, K extends Serializable> {

  protected final Repository<T, K> repository;

  protected Service(Repository<T, K> repository) {
    this.repository = repository;
  }

  Optional<T> findById(K id) {
    return repository.findById(id);
  }

  List<T> getPage(int page, int size) {
    return repository.getPage(page, size);
  }

  @Transactional
  public T createOrUpdate(T data) {
    return repository.createOrUpdate(data);
  }

  @Transactional
  public void delete(K id) {
    repository.delete(id);
  }

}