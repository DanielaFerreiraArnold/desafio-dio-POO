package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    //Set<> é a classe mãe de LikedHashSet (polimorfismo).
    //new LinkedHashSet é para salver os conteúdos na memória na mesma ordem
    //usa-se o Set<> por que queremos que os conteúdos só sejam adicionados uma vez.
    //Set<> não deixa repedir nomes na lista.


    //abaixo foram criados os métodos
    public void inscreverBootcamp(Bootcamp bootcamp) {
        //adicionar todos os conteúdos do bootcamp dentro dos conteúdos inscritos
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        //adicionar o Dev no bootcamp para dizer que ele está matriculado
        bootcamp.getDevsInscritos().add(this);

    }
    public void progredir() {
        //findFirst é para o dev fazer os cursos e mentorias na ordem em que foram adicionadas na plataforma
        //this.conteudosInscritos.stream().findFirst(); -> firndFirst é colocado dentro de uma variável (ctrl+v)
        //Optional serve para resolver questões de conteúdos nulos
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }
    public double calcularTotalXp() {
        /*
        para calcula:
        Utilização do stram API, peguei cada conteúdo de dentro do
        set de conteúdos concluídos, peguei o XP de cada condteúdo e somei
         */
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while (iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        //return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    //como está sendo trabalhado com Set<> e LinkedHashSet<>, deve-se implementar equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
