package com.task.warehouse.controllers;

import com.task.warehouse.models.Operation;
import com.task.warehouse.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "warehouses")
public class OperationsController {

    private OperationService service;

    @Autowired
    public OperationsController(OperationService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}/operations")
    public ResponseEntity<Iterable<Operation>> getWarehouseOperations(@PathVariable Long id) {

        Iterable<Operation> byWarehouse = service.findByWarehouse(id);
        return new ResponseEntity<>(byWarehouse, HttpStatus.OK);
    }

    @GetMapping(path = "/operations")
    public ResponseEntity<Iterable<Operation>> getAllOperations() {
        Iterable<Operation> all = service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
