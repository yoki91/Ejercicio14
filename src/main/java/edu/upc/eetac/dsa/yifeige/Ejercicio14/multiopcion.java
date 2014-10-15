package edu.upc.eetac.dsa.yifeige.Ejercicio14;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Date;

public class multiopcion 
{
    public static void main( String[] args )
    {
    	int PortNumber=7005;
        try
        {   
        	ServerSocket SocketServidor=new ServerSocket(PortNumber);
        	System.out.print("Socket construido esperando una conexion");
        	Socket SocketCliente=SocketServidor.accept();
        	
        	Date fecha=new Date();
        	SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        	SimpleDateFormat formato1=new SimpleDateFormat("[dd]:[MM] [kk]:[mm]:[ss]");
    
        	
        	PrintWriter escritor=new PrintWriter(SocketCliente.getOutputStream(),true);
        	BufferedReader lector=new BufferedReader(new InputStreamReader(SocketCliente.getInputStream()));
        	
        	int opcionRecibido;
        	opcionRecibido=Integer.parseInt(lector.readLine());
        	
        	
        	
        	if(opcionRecibido==0)
        	{
        		String hora=formato.format(fecha);
        		escritor.println(hora);
        	}
        	if(opcionRecibido==1)
        	{
        		String hora=formato1.format(fecha);
        		escritor.println(hora); 		
        	}
        	else
        		System.exit(1);
         }
        catch(IOException e)
        {
        	System.out.println("Exception caught when trying to listen on port "+ PortNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
        
    }
}
