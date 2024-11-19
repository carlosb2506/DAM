using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
public class Sacerdote:Personaje
{
    public Sacerdote(string nombre):base(nombre) 
    {
        base.Vida = Constantes.VIDA_SACERDOTE;
        base.Energia = Constantes.ENERGIA_SACERDOTE;
    }
}

