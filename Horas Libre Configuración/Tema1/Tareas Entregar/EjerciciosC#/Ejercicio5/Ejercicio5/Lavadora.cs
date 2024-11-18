
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Lavadora:Electrodomestico
{
    private int carga;

    public int Carga
    {
        get { return carga; }
        set { carga = value; }
    }

    public Lavadora():base()
    {
        Carga = Constantes.CARGALAV;
    }

    public Lavadora(int precio, int peso) : base()
    {
        PrecioBase = precio;
        Peso = peso;
        Carga = Constantes.CARGALAV;
    }
    public Lavadora(int carga) : base()
    {
        Carga = carga;
    }

    public override double PrecioFinal()
    {
        double precioFin = base.PrecioFinal();

        if (Carga > 30)
        {
            precioFin += 50;
        }

        return precioFin;
    }
}

