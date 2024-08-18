USE finalProject;

-- Insert data into Teachers table
INSERT INTO teacher (teacher_name, teacher_surname) VALUES
('John', 'Doe'),
('Jane', 'Smith'),
('Sarah', 'Connor'),
('Mike', 'Taylor'),
('Emily', 'White'),
('Robert', 'Brown'),
('Lisa', 'Johnson'),
('Mark', 'Wilson'),
('Nancy', 'Lee'),
('David', 'King');

-- Insert data into ClassRooms table
INSERT INTO class_room (class_room_name, teacher_id) VALUES
('Math 101', 1),
('Science 102', 2),
('History 201', 3),
('English 202', 4),
('Physics 301', 5),
('Chemistry 302', 6),
('Biology 303', 7),
('Geography 304', 8),
('Music 401', 9),
('Art 402', 10);

-- Insert data into Students table
-- This block will now have 60 students, aiming for over 80% with two parents.
INSERT INTO student (student_name, student_surname, class_room_id) VALUES
('Alice', 'Johnson', 1),
('Bob', 'Brown', 1),
('Charlie', 'Davis', 2),
('David', 'Evans', 2),
('Ella', 'Foster', 3),
('Fiona', 'Green', 3),
('George', 'Hill', 4),
('Hannah', 'Irwin', 4),
('Ivy', 'Jones', 5),
('Jack', 'Keller', 5),
('Karen', 'Long', 6),
('Liam', 'Miller', 6),
('Mia', 'Nelson', 7),
('Noah', 'Owens', 7),
('Olivia', 'Perez', 8),
('Paul', 'Quinn', 8),
('Quinn', 'Reed', 9),
('Ruby', 'Scott', 9),
('Sophia', 'Turner', 10),
('Tom', 'Underwood', 10),
('Emma', 'Johnson', 1),  -- Alice's sibling
('Liam', 'Brown', 1),    -- Bob's sibling
('Lucas', 'Davis', 2),   -- Charlie's sibling
('Sophia', 'Evans', 2),  -- David's sibling
('Ava', 'Foster', 3),    -- Ella's sibling
('Oliver', 'Green', 3),  -- Fiona's sibling
('Charlotte', 'Hill', 4),
('Mason', 'Irwin', 4),
('Amelia', 'Jones', 5),
('Ethan', 'Keller', 5),
('Isabella', 'Long', 6),
('James', 'Miller', 6),
('Harper', 'Nelson', 7),
('Logan', 'Owens', 7),
('Abigail', 'Perez', 8),
('Benjamin', 'Quinn', 8),
('Chloe', 'Reed', 9),
('Daniel', 'Scott', 9),
('Elizabeth', 'Turner', 10),
('Matthew', 'Underwood', 10),
('Aiden', 'Johnson', 1),
('Grace', 'Brown', 1),
('Anthony', 'Davis', 2),
('Natalie', 'Evans', 2),
('Zoe', 'Foster', 3),
('Elijah', 'Green', 3),
('Samantha', 'Hill', 4),
('Gabriel', 'Irwin', 4),
('Emily', 'Jones', 5),
('Andrew', 'Keller', 5),
('Scarlett', 'Long', 6),
('William', 'Miller', 6),
('Lily', 'Nelson', 7),
('Henry', 'Owens', 7),
('Victoria', 'Perez', 8),
('Jackson', 'Quinn', 8),
('Ella', 'Reed', 9),
('Michael', 'Scott', 9),
('Avery', 'Turner', 10),
('Alexander', 'Underwood', 10);

-- Insert data into Parents table
-- Adding more unique parents
INSERT INTO parent (parent_name, parent_surname, parent_email, parent_phone) VALUES
('Michael', 'Johnson', 'michael.johnson@example.com', '555-1234'),
('Emily', 'Brown', 'emily.brown@example.com', '555-5678'),
('David', 'Davis', 'david.davis@example.com', '555-8765'),
('Susan', 'Evans', 'susan.evans@example.com', '555-2345'),
('Helen', 'Foster', 'helen.foster@example.com', '555-3456'),
('Andrew', 'Green', 'andrew.green@example.com', '555-4567'),
('Barbara', 'Hill', 'barbara.hill@example.com', '555-5678'),
('Charles', 'Irwin', 'charles.irwin@example.com', '555-6789'),
('Donna', 'Jones', 'donna.jones@example.com', '555-7890'),
('Edward', 'Keller', 'edward.keller@example.com', '555-8901'),
('Fiona', 'Long', 'fiona.long@example.com', '555-9012'),
('George', 'Miller', 'george.miller@example.com', '555-0123'),
('Hannah', 'Nelson', 'hannah.nelson@example.com', '555-2346'),
('Ian', 'Owens', 'ian.owens@example.com', '555-3457'),
('Jennifer', 'Perez', 'jennifer.perez@example.com', '555-4568'),
('Kevin', 'Quinn', 'kevin.quinn@example.com', '555-5679'),
('Laura', 'Reed', 'laura.reed@example.com', '555-6780'),
('Matthew', 'Scott', 'matthew.scott@example.com', '555-7891'),
('Natalie', 'Turner', 'natalie.turner@example.com', '555-8902'),
('Oliver', 'Underwood', 'oliver.underwood@example.com', '555-9013'),
-- Additional parents for new students
('Paula', 'Watson', 'paula.watson@example.com', '555-1235'),
('Ryan', 'Young', 'ryan.young@example.com', '555-5679'),
('Tina', 'Zimmer', 'tina.zimmer@example.com', '555-8766'),
('Vince', 'Adams', 'vince.adams@example.com', '555-2346'),
('Wendy', 'Baker', 'wendy.baker@example.com', '555-3457');

-- Insert data into Student_Parent relationship table
INSERT INTO student_parent (student_id, parent_id) VALUES
-- Each student should have at least one parent, most have two
(1, 1), (1, 2),  -- Alice
(2, 2), (2, 3),  -- Bob
(3, 3), (3, 4),  -- Charlie
(4, 4), (4, 5),  -- David
(5, 5), (5, 6),  -- Ella
(6, 6), (6, 7),  -- Fiona
(7, 7), (7, 8),  -- George
(8, 8), (8, 9),  -- Hannah
(9, 9), (9, 10), -- Ivy
(10, 10),        -- Jack (one parent)
(11, 1), (11, 2), -- Karen
(12, 2), (12, 3), -- Liam
(13, 3), (13, 4), -- Mia
(14, 4), (14, 5), -- Noah
(15, 5), (15, 6), -- Olivia
(16, 6), (16, 7), -- Paul
(17, 7), (17, 8), -- Quinn
(18, 8), (18, 9), -- Ruby
(19, 9), (19, 10), -- Sophia
(20, 10), (20, 1), -- Tom
-- Siblings and new students
(21, 1), (21, 2),  -- Emma (sibling of Alice)
(22, 2), (22, 3),  -- Liam (sibling of Bob)
(23, 3), (23, 4),  -- Lucas (sibling of Charlie)
(24, 4), (24, 5),  -- Sophia (sibling of David)
(25, 5), (25, 6),  -- Ava (sibling of Ella)
(26, 6), (26, 7),  -- Oliver (sibling of Fiona)
(27, 7), (27, 8),  -- Charlotte
(28, 8), (28, 9),  -- Mason
(29, 9), (29, 10), -- Amelia
(30, 10), (30, 11), -- Ethan
(31, 11), (31, 12), -- Isabella
(32, 12), (32, 13), -- James
(33, 13), (33, 14), -- Harper
(34, 14), (34, 15), -- Logan
(35, 15), (35, 16), -- Abigail
(36, 16), (36, 17), -- Benjamin
(37, 17), (37, 18), -- Chloe
(38, 18), (38, 19), -- Daniel
(39, 19), (39, 20), -- Elizabeth
(40, 20), (40, 21), -- Matthew
(41, 21), (41, 22), -- Aiden
(42, 22), (42, 23), -- Grace
(43, 23), (43, 24), -- Anthony
(44, 24), (44, 25), -- Natalie
(45, 1), (45, 2),  -- Zoe
(46, 2), (46, 3),  -- Elijah
(47, 3), (47, 4),  -- Samantha
(48, 4), (48, 5),  -- Gabriel
(49, 5), (49, 6),  -- Emily
(50, 6), (50, 7),  -- Andrew
(51, 7), (51, 8),  -- Scarlett
(52, 8), (52, 9),  -- William
(53, 9), (53, 10), -- Lily
(54, 10), (54, 11), -- Henry
(55, 11), (55, 12), -- Victoria
(56, 12), (56, 13), -- Jackson
(57, 13), (57, 14), -- Ella
(58, 14), (58, 15), -- Michael
(59, 15), (59, 16), -- Avery
(60, 16), (60, 17); -- Alexander
