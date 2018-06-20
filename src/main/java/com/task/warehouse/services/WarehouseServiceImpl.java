package com.task.warehouse.services;

import com.task.warehouse.common.OperationType;
import com.task.warehouse.dto.CapacityChange;
import com.task.warehouse.models.Operation;
import com.task.warehouse.models.Warehouse;
import com.task.warehouse.repositories.OperationRepository;
import com.task.warehouse.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;
    private OperationRepository operationRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, OperationRepository operationRepository) {
        this.warehouseRepository = warehouseRepository;
        this.operationRepository = operationRepository;
    }

    @Override
    public Warehouse save(Warehouse entity) {
        return warehouseRepository.save(entity);
    }

    @Override
    public Warehouse update(Warehouse entity) {
        return warehouseRepository.save(entity);
    }

    @Override
    public Warehouse findById(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        warehouseRepository.findById(id);
    }

    @Override
    public Warehouse changeCapacity(CapacityChange capacityChange, Long id, OperationType operationType) {

        Warehouse fromDB = findById(id);

        Double newCapacity;
        switch (operationType) {
            case DELIVERY:
                newCapacity = fromDB.getCurrentCapacity() + capacityChange.getCapacityDelta();
                break;

            case DISPATCH:
                newCapacity = fromDB.getCurrentCapacity() - capacityChange.getCapacityDelta();
                break;

            default:
                throw new IllegalArgumentException();
        }

        registerOperation(fromDB.getId(), capacityChange, operationType, fromDB.getCurrentCapacity(), newCapacity);

        fromDB.setCurrentCapacity(newCapacity);
        return update(fromDB);
    }

    private void registerOperation(Long warehouseId,
                                   CapacityChange capacityChange,
                                   OperationType operationType,
                                   Double currentCapacity,
                                   Double newCapacity) {

        Operation operation = new Operation();
        operation.setTime(Instant.now().toEpochMilli());
        operation.setAfterCapacity(newCapacity);
        operation.setBeforeCapacity(currentCapacity);
        operation.setDeltaCapacity(capacityChange.getCapacityDelta());
        operation.setOperationType(operationType);
        operation.setWarehouseId(warehouseId);
        operationRepository.save(operation);

    }
}
