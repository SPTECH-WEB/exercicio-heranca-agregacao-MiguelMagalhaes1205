package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {

    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMemoria) {
        this.horasMentoria = horasMemoria;
    }

    public DesenvolvedorWeb(){}

    @Override
    public Double calcularSalario(){
        return super.calcularSalario() + this.horasMentoria*300;
    }

    public boolean isFullstack(){
        if (backend != null && frontend != null && sgbd != null){
            return true;
        } else {
            return false;
        }
    }
}
