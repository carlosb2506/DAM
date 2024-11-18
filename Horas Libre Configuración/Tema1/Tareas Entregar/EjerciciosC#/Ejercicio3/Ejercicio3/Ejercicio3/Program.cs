using System.Net;

Console.WriteLine("Dime el nombre de la persona: ");
string nombre = Console.ReadLine();
Console.WriteLine("Dime el DNI de la persona: ");
string dni = Console.ReadLine();
Console.WriteLine("Dime el genero de la persona: ");
char genero = Char.Parse(Console.ReadLine());
Console.WriteLine("Dime la edad de la persona: ");
int edad = Int32.Parse(Console.ReadLine());
Console.WriteLine("Dime el peso de la persona: ");
double peso = Double.Parse(Console.ReadLine());
Console.WriteLine("Dime la altura de la persona: ");
double altura = Double.Parse(Console.ReadLine());

Persona persona1 = new Persona(nombre, dni,genero,edad,peso,altura);
Console.WriteLine(persona1.ToString());
persona1.MayorDeEdad(persona1.Edad);
Console.WriteLine();

Console.WriteLine("Dime el nombre de la persona: ");
nombre = Console.ReadLine();
Console.WriteLine("Dime el DNI de la persona: ");
dni = Console.ReadLine();
Console.WriteLine("Dime el genero de la persona: ");
genero = Char.Parse(Console.ReadLine());
Console.WriteLine("Dime la edad de la persona: ");
edad = Int32.Parse(Console.ReadLine());

Persona persona2 = new Persona(nombre, dni ,edad,genero);
Console.WriteLine(persona2.ToString());
persona2.MayorDeEdad(persona2.Edad);
Console.WriteLine();

Persona persona3 = new Persona();
Console.WriteLine(persona3.ToString());
persona3.MayorDeEdad(persona3.Edad);
Console.WriteLine();
