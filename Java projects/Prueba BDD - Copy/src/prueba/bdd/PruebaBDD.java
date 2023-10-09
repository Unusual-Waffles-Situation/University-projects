package prueba.bdd;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PruebaBDD 
{
    public static BufferedReader leer()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }
    
    public static byte leerByte()
    {
        byte i = 0;
	
        boolean sw;
	
        do
	{
            sw = false;
            
            try
            {
		i = Byte.parseByte(leer().readLine());
            }
			
            catch (Exception e)
            {
		System.out.println("Ha ocurrido un error.");
		
                sw = true;
            }
            
	} while (sw);
	
        return i;
    }
    
    public static String leerCadena()
    {
	String i = "";
	
        boolean sw;
	
        do
	{
            sw = false;
            
            try
            {
		i = leer().readLine();
            }
			
            catch (Exception e)
            {
		System.out.println("Ha ocurrido un error.");
		
                sw = true;
            }
            
	} while (sw);
		
        return i;
    }
    
    public static void main(String[] args) 
    {
        Operaciones o = new Operaciones();
        
        byte op = 1;
        
        do
        {
            System.out.print("¿Qué desea hacer? \n1. Agregar persona. \n2.Mostrar personas. \n3. Salir. \nOpción: ");
            
            op = leerByte();
            
            switch(op)
            {
                case 1:
                {
                    boolean comp = false;
                    
                    String nombre, cedula;
                    nombre = cedula = "";
                    
                    System.out.print("Ingrese el nombre de la persona: ");
                    nombre = leerCadena();
                    
                    System.out.print("Ingrese cedula: ");
                    cedula = leerCadena();
                    
                    comp = o.agregarPersona(nombre, cedula);
                    
                    if (comp)
                        System.out.println("Se ha agregado la persona.\n");
                    
                    else
                        System.out.println("Ya se encuentra una persona con la cedula '" + cedula + "' en la base de datos.\n");
                    
                    break;
                }
                
                case 2:
                {
                    String comp = o.leerPersonas();
                    
                    if (comp.equals(""))
                        System.out.println("No se encuentra personas en la base de datos.\n");
                    
                    else
                        System.out.println(comp);
                    
                    break;
                }
                
                case 3:
                {
                    String lugar = "";
                    
                    System.out.print("Ingrese el lugar que desea buscar: ");
                    
                    lugar = leerCadena();
                    
                    String comp = o.buscarLugar(lugar);
                    
                    if (comp.equals(""))
                        System.out.println("Ninguna persona trabaja en esa zona.\n");
                    
                    else
                        System.out.println(comp);
                    
                    break;
                }
                
                case 4:
                    break;
                    
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.\n");
                    
                    break;
            }
            
        } while (op != 4);
        
        //o.crearTabla();
        
        //o.agregarPersona();
        
        o.leerPersonas();
        
        try 
        {
            o.getCon().close();
        } 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(PruebaBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
