create table Empleado
(
    ID_Empleado int primary key,
    Nombre_Empleado varchar(30),
    Tipo_Empleado int
);

create table Producto
(
    ID_Producto int primary key,
    Nombre_Producto varchar(30),
    Costo_Elaboracion float,
    Costo_Venta float
);

create table Ventas
(
    ID_Venta int primary key,
    Costo_Venta float,
    Utilidades float,
    Fecha_Venta datetime
);

create table Venta_Producto
(
    ID_Venta int,
    ID_Producto int,
    Cantidad int,
    Costo_Articulos float,
    
    foreign key (ID_Venta) references Ventas(ID_Venta),
    foreign key (ID_Producto) references Producto(ID_Producto)
);

create table Inventario
(
    ID_abastecimiento int primary key,
    ID_Producto int,
    Cantidad int,
    Fecha_Abastecimiento date,
    
    foreign key (ID_Producto) references Producto(ID_Producto)
);

create table ConfiguracionUsuario
(
    ID_Empleado int,
    Tema int,
    Componente1,
    Componente2,
    
    foreign key (ID_Empleado) references Empleado(ID_Empleado)
);
