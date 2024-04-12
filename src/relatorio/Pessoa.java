package relatorio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public void inserirInformacoes(String nome, String cargo, String habilidades, int idade, char sexo, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.cargo = cargo;
        this.habilidades = habilidades;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public static void main(String[] args) {
        // Lista para armazenar as pessoas
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        // Supondo que você já tenha inserido as informações das pessoas, ou você pode lê-las de uma fonte externa

        // Gerar relatório CSV por cidade
        relatorioCSVPorCidade(pessoas);

        // Gerar relatório CSV por cargo
        relatorioCSVPorCargo(pessoas);

        // Gerar relatório CSV por sexo
        relatorioCSVPorSexo(pessoas);

        // Gerar relatório CSV por estado
        relatorioCSVPorEstado(pessoas);
    }

    // Método para gerar relatório CSV por cidade
    public static void relatorioCSVPorCidade(ArrayList<Pessoa> pessoas) {
        Map<String, Integer> relatorio = new HashMap<>();

        for (Pessoa pessoa : pessoas) {
            String cidade = pessoa.cidade;
            relatorio.put(cidade, relatorio.getOrDefault(cidade, 0) + 1);
        }

        escreverRelatorioCSV("RelatorioPorCidade.csv", relatorio);
    }

    // Método para gerar relatório CSV por cargo
    public static void relatorioCSVPorCargo(ArrayList<Pessoa> pessoas) {
        Map<String, Integer> relatorio = new HashMap<>();

        for (Pessoa pessoa : pessoas) {
            String cargo = pessoa.cargo;
            relatorio.put(cargo, relatorio.getOrDefault(cargo, 0) + 1);
        }

        escreverRelatorioCSV("RelatorioPorCargo.csv", relatorio);
    }

    // Método para gerar relatório CSV por sexo
    public static void relatorioCSVPorSexo(ArrayList<Pessoa> pessoas) {
        Map<Character, Integer> relatorio = new HashMap<>();

        for (Pessoa pessoa : pessoas) {
            char sexo = pessoa.sexo;
            relatorio.put(sexo, relatorio.getOrDefault(sexo, 0) + 1);
        }

        escreverRelatorioCSV("RelatorioPorSexo.csv", relatorio);
    }

    // Método para gerar relatório CSV por estado
    public static void relatorioCSVPorEstado(ArrayList<Pessoa> pessoas) {
        Map<String, Integer> relatorio = new HashMap<>();

        for (Pessoa pessoa : pessoas) {
            String estado = pessoa.estado;
            relatorio.put(estado, relatorio.getOrDefault(estado, 0) + 1);
        }

        escreverRelatorioCSV("RelatorioPorEstado.csv", relatorio);
    }

    // Método para escrever relatório CSV
    public static void escreverRelatorioCSV(String nomeArquivo, Map<?, Integer> relatorio) {
        try {
            FileWriter arquivo = new FileWriter(nomeArquivo);
            arquivo.append("Categoria,Quantidade\n");

            for (Map.Entry<?, Integer> entry : relatorio.entrySet()) {
                arquivo.append(entry.getKey().toString()).append(",").append(entry.getValue().toString()).append("\n");
            }

            arquivo.flush();
            arquivo.close();
            System.out.println("Relatório " + nomeArquivo + " gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório CSV: " + e.getMessage());
        }
    }
}
