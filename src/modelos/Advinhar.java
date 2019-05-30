package modelos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Advinhar {
	private ArrayList<String> a1 = new ArrayList<String>();
	private int x = 0;
	private String palavra = "";
	private String posicaoL;
	private int quantLetras;
	private Random chute = new Random();
	private String chuteC;
	private int chutePosicao;
	private String chutePalavra;
	private int vidas = 9;
	private String letrasUsadas = "";
	public void inicio() { 
		System.out.println("Quantas letras a sua palavra tem?(MIN-4, MAX-10)");
		quantLetras = DadosTeclado.pegaInt();
		String escolha = "";
		while(quantLetras<4 && quantLetras >10) {
			System.out.println("VALOR INVALIDO(PRECISA DE AJUDA PARA CONTAR?)");
			quantLetras = DadosTeclado.pegaInt();
		}
		for(int i = 0; i< quantLetras;i++) {
			palavra = palavra +".";
		}
		System.out.println("Tipo Assim?(s/n)" + palavra);
		escolha = DadosTeclado.pegaString();
		if(escolha.equals("s")) {
			try{
				this.arquivo();
			}catch(FileNotFoundException e) {
				System.out.println("ARQUIVO NÃO ENCONTRADO");
			}
		}else if(escolha.equals("n")){
			this.inicio();
		}
	}
	private void arquivo() throws FileNotFoundException {
		File palavras = new File("\\palavras.txt");
		Scanner arquivo = new Scanner(palavras);
		System.out.println("LENDO SUA MENTE!! AGUARDE");
		while(arquivo.hasNextLine()) {
			String texto = arquivo.nextLine();
			if(texto.length() == quantLetras) {
				a1.add(texto);
			}
		}
		this.chute();
		arquivo.close();
	}
	private void atualizarArquivo(int opcao) {
		if(opcao == 2) {
			int i = 0;
			while(true) {
				if(a1.size()>i) {
					if(a1.get(i).indexOf(chuteC) != -1) {
						a1.remove(i);
						i = 0;
					}else {
						i++;
					}
				}if(a1.size()<=i) {
					break;
				}
			}
		}
		if(opcao == 3) {
			int i = 0;
			while(true) {
				if(a1.size()>i) {
					if(a1.get(i).indexOf(chuteC) == -1) {
						a1.remove(i);
						i = 0;
					}else if(a1.get(i).indexOf(chuteC) != -1){
						boolean b = false;
						for(int a = 0; a<palavra.length(); a++) {
							if(palavra.charAt(a) != '.' && palavra.charAt(a) != a1.get(i).charAt(a)){
								a1.remove(i);
								i = 0;
								b = true;
							}
						}
						if(b == false) {
							i++;
						}
					}else{
						i++;
					}
				}if(a1.size()<=i) {
					break;
				}
			}
		}
		this.chute();
	}

	private void chute() {
		if(!palavra.contains(".")) {
			System.out.println("Ganhei MUAHAHAHAHA\n "
					+"....................../´¯/) \r\n" + 
					"....................,/¯../ \r\n" + 
					".................../..../ \r\n" + 
					"............./´¯/'...'/´¯¯`·¸ \r\n" + 
					"........../'/.../..../......./¨¯\\ \r\n" + 
					"........('(...´...´.... ¯~/'...') \r\n" + 
					".........\\.................'...../ \r\n" + 
					"..........''...\\.......... _.·´ \r\n" + 
					"............\\..............( \r\n" + 
					"..............\\.............\\... t(▀̿Ĺ̯▀̿ ̿)");
			System.exit(0);
		}
		String opcao = "";
		if(x<1) {
			if (x == 0) {
				chuteC = "a";
				x++;
			}
		}
			while(palavra.contains(chuteC) || letrasUsadas.contains(chuteC)) {
				chutePalavra = a1.get(chute.nextInt(a1.size()));
				chutePosicao = chute.nextInt(quantLetras);
				if(chutePosicao == quantLetras-1) {
					chuteC = chutePalavra.substring(chutePosicao);
				}else {
					chuteC = chutePalavra.substring(chutePosicao, chutePosicao+1);
				}	
			}
			letrasUsadas = letrasUsadas + chuteC;
		System.out.println("A Sua Palavra Tem a Letra " + chuteC + "?(s/n) erros restantes:" + vidas);
		opcao = DadosTeclado.pegaString();
		while(true) {
			if(opcao.equals("s")) {
				this.casoS();
			}else if(opcao.equals("n")) {
				vidas = vidas - 1;
				if(vidas == 0) {
					System.out.println("Boa Jogada! Toma Aqui Seu Prêmio:\n"
							+ "		      ___________\r\n" + 
							"            '._==_==_=_.'\r\n" + 
							"            .-\\:      /-.\r\n" + 
							"           | (|:.     |) |\r\n" + 
							"            '-|:.     |-'\r\n" + 
							"              \\::.    /\r\n" + 
							"               '::. .'\r\n" + 
							"                 ) (\r\n" + 
							"               _.' '._\r\n" + 
							"          jgs `\"\"\"\"\"\"\"` LUCAS RULES");
					System.exit(0);
				}
				this.casoN();
			}else {
				System.out.println("VOCÊ É BURRO?! DIGITE NOVAMENTE");
				opcao = DadosTeclado.pegaString();
			}
		}
	}
	private void casoS(){
		System.out.println("Digite a/as posição:(ex: se Houver mais de uma digite 134)");
		posicaoL = DadosTeclado.pegaString();
		atualizarPalavra(posicaoL);
	}
	private void casoN() {
		this.atualizarArquivo(2);
	}
	private void atualizarPalavra(String posicao) {
		for (int i = 0; i < posicao.length(); i++) {
			String ch;
			if(i == posicao.length()-1){
				ch = posicao.substring(i);
			}else {
				ch = posicao.substring(i,i+1);
			}

			if(Integer.parseInt(ch) == 1) {
				palavra = chuteC + palavra.substring(i+1);
			}else if(Integer.parseInt(ch) < palavra.length() && Integer.parseInt(ch) != 1) {
				palavra = palavra.substring(0, Integer.parseInt(ch)-1) + chuteC +palavra.substring(Integer.parseInt(ch));
			}else if(Integer.parseInt(ch) == palavra.length()){
				palavra = palavra.substring(0, palavra.length()-1) + chuteC;
			}

		}
		System.out.println("Assim(s/n)? " + palavra);
		String opcao = DadosTeclado.pegaString();
		while(true) {
			if(opcao.equals("s")) {
				this.atualizarArquivo(3);
			}else if (opcao.equals("n")) {
				System.out.println("Você é idiota!!!!!!! Comece DNV!\n"
						+ "                 .     _,\r\n" + 
						"                   |`\\__/ /\r\n" + 
						"                   \\  . .(\r\n" + 
						"                    | __T|\r\n" + 
						"                   /   |\r\n" + 
						"      _.---======='    |\r\n" + 
						"     //               {}\r\n" + 
						"    `|      ,   ,     {}\r\n" + 
						"     \\      /___;    ,'\r\n" + 
						"      ) ,-;`    `\\  //\r\n" + 
						"     | / (        ;||\r\n" + 
						"     ||`\\\\        |||\r\n" + 
						"     ||  \\\\       |||\r\n" + 
						"jgs  )\\   )\\      )||\r\n" + 
						"     `\"   `\"      `\"\" Sua representação na natureza");
				break;
			}

		}
	}

}
