package br.com.lembraimer.business.interfaces;

import br.com.lembraimer.dominio.Endereco;
import br.com.lembraimer.dominio.Paciente;
import br.com.lembraimer.tela.TelaCadastro;
import br.com.lembraimer.tela.TelaPesquisa;
        
public interface PacienteInterface {
    
    public Paciente salvarPaciente(Paciente paciente, Endereco endereco, TelaCadastro telacadastro);
    
    public Paciente buscarPacientePorNome(Paciente nome, TelaPesquisa telaPesquisa);
}
