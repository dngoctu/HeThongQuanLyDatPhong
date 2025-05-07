-- Tạo bảng address
CREATE TABLE IF NOT EXISTS address (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    district VARCHAR(255),
    city VARCHAR(255) NOT NULL
);

-- Thêm dữ liệu mẫu
INSERT INTO address (name, district, city) VALUES
('Chợ Bến Thành', 'Quận 1', 'TP HCM'),
('Công viên Lê Văn Tám', 'Quận 3', 'TP HCM'),
('Hồ Gươm', 'Hoàn Kiếm', 'Hà Nội'),
('Phố cổ Hội An', 'Minh An', 'Hội An'),
('Chùa Thiên Mụ', 'Hương Long', 'Huế');
