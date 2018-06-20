package com.task.warehouse.controllers;

import com.task.warehouse.common.OperationType;
import com.task.warehouse.dto.CapacityChange;
import com.task.warehouse.models.Warehouse;
import com.task.warehouse.services.WarehouseService;
import com.task.warehouse.services.base.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "warehouses")
public class WarehouseController {

    private WarehouseService service;

    @Autowired
    public WarehouseController(WarehouseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse saved = service.save(warehouse);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse updated = service.save(warehouse);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable Long id) {
        Warehouse warehouse = service.findById(id);

        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Warehouse> deleteWarehouse(@PathVariable Long id) {
        service.delete(id);

        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}/capacity/{operation}")
    public ResponseEntity<Warehouse> changeCurrentCapacity(@RequestBody @Valid CapacityChange capacityChange, BindingResult result,
                                                           @PathVariable Long id, @PathVariable String operation) {

        if(result.hasErrors()) {
            /////
        }

        Warehouse changed = service.changeCapacity(capacityChange, id, OperationType.valueOf(operation.toUpperCase()));

        return new ResponseEntity<>(changed, HttpStatus.OK);
    }
}
