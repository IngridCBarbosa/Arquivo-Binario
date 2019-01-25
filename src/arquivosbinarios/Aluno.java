package arquivosbinarios;

import java.io.Serializable;

public class Aluno implements Serializable {
    // pode ser transformada em uma sequencia de bits
    
    private String nome;
    private double nota;
    public Aluno(String n,double nt){
        nome = n;
        nota = nt;
    }
  
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }  
    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

  
    public String toString() {
        return "Aluno:" + "nome=" + nome + ", nota:" + nota;
    }
}
