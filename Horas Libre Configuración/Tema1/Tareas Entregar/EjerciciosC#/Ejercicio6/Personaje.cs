using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public abstract class Personaje
{
    private string nombre;
    private int energia;
    private int vida;

    public string Nombre
    {
        get { return nombre; }
        set { nombre = value; }

    }

    public int Energia
    {
        get { return energia; }
        set { energia = value; }
    }

    public int Vida
    {
        get { return vida; }
        set { vida = value; }
    }
    
    public Personaje()
    {
        Nombre = "";
        Energia = 0; 
        Vida = 0;
    }
    public Personaje(string nombre)
    {
        Nombre = nombre;
        Energia = 0;
        Vida = 0;
    }

    public bool Defender() 
    {
        bool defendido = false;
        Random random = new Random();

        int numeroAleatorio = random.Next(1, 4);

        if (numeroAleatorio == 1)
        {
            defendido = true;
        }

        return defendido;
    }

    public abstract int Atacar();

    public void RecibirGolpe(int golpe)
    {
        string mensajeInformativo = "EL PERSONAJE " + Nombre + " HA FALLECIDO";
        if (EstaVivo())
        {
            if (Defender())
            {
                if (Vida < golpe)
                {
                    Console.WriteLine(mensajeInformativo);
                    Vida = Constantes.DIFUNTO;
                }
                else
                {
                    Vida -= (golpe / 2);
                }
            }
            else
            {
                if (Vida < golpe)
                {
                    Console.WriteLine(mensajeInformativo);
                    Vida = Constantes.DIFUNTO;
                }
                else
                {
                    Vida -= golpe;
                }
            }
        }
        else 
        {
            Console.WriteLine(mensajeInformativo);
        }

    }

    public bool EstaVivo()
    {
        bool superviviente = false;
        if (Vida > Constantes.DIFUNTO)
        {
            superviviente = true;
        }

        return superviviente;
    }

    public  void Comer()
    {
        Energia += (Energia / 2);
    }

    public override string ToString()
    {
        return "NOMBRE: " + Nombre + " VIDA: " + Vida + " ENERGIA: " + Energia;
    }
}

