# Queue-_de_canciones_


La librería de la cola se compila desde la carpeta del proyecto queue ejecutando el comando mvn clean install, lo cual además de compilarla la instala en el repositorio local de Maven para que pueda ser utilizada por otros proyectos.

El proyecto consumidor queueHandler se compila desde su carpeta usando mvn clean package y se ejecuta desde consola ingresando a la carpeta target y ejecutando java -jar queueHandler-0.0.1-SNAPSHOT.jar. 

El diseño del proyecto se basa en una arquitectura modular donde la estructura de datos se implementa en una librería independiente y luego se consume desde otro proyecto, lo que permite separar responsabilidades y reutilizar código.

La cola fue implementada manualmente utilizando nodos enlazados con referencias head y tail, garantizando complejidad O(1) para las operaciones de inserción y eliminación sin utilizar estructuras del JDK. 

Para manejar la prioridad se utilizaron dos colas internas, una para canciones de prioridad alta y otra para prioridad normal, reproduciendo primero la cola de prioridad alta y luego la normal, respetando el orden FIFO dentro de cada una. 

La simulación de la duración de las canciones se realizó de forma realista segundo a segundo utilizando Thread.sleep(1000) dentro de un ciclo, mostrando en consola el progreso de reproducción y permitiendo llevar el control del tiempo total reproducido y del número de canciones reproducidas.
