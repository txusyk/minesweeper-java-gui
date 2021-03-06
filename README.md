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

#Buscaminas

Este ha sido el proyecto propuesto para la asignatura de **IS** (Ingenieria del Software) para el curso 2015/2016 en la escuela **EUITI** de la universidad **UPV/EHU**.

Las personas encargadas de llevar a cabo el proyecto hemos sido **Josu Alvarez** y **David Max**.

Se nos planteaba hacer un buscaminas basado en el *MVC* (Modelo Vista Controlador), por lo tanto con el uso de la libreria *Swing* de *Java*.

* * *
## Introduccion

###¿Que se pedia?

Para este proyecto, se sugeria el uso de *MVC*. Asi mismo se pedia que el programa fuera capaz de ejecutarse con diferentes medidas y numero de minas en funcion de la dificultad que el usuario debia seleccionar.
Una vez tenemos varias partidas de usuario guardadas, debe mostrar (una vez asi lo solictemos) un ranking con el Top10 de los mejores jugadores.

###¿Que hemos hecho?

En principio, **se cumplen todos los requisitos establecidos para el proyecto**.

Al arrancar, **el juego cargara todos los datos de los usuarios y sus partidas** desde un *XML/CSV* (a eleccion del usuario). Una vez realizada dicha carga, **mostrara una ventana de *LogIn***, donde se podra seleccionar la dificultad y tendremos la opcion tambien de crear un usuario nuevo (al que se le pedira un nombre distinto de los ya registrados y una contraseña).
**Cuando el *LogIn* ha finalizado, se lanza un tablero de juego (Buscaminas)** con las caracteristicas que se definieron en base a su dificultad.

Asi mismo, en estas dos ventanas de juego **se mostrara una barra de menu (JMenuBar) que contendra, entre otras, la opcion de reiniciar una partida y de mostrar el ranking de los 10 mejores jugadores**.

**Respecto a los patrones**, finalmente no hemos conseguido implementar el *Factory*. **Pero si hemos conseguido implementar el *State*, *Observer/Observator*** (MVC).
* * *
#Implementacion

##¿Que hemos implementado?

Estas son las funcionalidades que bien durante el diseño o el desarollo han sido planteadas como posibles e interesantes a la hora de llevar a cabo:

###Buscaminas
- Sera la main() de nuestro proyecto.
- Unicamene se encargara de las llamadas a los metodos que arrancan el juego.

###GestorVentanas
- En caso de que nos de tiempo, nos parece mas que interesante la posibilidad de implementar un gestor que se encargue de la visibilidad de las ventanas y la gestion de los eventos de las mismas.
- Sera el encargado de definir la barra de menu (JMenuBar) de nuestra ventana. En dicha barra de menu mostraremos:
	- Archivo: Nos dara las opciones de reiniciar la partida (en caso de haber una previamente en juego) y la opcion de salir del mismo.
	- Ayuda: Nos dara las opciones de mostrar las preguntas frecuentes  o la opcion 'acerca de' del juego (JOptionPane).
	- Juego: Nos permitira mostrar el Ranking de los 10 mejores jugadores y la opcion de eliminar a un jugador (en caso de existir y conocer sus credenciales).

###MenuLogin
- Sera un JPanel que se mostrara en la ventana que hemos creado anteriormente.
- Dicha ventana se redimensionara hasta ocupar perfectamente el JPanel que estamos mostrando.
- Nos dara la opcion de seleccion de un modo de dificultad, a elegir: facil, medio,dificil
- Nos dara las opciones de login:
	- LogIn: En caso de haber creado anteriormente un usuario, contrastara el nombre y password introducidos con los almacenados en la base de datos. Mostrara un error en caso de nombre y/o contraseña erroneos y arrancara el juego en caso contrario.
	- Nuevo usuario: Contrastara la informacion introducida con los almacenados en la base da datos. Mostrara un error en caso de que exista previamente el jugador que tratamos de crear.

###VistaBuscaminas
- Ha de ser una de las vistas que gestionara nuestro controlador.
- Sera un JPanel. No una ventana al completo, que mostrara el numero de minas restantes y el tiempo de juego.
- Heredara los componentes que tenga la ventana padre donde la mostremos

###VistaCasillas
- Ha de ser otra de las vistas que gestionara nuestro controlador.
- En este caso sera un JButton. Lo implementamos asi dado que seran los botones con los que el usuario interactuara sobre la vista.
- Generaremos antos botones como sea necesario para la dificultad que nos viene definida.
- Los botones al descubrirs mostraran iconos.
- Definimos que el tamaño adecuado sea 25x25.
- Todos los recursos deben de ser accesibles desde cualquier PC sin que sea necesario modificar ninguna linea de codigo.

###VistaRanking
- A diferencia de las otras vistas, esta si sera un JFrame que sustituira a nuestra ventana de juego cuando el usuario decida mostrarla.
- Dado que saldremos del juego, seria interesante plantearle al usuario dicha situacion para que actue en consecuencia. Seria aun mas interesante el hecho de plantearlo mediante interaccion con un JOptionPane.
- La vista mostrara una ventana centrada en pantalla.
- El tamaño de dicha pantalla sera el necesario para mostrar los 10 mejores resultados.
- En caso de no haber resultados, se mostrara una ventana sin contenido salvo el titulo de la misma. En caso de no haber 10 jugadores en dicha lista, se mostraran los que haya unicamente, mostrando espacios vacios en los que no habia nada.

###ModeloTablero
- Extendera a un Observable.
- Sera el encargado de gestionar las acciones de la VistaBuscaminas.
- Sera el encargado de gestionar las llamadas al Threat que llamara y controlara el temporizador que se mostrara en la VistaBuscaminas.

###ModeloCasilla
- Extendera a un Observable
- Sera el encargado de gestionar las acciones de la VistaCasillas.
- Sera el encargado de gestionar las acciones de resolucion de las casillas.

###Controlador
- Sera el encargado de comunicar las acciones de la VistaBuscaminas/VistaCasillas con ModeloTablero/ModeloCasillas

###Estado
- Sera la interfaz que implementara el patron State.

###Ganado - EnJuego - Perdido
- Seran los encargado de implementar las llamadas y la gestion de dicho patron.

###Gestor Ficheros
- Sera el encargado de cargar los ficheros
- La carga de ficheros sera mediante llamadas a gestores de recursos mediante el nombre del archivo a cargar.
- Daremos opciones de carga mediante CSV y XML.
- Daremos opciones de escritura mediante CSV y XML.

###Ranking
- Sera el encargado de gestionar la creacion de una lista de los 10 mejores jugadores.
- Dispondra para ello de la posibilidad de ordenar las listas de partidas de todos los jugadores.
- Asi mismo, creara una lista de todas las partidas ordenadas por puntuacion (sin tener en cuenta el limite de 10 partidas del metodo top10).

###InfoPartida
- Este elemento es el que formara el Ranking
- Esta compuesto por un nombre de jugador y una puntuacion (que en caso de ser repetida, no se guardara de nuevo salvo que el jugador sea distinto).

###ListaPartidas - Partida
- ListaPartidas:
	- Cada usuario contendra una lista de todas las partidas que ha jugado
- Partida
	- Las partidas recibiran el tiempo de juego y se encargaran de hallar una puntuacion basandose en: *((factorCalculoBase x factorDificultad /(segundos)) x 10.7)*
- Ambas clases se inicializan al comienzo del juego desde un XML/CSV (a eleccion del usuario).

###ListaJugadores - Jugadores
- ListaJugadores:
	- La lista de jugadores sera unica. Se inicializara al comenzar el juego, con la carga de ficheros (en caso de existir).
- Jugador: Un jugador estara compuesto por su nombre, password y listapartidas
	- nombre: guardara en formato String el nombre del jugador
	- passw : guardara en formato char[] (respetando el formato original de la contraseña) la contraseña del usuario
	- listaPartidas: guardara un objeto de tipo ListaPartidas que contendra todas las partidas del jugador (tanto las cargadas desde fichero como las jugadas en una nueva sesion).

###Usuarios.txt - Usuarios.xml
- Usuarios.txt: Contendra una lista con toda la informacion de los jugadores y sus partidas en formato CSV
- Usuarios.xml: Contendra una lista con toda la informacion de los jugadores y sus partidas en formato XML
* * *
##Analisis de los casos de prueba

En este apartado haremos un resumen de los casos de prueba que se han implementado para las clases que hemos definido.

Hemos utilizado dos frameworks de test para realizar dicho analisis. TestNG y JUnit4.
Lo hemos decidido hacer asi para ser mas conscientes de las mejoras que nos aporta TestNG.

Por ejemplo, en lugar de definir un setUp() que lleve una etiqueta de tipo @AfterMetod. TestNG, nos permite utilizar una etiqueta de tipo @AfterClass que arrancara dicho metodo no en cada llamada a metodos de test, sino que lo hara una unica vez al instanciar la clase de test.

Esta es solo una de las mejoras que hemos encontrado, para mas informacion:

- [JUnit 4 Vs TestNG – Comparison](http://www.mkyong.com/unittest/junit-4-vs-testng-comparison/)
- [JUnit 4 vs TestNG - Update 2013 - 2014](http://stackoverflow.com/questions/14136731/junit-4-vs-testng-update-2013-2014)
- [Migrating from JUnit to TestNG](http://testng.org/doc/migrating.html)
- [FAQ: Should I use JUnit or TestNG, which is better?](http://blog.javafortesters.com/2014/09/faq-should-i-use-junit-or-testng-which.html)
- [TestNG or JUnit](https://dzone.com/articles/testng-or-junit)

###¿Que clases tienen un test?

- ControladorTest
- EnJuegoTest
- GanadoTest
- GestorFicherosTest
- InfoPartidaTest
- JugadorTest
- ListaJugadoresTest
- ListaPartidasTest
- ListaRankingTest
- ModeloCasillaTest
- ModeloTableroTest
- PartidaTest
- PerdidoTest
- PuntuacionTest
- RankingTest

El main (Buscaminas) solo hace 3 llamadas a metodos ya testeados.
El resto de clases son las vistas del programa y no las probamos mediante JUnits/TestNG si no que lo haremos mediante pruebas de ejecucion para comprobar que todo se visualiza como queremos.

A continuacion, haremos un breve resumen de los casos de prueba que se han tenido en cuenta, para mas informacion aconsejamos ejecutar y/o revisar las clases de prueba que hemos generado.

* * *

####ControladorTest

- Se comprobara que se gestiona correctamente el click de raton
- Se comprobara que las constructoras funcionan correctamente

####EnJuegoTest
- se comprueba que se puede acceder y modificar el estado

####GanadoTest
- se comprueba que se puede acceder y modificar el estado

####GestorFicheros
- se comprueba que se carga correctamente la informacion desde xml
- se comprueba que se carga correctamente la informacion desde csv
- se comprueba que se exporta correctamente la informacion desde csv
- 

####InfoPartidaTest
- comprobamso que el objeto se crea bien
- comprobamos que accedemos correctamente al nombre/puntuacion
- comprobamos que se guarda el nombre/puntuacion correctamente

####JugadorTest
- comprobamos que el objeto se crea bien
- comprobamos que la listaPartidas no se crea nula
- comprobamso que accedemos correctamente a la listaPartidas
- comprobamos que accedemos correctamente al nombre/passwd
- comprobamos que modificamos correctamente el nombre/passwd
- comprobamos que el metodo comprobarPasswd() funciona correctamente

####ListaJugadoresTest
- comprobbamos que el objeto (MAE) no es nulo tras su creacion
- comprobamos que se accede correctamente a dicho objeto
- comprobamos que se añaden correctamente jugadores
- comprobamos que se eliminan correcctamente jugadores
- comprobamos que se gestionan correctamente las contraseñas

####ListaPartidasTest
- comprobamos que el objeto se crea correctamente
- comprobamos que el iterador se genera y funciona OK
- comprobamos los getters&setters
- comprobamos el metodo eliminarPartida()
- comprobamos que se imprime la informacion de las partidas OK
- comprobamos que el metodo esta() funciona correctamente
- comprobamos que la lista de partidas se ordena correctamente en base a la puntuacion del usuario

####ListaRankingTest
- se comprueba que el objeto que se genera no es nulo
- se comprueba que el metodo obtener10mejores() funciona correctamente
- asi mismo, debido a la naturaleza del metodo, obtener10mejores() es imperativo probar el funcionamiento de otros metodos.

####ModeloCasilla
- se comprueba que el objeto no se crea nulo
- se comprueba que el patron Observable funciona correctamente
- se comprueba que los objetos se resuelven correctamente
- se comprueba que los getters&setters funcionan como es debido
- comprobamos que las casillas se marcan cuando es registrado por el usuario

####ModeloTableroTest

- comprobamos que el objeto se crea correctamente
- comprobamso que los getters y los setters funcionan correctamente
- comprobamos que la incialziacion una vez una partida ha teminado funciona correctamente
- comprobamos que el threat se crea correctamente y se gestiona tambien de forma OK
- comprobamos que el timer se actualiza de forma correcta
- comprobamso que se configura de forma correctala distribucion de las casillas (es decir, la creacion del array que contendra todas las casillas del tablero de juego)
- comprobamso que el metodo contarMinas() funciona OK
- hacemos lo mismo para el metodo descubrirCasillasVacias()

####PartidaTest
- comprobamso que el objeto que se crea no es null, se crea correctamente
- comprobamos que los getters&setters funcionan correctamente
- comprobamos que el calculo de la puntuacion de las partidas es correcto

####PerdidoTest
- se comprueba que se puede acceder y modificar el estado

####RankingTest
- comprobamos que el objeto que se crea no es nulo
- comprobamos que se genera correctamente la lista de los 10 mejores jugadores
- comprobamos que se genera correctamente la lista general de las mejores partidas, ordenadas por puntuacion (de mayor a menor)


* * *


##Reparto de tareas y tiempo empleado

El reparto inicial de las tareas se tuvo que ver modificado debido a dudas y a problemas con el codigo. Por ello, el reparto final de tareas ha sido:

###Clases

- Controlador: Josu <jalvarez041@ikasle.ehu.eus> / David <damax001@ikasle.ehu.eus>
	- El controlador ha supuesto aproximadamente 45 min de programacion. 20 min para su diseño. Todo ha sido realizado en comun.
- EnJuego / EnJuegoTest: David <damax001@ikasle.ehu.eus>
	- Ambas clases han sido implementadas por David. Han supuesto 30 min para su programacion y su diseño (teniendo en cuenta que ha sido diseñada para el uso de un patron)
- Ganado / GanadoTest: David <damax001@ikasle.ehu.eus>
	-  Ambas clases han sido implementadas por David. Han supuesto 30 min para su programacion y su diseño.
- GestorFicheros : Josu <jalvarez041@ikasle.ehu.eus>
	- Ha supuesto 1h de diseño y aproximadamente 1.30h de programacion. Se ha reutilizado parte de codigo que usaba para otros proyectos.
- InfoPartida /InfoPartidaTest: David <damax001@ikasle.ehu.eus>
	- InfoPartida : Ha supuesto 5 min de diseño y aproximadamente 15 de programacion. 
	- InfoPartidaTest : Ha supuesto 10 min para programarla.
- Jugador: Josu <jalvarez041@ikasle.ehu.eus>
	- Ha puesto unos 20 min para diseñarla y unos 30-40 minutos para su implementacion.
- JugadorTest: David <damax001@ikasle.ehu.eus>
	- Ha supuesto unos 20 min para su diseño e implementacion.
- ListaJugadores: Josu <jalvarez041@ikasle.ehu.eus> y David <damax001@ikasle.ehu.eus>
	- Hemos tardo aproximadamente 15 minutos en implementar la clase, su diseño practicamente no nos llevo tiempo.
- ListaJugadoresTest: David <damax001@ikasle.ehu.eus>
	- Ha llevado unos 15 minutos implementar los casos de prueba de esta clase.
- ListaPartidas / ListaPartidasTest: David <damax001@ikasle.ehu.eus>
	- El diseño de las dos clases llevo unos 30 minutos. Su implementacion aproximadamente 40 min.
- ModeloCasilla: Josu <jalvarez041@ikasle.ehu.eus>
	- El modelo supuso pensar bastante, unos 40 minutos para lograr un diseño que nos convenciera. Su implementacion fue relativamente facil y nos llevo 30 min.
- ModeloCasillaTest: David <damax001@ikasle.ehu.eus>
	- El test ha supuesto un gran esfuerzo, dado que habia que gestionar muchas llamadas y no entendia el codigo al 100%. He tardado 1h en implementar los casos de prueba.
- ModeloTablero: Josu <jalvarez041@ikasle.ehu.eus>
	- Implementar el modelo del tablero ha sido dificil. Quizas la clase mas dificil que he implementado en este proyecto. Al comienzo no entendia el MVC, por lo que, he tenido que reescribir el codigo varias veces. En total, entre diseño y programacion habra supuesto al menos 4h hacer que funcione junto con las vistas y el resto del codigo relacionado al MVC.
- ModeloTableroTest : David <damax001@ikasle.ehu.eus>
	- Implementamos los casos de prueba en unos 30 min.
- MenuLogin: Josu <jalvarez041@ikasle.ehu.eus>
	- El diseño de esta vista ha sido la mas sencilla puesto que ya teniamos practica con 'Swing' y ha sido la ultima ventana que hemos implementado. Unos 30 minutos para diseñar como la queriamos y otros 40 para ubicar todos los elementos y darles la funcionalidad apropiada.
- Partida / PartidaTest: David <damax001@ikasle.ehu.eus>
	- Dado que es una clase auxiliar y relativamente sencilla ha supuesto unos 30 minutos realizar su diseño y otros 30 minutos implementar tanto la clase como los propios casos de prueba.
- Perdido / PerdidoTest: David <damax001@ikasle.ehu.eus>
	- Ambas clases han sido implementadas por David. Han supuesto 30 min para su programacion y su diseño (teniendo en cuenta que ha sido diseñada para el uso de un patron)
- Puntuacion / PuntuacionTest: David <damax001@ikasle.ehu.eus>
	- Ambas clases han sido implementadas por David. Han supuesto 30 min de diseño y 20 de implementacion.
- Ranking: Josu <jalvarez041@ikasle.ehu.eus> y David <damax001@ikasle.ehu.eus>
	- La clase ha sido relativamente facil de diseñar, aproximadamente 20 min. Pero, a la hora de implementarlo hemos tenido distintos problemas que no preeveiamos y no hemos tenido otro remedio que aplicar unas soluciones distintas a las que teniamos pensadas en un comienzo, por ello, la implementacion de este ma clase nos ha llevado al menos el doble de tiempo de lo que teniamos estmado, 1.30h.
- VistaBuscaminas: Josu <jalvarez041@ikasle.ehu.eus>
	- Debido a que no sabia utilizar 'Swing' (en el momento de afrontar esta implementacion) ha sido al clase que mas tiempo me ha costado implementar. No la mas dificil, pero si ante la cual mas indefenso me he sentido. Solo su diseño ha ocupado mas de 1.30h y su implementacion ha sido caotica (he tenido que reacer el codigo inumerables veces desde cero). No sabria decir cuanto tiempo ha ocupado su implementacion.
- VistaCasillas: Josu <jalvarez041@ikasle.ehu.eus>
	- Debido al mismo problema que el mencionado anteriormente en la clase de VistaBusaminas, hemos tenido probelmas a la hora de afrontar este diseño por que no entendiamos bien como funcionaban y como habia que distribuir los botones de esta vista. Su diseño al menos ocupo unos 30 min de nuestro tiempo y su implementacion nos llevo mas de 2h.
- VistaRanking: Josu <jalvarez041@ikasle.ehu.eus>
	- Su diseño supuso apenas 10 min. En el momento en el que decidimos que su implementacion seria en otra ventana sin el JMenuBar de la original, se simplifico muchisimo su diseño. Por ello, tardamos unos 10 min en imaginar su funcionamiento y unos 20 en tener un codigo funcional.


* * *

##Funcionalidades extra del programa

###¿Que mejoras hemos implementado?

- **Gestion de usuarios**: Se pedia disponer de usuarios. Nosotros hemos decidido llevarlo un paso mas adelante implementando tambien su contraseña, como haria cualquier otra aplicacion que gestione usuarios.
- **Barra de menu**: Se pedia disponer de un boton para salir, otro para reiniciar y otro mas para mostrar el ranking. Nosotros hemos decidido introducir una barra de menu que aporta lo siguiente:
	- Archivo
		- Reiniciar : Da la opcion de reiniciar la partida, solo si ya hay una en juego con una dificultad seleccionada
		- Salir: Se cierra la ventana de juego
	- Ayuda
		- FAQ: Se mostrara la informacion sobre las preguntas frecuentes del juego
		- Acerca de: Se mostrara informacion acerca de los desarrolladores del juego
	- Juego
		- Ranking Top 10: Obtiene y muestra en un JFrame a los 10 mejores jugadores y sus respectivas partidas
		- Eliminar Jugador: Elimina a un jugador tras confirmar que conocemos sus credenciales
- **Gestion de usuarios y sus partidas**: Hemos implementado varios metodos que se encarguen de crear y guardar (a la apertura y cierre, respectivamente) los datos de la aplicacion en un fichero. 
	- XML: Dado que teniamos algo de tiempo y nos parecia interesante, hemos implementado un metodo que gestione ficheros XML personalizados del juego
	- CSV : Aprovechando codigo de otras aplicaciones, hemos implementado un gestor de ficheros que trabaja bajo el formato CSV.
- **Uso de lambda y Stream**: Lambda es una funcion que es soportada desde Java 1.7 y Stream es otra soportada desde 1.8. Nos parecio bastante interesante hacer uso intensivo de estos recursos (siempre que fuera posible) para simplificar el codigo lo maximo posible. Tal y como se puede ver, al menos 5-6 clases hacen uso de dichas caracteristicas.
- **TestNG**: Como hemos mencionado, hemos incluido algunos test de tipo TestNG
- **Uso de GitHub**: Como hemos comentado en otras ocasiones, mientras ha durado el proyecyo hemos hecho uso de GitHub
	- Notificaciones en el movil: Para estar al dia de otras novedades en nuestro repositorio, creamos un grupo de telegram y añadimos un bot que notificaba de todos los cambios que hubiera en el servidor.
	- Mantenimiento de codigo: Revision y mantenimiento con control de versiones.
	- Gestion de ramas alternativas de trabajo: Gestion de ramas mediante braches.
	- Wiki: Mostramos informacion acerca del juego, no del desarrollo del mismo.
	- Issues y Milestones: Hemos hecho un uso intensivo de estos dos, marcando el tipo de 'issue' que teniamos y añadiendolo a nuestra fecha limite de solucion.
	- Readme: En nuestro archivo de readme de Github mantenemos un resumen de todos los cambios y de las caracteristicas del programa en los distintos puntos de entrega 'con el cliente'.
- **IDE alternativo, IntelliJ Idea 2016.1**: Conociamos eclipse desde que comenzamos a programar. Hace relativamente poco nos interesamos por NetBeans pero al encontrar (lo que nosotros consideramos) un IDE de Java perfecto decidimos tratar de implementar todo el proyecto haciendo uso exclusivo de dicho IDE. El por que de esta decision tiene inumerables respuestas:
	- desde una interfaz mas amigable y personalizable
	- unos controles mas intuitivos
	- frameworks nativos mucho mas variados
	- facilidad de moverse mediante atajos de teclado
	- un autocompletado que deberia ser la envidia de otros IDEs
	- inspeccion de codigo avanzada al alcance de cualquier desarrollador

- **Documentacion unicamente en formato MardkDown**: Debido a la naturaleza de GitHub, disponiendo incluso de un flavor de MarkDown, decidimos hacer toda la documentacion en este formato. Al igual que esta memoria.  

* * *

##Conclusiones

- Josu <jalvarez041@ikasle.ehu.eus> : Ha sido un proyecto que inicialmente parecia sencillo, tanto en su diseño como en su implementacion. El hecho de haber tenido problemas a la hora de gestionar el MVC ha hecho que el proyecto me haya parecido en ocasiones hasta imposible. Tras horas de lectura y de comprension, he llegado a entender como se comportaba y logrado implementar lo que se pedia. Me ha parecido un proyecto increible para aprender, con una curva de aprendizaje elevada pero necesara a estas alturas. Un proyecto divertido, que sin duda continuare desarrollando y liberaremos el codigo en GitHub para que cualquier persona pueda acceder.
- David <dmax001@ikasle.ehu.eus> : Un proyecto muy completo, que ha exigido tanto tiempo como esfuerzo, pero que una vez finalizado ha resultado muy gratificante.

* * *

##Bibliografia

- [MineSweeper GUI](http://stackoverflow.com/questions/22028923/java-minesweeper-gui)
- [Minesweeper Action Events](http://stackoverflow.com/questions/7006029/minesweeper-action-events/7016492#7016492)
- [Building a Monopoly Board with GridBagLayout ](http://stackoverflow.com/questions/3038631/building-a-monopoly-board-with-gridbaglayout)
- [Factory method pattern](https://en.wikipedia.org/wiki/Factory_method_pattern)
- [Simply way to convert a string to char[]](http://crunchify.com/java-simple-way-to-convert-string-to-char-array)
- [What is MVC (Model View Controller)?](http://stackoverflow.com/questions/129921/what-is-mvc-model-view-controller)
- [Game Programming in Java](http://stackoverflow.com/questions/7052005/game-programming-in-java)
- [Oracle (Oficcial) Lambdas&Streams](http://www.oracle.com/technetwork/es/articles/java/expresiones-lambda-api-stream-java-2633852-esa.html)
- [How Misusing Streams Can Make Your Code 5 Times Slower](http://blog.takipi.com/benchmark-how-java-8-lambdas-and-streams-can-make-your-code-5-times-slower/)




