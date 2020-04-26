package Flat;

import Shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/flat?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "Xeraxera1997";

    public static void main(String[] args) throws SQLException {
        ConnectionFactory f = new ConnectionFactory(
                DB_CONNECTION, DB_USER, DB_PASSWORD
        );
        Connection conn = f.getConnection();
        FlatDAO dao = new FlatDAOclass(conn);
        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("If you want to see all flat: Enter all."+
                "\n"+"If you want to select option: Enter option");
        String enter = sc.nextLine();
        if(enter.equals("all")) {
            dao.getAll();
            System.out.println(dao.toString());
            break;
        }if(enter.equals("option")){ start(dao); break;}
        else{System.out.println("try again");
        }
    }
    }


    public static void start(FlatDAO dao) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select option:");
            System.out.println("For example : district, area, rooms_number, price");
            String option = sc.nextLine();
            if(option.isEmpty()){ System.out.println(dao.getAll()); break;}
            if (option.equals("district")) {
                System.out.println("what district are you interested in?" + "\n" + "Goloseevskiy,Pechersk,Poznyki");
                String value = sc.nextLine();
                dao.getAll(option, value);
                System.out.println(dao.toString());
                return;
            }
            if (option.equals("area")) {
                System.out.println("Enter the minimum area of the apartment:");
                String value = sc.nextLine();
                dao.getAll(option,value);
                System.out.println(dao.toString());
                return;
            }
            if (option.equals("rooms_number")) {
                System.out.println("Enter the number of rooms:");
                String value = sc.nextLine();
                dao.getAll(option, value);
                System.out.println(dao.toString());
                return;
            }
            if (option.equals("price")) {
                System.out.println("Enter the maximum price of the apartment:");
                String value = sc.nextLine();
                dao.getAll(option, value);
                System.out.println(dao.toString());
                return;
            } else {
                System.out.println("Wrong option,try again");
            }
        }
    }



}
