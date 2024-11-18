using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploHerencia
{
    public class PoligonoRegular
    {
        private int numLados;
        private int medidaLado;

        public PoligonoRegular()
        {

            this.numLados = Constantes.NUMLADOS;
            this.medidaLado = Constantes.MEDLADOS;
        }

        public PoligonoRegular(int numLados, int medidaLado)
        {
            NumLados = numLados;
            MedidaLados = medidaLado;
        }

        //Propiedades
        public int NumLados
        {
            get { return this.numLados; }
            set{ 
                if(value < 2)
                {
                    this.numLados = 3;
                }
                else
                {
                    this.numLados = value;
                }
            } 

        }

        public int MedidaLados
        {
            get { return this.medidaLado; }
            set
            {
                if (value < 1)
                {
                    this.medidaLado = 1;
                }
                else
                {
                    this.medidaLado = value;
                }

            }
        }

        //METODOS

        public int Perimetro()
        {
            int perimetro;

            perimetro = NumLados * MedidaLados;

            return perimetro;
        }
        public virtual int Area()
        {
            return MedidaLados * MedidaLados;
        }
        public override string ToString()
        {
            return "Tenemos un polígono de " + NumLados + " de " + MedidaLados + " cm de lados.";
        }

    }
}
