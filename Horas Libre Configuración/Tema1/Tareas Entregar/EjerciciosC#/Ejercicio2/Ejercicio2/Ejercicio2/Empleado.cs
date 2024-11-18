using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio2
{
    public class Empleado
    {
        private string nombre;
        private int antiguedad;
        public bool extranjero;
        public int numHorasTrabajadas;
        public enum Level { JUNIOR, SENIOR, ANALISTA };
        private Level nivel;

        //PROPIEDADES
        public string Nombre
        {
            get { return this.nombre; }
            set { 
                this.nombre = value;
            }
        }
        public int Antiguedad
        {
            get { return this.antiguedad; }
            set
            {
                this.antiguedad = value;
            }
        }
        public bool Extranjero
        {
            get { return this.extranjero; }
            set { this.extranjero = value; }
        }
        public int NumHorasTrabajadas
        {
            get { return this.numHorasTrabajadas; }
            set { this.numHorasTrabajadas = value; }
        }
        public Level Nivel
        {
            get { return this.nivel; }
            set { this.nivel = value; }
        }


        //MÉTODOS
        public Empleado(string nombre, int antiguedad, bool extranjero, int numHorasTrabajadas, Level nivel)
        {
            Nombre = nombre;
            Antiguedad = antiguedad;
            Extranjero = extranjero;
            NumHorasTrabajadas = numHorasTrabajadas;
            Nivel = nivel;
        }
        public double SalarioBase(int numHorasTrabajadas)
        {
            double v;

            if (numHorasTrabajadas <= 40)
            {
                v = numHorasTrabajadas * 27;
            }
            else
            {
                v = 40 * 27;
            }
            return v;
        }
        public int CalculaSexenio(int antiguedad)
        {
            int v = 0;

            int sexenios = antiguedad / 6;  // Calcula el número de sexenios

            v += sexenios * 90;  // Suma 90 euros por cada sexenio

            return v;
        }
        public double Extras(int horasExtras)
        {
            double salarioExtra = 27;
                salarioExtra += salarioExtra * 0.3;

            salarioExtra = salarioExtra * horasExtras;

            return salarioExtra;
        }
        public double EsExtranjero(bool Extranjero)
        {
            double extraExtranjero = 0;
            if (extranjero)
            {
                extraExtranjero += SalarioBase(numHorasTrabajadas) * 0.12;
            }
            else
            {
                extraExtranjero = 0;
            }
            return extraExtranjero;
        }
        public double CompruebaNivel(Level nivel)
        {
            double extraNivel = 0;
            switch (nivel)
            {
                case Level.SENIOR:
                    extraNivel += SalarioBase(numHorasTrabajadas) * 0.25;
                    break;
                case Level.ANALISTA:
                    extraNivel += SalarioBase(numHorasTrabajadas) * 0.50;
                    break;
            }
            return extraNivel;
        }

        public double ImporteBruto()
        {
            return SalarioBase(NumHorasTrabajadas) + CalculaSexenio(Antiguedad) + EsExtranjero(Extranjero) + CompruebaNivel(Nivel);
        }
        public double ImporteNeto()
        {
            double importeNeto = 0;
            if (SalarioBase(numHorasTrabajadas) < 1400)
            {
                importeNeto =  SalarioBase(NumHorasTrabajadas) * 0.15;
                //precio += this.precioBase * 0.015;
            } else if (SalarioBase(numHorasTrabajadas) > 1401 && SalarioBase(numHorasTrabajadas) < 1700)
            {
                importeNeto =  SalarioBase(NumHorasTrabajadas) * 0.22;
            }
            else if (SalarioBase(NumHorasTrabajadas) > 1700)
            {
                importeNeto =  SalarioBase(numHorasTrabajadas) * 0.27;
            }
            return importeNeto;
        }
        public override string ToString()
        {
            return "NOMBRE:" + Nombre + " ANTIGUEDAD: " + Antiguedad + " EXTRANJERO: " + (Extranjero ? "SÍ" : "NO") + " HORAS TRABAJADAS: " + NumHorasTrabajadas + " IMPORTE BRUTO: " + ImporteBruto()
                + " IMPORTE NETO: " + (ImporteBruto() - ImporteNeto());
        }
    }
}
