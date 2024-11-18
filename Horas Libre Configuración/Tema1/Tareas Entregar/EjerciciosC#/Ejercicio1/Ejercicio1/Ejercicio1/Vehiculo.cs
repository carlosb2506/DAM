using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio1
{
    public class Vehiculo
    {
        private string matricula;

        public enum Marca { TOYOTA, AUDI, ALFAROMEO };

        private Marca marcaCoche;
        public enum Tipo { TODOTERRENO, SEDAN, DEPORTIVO };
        private Tipo tipoCoche;

        private int numPuerta;

        private double precioBase;

        private bool llantasAleacion;

        private bool techoSolar;

        private int numAirbags;

        public string Matricula
        {
            get { return matricula; }
            set { matricula = value; }
        }

        public Marca MarcaCoche
        {
            get { return marcaCoche; }
            set { marcaCoche = value; }
        }

        public Tipo TipoCoche
        {
            get { return tipoCoche; }
            set { tipoCoche = value; }
        }

        public int NumPuerta
        {
            get { return numPuerta; }
            set {

                if(this.numPuerta != 3 && this.numPuerta != 5 )
                {  this.numPuerta = 3;}
                else
                {
                    this.numPuerta = value;
                }
            }
        }
        public double PrecioBase
        {
            get { return precioBase; }
            set { precioBase = value; }
        }

        public bool LlantasAleacion
        {
            get { return llantasAleacion; }
            set { llantasAleacion = value; }
        }

        public bool TechoSolar
        {
            get 
            {
                return techoSolar; 
            }
            set { techoSolar = value; }
        }
        public int NumAirbags
        {
            get { return numAirbags; }
            set
            {
                if (value > 6 || value < 0)
                {
                    this.numAirbags = 6;
                }
                else
                {
                    this.numAirbags = value;
                }
            }
        }


        public Vehiculo(string matricula, Marca marcaCoche, Tipo tipoCoche, int numPuerta, double precioBase, bool llantasAleacion, bool techoSolar, int numAirbags)
        {
            Matricula = matricula;
            MarcaCoche = marcaCoche;
            TipoCoche = tipoCoche;
            NumPuerta = numPuerta;
            PrecioBase = precioBase;
            LlantasAleacion = llantasAleacion;
            TechoSolar = techoSolar;
            NumAirbags = numAirbags;
        }

        public double PrecioTecho(bool techoSolar)
        {
            double precio = 0;

            if (techoSolar)
            {
                //precio = this.precioBase + (this.precioBase * 0.023);
                precio += PrecioBase * 0.023;
            }
            
            return precio;
        }

        public double PrecioPuerta(int numPuerta)
        {
            double precio = 0;

            if (numPuerta == 3)
            {
                //precio = this.precioBase - (this.precioBase * 0.005);
                precio -= PrecioBase * 0.005;
            }
            return precio;
        }

        public double PrecioMarca(Marca marcaCoche, Tipo tipoCoche)
        {
            double precio = 0;

            if(marcaCoche == Marca.AUDI && tipoCoche == Tipo.DEPORTIVO)
            {
                //precio = this.precioBase + (this.precioBase * 1.2);
                precio += PrecioBase * 1.2;
            }
            return precio;

        }

        public double PrecioLlantas(bool lllantasAleacion)
        {
            double precio = 0;
            if (lllantasAleacion)
            {
                precio = PrecioBase + 2500;
            }
            return precio;
        }

        public double PrecioAirbag(int numAirbags)
        {
            double precio = 0;
            switch (numAirbags) 
            {
                case 1:
                    precio += PrecioBase * 0.015;
                    break;
                case 2: 
                    precio += PrecioBase * 0.03;
                    break;
                case 3:
                    precio += PrecioBase * 0.045;
                    break;
                case 4:
                    precio += PrecioBase * 0.06;
                    break;
                case 5:
                    precio += PrecioBase * 0.075;
                    break;
                case 6:
                    precio += PrecioBase * 0.9;
                    break;
            }
            return precio;

        }
        public double ImporteTotal()
        {
            double precio = 0;

            precio = PrecioBase + PrecioTecho(TechoSolar) - PrecioPuerta(NumPuerta) + PrecioMarca(MarcaCoche, TipoCoche) + PrecioLlantas(LlantasAleacion) + PrecioAirbag(NumAirbags);

            return precio;
        }

        public override string ToString()
        {
            return "MATRICULA: " + Matricula + " MARCA: " + MarcaCoche + " TIPO: " + TipoCoche + " NUM PUERTAS: " + NumPuerta
                + " PRECIO BASE: " + PrecioBase + " LLANTAS DE ALEACIÓN: " + (LlantasAleacion ? "SÍ" : "NO") + " TECHO SOLAR: " + (TechoSolar ? "SÍ" : "NO") + " AIRBAGS: " + NumAirbags;
        }

    }
}
