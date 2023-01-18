package org.example.DAO.impl;

import org.example.DAO.AbstractDAO;
import org.example.Model.User;
import org.example.Utils.BDUtils;

import java.sql.*;
import java.util.Set;

public class UserDAO extends AbstractDAO<User> {
    @Override
    public boolean insert(User user) {
        String sql="INSERT into user_db.user (name,email,password)VALUES (?,?,?)";
        Connection connection=null;
        try{
            connection=BDUtils.getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            if(ps.executeUpdate()==1){
                System.out.println("User added");
                return true;
            }
        }catch (SQLException ex){
            System.err.println(ex);
        }


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
        String sql="SELECT * FROM user_db.user WHERE email='"+email+"'";
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
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("id"));

            }else{
                System.out.println("User doesn't found, try again");
            }

        }catch (SQLException e){
            System.err.println(e);
        }

        return user;

    }
}
