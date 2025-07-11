package org.example.votingsystem;

import java.io.ByteArrayInputStream;
import java.sql.*;

public class AccountRepository
{
    public static boolean searchAccount(String name, String email)
    {
        try(Connection connection = DriverManager.getConnection(DatabaseConnection.CONNECTION_DATABASE,"root","galagar"))
        {
            String query = "SELECT * FROM voters WHERE voters_name = ? AND voters_email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean isAccountAdded(VoterModel voter)
    {
        try(Connection connection = DriverManager.getConnection(DatabaseConnection.CONNECTION_DATABASE,"root","galagar"))
        {
            String query = "INSERT INTO voters(voters_name, voters_email, voters_contact, voters_password, voters_profile) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,voter.getName());
            preparedStatement.setString(2,voter.getEmail());
            preparedStatement.setString(3,voter.getContactNum());
            preparedStatement.setString(4,voter.getPassword());

            ByteArrayInputStream inputStream = new ByteArrayInputStream(voter.getProfile());
            preparedStatement.setBlob(5, inputStream);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet > 0;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isAccountExisted(int id, String pass)
    {
        try(Connection connection = DriverManager.getConnection(DatabaseConnection.CONNECTION_DATABASE,"root","galagar"))
        {
            String query = "SELECT * FROM voters WHERE voters_id = ? AND voters_password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getVotersId(String name, String email)
    {
        try(Connection connection = DriverManager.getConnection(DatabaseConnection.CONNECTION_DATABASE,"root","galagar"))
        {
            String query = "SELECT * FROM voters WHERE voters_name = ? AND voters_email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return resultSet.getInt("voters_id");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static String getVotersName(int id)
    {
        try(Connection connection = DriverManager.getConnection(DatabaseConnection.CONNECTION_DATABASE,"root","galagar"))
        {
            String query = "SELECT * FROM voters WHERE voters_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return resultSet.getString("voters_name");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Anonymous";
    }

    public static byte[] getVotersProfile(int id, String pass)
    {
        try(Connection connection = DriverManager.getConnection(DatabaseConnection.CONNECTION_DATABASE,"root","galagar"))
        {
            String query = "SELECT * FROM voters WHERE voters_id = ? AND voters_password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Blob blob = resultSet.getBlob("voters_profile");
                return blob.getBytes(1, (int) blob.length());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }



}
