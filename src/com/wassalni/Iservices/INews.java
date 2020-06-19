/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;

import java.sql.SQLException;
import java.util.List;

public interface INews<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(int t) throws SQLException;
    boolean update(T t) throws SQLException;
    List<T> readAll() throws SQLException;
    public T readID(T t) throws SQLException;

}
