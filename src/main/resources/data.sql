-- CIModule data
INSERT INTO ci_modules (name, type, price) VALUES ('CI Plus Module', 'DVB-CI', 49.99);
INSERT INTO ci_modules (name, type, price) VALUES ('HD+ CI Module', 'DVB-S2', 69.99);

-- RemoteController data
INSERT INTO remote_controllers (compatible_with, battery_type, name, brand, price, original_stock) VALUES ('Samsung', 'AAA', 'Smart Remote', 'Samsung', 29.99, 100);
INSERT INTO remote_controllers (compatible_with, battery_type, name, brand, price, original_stock) VALUES ('LG', 'AA', 'Magic Remote', 'LG', 39.99, 50);

-- WallBracket data
INSERT INTO wall_brackets (size, adjustable, name, price) VALUES ('32-55 inch', true, 'Tilting Wall Mount', 25.99);
INSERT INTO wall_brackets (size, adjustable, name, price) VALUES ('40-70 inch', false, 'Fixed Wall Mount', 19.99);

-- User data
INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK', 'admin@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('test', '$2a$12$bvA2jU9sCgcycesBhXrCjeDBHcDOtuVb8KS9RLgqb8vXMIzL/kJQ6', 'test@test.nl', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');