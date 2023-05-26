package vetores;

import java.util.Scanner;

public class jogoDaVelha {

	public void core() {
		int linha, coluna, i = 0;
		Scanner input = new Scanner(System.in);
		int matriz[][] = new int[3][3];
		Inicializa(matriz);

		while (true) {
			System.out.println("\nJogador 1 na rodada " + (i + 1));
			imprimeMatriz(matriz);
			System.out.print("Digite a linha:");
			linha = input.nextInt();
			System.out.print("Digite a coluna:");
			coluna = input.nextInt();
			matriz[linha][coluna] = 0;
			i++;
			System.out.println("\nJogado 1 após realizar a jogada "+ (i + 1));
			imprimeMatriz(matriz);
			if(i > 4) {
				if(this.validaJogada(matriz)==3) {
					break;
				}
			}
			
			if (i == 9) {
				break;
			}

			System.out.println("\nJogador 2 na rodada " + (i + 1));
			imprimeMatriz(matriz);
			System.out.print("Digite a linha:");
			linha = input.nextInt();
			System.out.print("Digite a coluna:");
			coluna = input.nextInt();
			matriz[linha][coluna] = 1;
			i++;
			System.out.println("\nJogado 2 após realizar a jogada "+ (i + 1));
			imprimeMatriz(matriz);
			if(i > 4) {
				if(this.validaJogada(matriz)==3) {
					break;
				}
			}
			if (i == 9) {
				break;
			}
		}

		System.out.println("\n\n Tabuleiro Finalizado\n\n");
		imprimeMatriz(matriz);

	}

	public void Inicializa(int mat[][]) {
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat[1].length; j++) {
				mat[i][j] = -1;
			}
		}
	}

	public void imprimeMatriz(int mat[][]) {

		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat[1].length; j++) {
				System.out.printf("%d ", mat[i][j]);
			}
			System.out.println();
		}
	}

	public int linhaSuperior(int tabuleiro[][]) {
		if (tabuleiro[0][0] == 0 && tabuleiro[0][1] == 0 && tabuleiro[0][2] == 0) {
			return 0;
		}
		if (tabuleiro[0][0] == 1 && tabuleiro[0][1] == 1 && tabuleiro[0][2] == 1) {
			return 1;
		}

		return -1;
	}

	public int linhaMeio(int tabuleiro[][]) {
		if (tabuleiro[1][0] == 0 && tabuleiro[1][1] == 0 && tabuleiro[1][2] == 0) {
			return 0;
		}
		if (tabuleiro[1][0] == 1 && tabuleiro[1][1] == 1 && tabuleiro[1][2] == 1) {
			return 1;
		}

		return -1;
	}

	public int linhaInferior(int tabuleiro[][]) {
		if (tabuleiro[2][0] == 0 && tabuleiro[2][1] == 0 && tabuleiro[2][2] == 0) {
			return 0;
		}
		if (tabuleiro[2][0] == 1 && tabuleiro[2][1] == 1 && tabuleiro[2][2] == 1) {
			return 1;
		}

		return -1;
	}

	public int colunaEsquerda(int tabuleiro[][]) {
		if (tabuleiro[0][0] == 0 && tabuleiro[1][0] == 0 && tabuleiro[2][0] == 0) {
			return 0;
		}
		if (tabuleiro[0][0] == 0 && tabuleiro[1][0] == 0 && tabuleiro[2][0] == 0) {
			return 1;
		}

		return -1;
	}

	public int colunaMeio(int tabuleiro[][]) {
		if (tabuleiro[0][1] == 0 && tabuleiro[1][1] == 0 && tabuleiro[2][1] == 0) {
			return 0;
		}
		if (tabuleiro[0][1] == 0 && tabuleiro[1][1] == 0 && tabuleiro[2][1] == 0) {
			return 1;
		}

		return -1;
	}

	public int colunaDireita(int tabuleiro[][]) {
		if (tabuleiro[0][2] == 0 && tabuleiro[1][2] == 0 && tabuleiro[2][2] == 0) {
			return 0;
		}
		if (tabuleiro[0][2] == 0 && tabuleiro[1][2] == 0 && tabuleiro[2][2] == 0) {
			return 1;
		}

		return -1;
	}

	public int colunaDiagonal1(int tabuleiro[][]) {
		if (tabuleiro[0][0] == 0 && tabuleiro[1][1] == 0 && tabuleiro[2][2] == 0) {
			return 0;
		}
		if (tabuleiro[0][0] == 0 && tabuleiro[1][1] == 0 && tabuleiro[2][2] == 0) {
			return 1;
		}

		return -1;
	}

	public int colunaDiagonal2(int tabuleiro[][]) {
		if (tabuleiro[2][0] == 0 && tabuleiro[1][1] == 0 && tabuleiro[0][2] == 0) {
			return 0;
		}
		if (tabuleiro[2][0] == 0 && tabuleiro[1][1] == 0 && tabuleiro[0][2] == 0) {
			return 1;
		}
		return -1;

	}
	
	public void respostaDefault(int valor) {
		if(valor==0) {
			System.out.println("Jogador 1 ganhou!");
		}
		else if(valor==1) {
			System.out.println("Jogador 2 ganhou!");
		}
		
	}
	
	public int validaJogada(int tabuleiro[][]) {
		int linhaS= this.linhaSuperior(tabuleiro);
		int linhaM= this.linhaMeio(tabuleiro);
		int linhaI= this.linhaInferior(tabuleiro);		
		int colunaE= this.colunaEsquerda(tabuleiro);
		int colunaM= this.colunaMeio(tabuleiro);
		int colunaD= this.colunaDireita(tabuleiro);
		int diagonal1= this.colunaDiagonal1(tabuleiro);
		int diagonal2= this.colunaDiagonal2(tabuleiro);
		
		int resposta=-1;
		if(linhaS != -1) {
			this.respostaDefault(linhaS);
			resposta=3;
		}
		else if(linhaM != 1) {
			this.respostaDefault(linhaM);
			resposta=3;
		}
		else if(linhaI != 1) {
			this.respostaDefault(linhaI);
			resposta=3;
		}
		else if(colunaE != 1) {
			this.respostaDefault(colunaE);
			resposta=3;
		}
		else if(colunaM != 1) {
			this.respostaDefault(colunaM);
			resposta=3;
		}
		else if(colunaD != 1) {
			this.respostaDefault(colunaD);
			resposta=3;
		}
		else if(diagonal1 != 1) {
			this.respostaDefault(diagonal1);
			resposta=3;
		}
		else if(diagonal2 != 1) {
			this.respostaDefault(diagonal2);
			resposta=3;
		}
		
		return resposta;
	}

}