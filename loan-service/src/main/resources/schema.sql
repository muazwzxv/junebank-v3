CREATE TABLE IF NOT EXISTS `applicant` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `applicant_uuid` varchar(36),
    `email` varchar(100),

    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `application` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `applicant_uuid` varchar(36),
    `application_uuid` varchar(36),
    `status` varchar(30),
    `status_reason` varchar(30),

    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `offer` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `application_uuid` varchar(36),
    `offered_limit` varchar,
    `offered_interest` varchar,
    `status` varchar(30),

    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);
