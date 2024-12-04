using Ejercicio1;
using static Ejercicio1.Vehiculo;


Vehiculo audi = new Vehiculo("4354 MGF", Marca.AUDI, Tipo.DEPORTIVO, 6, 78349.98, true, true, 6);
Console.WriteLine(audi.ToString());
Console.WriteLine("Su precio con los extras solicitados es: " + audi.ImporteTotal());
Console.WriteLine();
Console.WriteLine();

Vehiculo toyota = new Vehiculo("4354 HYF", Marca.TOYOTA, Tipo.TODOTERRENO, 3, 33456.99, false, true, 2);
Console.WriteLine(toyota.ToString());
Console.WriteLine("Su precio con los extras solicitados es: " + toyota.ImporteTotal());
Console.WriteLine();
Console.WriteLine();

Vehiculo alfaRomeo = new Vehiculo("4354 LFD", Marca.ALFAROMEO, Tipo.SEDAN, 5, 49654.96, true, false, 5);
Console.WriteLine(alfaRomeo.ToString());
Console.WriteLine("Su precio con los extras solicitados es: " + alfaRomeo.ImporteTotal());
