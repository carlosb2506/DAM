using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


public class VideoClub
{
    //atributos

    private string nombre;
    private ArrayList lista;

    // Propiedades

    public string Nombre 
    {  
        get { return nombre; } 
        set { nombre = value; } 
    }

    public ArrayList Lista
    {
        get { return lista; }
        set {  lista = value; }
    }

    public VideoClub()
    {
        Lista = new ArrayList();
        Nombre = string.Empty;
    }

    public VideoClub(string nombre)
    {
        Nombre = nombre;
        Lista = new ArrayList();
    }

    public VideoClub(string nombre, ArrayList list)
    {
        Nombre = nombre;
        Lista = list;
    }

    public void DarAlta(Producto producto)
    {
        Producto ultimo;
        if (Lista.Count > 0)
        {
            ultimo = (Producto) Lista[Lista.Count - 1];
            producto.Id = ultimo.Id + 1;
        }
        else { 
            producto.Id = 0;
        }

        lista.Add(producto);
        Console.WriteLine("Producto añadido con exito");
    }

    public void DarBaja(string nombre) 
    {
        int cont = 0;
        Boolean encontrado = false;
        Producto producto = null;
        if (Lista.Count > 0)
        {
            while (!encontrado && (cont > Lista.Count))
            {
                producto = (Producto)Lista[cont];
                if (producto.Nombre.Equals(nombre))
                {
                    encontrado = true;
                }
                else
                    cont++;
            }
            if (encontrado)
            {
                Lista.Remove(producto);
                Console.WriteLine("El producto ha sido eliminado");
            }
        }
        else
        {
            Console.WriteLine("No tiene productos añadidos");
        }
    }
}

