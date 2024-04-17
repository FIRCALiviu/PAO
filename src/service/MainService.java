package service;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class MainService {
    public static void process(InputStream i){
        Scanner s = new Scanner(i);
        System.out.println("interogati produse sau human ressources?[p/h]");
        if(Objects.equals(s.next(), "h")){
            HumanResourcesService.handle(i);
        }
        else{
            ProductsService.handle(i);
        }

    }

}


