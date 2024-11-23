// Crear instancia de Gestiones
 Gestiones gestiones = new Gestiones();

// Crear personajes
Personaje sacerdote1 = new Sacerdote("Sacerdote1");
Personaje curandero1 = new Curandero("Curandero1"); 
Personaje sacerdote2 = new Sacerdote("Sacerdote2"); 
Personaje curandero2 = new Curandero("Curandero2");

// Agregar personajes a la lista
gestiones.CrearPersonaje(sacerdote1); 
gestiones.CrearPersonaje(curandero1); 
gestiones.CrearPersonaje(sacerdote2); 
gestiones.CrearPersonaje(curandero2); 

// Mostrar estado inicial
Console.WriteLine("Estado inicial:");
gestiones.MostrarEstado();


// Sacerdote1 ataca a Curandero1
gestiones.AtacarPersonaje("Sacerdote1", "Curandero1"); 

// Sacerdote2 ataca a Curandero2
gestiones.AtacarPersonaje("Sacerdote2", "Curandero2"); 

// Mostrar estado después de los ataques
Console.WriteLine($"\nEstado después de ataques:");
gestiones.MostrarEstado();


// Curandero1 cura a Sacerdote1
gestiones.CurarPersonaje("Curandero1", "Sacerdote1"); 

// Sacerdote2 se cura a sí mismo

gestiones.Curarse("Sacerdote2");


gestiones.MostrarEstado();
