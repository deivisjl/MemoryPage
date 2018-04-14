/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import model.Marcos;
import model.Proceso;

/**
 *
 * @author SAMSUNG
 */
public class MainRepositoryImpl implements IMainRepository{
    
    public static MainRepositoryImpl INSTANCE = null;
    protected List<Proceso>  listaProcesos;
    protected List<Marcos> listaMarcos;
    public static String EN_ESPERA = "en espera";
    public static String EN_EJECUCION = "en ejecución";
    public static String FINALIZADO = "finalizado";
    
    //private int[] colorsArray = {Color.CYAN,Color.RED,Color.GRAY,Color.GREEN,Color.BLUE,Color.YELLOW};
    
    public int marcos_vacios;

    public MainRepositoryImpl() {
        this.listaProcesos = new ArrayList<Proceso>();
        this.marcos_vacios = 7;
        this.listaMarcos = new ArrayList<Marcos>();
        inicializarMarcos();
    }
    
    public static MainRepositoryImpl getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MainRepositoryImpl();
        }
        return INSTANCE;
    }

    @Override
    public void guardarProceso(Proceso proceso, IBridgeCallback callback) {
        proceso.setPID(UUID.randomUUID().toString());
        proceso.setEstado(EN_ESPERA);
        listaProcesos.add(proceso);
        
        verificarMarcosVacios();
        
        elegirProceso(this.marcos_vacios,callback);
    }

    @Override
    public void elegirProceso(int marco, IBridgeCallback callback) {
        
        int cont = 0;
        
        verificarMarcosVacios();
        
        for(int i = 0; i < listaProcesos.size(); i++){
            
            if(listaProcesos.get(i).getMarcoPagina() <= this.marcos_vacios){
                
                if(listaProcesos.get(i).getEstado().equals(EN_ESPERA)){
                    for(int j = 0; j < listaMarcos.size(); j++){
                        if(listaMarcos.get(j).getEstado() == 0 
                                && cont < listaProcesos.get(i).getMarcoPagina() ){
                            listaMarcos.get(j).setEstado(1);
                            listaMarcos.get(j).setPID(listaProcesos.get(i).getPID());
                            listaMarcos.get(j).setNombreProceso(listaProcesos.get(i).getNombre());
                            listaProcesos.get(i).setEstado(EN_EJECUCION);
                            cont++;
                        }
                    }
                }
                verificarMarcosVacios();

            }
        }
        
        callback.procesosSeleccionados(listaMarcos);
    }
    
    private void verificarMarcosVacios() {
        int disponibles = 0;
        for(int x = 0; x < listaMarcos.size(); x++){
            if(listaMarcos.get(x).getEstado() == 0){
                disponibles++;
            }
        }
        
        this.marcos_vacios = disponibles;
    }

    @Override
    public void finalizarProceso(String PID, IListProcessCallback callback) {
        for(int i = 0; i < listaProcesos.size(); i++){
            if(listaProcesos.get(i).getPID().equals(PID)){
                listaProcesos.get(i).setEstado(FINALIZADO);
                
                for(int j = 0; j < listaMarcos.size(); j++){
                    if(listaMarcos.get(j).getEstado() == 1 
                            && listaMarcos.get(j).getPID().equals(listaProcesos.get(i).getPID())){
                            listaMarcos.get(j).setEstado(0);
                            listaMarcos.get(j).setPID("");
                            listaMarcos.get(j).setNombreProceso("");
                    }
                }
                break;
            }
        }
        
        callback.listaDeProcesos(this.listaProcesos);
    }
    
    
    @Override
    public void retornarListaDeProcesos(IListProcessCallback callback) {
        callback.listaDeProcesos(this.listaProcesos);
    }


    private void inicializarMarcos() {
        Marcos marco0 = new Marcos();
        marco0.setNombre("txtCero");
        marco0.setEstado(0);
        listaMarcos.add(marco0);
        
        Marcos marco1 = new Marcos();
        marco1.setNombre("txtUno");
        marco1.setEstado(0);
        listaMarcos.add(marco1);
        
        Marcos marco2 = new Marcos();
        marco2.setNombre("txtDos");
        marco2.setEstado(0);
        listaMarcos.add(marco2);
        
        Marcos marco3 = new Marcos();
        marco3.setNombre("txtTres");
        marco3.setEstado(0);
        listaMarcos.add(marco3);
        
        Marcos marco4 = new Marcos();
        marco4.setNombre("txtCuatro");
        marco4.setEstado(0);
        listaMarcos.add(marco4);
        
        Marcos marco5 = new Marcos();
        marco5.setEstado(0);
        marco5.setNombre("txtCinco");
        listaMarcos.add(marco5);
        
        Marcos marco6 = new Marcos();
        marco6.setEstado(0);
        marco6.setNombre("txtSeis");
        listaMarcos.add(marco6);
        
        Marcos marco7 = new Marcos();
        marco7.setEstado(0);
        marco7.setNombre("txtSiete");
        listaMarcos.add(marco7);
    }

    
    
}
