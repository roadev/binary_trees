public class NodoArbol {

  int dato;
  NodoArbol izq;
  NodoArbol der;

  NodoArbol (int dato) {
    this.dato = dato;
    izq = null;
    der = null;
  }

  void insertar (int dato) {
    if(dato< this.dato)
    {
      if (izq == null)
      {
        izq = new NodoArbol(dato);
      }
      else
      izq.insertar(dato);
    }


    if (dato > this.dato) {
      if (der == null) {
        der = new NodoArbol(dato);
      }
      else
        der.insertar(dato);
    }
  }

}
