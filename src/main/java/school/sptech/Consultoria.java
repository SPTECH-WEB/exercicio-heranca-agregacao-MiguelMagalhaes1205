package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(){
        this.desenvolvedores = new ArrayList<>();
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

    public void contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double totalSalarios = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            totalSalarios += desenvolvedor.calcularSalario();
        }

        return totalSalarios;
    }

    public Integer qtdDesenvolvedoresMobile(){

        Integer qtdMobile = 0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile){
                qtdMobile++;
            }
        }

        return qtdMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){

        List<Desenvolvedor> desenvolvedoresEncontrados = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() >= salario){
                desenvolvedoresEncontrados.add(desenvolvedor);
            }
        }

        return desenvolvedoresEncontrados;
    }

    public Desenvolvedor buscarMenorSalario(){

        Desenvolvedor piorSalario = null;

        for (Desenvolvedor desenvolvedor : desenvolvedores){

            if (piorSalario == null){
                piorSalario = desenvolvedor;
            }

            if (desenvolvedor.calcularSalario() < piorSalario.calcularSalario()){
                piorSalario = desenvolvedor;
            }
        }

        return piorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devTech = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedor).getSgbd() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getBackend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getFrontend() == tecnologia) {
                    devTech.add(desenvolvedor);
                }
                } else if (desenvolvedor instanceof DesenvolvedorMobile) {
                    if (((DesenvolvedorMobile) desenvolvedor).getLinguagem() == tecnologia || ((DesenvolvedorMobile) desenvolvedor).getPlataforma() == tecnologia){
                        devTech.add(desenvolvedor);
                    }
                }
            }


        return devTech;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){

        Double totalSalario = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedor).getSgbd() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getBackend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getFrontend() == tecnologia) {
                    totalSalario += desenvolvedor.calcularSalario();
                }
                } else if (desenvolvedor instanceof DesenvolvedorMobile) {
                    if (((DesenvolvedorMobile) desenvolvedor).getLinguagem() == tecnologia || ((DesenvolvedorMobile) desenvolvedor).getPlataforma() == tecnologia){
                        totalSalario += desenvolvedor.calcularSalario();
                    }
                }
            }


        return totalSalario;
    }


}
