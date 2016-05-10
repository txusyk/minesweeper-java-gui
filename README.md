# IS
Contiene todos los trabajos, apuntes y el proyecto de asignatura del curso 2015/2016


#Primer Sprint

##Contenido que enviamos
+ Adjuntamos los archivos .java correspondientes a las historias de usuario requeridas. 
 + Hemos generado los ficheros de test, en este caso hemos decidido usar "testNG" en favor de JUnit4. Aun no los hemos implementado al no disponer aun de una solucion de codigo estable.
 + Hemos generado un primer tablero, alineando todas las casillas. Hemos realizado diferentes pruebas de diseño.
+ Disponemos de un diagrama UML que relaciona todo el contenido que actualmente tenemos.
+ Aun no hemos finalizado los diseños de los diagramas de secuencia. Sera nuestro siguiente paso una vez finalizado este Sprint.

##Patrones de diseño escogidos

+ Hemos decidido utilizar (aun no implementados) los siguientes patrones para diseñar el proyecto competo:
 + **Observer/Observator** para la relacion con la GUI (Modelo Vista Controlador)
 + Al generar el tablero utilizaremos **Factory**
 + Para decubrir el tablero, decidimos utilizar **Strategy**

##Otros aspectos

+ Disponemos de una pagina web desde la cual se puede acceder a todo el codigo del proyecto y nuestro repositorio en github. El enlace es: [www.txusyk.github.io/IS](http://txusyk.github.io/IS/)
+ 

#Segundo Sprint

##Contenido que enviamos
+ Adjuntamos los archivos .java correspondientes a las historias de usuario requeridas. 
 + Hemos generado los ficheros de test, en este caso hemos decidido usar "testNG" en favor de JUnit4. Aun no los hemos implementado al no disponer aun de una solucion de codigo estable.
 + Hemos generado tablero casi definitivo, en una malla de **n*m**. Aun nos falta cambiar los numeros y el color **ROJO** de la casilla cuando es mina por iconos.
+ Disponemos de un diagrama UML que relaciona todo el contenido que actualmente tenemos.
+ Estamos finalizando el diseño de los diagramas de secuancia en el momento actual de desarrollo.

##Patrones de diseño escogidos

+ Hemos decidido utilizar (e implementado) los siguientes patrones para diseñar el proyecto competo:
 + **Observer/Observator** para la relacion con la GUI (Modelo Vista Controlador)
 + Al generar el tablero utilizaremos **Factory**
+ Definitivamente no vamos a utilizar el siguiente patron: **Strategy** para la resolucion del tablero
+ Por ultimo, vamos a utilizar un nuevo patron para el control del tablero: **State** es el patron que utilizaremos para la gestion del tablero 

