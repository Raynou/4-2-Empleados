package com.company;

// Clase padre
abstract class Employee {
    protected String nombrePila;
    protected String apellidoPaterno;
    protected String apellidoMaterno;

    public Employee(String nombrePila, String apellidoPaterno, String apellidoMaterno) {
        this.nombrePila = nombrePila;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombrePila(){
        return nombrePila;
    }
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    public void getNombreCompleto(){
        System.out.println(nombrePila + " " + apellidoPaterno+ " " + apellidoMaterno);
    }

    //    Método "earnings()"
    public abstract void calcularGanancias();

}

// Clase Boss
final class Boss extends Employee{

    public Boss(String nombrePila, String apellidoPaterno, String apellidoMaterno){
        super(nombrePila, apellidoPaterno, apellidoMaterno);
    }

    @Override
    public void calcularGanancias() {
        final float SALARIO_SEMANAL_FIJO = 25000f;
        System.out.println("Sueldo de Jefe: $" + SALARIO_SEMANAL_FIJO);
    }
}

// Clase CommissionWorker
final class CommissionWorker extends Employee{

    private final float SALARIO_FIJO = 1500f;
    private final float PORCENTAJE_GANADO_POR_VENTAS=0.10f;
    private float gananciasPorVentas;

    public CommissionWorker(String nombrePila, String apellidoPaterno, String apellidoMaterno) {
        super(nombrePila, apellidoPaterno, apellidoMaterno);
    }

    public float getPORCENTAJE_GANADO_POR_VENTAS() {
        return PORCENTAJE_GANADO_POR_VENTAS;
    }

    public float getSALARIO_FIJO() {
        return SALARIO_FIJO;
    }

    public void setGananciasPorVentas(float gananciasPorVentas) {
        this.gananciasPorVentas = gananciasPorVentas;
    }

    public float getGananciasPorVentas() {
        return gananciasPorVentas;
    }

    @Override
    public void calcularGanancias() {
        float pagoPorVentas = gananciasPorVentas*PORCENTAJE_GANADO_POR_VENTAS;
        System.out.println("Sueldo fijo: $" + SALARIO_FIJO);
        System.out.println("Ganancias por ventas: $" + pagoPorVentas);
        System.out.println("Sueldo total: $" + (SALARIO_FIJO+pagoPorVentas));
    }
}

// Clase PieceWorker
final class PieceWorker extends Employee{

    private final float PRECIO_ARTICULO=250f;
    private int numArt;

    public PieceWorker(String nombrePila, String apellidoPaterno, String apellidoMaterno) {
        super(nombrePila, apellidoPaterno, apellidoMaterno);
    }

    public float getPRECIO_ARTICULO() {
        return PRECIO_ARTICULO;
    }

    public void setNumArt(int numArt) {
        this.numArt = numArt;
    }

    @Override
    public void calcularGanancias() {
        System.out.println("Ganancias totales: $" + numArt * PRECIO_ARTICULO);
    }
}

//Clase HourlyWorker
final class HourlyWorker extends Employee{

    float horasTrabajadas;
    float sueldoPorHora;
    float horasExtras;

    public HourlyWorker(String nombrePila, String apellidoPaterno, String apellidoMaterno) {
        super(nombrePila, apellidoPaterno, apellidoMaterno);
    }

    public void setHorasTrabajadas(float horasTrabajadas) {

        if (horasTrabajadas<=8)this.horasTrabajadas = horasTrabajadas;
        else{
            this.horasTrabajadas = 8;
            this.horasExtras = horasTrabajadas - 8;
        }

    }

    public void setSueldoPorHora(float sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    public float horasTotales(){
        return horasTrabajadas+horasExtras;
    }

    private float calculoHorasExtra(){
        return (horasTrabajadas*sueldoPorHora)+(horasExtras*(sueldoPorHora*3));
    }

    @Override
    public void calcularGanancias() {
        if (horasTotales() <= 8){
            System.out.println("Ganancias totales: $" + sueldoPorHora*horasTotales());
        }else {
            System.out.println("Ganancias totales: $" + calculoHorasExtra());
        }
    }
}
