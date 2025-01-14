-- Insert data into Kapsejlads
INSERT INTO Kapsejlads (name, start_date, race_type)
VALUES
    ('Kapsejlads 1', '2025-06-01', 1),
    ('Kapsejlads 2', '2025-07-15', 2),
    ('Kapsejlads 3', '2025-08-20', 3);

-- Insert data into Sejlbåd
INSERT INTO Sejlbåd (name, båd_type, points) VALUES ('Nordic Star', 'TYPE_A', 0);
INSERT INTO Sejlbåd (name, båd_type, points) VALUES ('Ocean Breeze', 'TYPE_B', 0);
INSERT INTO Sejlbåd (name, båd_type, points) VALUES ('Wind Rider', 'TYPE_C', 0);
INSERT INTO Sejlbåd (name, båd_type, points) VALUES ('Sea Explorer', 'TYPE_A', 0);
INSERT INTO Sejlbåd (name, båd_type, points) VALUES ('Coastal Runner', 'TYPE_B', 0);
INSERT INTO Sejlbåd (name, båd_type, points) VALUES ('Harbor Spirit', 'TYPE_C', 0);

-- Assign Sejlbåd to Kapsejlads
-- Nordic Star and Sea Explorer participate in Kapsejlads 1
INSERT INTO kapsejlads_sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (1, 1);
INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (1, 4);

-- Ocean Breeze and Coastal Runner participate in Kapsejlads 2
INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (2, 2);
INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (2, 5);

-- Wind Rider and Harbor Spirit participate in Kapsejlads 3
INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (3, 3);
INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (3, 6);












--
-- -- Insert data into Kapsejlads
-- INSERT INTO Kapsejlads (name, start_date, race_type)
-- VALUES
--     ('Kapsejlads 1', '2025-06-01', 1),
--     ('Kapsejlads 2', '2025-07-15', 2),
--     ('Kapsejlads 3', '2025-08-20', 3);
--
-- -- Insert data into Sejlbåd
-- INSERT INTO Sejlbåd (name, kapsejlads_id, båd_type, points) VALUES ('Nordic Star', 1, 'TYPE_A', 0);
-- INSERT INTO Sejlbåd (name, kapsejlads_id, båd_type, points) VALUES ('Ocean Breeze', 1, 'TYPE_B', 0);
-- INSERT INTO Sejlbåd (name, kapsejlads_id, båd_type, points) VALUES ('Wind Rider', 2,  'TYPE_C', 0);
-- INSERT INTO Sejlbåd (name, kapsejlads_id, båd_type, points) VALUES ('Sea Explorer', 2, 'TYPE_A', 0);
-- INSERT INTO Sejlbåd (name, kapsejlads_id, båd_type, points) VALUES ('Coastal Runner', 3, 'TYPE_B', 0);
-- INSERT INTO Sejlbåd (name, kapsejlads_id, båd_type, points) VALUES ('Harbor Spirit', 3, 'TYPE_C', 0);
--
-- -- -- Assign Sejlbåd to Kapsejlads
-- -- -- Nordic Star and Sea Explorer participate in Kapsejlads 1
-- -- INSERT INTO kapsejlads_sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (1, 1);
-- -- INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (1, 4);
-- --
-- -- -- Ocean Breeze and Coastal Runner participate in Kapsejlads 2
-- -- INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (2, 2);
-- -- INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (2, 5);
-- --
-- -- -- Wind Rider and Harbor Spirit participate in Kapsejlads 3
-- -- INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (3, 3);
-- -- INSERT INTO Kapsejlads_Sejlbåde (kapsejlads_id, sejlbåde_id) VALUES (3, 6);
