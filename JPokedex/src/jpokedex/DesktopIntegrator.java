/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex;

import javax.jnlp.IntegrationService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;

/**
 *
 * @author grb19
 */
public class DesktopIntegrator {

    public DesktopIntegrator() {
        checkForShortcut();
    }
    
    private void checkForShortcut() {
        IntegrationService is;
        try{
            is=(IntegrationService) ServiceManager.lookup("javax.jnlp.IntegrationService");
        }catch(UnavailableServiceException e){
            return;
        }
        if(!is.hasDesktopShortcut()){
            if(!is.requestShortcut(true, true, "JPokedex")){
                System.out.println("shortcuts not created sucessfully");
            }
            else{
                System.out.println("shortcuts created sucessfully");
            }
        }else{
            System.out.println("already existent");
        }
    }
}
