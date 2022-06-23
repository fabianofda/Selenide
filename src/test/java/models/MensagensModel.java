package models;

public class MensagensModel {
    public String messageNome;
    public String messageCpf;
    public String messageEmail;
    public String messageCep;
    public String messegeNumero;
    public String messegeMetodo;
    public String messegeImagem;

    public MensagensModel(String messageNome, String messageCpf, String messageEmail, String messageCep, String messegeNumero, String messegeMetodo, String messegeImagem) {
        this.messageNome = messageNome;
        this.messageCpf = messageCpf;
        this.messageEmail = messageEmail;
        this.messageCep = messageCep;
        this.messegeNumero = messegeNumero;
        this.messegeMetodo = messegeMetodo;
        this.messegeImagem = messegeImagem;
    }
}
