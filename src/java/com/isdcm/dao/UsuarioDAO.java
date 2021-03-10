/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdcm.dao;

import com.isdcm.dto.UsuarioDTO;
import com.isdcm.jdbc.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fiblabs
 */
public class UsuarioDAO {
    
    public UsuarioDTO checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        DataSource ds = DataSource.getInstance();
        String sql = "SELECT * FROM usuarios WHERE email = ? and password = ?";
        PreparedStatement statement = ds.getConnection().prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
        UsuarioDTO user = null;
 
        if (result.next()) {
            user = new UsuarioDTO(Integer.SIZE, email, email, email, email, password);
            user.setNombre(result.getString("nombre"));
            user.setEmail(email);
        }
 
        ds.getConnection().close();
 
        return user;
    }
}
