package br.com.lembraimer.business;

import br.com.lembraimer.business.interfaces.UsuarioInterface;
import br.com.lembraimer.db.DataBase;
import br.com.lembraimer.dominio.Endereco;
import br.com.lembraimer.dominio.Paciente;
import br.com.lembraimer.dominio.Usuario;
import br.com.lembraimer.tela.TelaMobile;
import br.com.lembraimer.tela.TelaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class UsuarioBusiness implements UsuarioInterface{ 
    
    @Override
    public boolean checkLogin(String IdLogin, String senha) {
    Connection conn;
    PreparedStatement cmd;
    ResultSet rs;
    
    boolean check = false;
    conn = DataBase.conexao();
        try {
            cmd = conn.prepareStatement("SELECT * FROM paciente where Id = ? and senha = ?");
            cmd.setString(1, IdLogin);
            cmd.setString(2, senha);
            rs = cmd.executeQuery();
            while(rs.next()){
                check = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    

    @Override
    public Usuario usuarioLogado(Usuario usuario, Usuario senha, TelaMobile tl) {
        if(this.checkLogin(usuario.getLogin(), senha.getSenha())){
            try {
            PreparedStatement cmd;
            Connection conn;
            ResultSet rs;
            
            conn = DataBase.conexao();
            
            String query = "SELECT * FROM paciente where Id = ? and senha = ?";

            cmd = conn.prepareStatement(query);
            
            cmd.setString(1, usuario.getLogin());
            cmd.setString(2, usuario.getSenha());
            
            rs = cmd.executeQuery();
            
            Paciente paciente = new Paciente();
            Endereco endereco = new Endereco();
            
            while(rs.next()){
                  paciente.setId(Integer.parseInt(rs.getString("Id")));
                  paciente.setNomePaciente(rs.getString("nomePaciente"));
                  paciente.setNomeResponsavel(rs.getString("nomeResponsavel"));
                  paciente.setTelefone(Integer.parseInt(rs.getString("telefoneResponsavel")));
                  paciente.setRemedio(rs.getString("medicamento"));
                  paciente.setHorarioMedicamento(rs.getString("horarioMedicamento"));
                  endereco.setRua(rs.getString("endereco"));
                  paciente.setLembrete(rs.getString("lembretes"));
            }
            //teste certo
            TelaUsuario novaTela = new TelaUsuario(paciente.getNomePaciente(), paciente.getNomeResponsavel(), paciente.getTelefone(), endereco.getRua(), paciente.getHorarioMedicamento(), paciente.getLembrete(), paciente.getRemedio());
            novaTela.setVisible(true);
            
            tl.dispose();
            
            
            DataBase.fecharfecharConexao(conn, cmd, rs);                            
             } catch(SQLException ex){
            System.out.println("Erro de conexão " + ex.getMessage());
        }
     
            }else{
                JOptionPane.showMessageDialog(null, "Erro de usuario ou senha");
            }
        return null;
    }
   
}
