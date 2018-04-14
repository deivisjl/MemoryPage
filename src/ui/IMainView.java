/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;
import model.Marcos;

/**
 *
 * @author SAMSUNG
 */
public interface IMainView {
    public void onError(String msg);
    public void onRefreshView(List<Marcos> lista);
}
