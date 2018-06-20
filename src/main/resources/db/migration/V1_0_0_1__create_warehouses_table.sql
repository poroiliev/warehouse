CREATE TABLE warehouses
(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    warehouse_name varchar,
    current_capacity decimal,
    max_capacity decimal ,
    type varchar
);
