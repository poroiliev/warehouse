package com.task.warehouse.services;

import com.task.warehouse.common.OperationType;
import com.task.warehouse.dto.CapacityChange;
import com.task.warehouse.models.Warehouse;
import com.task.warehouse.services.base.CrudService;

public interface WarehouseService extends CrudService<Warehouse, Long> {
    Warehouse changeCapacity(CapacityChange capacityChange, Long id, OperationType operationType);
}
