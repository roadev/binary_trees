public class Arbol {


  NodoArbol raiz;

  Arbol() {
    raiz = null;
  }

  void insertar_Nodo(int dato) {
    if (raiz==null) {
      raiz = new NodoArbol(dato);
    } else {
      raiz.insertar(dato);
    }
  }


    /* public String preorden()
    {
    String resultado = preorden(raiz);
    return resultado;
  }*/
  public String inorden() {
    String resultado = inorden(raiz);
    return resultado;
  }
  public String postorden() {
    String resultado = postorden(raiz);
    return resultado;
  }



  public String preorden(NodoArbol nodo) {
    String cadena = new String();
    if (nodo != null) {
      cadena += " " + String.valueOf(nodo.dato);
      cadena += preorden(nodo.izq);
      cadena += preorden(nodo.der);
    } else {
      cadena = "";
    }
    return cadena;
  }

  public String inorden(NodoArbol nodo) {
    String cadena = new String();
    if (nodo != null) {
      cadena += preorden(nodo.izq);
      cadena += " " + String.valueOf(nodo.dato);
      cadena += preorden(nodo.der);
    } else {
      cadena = "";
    }
    return cadena;
  }


  public String postorden(NodoArbol nodo) {
    String cadena = new String();
    if (nodo != null) {
      cadena += preorden(nodo.izq);
      cadena += preorden(nodo.der);
      cadena += " " + String.valueOf(nodo.dato);
    } else {
      cadena = "";
    }
    return cadena;
  }


  public NodoArbol BuscarNodo(int dato) {
    NodoArbol tem = raiz;
    while (tem.dato!=dato) {
      if (dato< tem.dato) {
        tem=tem.izq;
      } else {
        tem=tem.der;
      }

      if (tem==null) {
        return null;
      }
    }
    return tem;
  }

  public boolean eliminar (int dato) {
    NodoArbol temp = raiz;
    NodoArbol padre = raiz;
    boolean hizq=true;
    while (temp.dato!=dato) {
      padre=temp;
      if (dato<temp.dato) {
        hizq=true;
        temp = temp.izq;
      } else {
        hizq=false;
        temp=temp.der;
      }
      if (temp==null) {
        return false;
      }

    }
    if (temp.izq ==null && temp.der==null) {
      if (temp==raiz) {
        raiz=null;
      } else if (hizq) {
        padre.izq=null;
      }else{
        padre.der=null;
      }
    }
    else if (temp.der==null) {
      if (temp==raiz) {
        raiz=temp.izq;
      }else if (hizq) {
        padre.izq=temp.izq;
      }else{
        padre.der=temp.izq;
      }
    }else if (temp.izq ==null) {
      if (temp==raiz) {
        raiz=temp.der;
      } else if (hizq) {
        padre.izq=temp.der;
      } else {
        padre.der=temp.izq;
      }
    } else {
      NodoArbol reemplazar = reemplazo(temp);
      if (temp== raiz) {
        raiz= reemplazar;
      } else if (hizq) {
        padre.izq= reemplazar;
      } else {
        padre.der =reemplazar;
      }
      reemplazar.izq =temp.izq;
    }
    return true;

  }

  public NodoArbol reemplazo(NodoArbol nodoreemplazo) {

    NodoArbol reemplazaPadre = nodoreemplazo;
    NodoArbol reemplazo = nodoreemplazo;
    NodoArbol temp = nodoreemplazo.der;
    while (temp !=null) {
      reemplazaPadre =reemplazo;
      reemplazo=temp;
      temp=temp.izq;
    }

    if (reemplazo != nodoreemplazo.der) {
      reemplazaPadre.izq=reemplazo.der;
      reemplazo.der = nodoreemplazo.der;
    }
    System.out.println ("El nodo reemplazado es: "+ reemplazo);
    return reemplazo;
  }

}
