-- database: ../DataBase/prjDataBase.sqlite
DROP TABLE IF EXISTS Administrador;
DROP TABLE IF EXISTS AdministradorTipo;
DROP TABLE IF EXISTS Producto;
DROP TABLE IF EXISTS Seccion;
DROP TABLE IF EXISTS Categoria;
CREATE TABLE AdministradorTipo(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

INSERT INTO AdministradorTipo (nombre) VALUES
('admin'),
('superAdmin');

CREATE TABLE Administrador(
    nAdmin INTEGER PRIMARY KEY AUTOINCREMENT,
    Codigo TEXT CHECK(length(Codigo) = 13) NOT NULL UNIQUE,
    Tipo INTEGER,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,

    FOREIGN KEY (Tipo) REFERENCES AdministradorTipo(id)
);
INSERT INTO Administrador(Codigo, Tipo) VALUES
('1234567890120', 1),
('1234567890121', 2),
('1234567890122', 1),
('1234567890123', 2);


CREATE TABLE Categoria (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

INSERT INTO Categoria(nombre) VALUES
('Comestibles'),
('Macotas'),
('Deportes'),
('Belleza'),
('Hogar');

CREATE TABLE Seccion(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    id_categoria INTEGER,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,

    FOREIGN KEY (id_categoria) REFERENCES Categoria(id)
);

INSERT INTO Seccion(nombre, id_categoria) VALUES
('Cereal', 1),
('Lacteos', 1),
('Comida de perro', 2),
('Jueguete para perro',2),
('Perdfumeria', 4),
('Despensa', 1);


CREATE TABLE Producto(
    nProducto INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT,
    BarCode TEXT CHECK(length(BarCode) = 13) NOT NULL UNIQUE,
    Precio REAL NOT NULL DEFAULT 0.0,
    id_Seccion INTEGER,
    id_Categoria INTEGER,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,
    
    FOREIGN KEY (id_Seccion) REFERENCES Seccion(id),
    FOREIGN KEY (id_Categoria) REFERENCES Categoria(id)

);

INSERT INTO Producto(Nombre, BarCode, Precio, id_Seccion, id_Categoria) VALUES
('Huevos', '1234567890120', 1.5, 6, 1),
('Leche', '1234567890121', 1, 2, 1), 
('Perfume', '1234567890122', 5.75, 5, 4);

