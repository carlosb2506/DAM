using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Videojuegos : Producto
{

    public enum Genero { ARCADE, PRIMERA, TERCERA, AVENTURA, CONVERSACIONAL};
    // atributos 

    private string compañia;
    private Genero generoVideojuego;

    //propiedades

    public string Compañia
    {
        get { return compañia; }
        set { compañia = value; }
    }

    public Genero GeneroVideojuego
    {
        get { return generoVideojuego; }
        set { generoVideojuego = value; }
    }

    public Videojuegos() : base()
    {
        Compañia = String.Empty;
        GeneroVideojuego = Genero.PRIMERA;
    }
    public Videojuegos(string nombre, int anio, string compania, string genero) : base(nombre, anio)
    {
        Compañia = compania;
        CalcularGenero(genero);
    }

    private void CalcularGenero(string genero)
    {
        if (genero.ToUpper().Equals(Genero.AVENTURA.ToString()))
        {
            GeneroVideojuego = Genero.AVENTURA;
        } else if (genero.ToUpper().Equals(Genero.ARCADE.ToString()))
        {
            GeneroVideojuego = Genero.ARCADE;
        }
        else if (genero.ToUpper().Equals(Genero.CONVERSACIONAL.ToString()))
        {
            GeneroVideojuego = Genero.CONVERSACIONAL;
        }
        else if (genero.ToUpper().Equals(Genero.PRIMERA.ToString()))
        {
            GeneroVideojuego = Genero.PRIMERA;
        }
        else if (genero.ToUpper().Equals(Genero.TERCERA.ToString()))
        {
            GeneroVideojuego = Genero.TERCERA;
        }
        else
        {
            GeneroVideojuego = Genero.AVENTURA;
        }
    }

    public override double Abonar()
    {
        return Constantes.PRECIOVJ;
    }
}

