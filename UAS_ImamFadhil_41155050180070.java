package uaspraktikum;

import java.io.IOException;
import java.util.Scanner;

public class UAS_ImamFadhil_41155050180070 extends Thread {
    int threadNumber; //deklarasi threadnumber
    int time; //deklarasi time global
    
    public UAS_ImamFadhil_41155050180070 (int num, int t) {
        threadNumber = num; //inisialisasi threadnumber global
        time = t; //inisialisasi time global
    }
    public void run() {
        int count = 1;
        System.out.println("I'm thread number: "+threadNumber);
        try {
            for (int i = 1; i <= this.time; i++) { //ulangi sesuai jumlah waktu
                Thread.sleep(1000); //sleep selama satu detik jadi menyesuaikan dengan jumlah waktu
                System.out.print("Thread "+threadNumber+"."+i+", ");
            }
        } catch (Exception e) {
            System.out.println("Thread Number " + threadNumber + " is finished");            
        }
        System.out.println("\nThread Number " + threadNumber + " is finished");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        boolean ulang = false;  //deklarasi ulang
        int thread = 0;  //deklarasi jumlah thread
        int time = 0;  //deklarasi waktu
        Thread thr = null; //deklarasi thread
        Scanner input = new Scanner(System.in); //inisialisasi scanner
        do {
            System.out.println("Program multithread");
            System.out.print("Masukan jumlah thread : ");
            thread = input.nextInt(); //masukan jumlah thread
            System.out.print("Masukan waktu (dalam satuan detik) : ");
            time = input.nextInt(); //masukan waktu
            input.nextLine(); 
            System.out.println("");
            System.out.println("Multithread start...");
            for (int i = 1; i <= thread; i++) { //ulangi sebanyak jumlah thread
                thr = new UAS_ImamFadhil_41155050180070(i, time); //inisialisasi thread
                thr.start(); //mulai thread
                thr.join(); // run thread satu", jadi nunggu thread yg satu mati baru lanjut
            }
        }while(ulang && !thr.isAlive()); //ulangi jika thread nya udah mati dan ulang nya true
        System.out.println("\nThread run successfully");
    }
}
