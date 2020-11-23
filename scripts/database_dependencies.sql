-- Please follow the start order below
-- this script is just for the usage with an new created empty arrowhead database

-- Start: 
-- Service Registry --> Authorization --> Orchestrator --> Consumer --> Producer

-- Create UC4 in Secure: 

-- Table system_:
-- consumer ID: 3
-- producer ID: 4

-- Table service_registry: 
-- /producer/on_ac service_id: 7

INSERT INTO `orchestrator_store` (`id`, `consumer_system_id`, `provider_system_id`, `foreign_`, `service_id`, `service_interface_id`, `priority`, `attribute`, `created_at`, `updated_at`) VALUES (NULL, '3', '4', '0', '7', '2', '1', NULL, UTC_TIMESTAMP(), UTC_TIMESTAMP());

INSERT INTO `authorization_intra_cloud` (`id`, `created_at`, `updated_at`, `consumer_system_id`, `provider_system_id`, `service_id`) VALUES (NULL, UTC_TIMESTAMP(), UTC_TIMESTAMP(), '3', '4', '7'); 


-- Table authorization_intra_cloud:
-- authorization_intra_cloud_id ID: 1 (one entry per service - if you have more services)

INSERT INTO `authorization_intra_cloud_interface_connection` (`id`, `authorization_intra_cloud_id`, `interface_id`, `created_at`, `updated_at`) VALUES (NULL, '1', '2', UTC_TIMESTAMP(), UTC_TIMESTAMP());
