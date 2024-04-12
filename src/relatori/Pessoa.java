package relatori;

import javax.swing.JOptionPane;

public class Pessoa {
    private String nome;
    private String cargo;
    private String habilidades;
    private int idade;
    private char sexo;
    private String endereco;
    private String cidade;
    private String estado;

    // Método construtor
    public Pessoa() {
        // Inicializa todas as variáveis como vazias ou padrão
        nome = "";
        cargo = "";
        habilidades = "";
        idade = 0;
        sexo = ' ';
        endereco = "";
        cidade = "";
        estado = "";
    }

    // Método para inserir informações da pessoa
    public void inserirInformacoes() {
        nome = JOptionPane.showInputDialog("Digite o nome:");
        cargo = JOptionPane.showInputDialog("Digite o cargo:");
        habilidades = JOptionPane.showInputDialog("Digite as habilidades:");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:"));
        sexo = JOptionPane.showInputDialog("Digite o sexo (M/F):").charAt(0);
        endereco = JOptionPane.showInputDialog("Digite o endereço:");
        
        cidade = JOptionPane.showInputDialog("Digite a cidade:");
        estado = JOptionPane.showInputDialog("Digite o estado:");
    }

    // Método para exibir informações da pessoa
    public void exibirInformacoes() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("\nInformações da Pessoa:\n");
        mensagem.append("Nome: ").append(nome).append("\n");
        mensagem.append("Cargo: ").append(cargo).append("\n");
        mensagem.append("Habilidades: ").append(habilidades).append("\n");
        mensagem.append("Idade: ").append(idade).append("\n");
        mensagem.append("Sexo: ").append(sexo).append("\n");
        mensagem.append("Endereço: ").append(endereco).append("\n");
        mensagem.append("Cidade: ").append(cidade).append("\n");
        mensagem.append("Estado: ").append(estado).append("\n");

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(); // Criando um objeto da classe Pessoa
        pessoa.inserirInformacoes(); // Inserindo informações da pessoa
        pessoa.exibirInformacoes(); // Exibindo informações da pessoa
    }
}
