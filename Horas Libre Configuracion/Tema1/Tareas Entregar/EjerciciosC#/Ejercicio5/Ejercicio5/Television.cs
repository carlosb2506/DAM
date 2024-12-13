using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


public class Television:Electrodomestico
{
    private double resolucion;
    private bool tdt;

    public double Resolucion
    {
        get { return resolucion; }
        set { resolucion = value; }
    }
    public bool Tdt
    {
        get { return tdt; }
        set { tdt = value; }
    }
    public Television():base()
    {
        Resolucion = Constantes.RESOLUCION;
        Tdt = Constantes.TDT;
    }

    public Television(int precio, int peso) : base()
    {
        PrecioBase = precio;
        Peso = peso;
    }
    public Television(double resolucion, bool tdt ,colores color, double precio, double peso, valorEnergetico valor) : base(color, precio,  peso,  valor)
    {
        Resolucion = resolucion;
        Tdt = tdt;
    }

    public override double PrecioFinal()
    {
        double precioFin = base.PrecioFinal();

        if (Resolucion > 40)
        {
            precioFin += precioFin * 0.30;
        }
        if (Tdt)
        {
            precioFin += 50;
        }

        return precioFin;
    }


}

