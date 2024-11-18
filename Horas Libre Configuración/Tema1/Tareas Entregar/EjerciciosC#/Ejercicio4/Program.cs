string cntdd;
int cantidadPasswords;
int longitud;
do
{
    Console.WriteLine("¿Cuántas contraseñas deseas ingresar?: ");
    cntdd = Console.ReadLine();
    cantidadPasswords = Int32.Parse(cntdd);
    Console.WriteLine("¿De que longitud desea las contraseñas?: ");
    longitud = Int32.Parse(Console.ReadLine());
}
while (cantidadPasswords <= 0 || longitud <= 0);


string[] passwords = new string[cantidadPasswords];
bool[] esFuerte = new bool[cantidadPasswords];


for (int i = 0; i < cantidadPasswords; i++)
{
    Password password = new Password();
    passwords[i] = password.GenerarContrasenia(longitud);
    esFuerte[i] = password.EsFuerte(passwords[i]);
    Console.WriteLine("Contraseña " + passwords[i] + " - " + (esFuerte[i] ? "Es fuerte" : "Es débil"));
}
