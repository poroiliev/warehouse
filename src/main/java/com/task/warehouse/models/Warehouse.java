package com.task.warehouse.models;

import com.task.warehouse.models.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "warehouses")
@Data
public class Warehouse extends BaseEntity {

    @NotNull
    @Column(name = "warehouse_name")
    private String warehouseName;

    @NotNull
    @Min(0)
    @Column(name = "current_capacity")
    private Double currentCapacity;

    @NotNull
    @Min(0)
    @Column(name = "max_capacity")
    private Double maximumCapacity;

    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        WHEAT, TANK
    }
}
