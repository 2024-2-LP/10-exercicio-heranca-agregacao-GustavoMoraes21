package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        List<Desenvolvedor> desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        Boolean contratou = false;

        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
            contratou = true;
        }
        return contratou;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        Boolean contratou = false;

        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
            contratou = true;
        }
        return contratou;
    }

    public Double getTotalSalarios(){
        Double salarios = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            salarios += desenvolvedor.calcularSalario();
        }
        return salarios;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer desenvolvedoresMobile = 0;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                desenvolvedoresMobile++;
            }
        }
        return desenvolvedoresMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> salariosMaiores = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                salariosMaiores.add(desenvolvedor);
            }
        }
        return salariosMaiores;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()) {
            return null;
        }

        Desenvolvedor menorSalario = desenvolvedores.get(0);

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() < menorSalario.calcularSalario()) {
                menorSalario = desenvolvedor;
            }
        }
        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedoresTec = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia) ||
                ((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia)) {
                    desenvolvedoresTec.add(desenvolvedor);
                }
            } else if (desenvolvedor instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) ||
                ((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) ||
                ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia)) {
                    desenvolvedoresTec.add(desenvolvedor);
                }
            }
        }
        return desenvolvedoresTec;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salarios = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia) ||
                        ((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia)) {
                    salarios += desenvolvedor.calcularSalario();
                }
            } else if (desenvolvedor instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia)) {
                    salarios += desenvolvedor.calcularSalario();
                }
            }
        }
        return salarios;
    }
}
