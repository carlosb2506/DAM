
using static Electrodomestico;
using System.Drawing;

Electrodomestico[] electrodomesticos = new Electrodomestico[10];

    electrodomesticos[0] = new Lavadora(56);
    Console.WriteLine(electrodomesticos[0].PrecioFinal());
    electrodomesticos[1] = new Lavadora(23);
    Console.WriteLine(electrodomesticos[1].PrecioFinal());
    electrodomesticos[2] = new Lavadora(17);
    Console.WriteLine(electrodomesticos[2].PrecioFinal());
    electrodomesticos[3] = new Lavadora(78);
    Console.WriteLine(electrodomesticos[3].PrecioFinal());

    electrodomesticos[4] = new Electrodomestico(colores.BLANCO, 103.45, 29.67,valorEnergetico.F);
    Console.WriteLine(electrodomesticos[4].PrecioFinal());
    electrodomesticos[5] = new Electrodomestico(colores.AZUL, 546.85, 29.67, valorEnergetico.B);
    Console.WriteLine(electrodomesticos[5].PrecioFinal());
    electrodomesticos[6] = new Electrodomestico(colores.ROJO, 223.94, 29.67, valorEnergetico.E);
    Console.WriteLine(electrodomesticos[6].PrecioFinal());

    electrodomesticos[7] = new Television(89.9, false, colores.ROJO, 1233.67,5.67, valorEnergetico.D);
    Console.WriteLine(electrodomesticos[7].PrecioFinal());
    electrodomesticos[8] = new Television(43, false, colores.GRIS, 563.67, 5.67, valorEnergetico.E);
    Console.WriteLine(electrodomesticos[8].PrecioFinal());
    electrodomesticos[9] = new Television(32, false, colores.AZUL, 833.67, 5.67, valorEnergetico.A);
    Console.WriteLine(electrodomesticos[9].PrecioFinal());

double totalElectrodomesticos = 0;
double totalTelevisores = 0;
double totalLavadoras = 0;

foreach (var electrodomestico in electrodomesticos)
{
    
    if (electrodomestico is Lavadora)
    {
        totalLavadoras += electrodomestico.PrecioFinal();
    }
    else if (electrodomestico is Television)
    {
        totalTelevisores += electrodomestico.PrecioFinal();
    }
    else if (electrodomestico is Electrodomestico)
    {
        totalElectrodomesticos += electrodomestico.PrecioFinal();
    }
}

double total = totalElectrodomesticos + totalTelevisores + totalLavadoras;

// Mostrar los totales
Console.WriteLine("Total Lavadoras: " + totalLavadoras);
Console.WriteLine("Total Televisores: " + totalTelevisores);
Console.WriteLine("Total Electrodomésticos: " + totalElectrodomesticos);
Console.WriteLine("Total General: " + total);
