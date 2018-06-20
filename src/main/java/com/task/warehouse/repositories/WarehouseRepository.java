package com.task.warehouse.repositories;

import com.task.warehouse.models.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {
}
