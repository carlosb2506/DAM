using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
public class Password
{
    private int longitud;
    private string contrasenia;
    public int Longitud
    {
        get { return longitud; }
        set { longitud = value; }
    }
    public string Contrasenia
    {
        get { return contrasenia; }
        set { contrasenia = value; }
    }
    public Password() {
        Longitud = 8;
    }
    public Password(int longitud)
    {
        Longitud = longitud;
    }

    public bool EsFuerte(String contraseña)
    {
        int contadorMayusculas = 0;
        int contadorMinusculas = 0;
        int contadorNumeros = 0;
        bool esFuerte = false;

        foreach (char caracter in contraseña)
        {
            if (char.IsUpper(caracter))
            {
                contadorMayusculas++;
            }
            else if (char.IsLower(caracter))
            {
                contadorMinusculas++;
            }
            else if (char.IsDigit(caracter))
            {
                contadorNumeros++;
            }
        }
        if (contadorMayusculas >= 2 && contadorMinusculas >= 1 && contadorNumeros > 5)
        {
            esFuerte = true;
        }
        return esFuerte;
    }


    public String GenerarContrasenia(int longitud)
    {
        Random rand = new Random();
        String contra = "";
        for (int i = 0; i < longitud; i++)
        {
            int numAle = rand.Next(1, 4);
            if (numAle == 2)
            {
                contra += (char)(rand.Next(65,90)); // Aleatorio para mayusculas
            }
            else if (numAle == 1)
            {
                contra += (char)(rand.Next(97,122)); // Aleatorio para Minusculas
            }
            else
            {
                contra += (int)(rand.Next(0, 9));
            }
        }
        return contra;
    }
}

