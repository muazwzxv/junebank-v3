CREATE TABLE IF NOT EXISTS `order` (
    `id` int AUTO_INCREMENT PRIMARY KEY,

    `order_uuid` varchar(36),
    `customer_uuid` varchar(36),
    `design_uuid` varchar(36),
    `status` varchar(30),

    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `design` (
    `id` int AUTO_INCREMENT PRIMARY KEY,

    `design_uuid` varchar(36),
    `design_code` varchar(36),
    `name` varchar(50),
    `description` varchar(100),
    `status` varchar(30),

    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `transaction` (
    `id` int AUTO_INCREMENT PRIMARY KEY,

    `transaction_uuid` varchar(36),
    `card_uuid` varchar(36),
    `type` varchar(30), -- charge, refund
    `status` varchar(30),

    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `card` (
    `id` int AUTO_INCREMENT PRIMARY KEY,

    `card_uuid` varchar(36),
    `customer_uuid` varchar(36),
    `status` varchar(30),

    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);
