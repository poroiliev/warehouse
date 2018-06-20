package com.task.warehouse.repositories;

import com.task.warehouse.models.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository extends CrudRepository<Operation, Long> {
    Iterable<Operation> findAllByWarehouseId(Long id);
}
