package com.task.warehouse.services.base;

import java.util.List;

public interface CrudService<E, ID> {
    E save(E entity);

    E update(E entity);

    E findById(ID id);

    void delete(ID id);
}
