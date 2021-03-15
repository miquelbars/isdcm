package com.isdcm.dao;

import com.isdcm.dto.VideoDTO;
import com.isdcm.jdbc.DataSource;
import java.sql.*;

public class VideoDAO {
    
    
    public void insertVideo(VideoDTO video){
        try {
            DataSource ds = DataSource.getInstance();
            //here mydb is database name, mydb is username and password
            String insertNewUserSQL = "INSERT INTO MYDB.VIDEO (TITULO, AUTOR, FECHA_CREACION, DURACION, REPRODUCCIONES, DESCRIPCION, FORMATO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = ds.getConnection().prepareStatement(insertNewUserSQL);
            
            pstmt.setString(1, video.getTitulo());
            pstmt.setString(2, video.getAutor());
            java.sql.Date date1 = new java.sql.Date(video.getFechaCreacion().toEpochDay());
            java.sql.Time time1 = new java.sql.Time(video.getDuracion().toNanoOfDay());
            pstmt.setDate(3, date1);
            pstmt.setTime(4, time1);
            pstmt.setInt(5, video.getReproducciones());
            pstmt.setString(6, video.getDescripcion());
            pstmt.setString(7, video.getFormato());
            
            pstmt.executeUpdate();
            ds.getConnection().close();  
        }
        catch(SQLException e){ System.out.println(e);}
    }
    
    public boolean checkVideo(VideoDTO video){
        try {
            DataSource ds = DataSource.getInstance();
            //here mydb is database name, mydb is username and password
            String sql = "SELECT * FROM MYDB.VIDEO WHERE titulo = ? and autor = ?";
            PreparedStatement pstmt = ds.getConnection().prepareStatement(sql);
            pstmt.setString(1, video.getTitulo());
            pstmt.setString(2, video.getAutor());
            
            ResultSet rs = pstmt.executeQuery();
            int check = 0;
            
            if(rs.next()){
                ++check;
            }
            
            ds.getConnection().close();
            
            return check > 0;
        }
        catch(SQLException e){ System.out.println(e);}
        return false;
    }
}
