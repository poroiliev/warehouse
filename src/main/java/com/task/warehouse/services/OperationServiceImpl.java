package com.task.warehouse.services;

import com.task.warehouse.models.Operation;
import com.task.warehouse.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class OperationServiceImpl implements OperationService {

    private OperationRepository repository;

    @Autowired
    public OperationServiceImpl(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Operation> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Operation> findByWarehouse(Long id) {
        return repository.findAllByWarehouseId(id);
    }
}
