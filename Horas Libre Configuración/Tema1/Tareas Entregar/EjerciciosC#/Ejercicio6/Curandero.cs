using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Curandero:Personaje, Interface1
{
    public Curandero(string nombre):base(nombre)
    {
        base.Energia = Constantes.ENERGIA_CURANDERO;
        base.Vida = Constantes.VIDA_CURANDERO;
    }

    public override int Atacar()
    {
        int energiaActual = base.Energia;
        int golpe;

        Random random = new Random();

        golpe = random.Next(0, (int)(0.25 * energiaActual));

        energiaActual -= (energiaActual - golpe);

        return golpe;
    }

    public void Curar()
    {
        int energiaActual = Energia;

        int suma = Energia / 2;

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

            suma = Energia / 2;

            Console.WriteLine("NOMBRE: " + Nombre + " VIDA DESPUES DE LA CURA: " + Vida);

        }
        else
            Console.WriteLine("NO SE HA PODIDO CURAR PORQUE EL PERSONAJE QUE DESEAS CURAR ESTA MUERTO");

        return suma;

    }
}
