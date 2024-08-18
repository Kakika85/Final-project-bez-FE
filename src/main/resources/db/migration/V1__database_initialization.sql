-- Create the Teachers table
CREATE TABLE teacher
(
    teacher_id      INT AUTO_INCREMENT PRIMARY KEY,
    teacher_name    VARCHAR(50) NOT NULL,
    teacher_surname VARCHAR(50) NOT NULL
);

-- Create the ClassRooms table
CREATE TABLE class_room
(
    class_room_id   INT AUTO_INCREMENT PRIMARY KEY,
    class_room_name VARCHAR(100) NOT NULL,
    teacher_id      INT,
    FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id)
);

-- Create the Students table
CREATE TABLE student
(
    student_id      INT AUTO_INCREMENT PRIMARY KEY,
    student_name    VARCHAR(50) NOT NULL,
    student_surname VARCHAR(50) NOT NULL,
    class_room_id   INT,
    FOREIGN KEY (class_room_id) REFERENCES class_room (class_room_id)
    ON DELETE CASCADE
);

-- Create the Parents table
CREATE TABLE parent
(
    parent_id      INT AUTO_INCREMENT PRIMARY KEY,
    parent_name    VARCHAR(50)  NOT NULL,
    parent_surname VARCHAR(50)  NOT NULL,
    parent_email   VARCHAR(100) NOT NULL UNIQUE,
    parent_phone   VARCHAR(15)
);

-- Create the Student_Parent relationship table
CREATE TABLE student_parent
(
    student_id INT,
    parent_id  INT,
    PRIMARY KEY (student_id, parent_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id)
    ON DELETE CASCADE,
    FOREIGN KEY (parent_id) REFERENCES parent (parent_id)
    ON DELETE CASCADE
);
