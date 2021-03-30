/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import java.util.List;

/**
 *
 * @author hungn
 */
public abstract class ManageDAO<E,K> {
    public abstract boolean insert(E entity);
    public abstract boolean update(E entity);
    public abstract boolean delete(K key);
    public abstract List<E> selectAll();
    public abstract E selectByID(K key);
    protected abstract List<E> selectBySql(String sql, Object...args);
}
