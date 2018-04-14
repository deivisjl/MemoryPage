/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.EjecucionControllerImpl.EN_EJECUCION;
import java.util.ArrayList;
import java.util.List;
import model.Proceso;
import repository.IListProcessCallback;
import repository.IMainRepository;
import repository.MainRepositoryImpl;
import ui.IEsperaView;

/**
 *
 * @author SAMSUNG
 */
public class EsperaControllerImpl implements IEsperaController{
    
    private IEsperaView view;
    public static IMainRepository mainRepository;
    public static String EN_ESPERA = "en espera";

    public EsperaControllerImpl(IEsperaView view) {
        this.view = view;
        this.mainRepository = MainRepositoryImpl.getInstance();
    }
    
    

    @Override
    public void listarProcesosEnEspera() {
        this.mainRepository.retornarListaDeProcesos(new IListProcessCallback() {
            @Override
            public void listaDeProcesos(List<Proceso> listaProcesos) {
                recorrerLista(listaProcesos);
            }
        });
    }
    
    private void recorrerLista(List<Proceso> listaProcesos) {
        List<Proceso> procesosEnEspera = new ArrayList<Proceso>();
        
            for(int i = 0; i < listaProcesos.size(); i++){
             if(listaProcesos.get(i).getEstado().equals(EN_ESPERA)){
                 procesosEnEspera.add(listaProcesos.get(i));
             }
         }
         
         this.view.onProcessWaiting(procesosEnEspera);
    }
    
}
