
package uf2_hilos_ejercicio.pkg3;


public class Monstruo {
    private static int Vida;
    boolean Vivo = true;
    

    public Monstruo(int Vida){
        this.Vida = Vida;
    }
    
    public int getVida() {
        return Vida;
    }
    //Método sincronizado de hacer daño para que si dos hilos lo invocan, uno se quede suspendido hasta que el otro acabe.
    public synchronized int hacerDaño(String personaje, int valor){
        System.out.println("¡El monstruo ha atacado a " + personaje + "! ¡Le ha hecho un daño de " + valor + "!");
        return Vida;
    }
    //Método sincronizado de recibir daño.
    public synchronized int recibirDaño(String personaje, int valor){
        //si el daño es mayor a la vida del mosntruo, será derrotado.
        if (valor > Vida) {
             Vida -= valor;
             System.out.println("¡" + personaje + " atacó al monstruo y le hizo un daño de " + valor + "!");
             System.out.println("Vida del monstruo: " + Vida + ".");
             System.out.println("¡El monstruo ha sido derrotado!");
             Vivo = false;
            } else{
        Vida -= valor;
        System.out.println("¡" + personaje + " atacó al monstruo y le hizo un daño de " + valor + "!");
        System.out.println("Vida del monstruo: " + Vida + ".");
        }
        return Vida;
    }
    }


