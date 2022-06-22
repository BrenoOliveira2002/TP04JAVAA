//Autor: Breno Santos de Oliveira

package teste;

public class Principal {
    public static void main(String[] args){
        Data data = new Data();
        
        System.out.println("Mostra data 1: " + data.mostra1());
        System.out.println("Mostra data 2: " + data.mostra2());
        System.out.println("Ano bissexto: " + data.bissexto());
        System.out.println("Dias transcorridos: " + data.diasTranscorridos());
        data.apresentaDataAtual();
    }
}