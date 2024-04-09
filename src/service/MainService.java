package service;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class MainService {
    static void process(InputStream i){
        Scanner s = new Scanner(i);
        if(Objects.equals(s.next(), "produse")){
            HumanResourcesService.handle(i);
        }
        else{
            ProductsService.handle(i);
        }

    }

}


class HumanResourcesService {
    static  void handle(InputStream i){

    }
}

class ProductsService{
    static  void handle(InputStream i){

    }
}

