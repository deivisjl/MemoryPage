/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Proceso;
import repository.IListProcessCallback;
import repository.IMainRepository;
import repository.MainRepositoryImpl;
import ui.IListaView;

/**
 *
 * @author SAMSUNG
 */
public class ListaControllerImpl implements IListaController{
    
    private IListaView view;
    private IMainRepository mainRepository;

    public ListaControllerImpl(IListaView view) {
        this.view = view;
        this.mainRepository = MainRepositoryImpl.getInstance();
    }
    
    

    @Override
    public void listarProcesos() {
        this.mainRepository.retornarListaDeProcesos(new IListProcessCallback() {
            @Override
            public void listaDeProcesos(List<Proceso> listaProcesos) {
                retornarLista(listaProcesos);
            }
        });
    }
    
    private void retornarLista(List<Proceso> listaProcesos) {
        this.view.onProcessList(listaProcesos);
    }
    
}
