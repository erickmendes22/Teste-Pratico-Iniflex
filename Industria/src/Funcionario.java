import java.math.BigDecimal;
import java.time.LocalDate;
import java.math.*;
public class Funcionario extends Pessoa{
    public BigDecimal salario;
    public String funcao;
    public int year;
    public int month;
    public int day;
    private int milhar;
    private int fatorInteiro;
    private double restoDecimal;
    Funcionario(String nome, LocalDate datanascimento, BigDecimal salario, String funcao) {
    	this.nome = nome;
    	this.datanascimento = datanascimento;
    	this.salario = salario;
    	this.funcao = funcao;
    }
    public void aumentaSalario(BigDecimal porcentagem){
    
    	salario = salario.multiply(porcentagem);
    }
    private int algarismos(int numero) {
    	int numerodealgarismos=0;
    	while(numero!=0) {
    		numero=numero/10;
    		numerodealgarismos+=1;
    	}
    	return numerodealgarismos;
    }
    public void imprimeFuncionario() {;
		year = datanascimento.getYear();
		month = datanascimento.getMonthValue();
		day = datanascimento.getDayOfMonth();
		milhar = salario.intValue()/1000;
		fatorInteiro = salario.intValue();
		int numerodealgarismos=algarismos(fatorInteiro);
		String restoInteiro = Integer.toString(fatorInteiro).substring(numerodealgarismos-3);
		restoDecimal = salario.doubleValue() - fatorInteiro;
		String restosemzero = Double.toString(Math.round(restoDecimal*100D)/100D).substring(2);
		System.out.println(nome + " "+day+"/"+month+"/"+year+" "+milhar+"."+restoInteiro+","+restosemzero+" "+funcao);
    };
}
