# Completable Future demo to impove api performance

```
DB-SCHEMA

CREATE TABLE `category` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255),
  `type` varchar(255),
  `status` varchar(255)
);

CREATE TABLE `products` (
  `id` bigint PRIMARY KEY,
  `category_id` bigint,
  `name` varchar(255),
  `description` text,
  `status` varchar(255)
);

CREATE TABLE `price` (
  `id` bigint PRIMARY KEY,
  `product_id` bigint,
  `price` double,
  `valid_from` timestamp,
  `valid_to` timestamp,
  `status` varchar(255)
);

CREATE TABLE `inventory` (
  `id` bigint PRIMARY KEY,
  `product_id` bigint,
  `warehouse_id` bigint,
  `available_quantity` integer,
  `reserved_quantity` integer,
  `status` varchar(255)
);

ALTER TABLE `inventory` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `products` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `price` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);


-- Insert Statements
INSERT INTO `category` (`id`, `name`, `type`, `status`) VALUES
(1, 'Electronics', 'Goods', 'active'),
(2, 'Clothing', 'Goods', 'active'),
(3, 'Home Appliances', 'Goods', 'active');


INSERT INTO `products` (`id`, `category_id`, `name`, `description`, `status`) VALUES
(1, 1, 'Smartphone', 'Latest smartphone with high-speed performance', 'active'),
(2, 1, 'Laptop', '17-inch laptop with 32GB RAM, 512GB SSD', 'active'),
(3, 2, 'Tablates', 'Tablates', 'active'),
(4, 3, 'Air Conditioner', '1.5 ton AC with energy-efficient cooling', 'active');


INSERT INTO `price` (`id`, `product_id`, `price`, `valid_from`, `valid_to`, `status`) VALUES
(1, 1, 799.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active'),
(2, 2, 1699.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active'),
(3, 3, 519.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active'),
(4, 4, 2299.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active');


INSERT INTO `inventory` (`id`, `product_id`, `warehouse_id`, `available_quantity`, `reserved_quantity`, `status`) VALUES
(1, 1, 1, 120, 10, 'available'),
(2, 2, 1, 520, 5, 'available'),
(3, 3, 2, 200, 20, 'available'),
(4, 4, 3, 303, 2, 'available');

```
