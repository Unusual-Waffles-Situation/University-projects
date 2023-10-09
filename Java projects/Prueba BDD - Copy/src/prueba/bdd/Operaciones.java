package prueba.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operaciones
{
    private Connection con;
    
    public Operaciones()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdd_prueba", "invitado", "12345");
            
            System.out.println("Se conectó a la base de datos.");
        }
        
        catch (Exception ex)
        {
            System.out.println("No se encontró la base de datos " + ex);
        }
    }
    
    public boolean agregarPersona(String nombre, String ci)
    {
        String cedula = "";
        
        try
        {
            Statement sta = con.createStatement();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM persona");
            
            while(rs.next())
            {
                cedula = rs.getString(2);
                
                if (cedula.equals(ci))
                    return false;
            }
            
            sta = con.createStatement();
            
            String consulta = "INSERT INTO Persona (nombre_persona, cedula) VALUES ('" + nombre + "', '" + ci + "')";
            
            sta.execute(consulta);
            
            return true;
        }
        
        catch (SQLException ex)
        {
            return false;
        }
    }
    
    public String buscarLugar(String lu)
    {
        String personas = "";
        String cedulas = "";
        
        try
        {
            Statement sta = con.createStatement();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM oficinas");
            
            while (rs.next())
            {
                String lug = rs.getString(2);
                
                if (lug.toLowerCase().equals(lu.toLowerCase()))
                {
                    cedulas = rs.getString(1);
                    
                    Statement sta2 = con.createStatement();
                    
                    ResultSet ra2 = sta2.executeQuery("SELECT * FROM persona");
                    
                    while (ra2.next())
                    {
                        String ced = ra2.getString(2);
                        
                        if (cedulas.equals(ced))
                            personas += (ra2.getString(1) + ". C.I.: " + ra2.getString(2) + "\n");
                    }                      
                }
            }
            
            return personas;
        }
        
        catch (Exception e)
        {
            return personas;
        }
    }
    
    /*public String mostrar()
    {
        String personas = "";
        
        try
        {
            Statement sta = con.createStatement();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM oficinas");
            
            while(rs.next())
                personas += (rs.getString(1) + ". Lugar.: " + rs.getString(2) + "\n");
            
            return personas;
        }
        
        catch (SQLException ex)
        {
            return personas;
        }
    }*/
    
    /*public void crearTabla()
    {
        try
        {
            Statement sta = con.createStatement();
            
            sta.execute("CREATE TABLE Oficinas (cedula VARCHAR (11), lugar VARCHAR(20))");
            
            sta = con.createStatement();
            
            String consulta = "INSERT INTO Oficinas (cedula, lugar) VALUES ('123456', 'Norte')";
            
            sta.execute(consulta);
            
            sta = con.createStatement();
            
            consulta = "INSERT INTO Oficinas (cedula, lugar) VALUES ('789456', 'Norte')";
            
            sta.execute(consulta);
            
            sta = con.createStatement();
            
            consulta = "INSERT INTO Oficinas (cedula, lugar) VALUES ('45678977', 'Sur')";
            
            sta.execute(consulta);
            
            sta = con.createStatement();
            
            consulta = "INSERT INTO Oficinas (cedula, lugar) VALUES ('45698788', 'Este')";
            
            sta.execute(consulta);
            
            System.out.println("Se creo la tabla junto con sus personas");
        }
        
        catch (Exception e)
        {
            System.out.println("No se creo la tabla.");
        }
    }*/
    
    public String leerPersonas()
    {
        String personas = "";
        
        try
        {
            Statement sta = con.createStatement();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM persona");
            
            while(rs.next())
                personas += (rs.getString(1) + ". C.I.: " + rs.getString(2) + "\n");
            
            return personas;
        }
        
        catch (SQLException ex)
        {
            return personas;
        }
    }
    
    public Connection getCon(){ return con; }
}
