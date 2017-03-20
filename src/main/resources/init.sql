ALTER TABLE department ADD CONSTRAINT departmentUniqueNameParent UNIQUE (name, parentid);

INSERT INTO department(id, name) VALUES (1, 'Main department');

INSERT INTO department(id, name, parentid) VALUES (2, 'Secondary department 1', 1);
INSERT INTO department(id, name, parentid) VALUES (3, 'Secondary department 2', 1);
INSERT INTO department(id, name, parentid) VALUES (4, 'Secondary department 3', 1);
INSERT INTO department(id, name, parentid) VALUES (5, 'Secondary department 4', 1);

INSERT INTO department(id, name, parentid) VALUES (6, 'Additional department 1', 3);
INSERT INTO department(id, name, parentid) VALUES (7, 'Additional department 2', 3);
INSERT INTO department(id, name, parentid) VALUES (8, 'Additional department 3', 3);
INSERT INTO department(id, name, parentid) VALUES (9, 'Additional department 4', 4);
INSERT INTO department(id, name, parentid) VALUES (10, 'Additional department 5', 4);
INSERT INTO department(id, name, parentid) VALUES (11, 'Additional department 6', 4);
INSERT INTO department(id, name, parentid) VALUES (12, 'Additional department 7', 11);


INSERT INTO employee(firstname, lastname, gender, driverlicense, departmentid) VALUES ('Wimbledon', 'Tennismatch', 0, 'af3af2sdf', 2);
INSERT INTO employee(firstname, lastname, gender, driverlicense, departmentid) VALUES ('Congleton', 'Banglesnatch', 0, 'af3af2sdf', 3);
INSERT INTO employee (firstname, lastname, gender, driverlicense, departmentid)
VALUES ('Buttercup', 'Chesterfield', 0, 'af3af2sdf', 9);
INSERT INTO employee(firstname, lastname, gender, departmentid) VALUES ('Brewery', 'Crumplehorn', 1, 4);
INSERT INTO employee (firstname, lastname, middlename, gender, driverlicense, departmentid)
VALUES ('Budapest', 'Ampersand', 'Candygram', 0, 'af3af2sdf', 9);
INSERT INTO employee(firstname, lastname, middlename, gender, driverlicense, departmentid) VALUES ('Anglerfish', 'Coggleswort', 'Colonist', 1, 'af3af2sdf', 7);
INSERT INTO employee(firstname, lastname, middlename, gender, departmentid) VALUES ('Benadryl', 'Claritin', 'Countryside', 0, 2);

