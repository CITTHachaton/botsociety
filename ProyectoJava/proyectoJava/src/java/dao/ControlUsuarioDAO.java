/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Comuna;
import modelo.ControlUsuario;

/**
 *
 * @author benja
 */
public class ControlUsuarioDAO {
    
    private ArrayList<ControlUsuario> arrayUsuario = new ArrayList<>();
    Conectar conn;
    
    public ControlUsuario buscar(int idUsuario) {
        
        ControlUsuario obj = null;
        try {
            conn = new Conectar();
            Connection connection = conn.getConnection();
            
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM control_usuario WHERE id_control_u  =" + idUsuario + ";";
            
            ResultSet results = statement.executeQuery(query);

            /*
            
CREATE TABLE control_usuario (
    id_control_u   INT NOT NULL AUTO_INCREMENT,
    usuario        VARCHAR(40) NOT NULL,
    clave          VARCHAR(40) NOT NULL,
    rut_persona    VARCHAR(13),
    id_persona     INT NOT NULL,
    PRIMARY KEY(id_control_u)
);
             */
            int id, idP;
            String usuario, clave, rut;
            
            while (results.next()) {
                id = results.getInt("id_control_u");
                usuario = results.getString("usuario");
                clave = results.getString("clave");
                rut = results.getString("rut_persona");
                idP = results.getInt("id_persona");
                
                if (id == idUsuario) {
                    obj = new ControlUsuario(id, usuario, clave, idP);
                    break;
                }
            }
            connection.close();
            conn.desconectar();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

    public ControlUsuario buscarUsuario(String usuario) {
        
        ControlUsuario obj = null;
        try {
            conn = new Conectar();
            Connection connection = conn.getConnection();
            
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM control_usuario WHERE usuario  ='" + usuario + "';";
            
            ResultSet results = statement.executeQuery(query);

            /*
            
CREATE TABLE control_usuario (
    id_control_u   INT NOT NULL AUTO_INCREMENT,
    usuario        VARCHAR(40) NOT NULL,
    clave          VARCHAR(40) NOT NULL,
    rut_persona    VARCHAR(13),
    id_persona     INT NOT NULL,
    PRIMARY KEY(id_control_u)
);
             */
            int id, idP;
            String usuario1, clave, rut;
            
            while (results.next()) {
                id = results.getInt("id_control_u");
                usuario1 = results.getString("usuario");
                clave = results.getString("clave");
                rut = results.getString("rut_persona");
                idP = results.getInt("id_persona");
                
                if (usuario1.equals(usuario)) {
                    obj = new ControlUsuario(id, usuario, clave, idP);
                    break;
                }
            }
            connection.close();
            conn.desconectar();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }
    
     public int agregar(ControlUsuario control) {
         try {
            conn = new Conectar();
            Connection connection = conn.getConnection();
            Statement statement = connection.createStatement();
            String agregarSQL = "INSERT INTO control_usuario(usuario,clave,rut_persona,id_persona)"
                    + " VALUES('" + control.getUsuario()+ "','" + control.getClave()+ "','" + control.getRutPersona()+ "'," + control.getIdPersona()+ ");";
            int results = statement.executeUpdate(agregarSQL);
            connection.close();
            conn.desconectar();
            return results;
        } catch (java.lang.Exception ex) {
            return 0;
        }
    }
    
}
