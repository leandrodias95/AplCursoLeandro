/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.dao;

import br.com.curso.model.Usuario;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO implements GenericDAO {

    private Connection conexao;

    public UsuarioDAO() throws Exception {
        conexao = SingleConnection.getConnection();

    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Usuario oUsuario = (Usuario) objeto;
        Boolean retorno = false;
        if (oUsuario.getIdUsuario() == 0) {
            retorno = this.inserir(oUsuario);
        } else {
            retorno = this.alterar(oUsuario);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Usuario oUsuario = (Usuario) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into usuario (email, senha, nomecompleto, tipousuario) values (?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oUsuario.getEmail());
            stmt.setString(2, oUsuario.getSenha());
            stmt.setString(3, oUsuario.getNomeCompleto());
            stmt.setString(4, oUsuario.getTipoUsuario());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar o Usuario! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Usuario oUsuario = (Usuario) objeto;
        PreparedStatement stmt = null;
        String sql = "update usuario set email=?, senha=?, nomecompleto=?, tipousuario=? where idusuario=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oUsuario.getEmail());
            stmt.setString(2, oUsuario.getSenha());
            stmt.setString(3, oUsuario.getNomeCompleto());
            stmt.setString(4, oUsuario.getTipoUsuario());
            stmt.setInt(5, oUsuario.getIdUsuario());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Usuario! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idUsuario = numero;
        PreparedStatement stmt = null;

        String sql = "delete from usuario where idUsuario=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o Usuario! Erro: "
                    + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rolback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idUsuario = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario oUsuario = null;
        String sql = "select * from usuario where idUsuario=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oUsuario = new Usuario();
                oUsuario.setIdUsuario(rs.getInt("idUsuario"));
                oUsuario.setEmail(rs.getString("email"));
                oUsuario.setSenha(rs.getString("senha"));
                oUsuario.setNomeCompleto(rs.getString("nomecompleto"));
                oUsuario.setTipoUsuario(rs.getString("tipousuario"));
            }
            return oUsuario;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Usuario! Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from usuario order by idUsuario";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario oUsuario = new Usuario();
                oUsuario.setIdUsuario(rs.getInt("idUsuario"));
                oUsuario.setEmail(rs.getString("email"));
                oUsuario.setSenha(rs.getString("senha"));
                oUsuario.setNomeCompleto(rs.getString("nomecompleto"));
                oUsuario.setTipoUsuario(rs.getString("tipousuario"));
                resultado.add(oUsuario);
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Usuario! Erro: "
                    + ex.getMessage());
        }
        return resultado;
    }

}
