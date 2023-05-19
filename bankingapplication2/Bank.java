package bankingapplication2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Bank {
    private String name;
    public Bank(String name){
        this.name = name;
    }

    public void listAccout(){
        Connection connection = BankingConnection.connect();
        String sql = "SELECT * FROM account" ;
        Statement statement = null;

        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      

        
    }

    public void openAccount(int accoutNumber,String accountName,double balance ){
        Connection connection = BankingConnection.connect();
        String sql = "insert into account(accNumber,accName,accBalance) " +"values(?,?,?)" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accoutNumber);
            preparedStatement.setString(2, accountName);
            preparedStatement.setDouble(3, balance);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     

    public void closeAccount(int accountNumber){
        Connection connection = BankingConnection.connect(); 
        String sql = "delete from acount where accNumber='?'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            preparedStatement.executeQuery();

    
            
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void depositMoney(int accountNumber,double amout){
        Account account = getAccount(accountNumber);
        account.deposit(amout);
        Connection connection = BankingConnection.connect(); 
        String sql = "update account set accBalance=? where accNumber=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, accountNumber);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    public void withdrawMoney(int accountNumber,double amout){
        System.out.println("5");
    }
    public Account getAccount(int accountNumber){
        Account account=null;
        Connection connection = BankingConnection.connect(); 
        String sql = "SELECT * FROM account where accnumber=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,accountNumber);
            ResultSet result = preparedStatement.executeQuery();

            result.next();

            account = new Account(result.getInt(1), result.getString(2), result.getDouble(3));
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
        return account;
    }


}
