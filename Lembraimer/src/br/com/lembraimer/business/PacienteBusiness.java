package br.com.lembraimer.business;

import br.com.lembraimer.db.DataBase;
import br.com.lembraimer.business.interfaces.PacienteInterface;
import br.com.lembraimer.dominio.Paciente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.lembraimer.dominio.Endereco;
import br.com.lembraimer.dominio.Usuario;
import br.com.lembraimer.tela.TelaCadastro;
import br.com.lembraimer.tela.TelaPesquisa;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class PacienteBusiness implements PacienteInterface {

    public Paciente salvarPaciente(Paciente paciente, Endereco endereco, TelaCadastro tela, Usuario usuario) {
       if(validarPaciente(paciente) || validarEndereco(endereco)||validarUsuario(usuario)){
           try {
            Connection conn;
            PreparedStatement stmt;
            
            conn = DataBase.conexao();
            
            //cria a string para inserir no banco
            String query = "INSERT INTO paciente ( nomePaciente, nomeResponsavel, telefoneResponsavel, "
                    + "medicamento,horarioMedicamento, endereco, lembretes,senha) VALUES(?,?,?,?,?,?,?,?)";
            
            //seta os valores na string de inserção
            stmt = conn.prepareStatement(query);
            stmt.setString(1, paciente.getNomePaciente());
            stmt.setString(2, paciente.getNomeResponsavel());
            stmt.setString(3, String.valueOf(paciente.getTelefone()));
            stmt.setString(4, paciente.getRemedio());
            stmt.setString(5, paciente.getHorarioMedicamento());
            stmt.setString(6, endereco.getRua());
            stmt.setString(7, paciente.getLembrete());
            stmt.setString(8, usuario.getSenha());
            //executa o comando no banco de dados
            stmt.executeUpdate();
            
            //fecha a conexão
            stmt.close();
            conn.close();
 
        }catch(SQLException e){
            System.out.println("Ocorreu um erro de conexão " + e);
        }
           JOptionPane.showMessageDialog(null, " O Paciente foi cadastrado com sucesso,");
           
           limpaCampos(tela);
           
       }else{
           JOptionPane.showMessageDialog(null,"TODOS OS CAMPOS DEVEM SER PREENCHIDOS");
       }
            return null;
    }

    @Override
    public Paciente buscarPacientePorNome(Paciente nome, TelaPesquisa telaPesquisa) {
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
    
    public boolean validarPaciente(Paciente paciente){
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


    public boolean validarEndereco(Endereco endereco){
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
    public boolean validarUsuario(Usuario usuario){
        boolean clienteValido = true;
        if(usuario !=null)
        {
            if(usuario.getSenha()== null||
               usuario.getSenha().equals(""))
                {
                clienteValido = false;
                }
        }
        return clienteValido;
     }
    
    public void limpaCampos(TelaCadastro tela){
       tela.campoNomePaciente.setText("");
       tela.campoNomeResponsavel.setText("");
       tela.campoTelefoneResponsavel.setText("");
       tela.campoMedicamento.setText("");
       tela.campoHoraMedicamento.setText("");
       tela.campoEndereco.setText("");
       tela.campoLembrete.setText("");
       tela.jPasswordField1.setText("");
    }


    @Override
    public Paciente salvarPaciente(Paciente paciente, Endereco endereco, TelaCadastro telacadastro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}