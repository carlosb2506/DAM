using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploHerencia
{
    
    public class Triangulo:PoligonoRegular
    {
        private int altura;

        public Triangulo() : base() 
        {
            Altura = Constantes.MEDLADOS;
            base.NumLados = Constantes.NUMLADOS;
        }

        public Triangulo(int medidaLados, int altura) : base(Constantes.NUMLADOS, medidaLados)
        {
            Altura = altura;
        }
        public int Altura
        {
            get { return altura; }
            set { this.altura = value; }
        }
        public override int Area()
        {
            return ((base.MedidaLados * Altura) / 2);
        }

        public override string ToString()
        {
            return "Tienes un Triangulo de " + base.MedidaLados + "cm de lado";
        }
    }
}
