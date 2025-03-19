## Examen de Test Unitarios

---

### Enunciado

Con el código de este repositorio realiza:

- (*4 puntos*) Los test unitarios de los **dos** métodos, utiliza test **parametrizados**. Suponiendo que la `string` DNI, siempre es un DNI válido.
- (*2 puntos*) En el código, hay un error, ¿lo pudiste comprabar en los test? ¿Plantea la solución?
- (*3 puntos*) Si no hubiera una comprobación previamente encuanto a la longitud de la `string` del DNI, ¿Qué hay que cambiar en los tests para que comprueben estos casos?

Entrega tu repositorio con el código y los test. Además un `Readme` explicando y justificando cada apartado

Formato del `Readme` *1 punto*

---

## Tests realizados
He hecho las pruebas usando tests parametrizados

### Primer test
El primer test parametrizado es al metodo comprobarDNI, este test tiene la siguiente estructura(con el CSV source y todo lo demás), aqui comprobamos un numero de dni, bien el mayor error que hay es que no se verifica
el formato es decir te deja meterle A1234565 o 1231414F o lo que sea el unico motivo por el cual el programa no sigue adelante es que a la hora de hacer las operaciones necesita tener la letra como entero para obtener la letra y hacer la comprobacion
cosa que afecta tambien el metodo que vemos en el segundo test
```java
    void testComprobarDNI(String dni, char letra, boolean validez) {
        assertEquals(validez, Main.comprobarDNI(dni,letra));
    }
```

### Segundo test
Bien en el segundo test la estructura es todavia más sencilla. El metodo falla al calcular las letras S y Q, indicando que toca una Q en un apartado donde toca una S
```java
    void testCalcularLetra(String dni,char letra) {
        assertEquals(letra,Main.calcularLetraDNI(dni));
    }
```
### Conclusiones
El codigo tiene algunos problemas ignorando el hecho de que no contempla que pongamos una letra o asi en cualquier otro lugar o que la longitud sea la necesaria, y que cuando ponemos letra al menos esta la suerte de que ya no funciona porque falla la conversion a entero

Para arreglar el problema con el calculo de la S y la Q, habria que en caso de usar un array de chars cambiar la posicion de ambas para coincida con la lista oficial del Ministerio del Interior

Aqui esta el array con los cambios pertinentes de las letras S y Q
```java
char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
```
En caso de que no haya una comprobacion en el codigo principal y hubiera que hacerlo en los tests habria que verifciar la longitud de la cadena, en este caso al solo pasarle los numeros comprobariamos si la longitud es 8 ocho antes de hacer la operacion del test seria algo asi usando el primer metodo de test como ejemplo

```java
 void testComprobarDNI(String dni, char letra, boolean validez) {
    if (dni.length()==8) {
        assertEquals(validez, Main.comprobarDNI(dni,letra));
    }
}
```
Bueno en caso de que no cumpla con los requerimientos lo normal seria hacer algo para que ignore el caso invalido he comprobado que si lanzas una excepcion ya te lo pone y demás y lo pasa de largo, habria que hacer eso o algo similar para asegurar que va
asi que podria ser eso pero francamente el que cumpla con la longitud deberia venir en el codigo

### Referencias
- [Pagina del ministerio del interior sobre el tema del DNI](https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/) me ayudo a ver la parte del numero que corresponde a cada letra y ver el problema en el orden
- [ChatGPT](chatgpt.com) me ayudo a crear casos para todas las letras más rapido ojo no hizo los tests solo hizo algunos casos y otras cosas las hice yo, tambien hay algunos casos de cosecha propia