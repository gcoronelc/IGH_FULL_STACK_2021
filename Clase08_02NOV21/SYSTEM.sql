
select * from eureka.cliente;


select * from HR.employees;

/*
Usuario para la aplicación
*/

create user usereureka identified by admin;

grant connect to usereureka;

grant all on eureka.empleado to usereureka;

grant all on eureka.asignado to usereureka;

grant all on eureka.cargomantenimiento to usereureka;

grant all on eureka.cliente to usereureka;

grant all on eureka.contador to usereureka;

grant all on eureka.costomovimiento to usereureka;

grant all on eureka.cuenta to usereureka;

grant all on eureka.interesmensual to usereureka;

grant all on eureka.moneda to usereureka;

grant all on eureka.movimiento to usereureka;

grant all on eureka.parametro to usereureka;

grant all on eureka.sucursal to usereureka;

grant all on eureka.tipomovimiento to usereureka;




