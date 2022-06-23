package models;

public class CadastroModel {
    public String nome;
    public String cpf;
    public String email;
    public String whats;
    public String cep;
    public String rua;
    public String numero;
    public String complemento;
    public String bairro;
    public String cidade;
    public String metodo;
    public String imagem;

    public CadastroModel(String nome, String cpf, String email, String whats, String cep, String rua, String numero, String complemento, String bairro, String cidade, String metodo, String imagem) {
        dados(nome, cpf, email, whats);
        endereco(cep, rua, numero, complemento, bairro, cidade);
        metodoEntrega(metodo, imagem);;
    }

    private CadastroModel dados(String nome, String cpf, String email, String whats) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.whats = whats;

        return this;
    }

    private CadastroModel endereco(String cep, String rua, String numero, String complemento, String bairro, String cidade) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;

        return this;
    }

    private CadastroModel metodoEntrega(String metodo, String imagem) {
        this.metodo = metodo;
        this.imagem = imagem;

        return this;
    }
}
