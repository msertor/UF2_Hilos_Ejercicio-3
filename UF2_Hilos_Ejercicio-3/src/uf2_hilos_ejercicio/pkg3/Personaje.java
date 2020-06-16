package uf2_hilos_ejercicio.pkg3;

import java.util.Random;

public class Personaje implements Runnable{ //implements Runnable, para crear los hilos
    private String nombre;
    private String estado = "Preparado para luchar";
    private int energia = 50;
    private int fuerza = 0;
    private Monstruo monstruo; //Instancia del objeto mosntruo al que atacarán los personajes
        
    public Personaje(String nombre, int fuerza, Monstruo monstruo){
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.monstruo = monstruo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getFuerza() {
        return fuerza;
    }


    public String getEstado() {
        return estado;
    }

    public int getEnergia() {
        return energia;
    }
    
    public int atacar(){
        Random rnd = new Random();
        int dañoTotal;
        dañoTotal = this.fuerza * rnd.nextInt(10);//aleatorización del daño
        return dañoTotal;
    }
    
    public void recibirDaño(int dañoRecibido){
    this.energia = this.energia - dañoRecibido;
    System.out.println("Vida de " + getNombre() + ": " + getEnergia());
    if(this.energia <=0){//si el daño recibido es mayor al de la energía del personaje, este será derrotado.
        this.estado = "Derrotado";
        System.out.println("¡" + getNombre() + " ha sido derrotado!");
    }
}

@Override
    public void run(){
        int dañoAtaque;
        System.out.println("¡" + getNombre() + " tiene una fuerza de " + getFuerza() + "!");
        while(getEstado().equals("Preparado para luchar") && monstruo.getVida()>0){
        //esto se repetirá hasta que el personaje o el mosntruo sean derrotados
            if (Math.random() > 0.5) { //aleatorización de hacer daño o recibir daño
                atacar();
                monstruo.recibirDaño(getNombre(), atacar());
            } else {
                dañoAtaque = (int) (Math.random() * 70);//aleatorización del daño recibido
                monstruo.hacerDaño(getNombre(), dañoAtaque);
                recibirDaño(dañoAtaque);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
