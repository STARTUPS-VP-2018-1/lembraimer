package br.com.lembraimer.interfaces.test;

import br.com.lembraimer.dominio.test.EnderecoMock;
import br.com.lembraimer.dominio.test.PacienteMock;
import br.com.lembraimer.tela.test.TelaPesquisaMock;
import br.com.lembraimer.tela.test.TelaCadastroMock;
        
public interface PacienteInterfaceMock {
    
    public PacienteMock salvarPaciente(PacienteMock paciente, EnderecoMock endereco, TelaCadastroMock telacadastro);
    
    public PacienteMock buscarPacientePorNome(PacienteMock nome, TelaPesquisaMock telaPesquisa);
}
