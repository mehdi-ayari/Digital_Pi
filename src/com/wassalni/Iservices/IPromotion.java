/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;


import com.wassalni.entites.Promotion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author UnKnOWn
 */
public interface IPromotion<T>{
    
    void ajouter(T t) throws SQLException;
    void delete(T t) throws SQLException;
    void update(Promotion p) throws SQLException,IOException;
    List<T> readAllPromotion() throws SQLException;
}
