/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jawed
 */
public interface IEntreprise<T> {
    void ajouter(T t) throws SQLException;
    void delete() throws SQLException,IOException;
    void update() throws SQLException,IOException ;
    List<T> readAll() throws SQLException;
}
