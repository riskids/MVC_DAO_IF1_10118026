/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Nama :Riski Dwi Sabariyanto
 * NIM  : 10118026
 * Kelas: IF-1 2018
 *
 * @author Riski
 */
package event;

import entity.pelanggan;
import model.PelangganModel;

public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    public void onInsert(pelanggan pelanggan);
    public void onDelete();
    public void onUpdate(pelanggan pelanggan);

    
    
}
