using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Peliculas : Producto
{
    private string director;
    private int minduracion;

    //propiedades

    public string Director 
    {  get { return director; } 
       set { director = value; }
    }

    public int Minduracion 
    {   get { return minduracion; } 
        set { minduracion = value; } 
    }


    public Peliculas():base()
    {
        Minduracion = 0;
        Director = String.Empty;
    }
    public Peliculas(string nombre, int anio, string director, int duracion) : base(nombre, anio)
    {
        Director = director;
        Minduracion = duracion;
    }

    public override double Abonar()
    {
        return Constantes.PRECIOMINUTO * Minduracion;
    }
}

