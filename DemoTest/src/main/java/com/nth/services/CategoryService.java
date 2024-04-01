/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nth.services;

import com.nth.demotest.jdbcUtil;
import com.nth.pojo.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryService {
    public List<Category> getCategories() throws SQLException{
        List<Category> result = new ArrayList<>();
        try(Connection conn = jdbcUtil.getConnection()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Category");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category c = new Category(id, name);
                result.add(c);
            }
        }
        return result;
    }
}
