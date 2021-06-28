package com.company;

public class Main {

    public static void main(String[] args) {
        Boss juan = new Boss("Juan Alberto", "Perez", "Gonzalez");
        juan.getNombreCompleto();
        juan.calcularGanancias();

        CommissionWorker rafa = new CommissionWorker("Rafael", "García", "Mendoza");
        rafa.getNombreCompleto();
        rafa.setGananciasPorVentas(250000f);
        rafa.calcularGanancias();

        PieceWorker jason = new PieceWorker("Jason", "Sandoval", "Ruiz");
        jason.getNombreCompleto();
        jason.setNumArt(500);
        jason.calcularGanancias();

        HourlyWorker adrian = new HourlyWorker("Adrian", "Martinez", "Cruz");
        adrian.getNombreCompleto();
        adrian.setHorasTrabajadas(16);
        adrian.setSueldoPorHora(120);
        adrian.calcularGanancias();

    }
}
