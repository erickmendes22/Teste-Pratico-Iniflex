import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarios= new ArrayList<Funcionario>();
		funcionarios.add( new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990,05,12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add (new Funcionario("Caio", LocalDate.of(1961,05,2), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add( new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,01,5), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add (new Funcionario("Arthur", LocalDate.of(1993,03,31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add (new Funcionario("Laura", LocalDate.of(1994,07,8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,05,24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.33"), "Gerente"));
		
		int quantidadedeFuncionarios = funcionarios.size();
		Map<String, Funcionario> funcionariosporNome= new HashMap();
		String funcionariosmes="";
		int maiorIdade=0;
		float salariototal = 0;
		LocalDate now = LocalDate.now();
		int indexmaiorIdade=0;
		
		for(int i=0;i<quantidadedeFuncionarios;i++) {
			if (funcionarios.get(i).nome=="João") {
				funcionarios.remove(i);
				break;
			}
		}
		
		quantidadedeFuncionarios = funcionarios.size();
		int salariomin = 1212;
		String[] nomedosFuncionarios = new String[quantidadedeFuncionarios];
		
		
		System.out.println("Todos os funcionários da empresas e suas informações:");
		for(Funcionario funcionario : funcionarios) {
			funcionario.imprimeFuncionario();
		}
		for(Funcionario funcionario : funcionarios) {
			funcionario.aumentaSalario(new BigDecimal("1.1"));
		}
		String[] funcoes = new String[9];
		int j=0;
		Map<String, ArrayList<Funcionario>> mapFuncionario =new HashMap<>();
		ArrayList<ArrayList<Funcionario>>  Funcionariosfuncao =new ArrayList<>();
		for (Funcionario funcionario : funcionarios) {
			String funcao = funcionario.funcao;
			if (Arrays.stream(funcoes).anyMatch(funcao::equals)==false) {
				funcoes[j]=funcao;
				Funcionariosfuncao.add(new ArrayList());
				Funcionariosfuncao.get(j).add(funcionario );
				j++;
			}
			else {
				int k = Arrays.asList(funcoes).indexOf(funcao);
				Funcionariosfuncao.get(k).add(funcionario);
			}
		}
		
		System.out.println("\n");
		
		for(int i=0; i<j; i++) {
			mapFuncionario.put(funcoes[i],Funcionariosfuncao.get(i));
		}
		
		for(int i=0; i<j; i++) {
			String funcao= funcoes[i];
			ArrayList<Funcionario> arrayFuncionario = mapFuncionario.get(funcao);
			int mapFuncaoquantidade = arrayFuncionario.size();
			System.out.println("Funcionários com o cargo "+funcao+" :");
			for (int k=0;k<mapFuncaoquantidade;k++) {
				String funcionarionome = mapFuncionario.get(funcao).get(k).nome;
				System.out.println(funcionarionome);
			}
			System.out.println("");
		}
		
		System.out.println("Os funcionários que nascem no mes 10 e no mês 12 são:");
		
		
		
		for (Funcionario funcionario : funcionarios) {
		   int month = funcionario.datanascimento.getMonthValue();
		   if (month==10 || month==12) {
			   funcionariosmes=funcionariosmes+funcionario.nome+"\n";
		   }
		}
		
		System.out.println(funcionariosmes);
		
		for (Funcionario funcionario : funcionarios) {
			   salariototal += funcionario.salario.floatValue();
			  
			}
		
		for(int i=0; i<quantidadedeFuncionarios; i++) {
			LocalDate datanascimento=funcionarios.get(i).datanascimento;
			int idade=(int) ChronoUnit.YEARS.between(datanascimento,now);
			if(idade>maiorIdade) {
				indexmaiorIdade=i;
				maiorIdade=idade;
			}
		}
		
		String nomemaiorIdade = funcionarios.get(indexmaiorIdade).nome;
		System.out.println("O funcionário de maior idade é: " + nomemaiorIdade + " e tem " + maiorIdade + " anos." +"\n");
		System.out.println("O salario total é: "+ salariototal+'\n');
		
		for(int i=0; i<quantidadedeFuncionarios; i++) {
			nomedosFuncionarios[i]=funcionarios.get(i).nome;
		}
		
		Arrays.sort(nomedosFuncionarios);
		
		
		
		for (Funcionario funcionario: funcionarios) {
			funcionariosporNome.put(funcionario.nome, funcionario);
			}
		System.out.println("Funcionarios e suas informações por ordem alfabética:");
		
		for(String nome:nomedosFuncionarios ) {
			Funcionario funcionario=funcionariosporNome.get(nome);
			funcionario.imprimeFuncionario();
		}
		System.out.println("");
		
	    for (Funcionario funcionario : funcionarios) {
	    	int numerosalarios = funcionario.salario.intValue()/salariomin;
	    	String nome = funcionario.nome;
	    	System.out.println("O funcionario " +nome+ " ganha "+ numerosalarios+ " salarios minimos.");
	    }
	}
	

}
