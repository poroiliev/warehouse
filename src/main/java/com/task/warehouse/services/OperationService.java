package com.task.warehouse.services;

import com.task.warehouse.models.Operation;

public interface OperationService {

    Iterable<Operation> findAll();
    Iterable<Operation> findByWarehouse(Long id);

}
