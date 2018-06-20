package com.task.warehouse.models;

import com.task.warehouse.common.OperationType;
import com.task.warehouse.models.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operations")
@Data
public class Operation extends BaseEntity {

    @Column(name = "time")
    private Long time;

    @Column(name = "before_capacity")
    private Double beforeCapacity;

    @Column(name = "after_capacity")
    private Double afterCapacity;

    @Column(name = "capacity_delta")
    private Double deltaCapacity;

    @Column(name = "operation_type")
    private OperationType operationType;

    @Column(name = "warehouse_id")
    private Long warehouseId;
}
