DROP TABLE IF EXISTS patient;

CREATE TABLE patient (
                         id VARCHAR(36) PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) UNIQUE NOT NULL,
                         address TEXT NOT NULL,
                         date_of_birth TIMESTAMP NOT NULL,
                         register_date TIMESTAMP NOT NULL
);

INSERT INTO patient (id, name, email, address, date_of_birth, register_date) VALUES
                                                                                 ('550e8400-e29b-41d4-a716-446655440000', 'Alice Johnson', 'alice@example.com', '123 Main St, Springfield', '1990-05-15 00:00:00', '2025-04-10 09:00:00'),
                                                                                 ('660e8400-e29b-41d4-a716-446655440001', 'Bob Smith', 'bob@example.com', '456 Elm St, Rivertown', '1985-10-20 00:00:00', '2025-04-10 09:15:00'),
                                                                                 ('770e8400-e29b-41d4-a716-446655440002', 'Charlie Rose', 'charlie@example.com', '789 Oak St, Laketown', '1978-02-25 00:00:00', '2025-04-10 09:30:00');
