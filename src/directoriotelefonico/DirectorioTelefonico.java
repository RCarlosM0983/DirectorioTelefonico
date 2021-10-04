
package directoriotelefonico;

import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;


public class DirectorioTelefonico {
    private static String telefono;
    private static TreeMap<String,Cliente>clientes = new TreeMap<>();

    public DirectorioTelefonico() {
    }

     

    public static String getTelefono() {
        return telefono;
    }
    
 

    public static TreeMap<String, Cliente> getClientes() {
        return clientes;
    }
    
    public static void agregarCliente(String tel, Cliente cli) {
   
        if(!clientes.containsKey(tel)){
        clientes.put(tel, cli);
       JOptionPane.showMessageDialog(null, "Cliente agregado");           
        }else{
            JOptionPane.showMessageDialog(null, "El cliente ya existe");
        }
    }
    public static Cliente buscarCliente(String tel){
        if(clientes.containsKey(tel)){
             return clientes.get(tel);
        }else{
            return null;
        }
       
    }
    public static ArrayList<String> buscarTelefono(String apellido){
        ArrayList<String>numeros = new ArrayList<>();
        
        for(String tel:clientes.keySet()){
            if((clientes.get(tel)).getApellido() == apellido){
              numeros.add(tel);
            }else{
               JOptionPane.showMessageDialog(null,"No existen números telefónicos para este apellido"); 
            }
        }
        return numeros;
       
    } 
    public static ArrayList<Cliente> buscarClientes(String ciudad){
        ArrayList<Cliente>lista = new ArrayList<>();
        for(String tel: clientes.keySet()){
            if(clientes.get(tel).getCiudad() == ciudad){
                lista.add(clientes.get(tel));
            }
        }
        return lista;
    }
    public static void borrarCliente(String dni){
        boolean existe = false;
        for(String tel:clientes.keySet()){
            if(clientes.get(tel).getDni().equals(dni)){
               clientes.remove(tel);
               existe = true;
      
            }
        }
        if(existe){
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no existe");
        }
    }
    
    public static void main(String[] args) {
       
    }
    
}
