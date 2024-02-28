DROP TABLE IF EXISTS OrderDetails;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Sections;
DROP TABLE IF EXISTS Locations;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Roles;


-- Create Roles Table
CREATE TABLE IF NOT EXISTS Roles (
                       role_id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       description VARCHAR(255),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Users Table
CREATE TABLE IF NOT EXISTS Users (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       role_id INT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);

-- Create Categories Table
CREATE TABLE IF NOT EXISTS Categories (
                            category_id INT PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(255) NOT NULL,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Locations Table
CREATE TABLE IF NOT EXISTS Locations (
                           location_id INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Sections Table
CREATE TABLE IF NOT EXISTS Sections (
                          section_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          location_id INT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (location_id) REFERENCES Locations(location_id)
);

-- Create Products Table
CREATE TABLE IF NOT EXISTS Products (
                          product_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          quantity INT,
                          category_id INT,
                          location_id INT,
                          section_id INT,
                          price DECIMAL(10, 2),
                          sales_price DECIMAL(10, 2),
                          isbn VARCHAR(13),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (category_id) REFERENCES Categories(category_id),
                          FOREIGN KEY (location_id) REFERENCES Locations(location_id),
                          FOREIGN KEY (section_id) REFERENCES Sections(section_id)
);

-- Create Customers Table
CREATE TABLE IF NOT EXISTS Customers (
                           customer_id INT PRIMARY KEY AUTO_INCREMENT,
                           first_name VARCHAR(255),
                           last_name VARCHAR(255),
                           email VARCHAR(255),
                           phone_number VARCHAR(20),
                           billing_address TEXT,
                           shipping_address TEXT,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Orders Table
CREATE TABLE IF NOT EXISTS Orders (
                        order_id INT PRIMARY KEY AUTO_INCREMENT,
                        customer_id INT,
                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        total_amount DECIMAL(10, 2),
                        status VARCHAR(50),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Create OrderDetails Table
CREATE TABLE IF NOT EXISTS OrderDetails (
                              order_detail_id INT PRIMARY KEY AUTO_INCREMENT,
                              order_id INT,
                              product_id INT,
                              quantity INT,
                              unit_price DECIMAL(10, 2),
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (order_id) REFERENCES Orders(order_id),
                              FOREIGN KEY (product_id) REFERENCES Products(product_id)
);


-- Roles
INSERT INTO Roles (name, description) VALUES ('admin', 'Administrator');
INSERT INTO Roles (name, description) VALUES ('user', 'Regular User');

-- Users
INSERT INTO Users (username, password, email, first_name, last_name, role_id) VALUES
    ('admin_user', 'hashed_admin_password', 'admin@example.com', 'Admin', 'User', 1);
INSERT INTO Users (username, password, email, first_name, last_name, role_id) VALUES
    ('regular_user', 'hashed_regular_password', 'user@example.com', 'Regular', 'User', 2);

-- Categories
INSERT INTO Categories (name) VALUES ('Electronics');
INSERT INTO Categories (name) VALUES ('Clothing');
INSERT INTO Categories (name) VALUES ('Books');

-- Locations
INSERT INTO Locations (name) VALUES ('Warehouse A');
INSERT INTO Locations (name) VALUES ('Warehouse B');

-- Sections
INSERT INTO Sections (name, location_id) VALUES ('Section 1', 1);
INSERT INTO Sections (name, location_id) VALUES ('Section 2', 1);
INSERT INTO Sections (name, location_id) VALUES ('Section 3', 2);

-- Products
INSERT INTO Products (name, description, quantity, category_id, location_id, section_id, price, sales_price, isbn) VALUES
    ('Laptop', 'Powerful laptop for multitasking', 50, 1, 1, 1, 899.99, 799.99, '1234567890123');
INSERT INTO Products (name, description, quantity, category_id, location_id, section_id, price, sales_price, isbn) VALUES
    ('T-shirt', 'Comfortable cotton T-shirt', 100, 2, 1, 2, 19.99, 14.99, '9876543210987');
INSERT INTO Products (name, description, quantity, category_id, location_id, section_id, price, sales_price, isbn) VALUES
    ('Java Programming Book', 'Comprehensive guide to Java programming', 30, 3, 2, 3, 49.99, 39.99, '5678901234567');

-- Customers
INSERT INTO Customers (first_name, last_name, email, phone_number, billing_address, shipping_address) VALUES
    ('John', 'Doe', 'john.doe@example.com', '123-456-7890', '123 Main St, City, Country', '456 Second St, City, Country');
INSERT INTO Customers (first_name, last_name, email, phone_number, billing_address, shipping_address) VALUES
    ('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210', '789 Third St, City, Country', '789 Fourth St, City, Country');

-- Orders
INSERT INTO Orders (customer_id, order_date, total_amount, status) VALUES
    (1, '2024-01-28 12:00:00', 799.99, 'Shipped');
INSERT INTO Orders (customer_id, order_date, total_amount, status) VALUES
    (2, '2024-01-29 14:30:00', 34.98, 'Processing');

-- OrderDetails
INSERT INTO OrderDetails (order_id, product_id, quantity, unit_price) VALUES
    (1, 1, 1, 799.99);
INSERT INTO OrderDetails (order_id, product_id, quantity, unit_price) VALUES
    (2, 2, 2, 14.99);
