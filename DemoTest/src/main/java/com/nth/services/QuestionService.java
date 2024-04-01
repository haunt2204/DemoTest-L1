/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nth.services;

import com.nth.demotest.jdbcUtil;
import com.nth.pojo.Choice;
import com.nth.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {
    public boolean addQuestion(Question q, List<Choice> choice) throws SQLException{
        try(Connection conn = jdbcUtil.getConnection()){
            conn.setAutoCommit(false);
            String sql = "INSERT INTO Question(id, content, category_id) VALUES(?,?,?)"; //SQL Injection
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, q.getId());
            stm.setString(2, q.getContent());
            stm.setInt(3,q.getCategory_id());
            
            int r = stm.executeUpdate();
            for(Choice c: choice){
                String sql_c = "INSERT INTO Choice(id, content, "
                        + "question_id, is_correct) VALUES (?,?,?,?)";
                PreparedStatement stm_c = conn.prepareStatement(sql_c);
                stm_c.setString(1, c.getId());
                stm_c.setString(2, c.getContent());
                stm_c.setString(3, c.getQuestion_id());
                stm_c.setBoolean(4, c.isCorrect());
                
                stm_c.executeUpdate();
            }
            
            try{
                conn.commit();
                return true;
            }catch(Exception ex){
                ex.printStackTrace();
                return false;
            }
        }   
    } 
}
