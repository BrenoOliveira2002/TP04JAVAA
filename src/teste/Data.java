//Autor: Breno Santos de Oliveira

package teste;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;


public class Data {
	
	private Scanner scan = new Scanner(System.in);
	
	private int dia;
	private int mes;
	private int ano;
	
	
	public Data() {
		this.entraAno();
		this.entraMes();
		this.entraDia();	
	}

	public Data(int d, int m, int a) {
		this.entraDia(d);
		this.entraMes(m);
		this.entraAno(a);	
	}

	private void entraDia(int d) {
        int qtdDiasMes = quantidadeDiasNoMes(this.mes);

        if(d < 1 || d > qtdDiasMes){
            System.out.println("O dia deve ser um valor entre 1 e " + qtdDiasMes);
            return;
        }

        this.dia = d;		
	}

	private void entraMes(int m) {
		if(m < 1 || m > 12)
			System.out.println("O campo m�s aceita apenas valores entre 1 e 12");
		
		this.mes = m;		
	}

	private void entraAno(int a) {
		if(a < 1)
			System.out.println("O campo ano aceita apenas valores positivos");
		
		this.ano = a;
	}
	
	
	private void entraDia() {
        int d;

        do{
        	
            System.out.print("Digite o dia: ");
            d = scan.nextInt();

            if(d < 1 || d > quantidadeDiasNoMes(this.mes)){
                System.out.println("O dia deve ser um valor entre 1 e " + quantidadeDiasNoMes(this.mes));
            }
            
        }while(d < 1 || d > quantidadeDiasNoMes(this.mes));

        this.dia = d;
		
	}

	private void entraMes() {
		int m;
		
        do{
            System.out.print("Digite o mes: ");
            m = scan.nextInt();

            if(m < 1 || m > 12){
                System.out.println("O campo mes aceita apenas valores entre 1 e 12");
            }
            
        }while(m < 1 || m > 12);

        this.mes = m;
	}

	private void entraAno() {
		int a;
		
        do{
            System.out.print("Digite o ano: ");
            a = scan.nextInt();

            if(a <= 0){
                System.out.println("O campo ano aceita apenas valores positivos");
            }
            
        }while(a <= 0);

        this.ano = a;

	}
	
    public int retDia(){
        return this.dia;
    }

    public int retMes(){
        return this.mes;
    }

    public int retAno(){
        return this.ano;
    }
    
    public String mostra1(){

        return String.format("%02d", this.dia) + "/" +
            String.format("%02d", this.mes) + "/" +
            String.format("%04d", this.ano);
    }
    
    public String mostra2(){

        return String.format("%02d", this.dia) + "/" +
            nomeMes(this.mes) + "/" +
            String.format("%04d", this.ano);
    }
    
    
    public boolean bissexto(){
        return (this.ano % 400 == 0)
            || ((this.ano % 4 == 0) && (this.ano % 100 != 0));
    }
    
    public int diasTranscorridos(){
        int qtdDias = 0;

        for (int auxMes = 1; auxMes < this.mes; auxMes++) {
            qtdDias += quantidadeDiasNoMes(auxMes);
        }

        qtdDias += (this.dia - 1);
        
        return qtdDias;
    }
    
    public void apresentaDataAtual (){
        DateFormat dateformat = DateFormat.getDateInstance();

        System.out.println("Data atual: " + dateformat.format(new Date()));
    }

    private int quantidadeDiasNoMes(int numMes){
        int[] qtdDiasMes = new int[]{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(this.bissexto()){
            qtdDiasMes[1] = 29;
        }

        return qtdDiasMes[numMes - 1];
    }
    
    private String nomeMes(int numMes){
        String[] meses = {"Janeiro","Fevereiro","Mar�o","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"
        };

        return meses[numMes - 1];
    }
}