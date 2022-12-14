CREATE TABLE IF NOT EXISTS member (
    id SERIAL NOT NULL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NULL,
    location VARCHAR(50) NULL,
    role VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS lesson (
    id SERIAL NOT NULL PRIMARY KEY,
    method VARCHAR(50) NOT NULL,
    subject VARCHAR(100) NOT NULL,
    price VARCHAR(50) NOT NULL,
    rating VARCHAR(50) NULL,
    member_id BIGINT NOT NULL 
        CONSTRAINT lesson_member_fkey REFERENCES member
);

CREATE TABLE IF NOT EXISTS request_card (
    id SERIAL NOT NULL PRIMARY KEY,
    sender VARCHAR(50) NOT NULL,
    receiver VARCHAR(100) NOT NULL,
    message VARCHAR(50) NULL,
    lesson_id BIGINT NOT NULL
        CONSTRAINT request_card_lesson_fkey REFERENCES lesson
);