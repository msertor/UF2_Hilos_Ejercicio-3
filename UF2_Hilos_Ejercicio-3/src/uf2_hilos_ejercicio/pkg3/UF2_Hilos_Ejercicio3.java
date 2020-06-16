package uf2_hilos_ejercicio.pkg3;
import java.util.Scanner;


public class UF2_Hilos_Ejercicio3 {

public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        String nombre = "";
        int fuerza = 0;
        Monstruo monstruo = new Monstruo(100);
        System.out.println("Ha llegado un terrible monstruo a la ciudad y necesitamos la ayuda de tus dos mejores guerreros.");
        System.out.println("¿Podrías ayudarnos con esta tarea?");
        System.out.println("Por favor indícanos los nombres de tus dos mejores guerreros.");
        System.out.println("**Primer guerrero**");
        System.out.println("Escribe el nombre tu personaje:");
        nombre = s.nextLine();
        Personaje p1 = new Personaje(nombre, (int) (Math.random() * 10 + 1), monstruo);
        System.out.println("**Segundo guerrero**");
        System.out.println("Escribe el nombre tu personaje:");
        nombre = s.nextLine();
        Personaje p2 = new Personaje(nombre, (int) (Math.random() * 50 + 1), monstruo);
        System.out.println("¡Comienza la lucha contra el monstruo!");
        System.out.println("Monstruo: ¡Grrrrr!");
        
        Thread t1=new Thread(p1);
        t1.start();
        
        Thread t2=new Thread(p2);
        t2.start();
              
        t1.join();
        t2.join();
        
        System.out.println("Fin del combate");
        if(monstruo.Vivo){
            System.out.println("El monstruo ha derrotado a los dos guerreros... Inténtalo de nuevo enviando a tus dos mejores guerreros.");
        }else{
            System.out.println("¡Enhorabuena! El monstruo ha sido derrotado");
        }
    }
    
}
