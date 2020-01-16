/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import database.kingsbarbershopDatabase;
import entity.pelanggan;
import error.PelangganException;
import event.PelangganListener;
import service.PelangganDAO;

/**
 * Nama :Riski Dwi Sabariyanto
 * NIM  : 10118026
 * Kelas: IF-1 2018
 *
 * @author Riski
 */
public class PelangganModel {
    
    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
   protected void fireOnChange(){
       if(listener!=null){
          listener.onChange(this);
       }
   }
   
   protected void fireOnInsert(pelanggan pelanggan){
       if(listener!=null){
          listener.onInsert(pelanggan);
       }
   }
   protected void fireOnDelete(){
        if(listener!=null){
          listener.onDelete();
       }
   }
   protected void fireOnUpdate(pelanggan pelanggan){
       if(listener!=null){
          listener.onUpdate(pelanggan);
       }
   }
   
   public void InsertPelanggan() throws SQLException, PelangganException{
       PelangganDAO dao = kingsbarbershopDatabase.getPelangganDAO();
       pelanggan pelanggan = new pelanggan();
       pelanggan.setNama(nama);
       pelanggan.setAlamat(alamat);
       pelanggan.setTelepon(telepon);
       pelanggan.setEmail(email);
       
       dao.insertPelanggan(pelanggan);
       fireOnInsert(pelanggan);
        
   
   }
   
   public void UpdatePelanggan() throws SQLException, PelangganException{
       PelangganDAO dao = kingsbarbershopDatabase.getPelangganDAO();
       pelanggan pelanggan = new pelanggan();
       pelanggan.setNama(nama);
       pelanggan.setAlamat(alamat);
       pelanggan.setTelepon(telepon);
       pelanggan.setEmail(email);
       pelanggan.setId(id);
       
       dao.updatePelanggan(pelanggan);
       fireOnUpdate(pelanggan);
        
   
   }
   
   public void DeletePelanggan() throws SQLException, PelangganException{
       PelangganDAO dao = kingsbarbershopDatabase.getPelangganDAO();
       dao.deletePelanggan(id);
      fireOnDelete();
      
      

   }
   
   public void resetPelanggan(){
       setId(0);
       setNama("");
       setAlamat("");
       setTelepon("");
       setEmail("");
   }
    
}
