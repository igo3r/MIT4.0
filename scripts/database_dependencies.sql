-- Please follow the start order below
-- this script is just for the usage with an new created empty arrowhead database

-- Start: 
-- Service Registry --> Authorization --> Orchestrator --> Consumer --> Producer

-- Create UC2 in Secure: 

-- Table system_:
-- consumer ID: 3 --> Provider in AH
-- producer ID: 4 --> Consumer in AH

-- Table service_registry (one entry per service - if you have more services): 
-- /consumer/turn_aircondition_on: 6
-- /consumer/turn_aircondition_off: 7

INSERT INTO `orchestrator_store` (`id`, `consumer_system_id`, `provider_system_id`, `foreign_`, `service_id`, `service_interface_id`, `priority`, `attribute`, `created_at`, `updated_at`) VALUES (NULL, '4', '3', '0', '6', '1', '1', NULL, UTC_TIMESTAMP(), UTC_TIMESTAMP());
INSERT INTO `orchestrator_store` (`id`, `consumer_system_id`, `provider_system_id`, `foreign_`, `service_id`, `service_interface_id`, `priority`, `attribute`, `created_at`, `updated_at`) VALUES (NULL, '4', '3', '0', '7', '1', '1', NULL, UTC_TIMESTAMP(), UTC_TIMESTAMP());



-- Table authorization_intra_cloud:

INSERT INTO `authorization_intra_cloud` (`id`, `created_at`, `updated_at`, `consumer_system_id`, `provider_system_id`, `service_id`) VALUES (NULL, UTC_TIMESTAMP(), UTC_TIMESTAMP(), '4', '3', '6'); 
INSERT INTO `authorization_intra_cloud` (`id`, `created_at`, `updated_at`, `consumer_system_id`, `provider_system_id`, `service_id`) VALUES (NULL, UTC_TIMESTAMP(), UTC_TIMESTAMP(), '4', '3', '7'); 



-- Table authorization_intra_cloud_id ID: 1 & 2 (one entry per service - if you have more services)

INSERT INTO `authorization_intra_cloud_interface_connection` (`id`, `authorization_intra_cloud_id`, `interface_id`, `created_at`, `updated_at`) VALUES (NULL, '1', '1', UTC_TIMESTAMP(), UTC_TIMESTAMP());
INSERT INTO `authorization_intra_cloud_interface_connection` (`id`, `authorization_intra_cloud_id`, `interface_id`, `created_at`, `updated_at`) VALUES (NULL, '2', '1', UTC_TIMESTAMP(), UTC_TIMESTAMP());
