/*
 * 		Lista A2 - Parte I
 * 
 * 	LUCAS DE SOUZA SILVA - 817123053
 * 	LUCAS DO VALE CONCEIÇÃO - 817116816
 * 
 */

package CoeficienteAngular;

import java.util.Scanner;

public class CoeficienteAngular {

	static double matriz[][] = new double[2][3];			//Matriz que deverá armazenar os somatórios
	static double eliminacao[][] = new double[2][3];		//Matriz que deverá receber os cálculos 
	
    static double vetorX[] = new double[1000];				//Vetor que deverá armazenar os valores de X
    static double vetorY[] = new double[1000];				//Vetor que deverá armazenar os valores de Y

	static int n = 0;										//Valor de N
	static double  somaX = 0;								//Somatório de X
	static double  somaY = 0;								//Somatório de Y
	static double  somaX2 = 0;								//Somatório de X^2	
	static double  multiXY = 0;								//Somatório de X*Y
	
	static double elimiGaus = 0;							//Multiplexador
	static double l1 = 0;									//Cálculo de l1
	static double l2 = 0;									//Cálculo de l2
	static double l3 = 0;									//Cálculo de l3
	
	static double angular = 0;								//Cálculo do valor Angular
	static double linear = 0;								//Cálculo do valor Linear

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		
        Scanner lerX = new Scanner(System.in);
        Scanner lerY = new Scanner(System.in);
        
        System.out.println("Digie o valor de 'N':");
        n = input.nextInt();
        
        /*			PRIMEIRO FOR - ARMAZENADO 
         * 	Armazenara os valores de X e Y nos vetores:
         * 	vetorX =  Armazenara os de X
         * 	vetorY =  Armazenara os de Y
         * 
         */
        for (int i = 0; i < n; i++) {
            System.out.print("Informe o valor de X: ");
            vetorX[i] = lerX.nextDouble();
            
            System.out.print("Informe o valor de Y: ");
            vetorY[i] = lerY.nextDouble();
        }
        
        /*		SEGUNDO FOR - SOMATÓRIO
         * 	Somatório de X: Um loop For deverá percorre até
		 * o final do vetor fazendo a somatória dos valores de X,
		 * e armazenará a somatoria na variavel somaX;
		 * 
		 *	Somatório de Y: Um loop For deverá percorre até
		 * o final do vetor fazendo a somatória dos valores de X,
		 * e armazenará a somatoria na variavel somaY;
		 * 
		 *	Somatório de x^2: Ultilzando o mesmo lopp For, deverá 
		 *pecorrer até o final do vetorX, e elevar cada um valor ao
		 *quadrado, e somando o antecedente com o sonsequente. 
		 *Este calculo será feito através do método Math.pow, e no 
		 *final ira armazenar em uma variavel somaX2
		 *
		 *	Somatório de X*Y: Ultilizando o mesmo loop For deverá fazer 
		 *o somatório de cada valor que estão armazenados no veotorX e
		 * no veotorY, e no final armazenar na variavel multiXY.
	     * 
         */
        for(int i = 0; i < n; i++) {
        	//Somatorio de x
        	somaX = somaX + vetorX[i];
        	
        	//Somatorio de y
        	somaY = somaY + vetorY[i];
        	
        	//Somatorio de x^2
        	somaX2 = somaX2 + Math.pow(vetorX[i], 2);
        	
        	//Multiplicacao de X*Y
        	multiXY = multiXY + vetorX[i] * vetorY[i];
        	
        }
        
        /*		TERCEIRO FOR - ARMAZENANDO EM UMA MATRIZ
         * 	O método lineares deverá armazenar os valores de:
         * 	N, somatória de X, somatória de Y, somatória de X^2 e somatória X*Y
         * 
         */
        for (int i = 0; i < 2; i++) {
        	for (int j = 0; j < 3; j++) {
        		matriz[0][0] = n;			//Somatório de N
				matriz[0][1] = somaX;		//Somatório de X
				matriz[0][2] = somaY;		//Somatório de Y
				
				matriz[1][0] = somaX;		//Somatório de X
				matriz[1][1] = somaX2;		//Somatório de x^2
				matriz[1][2] = multiXY;		//Somatório de X*Y
			}
		}
        
        /*		QUARTO FOR - CÁLCULOS DE ELIMINAÇÃO
         * 	Atraves de dois método For devera pecorre a matriz
		 * e encontra os valores de:
		 * 
		 *  elimiGaus: Esta variavel deverá receber os valores de l1/l2.
		 *  
		 *  L1: Recebera o valor do cálculo de: matriz[1][0] - elimiGaus * matriz[0][0]:
		 *  L1: Recebera o valor do cálculo de: matriz[1][1] - elimiGaus * matriz[0][1]:
		 *  L1: Recebera o valor do cálculo de: matriz[1][1] - elimiGaus * matriz[0][2]:
         * 
         */
        for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				
				//Multiplicador
				elimiGaus = matriz[1][0]/matriz[0][0];
				
				//Substituindo os valores, da segunda linha
				l1 = matriz[1][0] - elimiGaus * matriz[0][0];
				l2 = matriz[1][1] - elimiGaus * matriz[0][1];
				l3 = matriz[1][2] - elimiGaus * matriz[0][2];
				
			}
		}
        
        /*		QUINTO FOR - ARMAZENANDO OS VALORES EM UMA NOVA MATRIZ
         * 	Na primeira linha serão armazenados os valores de n, somaX e somaY.
         * 	Na segunda linha serão armazenado os valore de l1. l2 e l3. 
         * 
         */
        for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				eliminacao[0][0] = n;			//Somatório de N		
				eliminacao[0][1] = somaX;		//Somatório de X
				eliminacao[0][2] = somaY;		//Somatório de Y
				
				eliminacao[1][0] = l1;			//Valores da linha01
				eliminacao[1][1] = l2;			//Valores da linha02	
				eliminacao[1][2] = l3;			//Valores da linha03
			}
		}
        
        /*		SEXTO FOR - ANGULA E LINEAR
         * 
	     * Angular: Atraves de um loop na matriz eliminação, será calculado os
	     *valores de A:
	     * 
	     * Linear: Atraves de um loop na matriz eliminação, será calculado os
	     *valores de B:
         * 
         */
        for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				//Angula "a"
				angular = eliminacao[1][2] / eliminacao[1][1];
				
				//Linear "b"
				linear = (eliminacao[0][2] - eliminacao[0][1]*angular) / eliminacao[0][0];
				
			}
		}
        
        //		IMPRIMINDO A PRIMEIRA MATRIZ
        System.out.println("======================================================================");
        System.out.println("Sistemas Lineares - Eliminação Gausiana");
        
        for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println(" ");
		}
        
        //		IMPRIMINDO A SEGUNDA MATRIZ
        System.out.println("======================================================================");
        System.out.println("Método dos Mínimos Quadrados");
        
        for (int i = 0; i < eliminacao.length; i++) {
			for (int j = 0; j < eliminacao[0].length; j++) {
				System.out.print(eliminacao[i][j] + "\t");
			}
			System.out.println(" ");
		}
        
        //		IMPRIMINDO OS VALORES ANGULAR E LINEAR
        System.out.println("======================================================================");
        System.out.println("Função");
        System.out.println("a (Angular) " + angular);
        System.out.println("b (Linear) " + linear);
        
	}
}
