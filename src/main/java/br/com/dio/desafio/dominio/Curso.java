package br.com.dio.desafio.dominio;

public class Curso {

    //por boa prática, se usa o modificador de acesso "private" antes dos atributos
    private String titulo;
    private String descricao;
    private int cargaHoraria;

    //criar construtor vazio


    public Curso() {
    }

    //criar getter e setters para poder trabalhar com os atributos
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

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    //criar o toString para poder imprimir

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
