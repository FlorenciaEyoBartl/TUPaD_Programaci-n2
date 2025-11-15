USE prog2;

-- ============================================================
-- 1. INSERCIÓN DE ENVÍOS (TABLA HIJA/DEPENDIENTE)
-- ============================================================
-- Nota: Insertamos primero los envíos para poder referenciarlos
-- luego en la tabla de pedidos mediante la FK.
-- ============================================================

INSERT INTO envios (id, tracking, empresa, tipo, costo, fecha_despacho, fecha_estimada, estado_envio, eliminado) VALUES
(1, 'TRK-AAA-1001', 'ANDREANI', 'ESTANDAR', 5500.50, '2025-11-01', '2025-11-05', 'ENTREGADO', FALSE),
(2, 'TRK-OCC-2045', 'OCA', 'EXPRES', 8200.00, '2025-11-10', '2025-11-12', 'EN_TRANSITO', FALSE),
(3, 'TRK-EEO-9988', 'CORREO_ARG', 'ESTANDAR', 4100.00, NULL, NULL, 'EN_PREPARACION', FALSE),
(4, 'TRK-PPR-001', 'ANDREANI', 'EXPRES', 9000.00, NULL, NULL, 'EN_PREPARACION', FALSE); 
-- El envío 4 quedará "huérfano" inicialmente para probar asignación manual desde Java.

-- ============================================================
-- 2. INSERCIÓN DE PEDIDOS (TABLA PADRE)
-- ============================================================
-- Casos:
-- Pedidos 1, 2 y 3: Ya tienen envío asignado (Relación 1->1).
-- Pedidos 4 y 5: No tienen envío (envio_id NULL).
-- ============================================================

INSERT INTO pedidos (numero, fecha, cliente_nombre, total, estado, envio_id, eliminado) VALUES
('PED-001', '2025-10-25', 'Juan Perez', 150000.00, 'ENVIADO', 1, FALSE),
('PED-002', '2025-11-08', 'Maria Garcia', 45600.50, 'ENVIADO', 2, FALSE),
('PED-003', '2025-11-11', 'Tecno Sur SA', 980000.00, 'ENVIADO', 3, FALSE),
('PED-004', '2025-11-12', 'Carlos Lopez', 12500.00, 'FACTURADO', NULL, FALSE),
('PED-005', '2025-11-13', 'Ana Martinez', 32000.00, 'NUEVO', NULL, FALSE);

-- ============================================================
-- VERIFICACIÓN DE DATOS
-- ============================================================
-- Ejecuta esta consulta para ver todo integrado:
/*
SELECT 
    p.id AS ped_id, p.numero, p.cliente_nombre, p.estado AS estado_ped,
    e.tracking, e.empresa, e.estado_envio
FROM pedidos p
LEFT JOIN envios e ON p.envio_id = e.id;
*/