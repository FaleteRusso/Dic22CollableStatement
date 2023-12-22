package com.corenetworks.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoFunciones extends Conexion{
    public String probarFuncionConParamametro(int id) throws SQLException, ClassNotFoundException {
        //1, declaracion variables
        CallableStatement sentencia = null;
        ResultSet rejilla = null;
        String sql ="Select nombre_producto(?);";
        String resultado=null;
        //2, abrir condicion
        abrirConexion();
        //3, crear statement
        sentencia = miConexion.prepareCall(sql);
        sentencia.setInt(1,id);
        //4, ejecutar statement
        rejilla = sentencia.executeQuery();
        if(rejilla.next()){
            resultado=rejilla.getString("nombre_producto");
        }
        //5, devolver resultado
        return resultado;
    }
}
