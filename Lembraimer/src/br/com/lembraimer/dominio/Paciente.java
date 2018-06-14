package br.com.lembraimer.dominio;

import java.util.Objects;

public class Paciente {
       private String nomePaciente;
       private double dataDeNascimento;
       private String genero;
       private Integer id;
       private String remedio;
       private String nomeResponsavel;
       private Integer telefone;
       private String horarioMedicamento;
       private String lembrete;

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nome) {
        this.nomePaciente = nome;
    }

    public double getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(double dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getHorarioMedicamento() {
        return horarioMedicamento;
    }

    public void setHorarioMedicamento(String horarioMedicamento) {
        this.horarioMedicamento = horarioMedicamento;
    }

    public String getLembrete() {
        return lembrete;
    }

    public void setLembrete(String lembrete) {
        this.lembrete = lembrete;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nomePaciente);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.dataDeNascimento) ^ (Double.doubleToLongBits(this.dataDeNascimento) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.genero);
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.remedio);
        hash = 83 * hash + Objects.hashCode(this.nomeResponsavel);
        hash = 83 * hash + Objects.hashCode(this.telefone);
        hash = 83 * hash + Objects.hashCode(this.horarioMedicamento);
        hash = 83 * hash + Objects.hashCode(this.lembrete);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (Double.doubleToLongBits(this.dataDeNascimento) != Double.doubleToLongBits(other.dataDeNascimento)) {
            return false;
        }
        if (!Objects.equals(this.nomePaciente, other.nomePaciente)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.remedio, other.remedio)) {
            return false;
        }
        if (!Objects.equals(this.nomeResponsavel, other.nomeResponsavel)) {
            return false;
        }
        if (!Objects.equals(this.lembrete, other.lembrete)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.horarioMedicamento, other.horarioMedicamento)) {
            return false;
        }
        return true;
    }

    public Object getteste() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
