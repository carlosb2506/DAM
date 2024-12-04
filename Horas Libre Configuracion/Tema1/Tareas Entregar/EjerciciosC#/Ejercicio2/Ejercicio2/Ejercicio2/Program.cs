using Ejercicio2;


Empleado empleado1 = new Empleado("Carlos", 12, true, 55, Empleado.Level.ANALISTA);

Console.WriteLine(empleado1.ToString());

Console.WriteLine();

Empleado empleado2 = new Empleado("Alejandro", 3, false, 40, Empleado.Level.JUNIOR);

Console.WriteLine(empleado2.ToString());

Console.WriteLine();

Empleado empleado3 = new Empleado("Fran", 6, false, 33, Empleado.Level.SENIOR);

Console.WriteLine(empleado3.ToString());
