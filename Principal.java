import java.util.Scanner;
public class Principal {

  /**
  * @param args the command line arguments
  */
  public static void main(String[] args) {
    Scanner Entrada = new Scanner (System.in);
    int dato;
    Arbol bi = new Arbol();

    bi.insertar_Nodo(5);
    bi.insertar_Nodo(12);
    bi.insertar_Nodo(0);
    bi.insertar_Nodo(3);

    System.out.println (bi.preorden(bi.raiz));
    //        System.out.println (bi.inorden());
    //        System.out.println (bi.postorden());

    System.out.println ("Digite el dato que desea buscar");
    dato= Entrada.nextInt();
    bi.BuscarNodo(dato);
    if ( bi.BuscarNodo(dato)==null) {
      System.out.println ("Nodo no encontrado");
    }
    else
    System.out.println ("Nodo encontrado");

    System.out.println ("Digite el dato a eliminar");
    dato= Entrada.nextInt();
    bi.eliminar(dato);

    if ( bi.eliminar(dato)==false) {
      System.out.println ("Nodo no encontrado");
    }
    else

    System.out.println ("Nodo Eliminado");
    System.out.println (bi.preorden(bi.raiz));

  }

}
