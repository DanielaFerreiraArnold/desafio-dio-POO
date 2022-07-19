package br.com.dio.desafio.dominio;

//classe mãe
//primeiro criar uma constante
//static é porque eu vou poder acessar o xp padrão de fora do conteúdo
//classe abstrata é para dizer que não é possível instanciar o conteúdo, ou criar um novo conteúdo.
//ela é criada para implementar atributos e não repetir códigos = herança.

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
