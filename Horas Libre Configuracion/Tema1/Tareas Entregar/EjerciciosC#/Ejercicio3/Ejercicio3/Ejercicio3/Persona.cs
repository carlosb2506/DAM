using Ejercicio3;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;
    public class Persona
    {
        // ATRIBUTOS
        private string nombre;
        private string dni;
        private char sexo;
        private int edad;
        private double peso;
        private double altura;
        
        //PROPIEDADES
        public string Nombre {
            get { return nombre; }
            set { nombre = value; }
        }
        public string Dni
        {
            get { return dni; }
            set { dni = value; }
        }
        public char Sexo
        {
            get { return sexo; }
            set { sexo = value; }
        }
        public int Edad
        {
            get { return edad; }
            set { edad = value; }
        }
        public double Peso
        {
            get { return peso; }
            set { peso = value; }
        }
        public double Altura
        {
            get { return altura; }
            set { altura = value; }
        }

        //CONSTRUCTORES
        public Persona(string nombre, string dni, char sexo, int edad, double peso, double altura)
        {
            Nombre = nombre;
            Dni = dni;
            Sexo = ComprobarSexo(sexo);
            Edad = edad;
            Peso = peso;
            Altura = altura;
        }
        public Persona(string nombre, string dni ,int edad, char sexo)
        {
            Nombre = nombre;
            Dni = dni;
            Peso = 0;
            Edad = edad;
            Sexo = ComprobarSexo(sexo);
            Altura = 0;

        }
        public Persona()
        {
            Nombre = "";
            Dni = ObtenerDNI();
            Peso = 0;
            Edad = 0;
            Sexo = 'h';
            Altura = 0;
        }

        //MÉTODOS PERSONALIZADOS DE LA CLASE
        public int CalcularIMC()
        {   
            double imc = Peso / Math.Pow(Altura, 2); 
            int result = 0;

            if (Peso == 0 || Altura == 0)
            {
                result = 6; 
            }
            else if (imc < 20)
            {
                result = Constantes.BAJOPESO; // La persona está por debajo del peso ideal
            }
            else if (imc >= 20 && imc <= 25)
            {
                result = Constantes.IDEAL; // La persona tiene un peso ideal
            }
            else
            {
                result = Constantes.SOBREPESO; // La persona tiene sobrepeso
            }
            return result;
        }
    public void MayorDeEdad(int edad)
        {
            bool mayor = false;

            if (edad >= 18)
            {
                Console.WriteLine(Nombre + ": ES MAYOR DE EDAD");
            }
            else
            Console.WriteLine(Nombre + ": ES MENOR DE EDAD");
        }

        public char ComprobarSexo(char sexo)
        {

            if (sexo.Equals('H') || sexo.Equals('h') || sexo.Equals('M') || sexo.Equals('m'))
            {
                Sexo = sexo;
            }
            else
                Sexo = 'H';

        return Sexo;
        }

        public override string ToString()
        {
        string cadena = "Nombre: " + Nombre + " DNI: " + Dni + " SEXO: " + Sexo + " EDAD: " + Edad + " PESO: " + Peso + " ALTURA: " + Altura;

        int imc = CalcularIMC();

        if (imc == 1)
        {
            cadena += " TIENES SOBREPESO";
        }
        else if (imc == 0)
        {
            cadena += " ESTAS EN TU PESO IDEAL";
        }
        else if (imc == -1)
        {
            cadena += " TIENES BAJO PESO";
        }
        else
        {
            cadena += " NO SE HA PODIDO CALCULAR EL IMC";
        }
        return cadena;
        }

        public string ObtenerDNI()
        {
            Random random = new Random();

            // Generar un número aleatorio de 8 cifras entre 10000000 y 99999999
            int dni = random.Next(10000000, 100000000);

            char[] letrass = {'T','R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
            int indice = (int)(dni % 23);
            string cadena = dni.ToString() + letrass[indice];

            return cadena;
        }
    }

