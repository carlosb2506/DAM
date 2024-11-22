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
        int i = 0;
        bool bandera = false;
        int golpe;

        while (bandera == false)
        {
            Personaje buscando = (Personaje) personajes[i];
            if (buscando.Nombre.Equals(personajeAtacador))
            {
                if (buscando.EstaVivo())
                {
                    golpe = buscando.Atacar();
                    bandera = true;
                }
                else
                    Console.WriteLine("El personaje que quieres que ataque esta fallecido");
            }
            i++;
        }

    }


}

