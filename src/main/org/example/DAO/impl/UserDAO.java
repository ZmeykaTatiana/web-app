package org.example.DAO.impl;

import org.example.DAO.AbstractDAO;
import org.example.Model.User;
import org.example.Utils.BDUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class UserDAO extends AbstractDAO<User> {
    @Override
    public boolean insert(User o) {
        return false;
    }

    @Override
    public boolean update(User o) {
        return false;
    }

    @Override
    public boolean delete(User o) {
        return false;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public Set getAll() {
        return null;
    }
    public User getByEmail(String email){
        Connection connection=BDUtils.getConnection();
        String sql="SELECT * FROM user_db WHERE email= '"+ email+"'";
        Statement st=null;
        ResultSet rs=null;
        User user=null;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                System.out.println("User is found");
                user=new User();
                user.setEmail(email);
                user.setName(rs.getString("name"));
                user.setPassword("password");
                user.setId(rs.getInt("id"));
            }else{
                System.out.println("User doesn't found, try again");
            }

        }catch (SQLException e){
            System.err.println(e);
        }finally {
            BDUtils.release(connection,st,null,rs);

        }

        return user;

    }
}
