/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import testing.db.JDBCConnection;
import testing.dto.Empleado;

/**
 *
 * @author Usuario
 */
public class EmpleadosService {
    
    public Collection<Empleado> getEmpleados() {
        JDBCConnection connDriver = new JDBCConnection();
        Collection<Empleado> retorno = null;
        Statement oStatement = null;
        ResultSet oResultSet = null;
        try {
            Connection conn = connDriver.getConexion();
            oStatement = conn.createStatement();
            oResultSet = oStatement.executeQuery("select * from empleados");
            retorno = this.mapEmpleados(oResultSet);
        } catch(SQLException e ) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
    
    private Collection<Empleado> mapEmpleados(ResultSet rs) throws SQLException {
        Collection<Empleado> retorno = new LinkedList();
        while (rs.next()) {
            Empleado oEmpleado = new Empleado();
            oEmpleado.setId(rs.getInt(1));
            oEmpleado.setNombres(rs.getString(2));
            oEmpleado.setApellidos(rs.getString(3));
            oEmpleado.setTelefono(rs.getString(4));
            oEmpleado.setDireccion(rs.getString(5));
            oEmpleado.setEdad(rs.getInt(6));
            retorno.add(oEmpleado);
        }
        return retorno;
    }
    
}
