package arquivosbinarios;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.EOFException;
public class ArquivosBinarios {
// Serializar é transformar em uma sequencia de byytes!!!
    
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        Aluno aluno;
        int i;
        String nome;
        double nota;
        try{
            FileOutputStream arq = new FileOutputStream("turma.dat");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            for(i = 1; i <= 3; i++){
                System.out.println("Informe o nome do aluno:");
                nome = enter.nextLine();
                System.out.println("Informe a nota do aluno: ");
                nota = enter.nextDouble();
                enter.nextLine();
                aluno = new Aluno(nome,nota);
                obj.writeObject(aluno); // grava o objeto aluno,mesmo esquema
                obj.flush(); // obriga a gravação , força a gravar sem espera que o buffer fique cheio para gravar no arquivo
            }
            obj.close(); // basta só fechar um 
        }
        catch(IOException ioException){
            System.err.println("Erro ao manipular o arquivo");
            System.exit(1);
        }
        try{
            FileInputStream arq = new FileInputStream("turma.dar");
            ObjectInputStream obj = new ObjectInputStream(arq);
            while(true){
                aluno =(Aluno) obj.readObject();
                System.out.println(aluno);
            } // sai do loop quando chega no fim do arquivo
            
        }
        catch(EOFException eofException){
            System.err.println("Fim do arquivo");
        }
        catch(IOException ioException){
            System.err.println("Erro de leitura no arquivo");
            System.exit(1);
        }
        catch(ClassNotFoundException classNotFoundException){
            System.err.println("Erro de leitura no arquivo");
            System.exit(1);
        }
    }
    
}
