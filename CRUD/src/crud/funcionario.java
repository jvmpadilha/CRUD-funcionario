package crud;

import java.util.ArrayList;
import java.util.List;

interface CRUD<T> {
    void create(T item);
    T read(int id);
    void update(int id, T newItem);
    void delete(int id);
}

class Funcionario {
    private int id;
    private String nome;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

class Gerente extends Funcionario {
    private String departamento;

    public Gerente(int id, String nome, String departamento) {
        super(id, nome);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}

class Programador extends Funcionario {
    private String linguagem;

    public Programador(int id, String nome, String linguagem) {
        super(id, nome);
        this.linguagem = linguagem;
    }

    public String getLinguagem() {
        return linguagem;
    }
}

class FuncionarioManager implements CRUD<Funcionario> {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void create(Funcionario funcionario) {
        funcionarios.add(funcionario);
        funcionario.getId(); // Set the ID
    }

    @Override
    public Funcionario read(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Funcionario newFuncionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == id) {
                funcionarios.set(i, newFuncionario);
                newFuncionario.getId(); // Update the ID
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
    }
}



