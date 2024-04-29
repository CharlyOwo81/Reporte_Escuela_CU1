/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author Oliver Valle
 */
public class DocenteEntity {
    
    private ObjectId _id ;
    private String CURP, nombre, apellidoP, apellidoM ;

    public DocenteEntity(ObjectId _id, String CURP, String nombre, String apellidoP, String apellidoM) {
        this._id = _id;
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }
    
    public DocenteEntity(String CURP, String nombre, String apellidoP, String apellidoM) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }
    
    public void setId(String _id) {
        this._id = new ObjectId(_id);
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    
    
    
}
