CREATE TABLE operations
(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    time bigint,
    before_capacity decimal,
    after_capacity decimal,
    capacity_delta decimal,
    operation_type varchar,
    warehouse_id bigint
);

ALTER TABLE operations
    ADD FOREIGN KEY (warehouse_id)
    REFERENCES warehouses(id);
