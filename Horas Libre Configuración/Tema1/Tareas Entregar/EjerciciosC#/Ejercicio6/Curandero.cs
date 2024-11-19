using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Curandero:Personaje
{
    public Curandero(string nombre):base(nombre)
    {
        base.Energia = Constantes.ENERGIA_CURANDERO;
        base.Vida = Constantes.VIDA_CURANDERO;
    }
}
