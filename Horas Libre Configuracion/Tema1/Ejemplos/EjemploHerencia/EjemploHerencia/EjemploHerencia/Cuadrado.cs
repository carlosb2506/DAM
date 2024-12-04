using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploHerencia
{
    public class Cuadrado : PoligonoRegular
    {
        public Cuadrado():base()
        {
            base.NumLados = Constantes.CUADRADO;
        }

        public Cuadrado(int medidaLados) : base(Constantes.CUADRADO, medidaLados)
        {

        }
        public override int Area()
        {
            return (int)Math.Pow(base.MedidaLados, 2);
        }

        public override string ToString()
        {
            return "Tienes un Cuadrado de " + base.MedidaLados + "cm de lado";
        }
    }
}
