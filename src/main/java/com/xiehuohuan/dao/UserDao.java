package com.xiehuohuan.dao;

import com.xiehuohuan.model.User;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable values(?,?,?,?,?,?";
        PreparedStatement st=con.prepareStatement(sql);
        st.executeUpdate();
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from ? where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.executeUpdate();
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            String sql="update usertable set username='"+user.getUsername()+"',passward='"+user.getPassward()+"',email='"+user.getEmail()+"',genter='"+user.getGenter()+"',birthdate='"+user.getBirthDate()+"' where id="+user.getId();
            createDbStatement.executeUpdate(sql);
            System.out.println("update "+user.getId()+" success");
            return 1;
        }catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable where username=? and passward=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable where passward=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable where genter=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable where birthDate=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select id,username,passward,email,genter,birthdate from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassward(rs.getString("passward"));
            user.setEmail(rs.getString("email"));
            user.setGenter(rs.getString("genter"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return null;
    }
}
