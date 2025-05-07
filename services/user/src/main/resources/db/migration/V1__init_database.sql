CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    description TEXT,
    address_id INT
);

-- Dữ liệu mẫu
INSERT INTO user (id,first_name, last_name, email, password, role, description, address_id) VALUES
(1, 'Nguyễn', 'Văn A', 'a@example.com', 'pass123', 'customer', 'Khách hàng thường', 1),
(2, 'Trần', 'Thị B', 'b@example.com', 'pass456', 'partner', 'Đối tác phân phối', 2),
(3, 'Lê', 'Văn C', 'c@example.com', 'admin123', 'admin', 'Quản trị viên hệ thống', 3);
