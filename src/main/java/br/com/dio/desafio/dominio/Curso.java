package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    //por boa prática, se usa o modificador de acesso "private" antes dos atributos

    private int cargaHoraria;

    //criar construtor vazio


    @Override
    public double calcularXp() {

        return XP_PADRAO * cargaHoraria;
    }

    public Curso() {
    }

    //criar getter e setters para poder trabalhar com os atributos


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
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
