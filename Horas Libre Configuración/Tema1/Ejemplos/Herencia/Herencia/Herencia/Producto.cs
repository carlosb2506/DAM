using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
public abstract class Producto
{
    //Atributos

    private int id;
    private string nombre;
    private int anio;
    private Boolean alquilado; 

    //Propiedades

    public int Id {  
        get { return id; }
        set { id = value; }
    }
    public string Nombre 
    { 
        get { return nombre; } 
        set { nombre = value; } 
    }

    public Boolean Alquilado
    {
        get { return alquilado; }
        set { alquilado = value; }
    }

    public int Anio 
    { 
        get { return anio; } 
        set 
        {
            if (value < Constantes.ANIO)
            {
                anio = Constantes.ANIO;
            }
            else
                anio = value;
        } 
    }

    //Contructor

    public Producto() 
    {
        Id = 0;
        Nombre = string.Empty;
        Anio = Constantes.ANIO;
        Alquilado = false;

    }

    public Producto(string nombre, int anio)
    {
      
        Nombre = nombre;
        Anio = anio;
        Id = 0;
        Alquilado=false;
    }

    public bool Alquiler()
    {
        bool exit = false;
        if (!Alquilado)
        {
            Console.WriteLine("Alquilando el producto con ID" + Id);
            Alquilado = true;
            exit = true;
        }
        return exit;
    }

    public bool Devolver()
    {
        bool exit = false;
        if (!Alquilado)
        {
            Console.WriteLine("Devolviendo el producto con ID" + Id);
            Alquilado = false;
            exit = true;
        }
        return exit;
    }

    public override string ToString()
    {
        string comprobar = Alquilado ? "Alquilado" : "No alquilado";
        return Nombre + " CON ID: " + Id + "[" + comprobar + "]";
    }

    // El metodo abonar debe implem,entarse en todas las subclases
    public abstract double Abonar();
}

