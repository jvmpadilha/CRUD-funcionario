package crud;

public class main {
    public static void main(String[] args) {
        FuncionarioManager funcionarioManager = new FuncionarioManager();

        Gerente gerente = new Gerente(1, "João", "TI");
        Programador programador = new Programador(2, "Maria", "Java");

        funcionarioManager.create(gerente);
        funcionarioManager.create(programador);

        Funcionario funcionario = funcionarioManager.read(1);
        System.out.println("Funcionário encontrado: " + funcionario.getNome());

        Programador novoProgramador = new Programador(2, "Pedro", "Python");
        funcionarioManager.update(2, novoProgramador);

        funcionario = funcionarioManager.read(2);
        System.out.println("Funcionário atualizado: " + funcionario.getNome() + " (" + ((Programador) funcionario).getLinguagem() + ")");

        funcionarioManager.delete(1);
        System.out.println("Funcionário removido.");
    }
}