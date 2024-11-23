using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class Gestiones
{
    private ArrayList personajes = new ArrayList();

    public void CrearPersonaje(Personaje personaje)
    {
        personajes.Add(personaje);
    }

    public void AtacarPersonaje(string personajeAtacador, string personajeAtacado)
    {
        Personaje atacador = null;
        Personaje atacado = null;
        int golpe;
        int i = 0;
        while ((atacador == null || atacado == null) && i < personajes.Count)
        {
            Personaje buscando = (Personaje)personajes[i];
            if (buscando.Nombre.Equals(personajeAtacador))
            {
                atacador = buscando;
            }
            else if (buscando.Nombre.Equals(personajeAtacado))
            {
                atacado = buscando;
            }
            i++;
        }
        if (!atacador.EstaVivo())
        {
            Console.WriteLine("El personaje que quieres que ataque está fallecido.");

        }
        else if (!atacado.EstaVivo())
        {
            Console.WriteLine("El personaje que quieres atacar está fallecido.");
        }
        golpe = atacador.Atacar();
        atacado.RecibirGolpe(golpe);

        Console.WriteLine(atacador.Nombre + " atacó a " + atacado.Nombre + " con un golpe de " + golpe + " puntos de daño.");
    }

    public void CurarPersonaje(string personajeCurador, string personajeCurado)
    {
        Personaje curador = null;
        Personaje curado = null;
        int curacion;
        int i = 0;
        while ((curador == null || curado == null))
        {
            Personaje buscando = (Personaje)personajes[i];
            if (buscando.Nombre.Equals(personajeCurador))
            {
                curador = buscando;
            }
            else if (buscando.Nombre.Equals(personajeCurado))
            {
                curado = buscando;
            }
            i++;
        }
        if (!curador.EstaVivo())
        {
            Console.WriteLine("EL PERSONAJE QUE QUIERES QUE CURE ESTA MUERTO.");
        }
        if (!curado.EstaVivo())
        {
            Console.WriteLine("EL PERSONAJE QUE QUIERES CURAR ESTÁ FALLECIDO");
        }
        if (curador is Sacerdote || curador is Curandero)
        {
            if (curador is Sacerdote)
            {
                curacion = ((Sacerdote)curador).CurarOtros();
            }
            else
            {
                curacion = ((Curandero)curador).CurarOtros();
            }
            curado.Vida += curacion;
            Console.WriteLine(curador.Nombre + " CURÓ A " + curado.Nombre);
        }
        else
        {
            Console.WriteLine("SOLO UN SACERDOTE O CURANDERO PUEDE CURAR");
        }
    }

    public void Curarse(string personajeCurar)
    {
        Personaje curador = null;
        int curacion;
        int i = 0;
        while (curador == null)
        {
            Personaje buscando = (Personaje)personajes[i];
            if (buscando.Nombre.Equals(personajeCurar))
            {
                curador = buscando;
            }
        }
        if (!curador.EstaVivo())
        {
            Console.WriteLine("EL PERSONAJE QUE QUIERES QUE SE CURE ESTA FALLECIDO");
        }

        else
        {

            if (curador is Sacerdote)
            {
                ((Sacerdote)curador).Curar();
            }
            else if (curador is Curandero)
            {
                ((Curandero)curador).Curar();
            }
            else
            {
                ((Curandero)curador).Curar();
            }
                Console.WriteLine(curador.Nombre + " SE CURÓ");
            
        }
    }

    public void MostrarEstado()
    {
        for (int i = personajes.Count - 1; i >= 0; i--)
        {
            Personaje personaje = (Personaje)personajes[i];
            if (personaje.EstaVivo())
            {
                Console.WriteLine("NOMBRE: " + personaje.Nombre + " VIDA: " + personaje.Vida + " ENERGIA: " + personaje.Energia);
            }
            else
            {
                personajes.RemoveAt(i);
            }
        }
    }

}




