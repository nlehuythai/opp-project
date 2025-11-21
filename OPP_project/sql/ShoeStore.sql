CREATE DATABASE SHOESTORE
GO
CREATE TABLE Category (
    categoryId INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE TABLE Shoe (
    shoeId VARCHAR(20) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    brand NVARCHAR(100) NOT NULL,
    size INT NOT NULL,
    price DECIMAL(12,2) NOT NULL,
    quantity INT NOT NULL,

    categoryId INT NOT NULL,
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId),

    -- Để phân biệt Sneaker / Boot / Running
    type VARCHAR(20) NOT NULL,

    -- Thuộc tính riêng của Sneaker
    hasAirCushion BIT,

    -- Thuộc tính riêng của Boot
    bootHeight INT,

    -- Thuộc tính riêng của RunningShoe
    weight FLOAT
);
CREATE TABLE Customer (
    customerId VARCHAR(20) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);
CREATE TABLE Invoice (
    invoiceId VARCHAR(20) PRIMARY KEY,
    date DATE NOT NULL,

    customerId VARCHAR(20) NOT NULL,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);
CREATE TABLE InvoiceItem (
    invoiceId VARCHAR(20) NOT NULL,
    shoeId VARCHAR(20) NOT NULL,
    quantity INT NOT NULL,

    PRIMARY KEY (invoiceId, shoeId),

    FOREIGN KEY (invoiceId) REFERENCES Invoice(invoiceId),
    FOREIGN KEY (shoeId) REFERENCES Shoe(shoeId)
);

