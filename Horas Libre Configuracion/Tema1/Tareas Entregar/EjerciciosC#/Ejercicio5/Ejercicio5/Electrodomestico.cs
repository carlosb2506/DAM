using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Electrodomestico
{
    // ATRIBUTOS

    private double precioBase;
    public enum colores { BLANCO, NEGRO, ROJO, AZUL, GRIS};

    private colores color;

    private double peso;
    public enum valorEnergetico { A,B,C,D,E,F};

    private valorEnergetico valor;

    // PROPIEDADES

    public double PrecioBase
    {
        get { return precioBase; }
        set { this.precioBase = value; }
    }

    public colores Color
    {
        get { return color; }
        set
        {
            if (ComprobarColor(value))
            {
                this.color = value;
            }
            else
            {
                this.color = colores.BLANCO;
            }
        }
    }

    public double Peso
    {
        get { return peso; }
        set { this.peso = value; }
    }

    public valorEnergetico Valor
    {
        get { return valor; }
        set
        {
            if (ComprobarConsumoEnergetico(value)) {
                this.valor = value;
            }
            else
            {
                this.valor = valorEnergetico.F;
            }
        }
        
    }

    // CONSTRUCTORES
    public Electrodomestico()
    {
        Color = colores.BLANCO;
        PrecioBase = 100;
        Peso = 5;
        Valor = valorEnergetico.F;
    }
    public Electrodomestico(double precio, double peso)
    {
        Color = colores.BLANCO;
        PrecioBase = precio;
        Peso = peso;
        Valor = Valor;
    }
    public Electrodomestico(colores color, double precio, double peso, valorEnergetico valor)
    {
        Color = color;

        PrecioBase = precio;

        Peso = peso;
        
        Valor = valor;
    }

    private bool ComprobarConsumoEnergetico(valorEnergetico valor)
    {
        bool resultado;
        if (valor.ToString().ToUpper().Equals(valorEnergetico.A.ToString()))
        {
            resultado = true;
        }
        else if (valor.ToString().ToUpper().Equals(valorEnergetico.B.ToString()))
        {
            resultado = true;
        }
        else if (valor.ToString().ToUpper().Equals(valorEnergetico.C.ToString()))
        {
            resultado = true;
        }
        else if (valor.ToString().ToUpper().Equals(valorEnergetico.D.ToString()))
        {
            resultado = true;
        }
        else if (valor.ToString().ToUpper().Equals(valorEnergetico.E.ToString()))
        {
            resultado = true;
        }
        else if (valor.ToString().ToUpper().Equals(valorEnergetico.F.ToString()))
        {
            resultado = true;
        }
        else
        {
            resultado = false;
        }
        return resultado;
    }

    private bool ComprobarColor(colores color)
    {
        bool resultado;
        if (color.ToString().ToUpper().Equals(colores.AZUL.ToString()))
        {
            resultado = true;
        }
        else if (color.ToString().ToUpper().Equals(colores.ROJO.ToString()))
        {
            resultado = true;
        }
        else if (color.ToString().ToUpper().Equals(colores.GRIS.ToString()))
        {
            resultado = true;
        }
        else if (color.ToString().ToUpper().Equals(colores.NEGRO.ToString()))
        {
            resultado = true;
        }
        else if (color.ToString().ToUpper().Equals(colores.BLANCO.ToString()))
        {
            resultado = true;
        }
        else
        {
            resultado = false;
        }
        return resultado;
    }

    public virtual double PrecioFinal()
    {
        double precioFin = 0;
        valor = Valor;
        peso = Peso;

        switch (valor)
        {
            case valorEnergetico.A:
                precioFin += 100;
                break;
            case valorEnergetico.B:
                precioFin += 80;
                break;
            case valorEnergetico.C:
                precioFin += 60;
                break;
            case valorEnergetico.D:
                precioFin += 50;
                break;
            case valorEnergetico.E:
                precioFin += 30;
                break;
            case valorEnergetico.F:
                precioFin += 10;
                break;
        }

        if (peso >= 0 && peso <= 19)
        {
            precioFin += 10;
        }else if (peso >= 20 && peso <= 49)
        {
            precioFin += 50;
        }else if (peso >= 50 && peso <= 79)
        {
            precioFin += 80;
        }
        else
        {
            precioFin += 100;
        }
        return precioFin;
    }
}

