package br.com.lembraimer.business.test;

import br.com.lembraimer.db.DataBase;

import br.com.lembraimer.dominio.test.PacienteMock;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.lembraimer.dominio.test.EnderecoMock;
import br.com.lembraimer.dominio.test.UsuarioMock;
import br.com.lembraimer.interfaces.test.PacienteInterfaceMock;
import br.com.lembraimer.tela.test.TelaPesquisaMock;
import br.com.lembraimer.tela.test.TelaCadastroMock;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class PacienteBusinessMock implements PacienteInterfaceMock {

    @Override
    public PacienteMock salvarPaciente(PacienteMock paciente, EnderecoMock endereco, TelaCadastroMock tela) {
       if(validarPaciente(paciente) || validarEndereco(endereco)){
           try {
            Connection conn;
            PreparedStatement stmt;
            
            conn = DataBase.conexao();
            
            //cria a string para inserir no banco
            String query = "INSERT INTO paciente ( nomePaciente, nomeResponsavel, telefoneResponsavel, "
                    + "medicamento,horarioMedicamento, endereco, lembretes) VALUES(?,?,?,?,?,?,?)";
            
            //seta os valores na string de inserção
            stmt = conn.prepareStatement(query);
            stmt.setString(1, paciente.getNomePaciente());
            stmt.setString(2, paciente.getNomeResponsavel());
            stmt.setString(3, String.valueOf(paciente.getTelefone()));
            stmt.setString(4, paciente.getRemedio());
            stmt.setString(5, paciente.getHorarioMedicamento());
            stmt.setString(6, endereco.getRua());
            stmt.setString(7, paciente.getLembrete());
            
            //executa o comando no banco de dados
            stmt.executeUpdate();
            
            //fecha a conexão
            stmt.close();
            conn.close();
 
        }catch(SQLException e){
            System.out.println("Ocorreu um erro de conexão " + e);
        }
           JOptionPane.showMessageDialog(null, " O Paciente foi cadastrado com sucesso!");
           
           limpaCampos(tela);
           
       }else{
           JOptionPane.showMessageDialog(null,"TODOS OS CAMPOS DEVEM SER PREENCHIDOS");
       }
            return null;
    }

    @Override
    public PacienteMock buscarPacientePorNome(PacienteMock nome, TelaPesquisaMock telaPesquisa) {
       try {
            Connection conn;
            PreparedStatement cmd;
            ResultSet rs;
            
            conn = DataBase.conexao();
            
            String query = "SELECT * FROM paciente WHERE nomePaciente like ?";

            cmd = conn.prepareStatement(query);
            
            cmd.setString(1, '%' + nome.getNomePaciente() + '%');

            rs = cmd.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) telaPesquisa.jTable1.getModel();
            
            model.setNumRows(0);

            while(rs.next()){
                  model.addRow(new Object[]{rs.getString("Id"),
                    rs.getString("nomePaciente"),
                    rs.getString("nomeResponsavel"),
                    rs.getString("telefoneResponsavel"),
                    rs.getString("medicamento"),
                    rs.getString("horarioMedicamento"),
                    rs.getString("endereco"),
                    rs.getString("lembretes")});
            }
            DataBase.fecharfecharConexao(conn, cmd, rs);
            
        } catch(SQLException ex){
            System.out.println("Erro de conexão " + ex.getMessage());
        }
       return null;
     }
    
    public boolean validarPaciente(PacienteMock paciente){
        boolean clienteValido = true;
        if(paciente !=null)
        {
            if( paciente.getNomePaciente()==null||
                paciente.getNomePaciente().equals("")||
                    
                paciente.getNomeResponsavel()==null||
                paciente.getNomeResponsavel().equals("")||
                    
                paciente.getRemedio()==null||
                paciente.getRemedio().equals("")||
                    
                paciente.getHorarioMedicamento()==null||
                paciente.getHorarioMedicamento().equals("")||
                    
                paciente.getLembrete()==null||
                paciente.getLembrete().equals(""))
                {
                clienteValido = false;
                }
        }
        return clienteValido;
     }


    public boolean validarEndereco(EnderecoMock endereco){
        boolean clienteValido = true;
        if(endereco !=null)
        {
            if(endereco.getRua()== null||
               endereco.getRua().equals(""))
                {
                clienteValido = false;
                }
        }
        return clienteValido;
     }
    
    public void limpaCampos(TelaCadastroMock tela){
       tela.campoNomePaciente.setText("");
       tela.campoNomeResponsavel.setText("");
       tela.campoTelefoneResponsavel.setText("");
       tela.campoMedicamento.setText("");
       tela.campoHoraMedicamento.setText("");
       tela.campoEndereco.setText("");
       tela.campoLembrete.setText("");
    }

}