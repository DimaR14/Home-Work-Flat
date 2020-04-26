package Flat;

import Shared.Flat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlatDAOclass  implements  FlatDAO{
    private final Connection conn;
    private List<Flat> res = new ArrayList();

    public FlatDAOclass(Connection conn) { this.conn = conn;}


    @Override
    public String toString() {
        String s = "";
        for(Flat f : res){
            s+= "\n"+f.toString();
        }
        return "Flat:" + s;

    }

    public List<Flat> getAll() {
        //List<Flat> res = new ArrayList();
        try{
            try(Statement st = conn.createStatement()){
                try(ResultSet rs = st.executeQuery("SELECT * FROM table1")){
                    while(rs.next()){
                        Flat flat = new Flat();
                        flat.setFlatId(rs.getInt(1));
                        flat.setDistrict(rs.getString(2));
                        flat.setAddress(rs.getString(3));
                        flat.setArea(rs.getInt(4));
                        flat.setRoomsNumber(rs.getInt(5));
                        flat.setPrice(rs.getInt(6));
                        res.add(flat);
                    }
                }
            }
            return res;
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }


    public List<Flat> getAll(String option, String value) {
        //List<Flat> res = new ArrayList();
        String x = "";
        try{
            try(Statement st = conn.createStatement()){
                if(option.equals("district")|option.equals("rooms_number")) {
                    x = "=";
                }if(option.equals("area")){
                    x = ">";
                }if(option.equals("price")){
                    x = "<";
                }
                    try(ResultSet rs = st.executeQuery("SELECT * FROM table1 WHERE "+option+x+"'"+value+"'")){
                    while(rs.next()){
                        Flat flat = new Flat();
                        flat.setFlatId(rs.getInt(1));
                        flat.setDistrict(rs.getString(2));
                        flat.setAddress(rs.getString(3));
                        flat.setArea(rs.getInt(4));
                        flat.setRoomsNumber(rs.getInt(5));
                        flat.setPrice(rs.getInt(6));
                        res.add(flat);
                    }
                }
            }if(res.isEmpty()){
                System.out.println("There are no apartments with such options");
                return  res;
            }
            return res;
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}
