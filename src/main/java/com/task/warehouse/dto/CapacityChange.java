package com.task.warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CapacityChange {

    @NotNull
    private Double capacityDelta;

}
