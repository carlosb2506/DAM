Gestiones gestiones = new Gestiones();

// Creacion de personajes
Personaje sacerdote1 = new Sacerdote("SACERDOTE1");
Personaje curandero1 = new Curandero("CURANDERO1"); 
Personaje sacerdote2 = new Sacerdote("SACERDOTE2"); 
Personaje curandero2 = new Curandero("CURANDERO2");

// Agregar personajes a la lista
gestiones.CrearPersonaje(sacerdote1); 
gestiones.CrearPersonaje(curandero1); 
gestiones.CrearPersonaje(sacerdote2); 
gestiones.CrearPersonaje(curandero2);

curandero1.Comer();

// Mostrar estado inicial
Console.WriteLine("ESTADO INICIAL:");
gestiones.MostrarEstado();


// Sacerdote1 ataca a Curandero1
gestiones.AtacarPersonaje("SACERDOTE1", "CURANDERO1"); 

// Sacerdote2 ataca a Curandero2
gestiones.AtacarPersonaje("SACERDOTE2", "CURANDERO2"); 

// Mostrar estado después de los ataques
Console.WriteLine("ESTADO DESPUÉS DE ATAQUES:");
gestiones.MostrarEstado();


// Curandero1 cura a Sacerdote1
gestiones.CurarPersonaje("CURANDERO1", "SACERDOTE1"); 

// Sacerdote2 se cura a sí mismo

gestiones.Curarse("SACERDOTE2");

// Sacerdote1 ataca a Curandero1
gestiones.AtacarPersonaje("SACERDOTE1", "CURANDERO1");

// Sacerdote2 ataca a Curandero2
gestiones.AtacarPersonaje("SACERDOTE2", "CURANDERO2");

Console.WriteLine("ESTADO:");
gestiones.MostrarEstado();
