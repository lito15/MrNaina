/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.BaseModel;

/**
 *
 * @author Joselito
 */
public interface InterfaceDAO {
    List<BaseModel> getAll() throws Exception;
    BaseModel getById(String id) throws Exception;
    void insert(BaseModel b) throws Exception;
    void update(String id,String chang)throws Exception;
    void delete(String id)throws Exception;
}
