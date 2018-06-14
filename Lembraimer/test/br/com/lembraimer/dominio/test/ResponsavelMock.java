package br.com.lembraimer.dominio.test;

import java.util.Objects;

public class ResponsavelMock {
    private String nomeResponsavel;
    private double dataDeNascimento;
    private String genero;
    private int telefone;

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nome) {
        this.nomeResponsavel = nome;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nomeResponsavel);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.dataDeNascimento) ^ (Double.doubleToLongBits(this.dataDeNascimento) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.genero);
        hash = 71 * hash + this.telefone;
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
        final ResponsavelMock other = (ResponsavelMock) obj;
        if (Double.doubleToLongBits(this.dataDeNascimento) != Double.doubleToLongBits(other.dataDeNascimento)) {
            return false;
        }
        if (this.telefone != other.telefone) {
            return false;
        }
        if (!Objects.equals(this.nomeResponsavel, other.nomeResponsavel)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        return true;
    }
    
}
