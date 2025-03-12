-- CIModule data
INSERT INTO ci_modules (name, type, price) VALUES ('CI Plus Module', 'DVB-CI', 49.99);
INSERT INTO ci_modules (name, type, price) VALUES ('HD+ CI Module', 'DVB-S2', 69.99);

-- RemoteController data
INSERT INTO remote_controllers (compatible_with, battery_type, name, brand, price, original_stock) VALUES ('Samsung', 'AAA', 'Smart Remote', 'Samsung', 29.99, 100);
INSERT INTO remote_controllers (compatible_with, battery_type, name, brand, price, original_stock) VALUES ('LG', 'AA', 'Magic Remote', 'LG', 39.99, 50);

-- WallBracket data
INSERT INTO wall_brackets (size, adjustable, name, price) VALUES ('32-55 inch', true, 'Tilting Wall Mount', 25.99);
INSERT INTO wall_brackets (size, adjustable, name, price) VALUES ('40-70 inch', false, 'Fixed Wall Mount', 19.99);
