using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
public class Sacerdote:Personaje, Interface1
{
    public Sacerdote(string nombre):base(nombre) 
    {
        base.Vida = Constantes.VIDA_SACERDOTE;
        base.Energia = Constantes.ENERGIA_SACERDOTE;
    }

    public override int Atacar()
    {;
        int golpe;

        Random random = new Random();

        golpe = random.Next((int)(0.25 * base.Energia), (int)(0.75 * base.Energia));
        base.Energia -= (base.Energia - golpe);

        return golpe;
    }

    public void Curar()
    {
        int energiaActual = Energia;

        int suma = Energia / 4;

        Vida += suma;
        Energia -= suma;
        Console.WriteLine("NOMBRE: " + Nombre + " VIDA DESPUES DE LA CURA: " + Vida);
    }

    public int CurarOtros()
    {
        int suma = 0;
        int energiaActual;
        if (EstaVivo())
        {
            energiaActual = Energia;

            suma = Energia / 4;

            Console.WriteLine("NOMBRE: " + Nombre + " VIDA DESPUES DE LA CURA: " + Vida);
            
        }
        else
            Console.WriteLine("NO SE HA PODIDO CURAR PORQUE EL PERSONAJE QUE DESEAS CURAR ESTA MUERTO");

        return suma;

    }
}

